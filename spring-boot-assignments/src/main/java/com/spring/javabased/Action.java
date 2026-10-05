package com.spring.javabased;

import java.util.Arrays;
import java.util.List;

public class Action implements IMovie {

	@Override
	public List<String> showMovieList() {
		return Arrays.asList("KGF","Bahubali");

	}

}
