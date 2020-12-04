package neebal.com.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import neebal.com.entity.UploadedFile;
import neebal.com.entity.User;

public class UserProfileDTO {


	private Long id;
	
	private UploadedFileDTO uploadedFile;

	private UserDTO user;
	

	public UserProfileDTO(UserDTO user) {
	 this.user =user;
	}


	public UserProfileDTO(UploadedFileDTO uploadedFile, UserDTO user) {
		this.uploadedFile =uploadedFile;
		this.user = user;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public UploadedFileDTO getUploadedFile() {
		return uploadedFile;
	}


	public void setUploadedFile(UploadedFileDTO uploadedFile) {
		this.uploadedFile = uploadedFile;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
	
	
	
}
