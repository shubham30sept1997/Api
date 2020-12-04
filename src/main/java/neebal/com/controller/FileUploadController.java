package neebal.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import neebal.com.DTO.UserFavMovieDTO;
import neebal.com.DTO.UserProfileDTO;
import neebal.com.entity.UploadedFile;
import neebal.com.response.FileUploadResponse;
import neebal.com.service.FileUploadServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

//import javax.annotation.Resource;


@RestController
public class FileUploadController {
    @Autowired
    private FileUploadServiceImpl fileUploadService;

   /* @PostMapping("/upload/local")
    public void uploadLocal(@RequestParam("file")MultipartFile multipartFile) throws IOException {

         fileUploadService.uploadToLocal(multipartFile);


    }*/
  
    
    @PostMapping("/upload")
    public FileUploadResponse uploadFile(@RequestParam("file")MultipartFile multipartFile)
    {
       UploadedFile uploadedFile = fileUploadService.uploadToDb(multipartFile);
       FileUploadResponse response = new FileUploadResponse();
       if(uploadedFile!=null){
           String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                   .path("/download/")
                   .path(uploadedFile.getFileId())
                   .toUriString();
           response.setDownloadUri(downloadUri);
           response.setFileId(uploadedFile.getFileId());
           response.setFileType(uploadedFile.getFileType());
           response.setUploadStatus(true);
           response.setMessage("File Uploaded Successfully!");
           return response;

       }
       response.setMessage("Oops 1 something went wrong please re-upload.");
       return response;
    }
    
    @PostMapping(value = "/store")
	public void storeFile(@RequestBody UserProfileDTO listelement) throws Exception {
		fileUploadService.userProfile(listelement);
	}
    
    
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String id)
    {
        UploadedFile uploadedFileToRet =  fileUploadService.downloadFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(uploadedFileToRet.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename= "+uploadedFileToRet.getFileName())
                .body(new ByteArrayResource(uploadedFileToRet.getFileData()));
    }



}
