package com.ylesb.download.config;
/**
 * @title: FileException
 * @projectName download
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/711:15
 */

/**
 * @className    : FileException
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/7 11:15]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/7 11:15]
 * @updateRemark : [描述说明本次修改内容] 
 */
public class FileException extends RuntimeException {

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}

