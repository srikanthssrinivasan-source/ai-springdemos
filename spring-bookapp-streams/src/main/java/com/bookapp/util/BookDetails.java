package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;

@Component
public class BookDetails {
	
public List<Book> showBooks(){
		
		return Arrays.asList(
				new Book("Java in Action",1,"Kathy","Tech",1000),
				new Book("Java in Action",1,"Sripriya","Tech",3000),
				new Book("Java in Process",1,"Mathan","Practical",2000),
				new Book("Coding with Shrishti",1,"Shrishti","Selfhelp",5000),
				new Book("Coding with Shrishti",1,"Shrishti","Classroom",20000)
				);
		 
}

}
