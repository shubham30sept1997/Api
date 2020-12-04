package neebal.com.entity;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author SHRUTI
 *
 */
@Entity
@Table(name="actor")
public class Actor {
	
	@Id//Marked as primary key
		@Column(name = "actor_id")
		int actorid;
		@Column(name = "firstname")
		String firstname;
		@Column(name="lastname")
		String lastname;
		@Column(name="image_url")
		String imageurl;
		
	    @ManyToMany
	    @JoinTable(
		        name = "actor_movie", 
		        joinColumns = { @JoinColumn(name = "actor_id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "movie_id") }
		    )
	    	@JsonIgnore
	      private List <Movie> movies;
	    
		
		public Actor() {
			
		}

		public Actor(int actorid, String firstname, String lastname, String imageurl, List<Movie> movies) {
			super();
			this.actorid = actorid;
			this.firstname = firstname;
			this.lastname = lastname;
			this.imageurl = imageurl;
//			this.movies = movies;
		}

		public int getActorid() {
			return actorid;
		}
		public void setActorid(int actorid) {
			this.actorid = actorid;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
	public Collection<Movie> getMovies() {
			return movies;
		}
		public void setMovies(List<Movie> movies) {
			this.movies = movies;
		}
		
		public String getImageurl() {
			return imageurl;
		}

		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}

		

		
		/*public Movie getMovies() {
			return movies;
		}
		public void setMovies(Movie movies) {
			this.movies = movies;
		}*/
		
		
		
		
}
