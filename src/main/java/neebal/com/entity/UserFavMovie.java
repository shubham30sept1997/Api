package neebal.com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
//@IdClass(UserFavMovie.class)
public class UserFavMovie implements Serializable {
	
	@Id
	@SequenceGenerator(name="CLIENT_SEQ",sequenceName="user_fav_movie_id_seq",allocationSize=1,initialValue=1)///name of the sequence,sequenceName 
	@GeneratedValue(generator="CLIENT_SEQ",strategy=GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne
	
	private Movie movie;
	@ManyToOne
	
	private User user;
	
	public UserFavMovie() {
	}

	public UserFavMovie(Movie movie, User user) {
		this.movie = movie;
		this.user = user;
	}

	public UserFavMovie(Long id, Movie movie, User user) {
		super();
		this.id = id;
		this.movie = movie;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserFavMovie [movie=" + movie + ", user=" + user + "]";
	}
	
	
}
