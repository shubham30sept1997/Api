package neebal.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neebal.com.DTO.MovieDTO;
import neebal.com.DTO.UserDTO;
import neebal.com.entity.Movie;
import neebal.com.entity.User;
import neebal.com.repository.RegisterRepo;

@Service
public class RegisterService {
	@Autowired
	private RegisterRepo registerRepo;// we inject this object when we create the object of Postserviceclass

	public List<UserDTO> getUser() {

		List<UserDTO> list = new ArrayList<>();

		Iterable<User> users = this.registerRepo.findAll();

		for (User user : users) {
			list.add(new UserDTO(user.getUserid(), user.getFullname(), user.getEmail(), user.getPassword()));
		}
		return list;

	}


	public Optional<UserDTO> getUserId(int id) {
		Optional<User> user1 = registerRepo.findById(id);
		User user = user1.get();
		return Optional.of(new UserDTO(user.getUserid(),user.getFullname(),user.getEmail()));
	}

	public User register(UserDTO user) throws Exception {

		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = java.util.regex.Pattern.compile(ePattern);
        String pattern1 = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        Pattern pattern2 = java.util.regex.Pattern.compile(pattern1);
        
		if (registerRepo.existsByEmail(user.getEmail())) {
			throw new Exception("user already exist");
		} else if(pattern.matcher(user.getEmail()).matches() && pattern2.matcher(user.getPassword()).matches())
		{
			registerRepo.save(new User(user.getUserid(), user.getFullname(), user.getEmail(), user.getPassword()));
	
		}else
		{
			throw new Exception("Please Enter Valid Email and Password");
		}
		return null;
		
	}
}