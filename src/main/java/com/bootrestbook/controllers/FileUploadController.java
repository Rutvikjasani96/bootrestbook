package com.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;
    
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

        try {
            // Validations
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Can't be Empty");
            }
            // if(!file.getContentType().equals("image/jpg")){
            //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPG File is Supported...");
            // }

            // Upload File
            boolean status = fileUploadHelper.uploadFile(file);

            if(status){
                return ResponseEntity.ok("File Uploaded Successfully...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong! Try again Later...");
    }
}
