package neebal.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user", schema = "public")
public class User {

	@Id//Marked as primary key
	@SequenceGenerator(name="CLIENT_SEQ",sequenceName="user_user_id_seq",allocationSize=1,initialValue=1)///name of the sequence,sequenceName 
	@GeneratedValue(generator="CLIENT_SEQ",strategy=GenerationType.SEQUENCE)///generate the root sequence
		@Column(name = "user_id")
		int userid;
		@Column(name = "fullname")
		String fullname;
		@Column(unique=true,name="email_id")
		String email;
		@Column(name = "password")
		String password;
		
		/*@ManyToMany(mappedBy="user")
		@JsonManagedReference
		 List<Movie> movies;*/
		
		public User() {
	
		}
		
		public User(int userid, String fullname, String email, String password) {
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
			return "User [userid=" + userid + ", fullname=" + fullname + ", email=" + email + ", password=" + password
					+ "]";
		}
		
		
		
	
}
