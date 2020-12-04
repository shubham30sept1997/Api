package neebal.com.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import neebal.com.entity.Actor;
import neebal.com.entity.Movie;

public class MovieActorDTO {


	private Long id;

	private MovieDTO movie;

	private ActorDTO actor;
	
	public MovieActorDTO() {
		super();
	}
	public MovieActorDTO(Long id, MovieDTO movie, ActorDTO actor) {
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
	public MovieDTO getMovie() {
		return movie;
	}
	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}
	public ActorDTO getActor() {
		return actor;
	}
	public void setActor(ActorDTO actor) {
		this.actor = actor;
	}

}
