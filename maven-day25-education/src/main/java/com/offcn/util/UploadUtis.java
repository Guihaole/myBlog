package com.offcn.util;

import cn.hutool.core.util.RandomUtil;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class UploadUtis {
    public  static String upload(Part part){
        String fileName = part.getSubmittedFileName();
        fileName= UUID.randomUUID()+fileName;
        InputStream is=null;
        OutputStream os=null;
        try {
            is = part.getInputStream();
            //os=new FileOutputStream("E:\\photo\\"+fileName);
            //os=new FileOutputStream("/software/tomcat6060/apache-tomcat-9.0.56/webapps/photo/"+fileName);
            os=new FileOutputStream("/software/tomcat/photo/"+fileName);
            IOUtils.copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
}
