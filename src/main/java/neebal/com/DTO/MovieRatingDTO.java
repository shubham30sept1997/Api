package neebal.com.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

import neebal.com.entity.MovieRating;



public class MovieRatingDTO implements Serializable {

	private Long id;
	private MovieDTO movie;
	private UserDTO user;
	private Integer rating;
	private String comment;
	private Timestamp timestamp;
	
	public MovieRatingDTO() {
		
	}
	
	public MovieRatingDTO(Long id, MovieDTO movie, UserDTO user, Integer rating, String comment, Timestamp timestamp) {
		super();
		this.id = id;
		this.movie = movie;
		this.user = user;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = timestamp;
	}
	

	public MovieRatingDTO(MovieDTO movie, UserDTO user, Integer rating, String comment, Timestamp timestamp) {
		super();
		this.movie = movie;
		this.user = user;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = timestamp;
	}
	
	
	
	

	public MovieRatingDTO(MovieDTO movie, Integer rating) {
		super();
		this.movie = movie;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}



	@Override
	public String toString() {
		return "MovieRating [movie=" + movie + ", user=" + user + ", rating=" + rating + ", comment=" + comment + "]";
	}
	
}
