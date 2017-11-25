package com.vikram.spring.springWebApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.vikram.spring.springWebApp.model.Author;
import com.vikram.spring.springWebApp.model.Book;
import com.vikram.spring.springWebApp.model.Publisher;
import com.vikram.spring.springWebApp.repository.AuthorRepository;
import com.vikram.spring.springWebApp.repository.BookRepository;
import com.vikram.spring.springWebApp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	
	

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {

		Author eric = new Author("Eric","Evans");
		Publisher hc = new Publisher("Harper Collins", "New york");
		Book ddd = new Book("Domain Driven Design", "1234", hc);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		
		Author rod = new Author("Rod","Johnson");
		Publisher worx = new Publisher("Worx", "Chicago");
		Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		authorRepository.save(eric);
		
		publisherRepository.save(hc);
		publisherRepository.save(worx);
		bookRepository.save(ddd);
		bookRepository.save(noEJB);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
}
