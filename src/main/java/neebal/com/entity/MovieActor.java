package neebal.com.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class MovieActor implements Serializable {
	
	@Id
	@SequenceGenerator(name="CLIENT_SEQ",sequenceName="movie_actor_rating__id_seq",allocationSize=1,initialValue=1)///name of the sequence,sequenceName 
	@GeneratedValue(generator="CLIENT_SEQ",strategy=GenerationType.SEQUENCE)
	private Long id;
	@OneToMany
	private Movie movie;
	@OneToMany
	private Actor actor;
	
	public MovieActor() {
		
	}
	public MovieActor(Long id, Movie movie, Actor actor) {
		super();
		this.id = id;
		this.movie = movie;
		this.actor = actor;
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
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}

}
