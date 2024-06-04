package org.example.restexam.controller;

import org.example.restexam.domain.UploadInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class FileController {
    public ResponseEntity<String> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestPart("info")UploadInfo uploadInfo
            ){
        String message = "";
        System.out.println(file.getOriginalFilename() + "===================");
        System.out.println(uploadInfo.getDescription() + "===================");
        System.out.println(uploadInfo.getTag() + "===================");

        try {
            InputStream inputStream = file.getInputStream();
            StreamUtils.copy(inputStream, new FileOutputStream("C:/temp/upload/"+file.getOriginalFilename()));
            message = "SUCCESSFULLY UPLOADED "  + file.getOriginalFilename() + "!";
            return ResponseEntity.ok().body(message);
        }catch (IOException e) {
            message = "FAIL TO UPLOAD " + file.getOriginalFilename() + "!";
            return ResponseEntity.ok().body(message);
//            e.printStackTrace();
        }
//        return ResponseEntity.ok("File uploaded successfully");
    }
}
