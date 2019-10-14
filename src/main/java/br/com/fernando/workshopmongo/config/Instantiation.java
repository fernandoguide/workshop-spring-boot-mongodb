package br.com.fernando.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fernando.workshopmongo.domain.Post;
import br.com.fernando.workshopmongo.domain.User;
import br.com.fernando.workshopmongo.repository.PostRepository;
import br.com.fernando.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postReposiroty;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postReposiroty.deleteAll();
		

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User fernando = new User(null, "Fernando Oliveira", "fernando@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("14/10/2019"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("14/10/2019"), "Bom dia", "Acordei feliz hoje!", maria);

		userRepository.saveAll(Arrays.asList(maria, alex, bob, fernando));
		postReposiroty.saveAll(Arrays.asList(post1, post2));

	}

}
