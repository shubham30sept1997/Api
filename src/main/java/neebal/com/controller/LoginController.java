package neebal.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import neebal.com.DTO.UserDTO;
import neebal.com.DTO.UserProfileDTO;
import neebal.com.entity.User;
import neebal.com.response.FileUploadResponse;
//springboots default gives us JSON response
import neebal.com.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService service;

	@PostMapping("/login")
	public UserProfileDTO login(@Validated @RequestBody User user) throws Exception// annotation is used for converting
																					// the information in proper //
																					// format
	// and associating and initializing value
	{
		return service.login(user);

	}
}
