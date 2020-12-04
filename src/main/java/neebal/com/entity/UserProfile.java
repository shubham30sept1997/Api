package neebal.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class UserProfile {

	
	@Id
	@SequenceGenerator(name="CLIENT_SEQ",sequenceName="user_profile_id_seq",allocationSize=1,initialValue=1)///name of the sequence,sequenceName 
	@GeneratedValue(generator="CLIENT_SEQ",strategy=GenerationType.SEQUENCE)
	private Long id;
	@OneToOne
	
	private UploadedFile uploadedFile;

	@OneToOne
	private User user;
	

	public UserProfile() {
		super();
	}


	public UserProfile(UploadedFile uploadedFile, User user) {
	
		this.uploadedFile = uploadedFile;
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}


	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
}
