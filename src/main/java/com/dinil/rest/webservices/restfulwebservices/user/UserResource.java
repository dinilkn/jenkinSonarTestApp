package com.dinil.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/users")
	public List<User> retrieveAllUser(){
		return userDaoService.findAllUser();
	}
	
	@GetMapping("/users/{id}")	
	public User retrieveUser(@PathVariable int id){
		
		User user =  userDaoService.findOne(id);
		if(user==null){
			throw new UserNotFoundException("ID  :"+id);
		}
		
//		Resource<User> resource = new Resource<User>(user);
//		ControllerLinkBuilder linkAllusers= linkTo(methodOn(this.getClass(), retrieveAllUser()));
//		resource.add(linkAllusers.withRel("all-Users"));
		
		return user;
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser = userDaoService.saveUser(user);
		
		//setting the status code and retrun uri
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
		}
	
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		User deletedUser = userDaoService.deleteById(id);
		
		if(deletedUser==null){
			throw new UserNotFoundException("ID :" + id);
		}
		
		//setting the status code and retrun uri
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(deletedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
		}
	
	
	@GetMapping("/helloWorldInternationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale){
		return messageSource.getMessage("good.morning.message",null,locale);
	}
}
