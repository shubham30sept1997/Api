package neebal.com.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import neebal.com.entity.Actor;
import neebal.com.entity.Movie;


public class MovieDTO implements Serializable {

	
		
		int movieid;
	
		String title;
		
		String description;
		
		String imageurl;
		
		String releasedate;
		
		String length;
		
		String rating;
	
		Integer avgrating;
		
		String genre;

		 List<Actor> actor;
		 
		public MovieDTO() {
			
		}

		public MovieDTO(int movieid, String title, String description, String imageurl, String releasedate,
				String length, String rating, Integer avgrating, String genre, List<Actor> actor) {
		
			this.movieid = movieid;
			this.title = title;
			this.description = description;
			this.imageurl = imageurl;
			this.releasedate = releasedate;
			this.length = length;
			this.rating = rating;
			this.avgrating = avgrating;
			this.genre = genre;
			this.actor = actor;
	
		}

		public int getMovieid() {
			return movieid;
		}

		public void setMovieid(int movieid) {
			this.movieid = movieid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImageurl() {
			return imageurl;
		}

		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}

		public String getReleasedate() {
			return releasedate;
		}

		public void setReleasedate(String releasedate) {
			this.releasedate = releasedate;
		}

		public String getLength() {
			return length;
		}

		public void setLength(String length) {
			this.length = length;
		}

		public String getRating() {
			return rating;
		}

		public void setRating(String rating) {
			this.rating = rating;
		}

		public Integer getAvgrating() {
			return avgrating;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}
		
		

	
		public List<Actor> getActor() {
			return actor;
		}

		public void setActor(List<Actor> actor) {
			this.actor = actor;
		}

		public void setAvgrating(Integer avgrating) {
			this.avgrating = avgrating;
		}


		
		
		
		  
		
	
}
