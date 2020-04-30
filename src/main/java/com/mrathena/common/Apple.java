package com.mrathena.common;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Apple {

	private Long weight;
	private String color;
	private String country;

	public static List<Apple> demo() {
		List<Apple> appleList = new LinkedList<>();
		appleList.add(new Apple(100L, "red", "china"));
		appleList.add(new Apple(200L, "red", "usa"));
		appleList.add(new Apple(300L, "yellow", "china"));
		appleList.add(new Apple(400L, "green", "china"));
		appleList.add(new Apple(500L, "blue", "china"));
		appleList.add(new Apple(600L, "red", "usa"));
		appleList.add(new Apple(700L, "wight", "usa"));
		appleList.add(new Apple(700L, "wight", "french"));
		appleList.add(new Apple(800L, "black", "china"));
		appleList.add(new Apple(600L, "red", "usa"));
		return appleList;
	}

}
