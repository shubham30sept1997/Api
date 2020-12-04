package neebal.com.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neebal.com.DTO.UserDTO;
import neebal.com.entity.User;
import neebal.com.service.RegisterService;
@RestController

public class RegistrationController {

		@Autowired
		private RegisterService service;
		
		@RequestMapping(method = RequestMethod.GET,value="/getRegister")
		public List<UserDTO> getRegister() {
			return service.getUser();
		}

		/*@GetMapping("/register/{id}") // springboot will get notify that this specific part is nothing but variable-id
		public ResponseEntity<UserDTO> getRegisterId(@PathVariable(value="user_id")int id)// using annotation automatic autowired is performed
		{
			return ResponseEntity.ok().body(service.getUserId(id).get());
		}*/
		
		@PostMapping("/register")
		public User Register(@Validated @RequestBody UserDTO listelement) throws Exception// annotation is used for converting the information in proper			// format
		// and associating and initializing value
		{
			 return service.register(listelement);
		}
	}


