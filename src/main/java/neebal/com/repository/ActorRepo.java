package neebal.com.repository;

import org.springframework.data.repository.CrudRepository;

import neebal.com.entity.Actor;
import neebal.com.entity.User;

public interface ActorRepo extends CrudRepository<Actor,Integer> {

}
