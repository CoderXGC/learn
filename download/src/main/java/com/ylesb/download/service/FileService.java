package com.ylesb.download.service;
/**
 * @title: FileService
 * @projectName download
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/710:52
 */

import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletResponse;

/**
 * @className    : FileService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/7 10:52]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/7 10:52]
 * @updateRemark : [描述说明本次修改内容] 
 */
public interface FileService {
     void fileDownload(String name, HttpServletResponse response) throws Exception;
     Resource loadFileAsResource(String fileName) throws Exception;
}

