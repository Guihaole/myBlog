package com.edu.util;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class UploadFileUtils {

    /**
     * 上传头像工具类
     * @param part
     * @return
     */
    public static String uploadFile(Part part){
        File file = new File("E:/photo/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = part.getSubmittedFileName();
        fileName= UUID.randomUUID()+fileName;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            inputStream = part.getInputStream();
            fos = new FileOutputStream(file+"/"+fileName);
            int count=0;
            byte[] buf = new byte[1024];
            while ((count=inputStream.read(buf))!=-1) {
                fos.write(buf,0,buf.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
}
