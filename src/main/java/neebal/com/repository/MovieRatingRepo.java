package neebal.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import neebal.com.entity.MovieRating;
import neebal.com.entity.UserFavMovie;

public interface MovieRatingRepo extends  JpaRepository<MovieRating,Long>{

	public List<MovieRating> findByMovieMovieid(int id);
	public List<MovieRating> findByUserUserid(int id);
	
	@Query(value ="Select avg(rating) from Movie_Rating where movie_movie_id=?",nativeQuery = true)
	public Integer getAverageRating(int id);
	
	
	
}
