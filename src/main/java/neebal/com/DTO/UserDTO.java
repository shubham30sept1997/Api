package neebal.com.DTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonManagedReference;


public class UserDTO implements Serializable {

		
		int userid;
		
		String fullname;
	
		String email;
		
		String password;

		public UserDTO() {
			
		}
		

		public UserDTO(int userid, String fullname, String email) {
			super();
			this.userid = userid;
			this.fullname = fullname;
			this.email = email;
		}


		public UserDTO(int userid, String fullname, String email, String password) {
			super();
			this.userid = userid;
			this.fullname = fullname;
			this.email = email;
			this.password = password;
		}

		public int getUserid() {
			return userid;
		}

		public void setUserid(int userid) {
			this.userid = userid;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "UserDTO [userid=" + userid + ", fullname=" + fullname + ", email=" + email + ", password="
					+ password + "]";
		}
		
		
		
		
				
	
}
