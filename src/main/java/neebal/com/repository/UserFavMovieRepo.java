package neebal.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import neebal.com.entity.Movie;
import neebal.com.entity.User;
import neebal.com.entity.UserFavMovie;

public interface UserFavMovieRepo extends  JpaRepository<UserFavMovie,Long>{

	public List<UserFavMovie> findByUserUserid(int id);

}
