package com.spring.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping(value = "/")
public class UploadController {
    @Autowired
    ServletContext servletContext;
    @GetMapping()
    public String index() {
        return "upload";
    }
    @PostMapping(value="uploadFile")
    @ResponseBody
    String uploadFileHandler(@RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String pathName = servletContext.getRealPath("/resources/upload/");
            File dir = new File(pathName);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String fileSource = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();
            File serverFile = new File(fileSource);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            return "You upload successfully a file, at : "+fileSource;
        } catch (IOException e) {
            System.out.println(e);
           return  "Error when upload file"+ e;
        }
    }
}
