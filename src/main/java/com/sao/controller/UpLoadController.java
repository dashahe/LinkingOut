package com.sao.controller;


import com.sao.service.UserDetailService;
import com.sao.utils.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class UpLoadController {

    private UserDetailService userDetailService;
    public static final String ROOT = "upload-dir";

    @Autowired
    public UpLoadController(UserDetailService userDetailService){
        this.userDetailService = userDetailService;
    }
    @PostMapping("/upload")
    public void handleFileUpload(@RequestParam(name = "file") MultipartFile file,
                                   HttpSession httpSession,
                                   RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (!file.isEmpty()) {
            try {
                String dest = ";";
                try {
                    File f = convert(file);
                    dest = QiniuUtil.Companion.generateUrl(f,"xxxx");
                }catch (Exception e){
                    e.printStackTrace();
                }

                userDetailService.updateImageByUid(Long.valueOf(
                        httpSession.getAttribute("uid").toString()),dest);

            } catch ( Exception e) {
                e.printStackTrace();
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
        }

    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        System.out.print("null file "+ convFile );
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    @GetMapping
    public String getPage(){
        return "test";
    }

}