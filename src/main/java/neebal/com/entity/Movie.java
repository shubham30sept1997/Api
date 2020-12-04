package neebal.com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="movie")
public class Movie {

	@Id//Marked as primary key
	@SequenceGenerator(name="CLIENT_SEQ",sequenceName="movie_movie_id_seq",allocationSize=1,initialValue=1)///name of the sequence,sequenceName 
	@GeneratedValue(generator="CLIENT_SEQ",strategy=GenerationType.SEQUENCE)///generate the root sequence
		@Column(name = "movie_id")
		int movieid;
		@Column(name = "title")
		String title;
		@Column(name = "description")
		String description;
		@Column(name="imageurl")
		String imageurl;
		@Column(name = "release_date")
		String releasedate;
		@Column(name = "length")
		String length;
		@Column(name = "rating")
		String rating;
		@Column(name = "avg_rating")
		Integer avgrating;
		@Column(name = "genre")
		String genre;

		@ManyToMany(mappedBy="movies")
		@JsonManagedReference
		 List<Actor> actor;
		
		/* @ManyToMany
		 @JoinTable(
			        name = "user_Fav_movie", 
			        joinColumns = { @JoinColumn(name = "email_id") }, 
			        inverseJoinColumns = { @JoinColumn(name = "movie_id") }
			    )
		  @JsonIgnore
		  private List <User> user;*/
		  
		
		public Movie() {
			
		}
	
		
		public List<Actor> getActor() {
			return actor;
		}


		public void setActor(List<Actor> actor) {
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
		public void setAvgrating(Integer avgrating) {
			this.avgrating = avgrating;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}




		


		public Movie(int movieid, String title, String description, String imageurl, String releasedate, String length,
				String rating, Integer avgrating, String genre, String user_rating, List<Actor> actor) {
			super();
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
		
			//this.actor = actor;
		
		}





		@Override
		public String toString() {
			return "Movie [movieid=" + movieid + ", title=" + title + ", description=" + description + ", imageurl="
					+ imageurl + ", releasedate=" + releasedate + ", length=" + length + ", rating=" + rating
					+ ", avgrating=" + avgrating + ", genre=" + genre +  "]";
		}




		
}
