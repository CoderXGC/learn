package com.ylesb.download.controller;
/**
 * @title: FileDownloadController
 * @projectName download
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/710:48
 */

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.ylesb.download.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @className    : FileDownloadController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/7 10:48]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/7 10:48]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestController
public class FileDownloadController {
    @Autowired
    private FileService fileService;
    @RequestMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("test".equals(name) && "123456".equals(pwd)) {
            StpUtil.login(10001);
            return SaResult.ok("登录成功，token:"+StpUtil.getTokenValue());
        }
        return SaResult.error("登录失败");
    }
    //实现Spring Boot 的文件下载功能，映射网址为/download
    @RequestMapping("/download")
    @SaCheckLogin
    public String downloadFile(HttpServletResponse response) throws UnsupportedEncodingException, NotLoginException {

        // 获取指定目录下的第一个文件
        File scFileDir = new File("C://music_eg");
        File TrxFiles[] = scFileDir.listFiles();
        System.out.println(TrxFiles[0]);
        String fileName = TrxFiles[0].getName(); //下载的文件名

        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            String realPath = "C://music_eg/";
            File file = new File(realPath, fileName);

            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download the song successfully!");
                }
                catch (Exception e) {
                    System.out.println("Download the song failed!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }


    /**
     * 下载日志接口
     *
     * @param name
     * @param response
     * @throws Exception
     */
    @SaCheckLogin
    @GetMapping(value = "/download2/{name}")
    public void logDownload(@PathVariable String name, HttpServletResponse response) throws Exception {
        fileService.fileDownload(name, response);
    }
    @SaCheckLogin
    @GetMapping("download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName,
                                                 HttpServletRequest request) throws Exception {
        Resource resource = fileService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {

        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
