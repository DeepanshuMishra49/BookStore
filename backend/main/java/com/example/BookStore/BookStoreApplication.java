package com.example.BookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}
}
