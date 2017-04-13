package br.com.interview.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.interview.json.User;
import br.com.interview.repository.UserRepository;

@Controller
@RequestMapping("/rest")
public class RestCRUDApi {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody User get(@PathVariable("id") Long id) {
		br.com.interview.entities.User u = repository.findOne(id);
		if (u != null) {
			User user = new User();
			BeanUtils.copyProperties(u, user);
			return user;
		} else {
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<User> list() {
		List<User> listReturn = new ArrayList<User>();
		List<br.com.interview.entities.User> list = repository.findAll();
		
		for (br.com.interview.entities.User user : list) {
			User u = new User();
			BeanUtils.copyProperties(user, u);
			listReturn.add(u);
		}
		return listReturn; 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody User update(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
		br.com.interview.entities.User u = repository.findOne(id);
		if (u != null) {
			BeanUtils.copyProperties(user, u, "id");
			u = repository.save(u);
			BeanUtils.copyProperties(u, user);
			return user;
		} else {
			throw new IllegalArgumentException("User does not exist!");
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody User save(@RequestBody User user) {
		br.com.interview.entities.User u = new br.com.interview.entities.User();
		BeanUtils.copyProperties(user, u);
		u.setId(UUID.randomUUID().getMostSignificantBits());
		repository.save(u);
		BeanUtils.copyProperties(u, user);
		return user;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		repository.delete(id);
	}
}
