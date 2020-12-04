package neebal.com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class MovieRating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="CLIENT_SEQ",sequenceName="user_movie_rating__id_seq",allocationSize=1,initialValue=1)///name of the sequence,sequenceName 
	@GeneratedValue(generator="CLIENT_SEQ",strategy=GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne
	private Movie movie;
	@ManyToOne
	private User user;
	@Column(name="Rating")
	private Integer rating;
	@Column(name="Comment")
	private String comment;
	@Column(name="TimeStamp")
	private Timestamp timestamp;

	
	public MovieRating() {
		super();
	}


	public MovieRating(Long id, Movie movie, User user, Integer rating, String comment, Timestamp timestamp) {
		this.id = id;
		this.movie = movie;
		this.user = user;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = timestamp;
	}


	public MovieRating(Movie movie, User user, Integer rating, String comment, Timestamp timestamp) {
		super();
		this.movie = movie;
		this.user = user;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = timestamp;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MovieRating [movie=" + movie + ", user=" + user + ", rating=" + rating + ", comment=" + comment
				+ ", timestamp=" + timestamp + "]";
	}

}
