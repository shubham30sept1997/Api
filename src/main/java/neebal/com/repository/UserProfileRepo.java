package neebal.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import neebal.com.entity.UserFavMovie;
import neebal.com.entity.UserProfile;

public interface UserProfileRepo extends CrudRepository<UserProfile,Long> {

	public UserProfile findByUserUserid(int id);

	public boolean existsByUserUserid(int userid);
	


}
