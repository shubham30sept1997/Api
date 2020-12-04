package neebal.com.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

import neebal.com.entity.Movie;

/**
 * @author SHRUTI
 *
 */

public class ActorDTO implements Serializable{
	

		int actorid;
		
		String firstname;
		
		String lastname;
		
		String imageurl;
		
		 private List <Movie> movies;

		public ActorDTO() {
			super();
		}

		
		public ActorDTO(int actorid, String firstname, String lastname, String imageurl,List <Movie> movies) {
			super();
			this.actorid = actorid;
			this.firstname = firstname;
			this.lastname = lastname;
			this.imageurl = imageurl;
			this.movies = movies;
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

		public String getImageurl() {
			return imageurl;
		}

		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}
		
		public List<Movie> getMovies() {
			return movies;
		}

		public void setMovies(List<Movie> movies) {
			this.movies = movies;
		}

		@Override
		public String toString() {
			return "ActorDTO [actorid=" + actorid + ", firstname=" + firstname + ", lastname=" + lastname
					+ ", imageurl=" + imageurl + ", movies=" + movies + "]";
		}

	
	    
	
		
}
