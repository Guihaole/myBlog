package com.offcn.util;

import java.io.File;

public class DeleteUtils {
    public static void deleteFile(String url){
        String[] split = url.split("/");
        String deleteFileName=split[split.length-1];
        //File file = new File("E:\\photo\\"+deleteFileName);
       // File file = new File("/software/tomcat6060/apache-tomcat-9.0.56/webapps/photo/"+deleteFileName);
       File file = new File("/software/tomcat/photo/"+deleteFileName);
        if(file.exists()){
            file.delete();
        }
    }
}
