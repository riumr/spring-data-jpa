package com.jpaProject.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpaProject.jpa.models.Author;
import com.jpaProject.jpa.models.Video;
import com.jpaProject.jpa.repository.AuthorRepository;
import com.jpaProject.jpa.repository.VideoRepository;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository,VideoRepository videoRepository){
		return args->{
			// var author = Author.builder()
			// 			.firstName("John")
			// 			.lastName("Willam")
			// 			.age(23)
			// 			.email("e@mail.com")
			// 			.build();
			// repository.save(author);
			var video = Video.builder()
				.name("abc")
				.length(5)
				.build();
			videoRepository.save(video);
		};
	}

}
