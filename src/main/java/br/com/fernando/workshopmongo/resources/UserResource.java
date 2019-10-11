package br.com.fernando.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.workshopmongo.domain.User;
import br.com.fernando.workshopmongo.dto.UserDTO;
import br.com.fernando.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	@RequestMapping(method=RequestMethod.GET)
//	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
//		converte cada elemento da lista original para um elemento dto
//		a partir do java 8 conseguimos fazer expressoes lambda  e percorrer cada obj dentro da lista
//		para cada obj x da lista original  eu  reyotno um new DTO passando o X como argumento
//		por fim eu volto o stream para uma lista usando o .collect usando o Collectors.toList;
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()) ;
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	
	
}
