package com.spring.javabased;

import java.util.Arrays;
import java.util.List;

public class Thriller implements IMovie {

	@Override
	public List<String> showMovieList() {
		return Arrays.asList("Ratchasan","Jailer");

	}

}
