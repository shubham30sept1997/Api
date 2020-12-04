package neebal.com.service;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neebal.com.DTO.MovieDTO;
import neebal.com.DTO.UploadedFileDTO;
import neebal.com.DTO.UserDTO;
import neebal.com.DTO.UserProfileDTO;
import neebal.com.entity.Movie;
import neebal.com.entity.UploadedFile;
import neebal.com.entity.User;
import neebal.com.entity.UserProfile;
import neebal.com.repository.FileUploadRepository;
import neebal.com.repository.LoginRepo;
import neebal.com.repository.UserProfileRepo;
import neebal.com.response.Response;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;// we inject this object when we create the object of Postserviceclass
	@Autowired
	private UserProfileRepo userProfileRepo;
	@Autowired
	private FileUploadRepository fileUploadRepository;

	public UserProfileDTO login(User user) throws Exception {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		Pattern pattern = java.util.regex.Pattern.compile(ePattern);
		String pattern1 = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		Pattern pattern2 = java.util.regex.Pattern.compile(pattern1);
		if (loginRepo.existsByEmail(user.getEmail()) && loginRepo.existsByPassword(user.getPassword())
				&& pattern.matcher(user.getEmail()).matches() && pattern2.matcher(user.getPassword()).matches()) {

			User user1 = this.loginRepo.findByemailLike(user.getEmail());
			if (userProfileRepo.existsByUserUserid(user1.getUserid())) {
				UserProfile user2 = userProfileRepo.findByUserUserid(user1.getUserid());
				UploadedFileDTO upload = getFileId(user2.getUploadedFile().getFileId()).get();
				UserDTO user3 = getUserId(user2.getUser().getUserid());
				return new UserProfileDTO(upload, user3);
			} else {
				UserDTO user5 = getUserId(user1.getUserid());
				return new UserProfileDTO(user5);
			}
		} else {

			throw new Exception("Invalid Username and Password");

		}
	}

	public Optional<UploadedFileDTO> getFileId(String id) {
		Optional<UploadedFile> file1 = fileUploadRepository.findById(id);
		UploadedFile file = file1.get();
		return Optional.of(new UploadedFileDTO(file.getFileId()));
	}

	public UserDTO getUserId(int id) {
		Optional<User> user = loginRepo.findById(id);
		User user1 = user.get();
		return new UserDTO(user1.getUserid(), user1.getFullname(), user1.getEmail());

	}

}
