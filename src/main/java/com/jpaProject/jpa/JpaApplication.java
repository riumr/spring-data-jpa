package com.jpaProject.jpa;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import com.github.javafaker.Faker;
import com.jpaProject.jpa.models.Author;
import com.jpaProject.jpa.models.Video;
import com.jpaProject.jpa.repository.AuthorRepository;
import com.jpaProject.jpa.repository.VideoRepository;
import com.jpaProject.jpa.specification.AuthorSpecification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository,VideoRepository videoRepository){
		return args->{
			for(int i=0; i<50; i++){
				Faker faker = new Faker();
				var author = Author.builder()
							.firstName(faker.name().firstName())
							.lastName(faker.name().lastName())
							.age(faker.number().numberBetween(19, 50))
							.email(faker.name().username()+i+"@mail.com")
							.build();
				repository.save(author);
			}
			// update Author with ID = 1
				var author = Author.builder()
							.id(1)
							.firstName("john")
							.lastName("son")
							.age(30)
							.email("new@mail.com")
							.build();
				// repository.save(author);
			// update Author set a.age = 25 where a.id = 1
			// repository.updateAuthor(25, 1);
			// update Author set a.age = 24
			// repository.updateAllAuthorsAge(24);

			// find by named query
			// repository.findByNamedQuery(30).forEach(System.out::println);

			// update with named query
			// repository.updateByNamedQuery(40);
			Specification spec = Specification
				.where(AuthorSpecification.hasAge(23))
				.or(AuthorSpecification.firstnameLike("Mi"));
			repository.findAll(spec).forEach(System.out::println);
		};

	}

}
