package com.spring.javabased;

import java.util.Arrays;
import java.util.List;

public class Comedy implements IMovie {

	@Override
	public List<String> showMovieList() {
		return Arrays.asList("Pammal K Smmandham","Pancha Thanthiram");

	}

}
