package com.ylesb.download.config;
/**
 * @title: FileProperties
 * @projectName download
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/711:09
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @className    : FileProperties
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/7 11:09]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/7 11:09]
 * @updateRemark : [描述说明本次修改内容] 
 */

@ConfigurationProperties(prefix = "file")
@Data
public class FileProperties {

    private String docDir;

}
