package com.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR="F:\\Spring Boot Projects\\bootrestbook\\src\\main\\resources\\static\\images";
    public boolean uploadFile(MultipartFile file){
        boolean status = false;

        try {
           // Old Technique
            InputStream is = file.getInputStream();
            byte data[] = new byte[is.available()];
            is.read(data);
            // write(Old Technique)
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();

           //    New Technique
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

            
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
