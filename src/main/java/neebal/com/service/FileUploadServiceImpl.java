package neebal.com.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import neebal.com.DTO.UserFavMovieDTO;
import neebal.com.DTO.UserProfileDTO;
import neebal.com.entity.Movie;
import neebal.com.entity.UploadedFile;
import neebal.com.entity.User;
import neebal.com.entity.UserFavMovie;
import neebal.com.entity.UserProfile;
import neebal.com.repository.FileUploadRepository;
import neebal.com.repository.RegisterRepo;
import neebal.com.repository.UserProfileRepo;
@Transactional
@Service
public class FileUploadServiceImpl {

	private String uploadFolderPath = "F:/work/";
    @Autowired
    private FileUploadRepository fileUploadRepository; 
    @Autowired
    private RegisterRepo registerRepo;
    @Autowired
    private UserProfileRepo profileRepo;

    public void uploadToLocal(MultipartFile file) {

        try {
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
    }
    
    public Path downloadFile1(String fileName) {

      Path dfile =Paths.get(uploadFolderPath + fileName);
	  return dfile;
    }
    


    public UploadedFile uploadToDb(MultipartFile file) {

        UploadedFile uploadedFile = new UploadedFile();
        try {
            uploadedFile.setFileData(file.getBytes());
            uploadedFile.setFileType(file.getContentType());
            uploadedFile.setFileName(file.getOriginalFilename());
            UploadedFile uploadedFileToRet = fileUploadRepository.save(uploadedFile);
            return uploadedFileToRet;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public UserProfile userProfile(UserProfileDTO userProfileDTO) throws Exception {
		Optional<UploadedFile> uploadedfile = fileUploadRepository.findById(userProfileDTO.getUploadedFile().getFileId());
		Optional<User> user = registerRepo.findById(userProfileDTO.getUser().getUserid());
		return profileRepo.save(new UserProfile(uploadedfile.get(), user.get()));
	}

    public UploadedFile downloadFile(String fileId) {
        UploadedFile uploadedFileToRet = fileUploadRepository.getOne(fileId);
        return uploadedFileToRet;
    }
}
