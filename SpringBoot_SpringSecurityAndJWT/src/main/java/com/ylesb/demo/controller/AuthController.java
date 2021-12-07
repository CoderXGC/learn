package com.ylesb.demo.controller;
/**
 * @title: AuthController
 * @projectName SpringBoot_SpringSecurityAndJWT
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2021/12/711:36
 */

import com.ylesb.demo.domain.ResultCode;
import com.ylesb.demo.domain.ResultJson;
import com.ylesb.demo.domain.auth.ResponseUserToken;
import com.ylesb.demo.domain.auth.Role;
import com.ylesb.demo.domain.auth.User;
import com.ylesb.demo.domain.auth.UserDetail;
import com.ylesb.demo.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @className    : AuthController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2021/12/7 11:36]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2021/12/7 11:36]
 * @updateRemark : [描述说明本次修改内容] 
 */

@RestController
@Api(description = "登陆注册及刷新token")
@RequestMapping("/api/v1")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "登陆", notes = "登陆成功返回token,登陆之前请先注册账号")
    public ResultJson<ResponseUserToken> login(
            @Valid @RequestBody User user){
        final ResponseUserToken response = authService.login(user.getName(), user.getPassword());
        return ResultJson.ok(response);
    }

    @GetMapping(value = "/logout")
    @ApiOperation(value = "登出", notes = "退出登陆")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    public ResultJson logout(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        authService.logout(token);
        return ResultJson.ok();
    }

    @GetMapping(value = "/user")
    @ApiOperation(value = "根据token获取用户信息", notes = "根据token获取用户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    public ResultJson getUser(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        UserDetail userDetail = authService.getUserByToken(token);
        return ResultJson.ok(userDetail);
    }

    @PostMapping(value = "/sign")
    @ApiOperation(value = "用户注册")
    public ResultJson sign(@RequestBody User user) {
        if (StringUtils.isAnyBlank(user.getName(), user.getPassword())) {
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        UserDetail userDetail = new UserDetail(user.getName(), user.getPassword(), Role.builder().id(1l).build());
        return ResultJson.ok(authService.register(userDetail));
    }
//    @GetMapping(value = "refresh")
//    @ApiOperation(value = "刷新token")
//    public ResultJson refreshAndGetAuthenticationToken(
//            HttpServletRequest request){
//        String token = request.getHeader(tokenHeader);
//        ResponseUserToken response = authService.refresh(token);
//        if(response == null) {
//            return ResultJson.failure(ResultCode.BAD_REQUEST, "token无效");
//        } else {
//            return ResultJson.ok(response);
//        }
//    }
}
