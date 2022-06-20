package com.edu.controller.day03;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.UUID;

//文件上传功能
@Controller
public class UploadController {
    //http://localhost:6060/uploadFile
    @RequestMapping("/uploadFile")
    @ResponseBody
    public String upload(MultipartFile source) {
        String path = "E:\\photo";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        System.out.println(source.getName());
        String filename = source.getOriginalFilename();
        filename = UUID.randomUUID() + filename;
        try {
            source.transferTo(new File(file, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功";
    }

    //http://localhost:6060/showFileList
    @RequestMapping("/showFileList")
    public String FileList(Model model,HttpSession session) {
        String path = "E:\\photo";
        File file = new File(path);
        File[] files = file.listFiles();
        ArrayList<String> fileList = new ArrayList<>();
        for (File file1 : files) {
            if (!file1.toString().endsWith(".mp4")) {
                //E:/photo/
                fileList.add(file1.toString().substring(9));
            }
        }
        model.addAttribute("files",fileList);
        return "jpg";
    }

    //下载功能
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String filename) throws Exception {
        String path = "E:\\photo\\" + filename;
        File file = new File(path);
        //设置响应头，而原生是直接response设置
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment",
                new String(filename.getBytes("utf-8"), "ISO-8859-1"));
        //application_octet_stream
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.OK);
    }

    //下载功能二
    @RequestMapping("/download2")
    //http://localhost:6060/download2
    public ResponseEntity<byte[]> download2(String filename, HttpSession session) throws Exception {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/image/"+filename);

        String mimeType = servletContext.getMimeType(realPath);
        File file = new File(realPath);
        //设置响应头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", mimeType);
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode("图片.jpg", "utf-8"));
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.OK);
    }
}
