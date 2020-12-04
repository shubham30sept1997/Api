package neebal.com.DTO;

import neebal.com.entity.Movie;
import neebal.com.entity.User;

public class UserFavMovieDTO {

	private Long id;
	private MovieDTO movie;

	private UserDTO user;


	
	public UserFavMovieDTO() {
	
	}




	public UserFavMovieDTO(Long id, MovieDTO movie, UserDTO user) {
		super();
		this.id = id;
		this.movie = movie;
		this.user = user;
	}




	public UserFavMovieDTO(MovieDTO movie, UserDTO user) {
	
		this.movie = movie;
		this.user = user;
	}
	



	public MovieDTO getMovie() {
		return movie;
	}


	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	
}
