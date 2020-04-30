package com.mrathena.common;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

	private String name;
	private boolean vegetarian;
	private int calories;
	private Type type;

	public enum Type {
		/**
		 *
		 */
		MEAT, FISH, OTHER
	}

	public static List<Dish> demo() {
		return Arrays.asList(
				new Dish("pork", false, 800, Type.MEAT),
				new Dish("beef", false, 700, Type.MEAT),
				new Dish("chicken", false, 400, Type.MEAT),
				new Dish("french fries", true, 530, Type.OTHER),
				new Dish("rice", true, 350, Type.OTHER),
				new Dish("season fruit", true, 120, Type.OTHER),
				new Dish("pizza", true, 550, Type.OTHER),
				new Dish("prawns", false, 300, Type.FISH),
				new Dish("salmon", false, 450, Type.FISH) );
	}

}
