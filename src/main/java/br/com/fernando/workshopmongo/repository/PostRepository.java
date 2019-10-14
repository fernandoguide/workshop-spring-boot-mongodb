package br.com.fernando.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fernando.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	
//	metodo para fazer busca personalizada no mongoDB 
//	$regex: ?0 quer dizer q eh o primeiro paramentro passado como argumento no metodo
//	$options: 'i' eh uma opcao do mongoDB para ignorar letras maiusculas e minusculas
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

}
