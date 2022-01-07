package com.ylesb.download.service.impl;
/**
 * @title: FileServiceImpl
 * @projectName download
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/710:52
 */

import com.ylesb.download.config.FileException;
import com.ylesb.download.config.FileProperties;
import com.ylesb.download.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @className    : FileServiceImpl
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/7 10:52]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/7 10:52]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
public class FileServiceImpl implements FileService {
    private final Path filePath;
    @Override
    public void fileDownload(String name, HttpServletResponse response) throws Exception {
        File file = new File("logs" + File.separator + name);

        if (!file.exists()) {
           // throw new GlobalException(name + "文件不存在");
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + name);

        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }
    }

    @Autowired
    public FileServiceImpl(FileProperties fileProperties) {
        filePath = Paths.get(fileProperties.getDocDir()).toAbsolutePath().normalize();
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        Path path = filePath.resolve(fileName).normalize();
        try {
            UrlResource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return resource;
            }
            throw new FileException("file " + fileName + " not found");
        } catch (MalformedURLException e) {
            throw new FileException("file " + fileName + " not found", e);
        }
    }
}
