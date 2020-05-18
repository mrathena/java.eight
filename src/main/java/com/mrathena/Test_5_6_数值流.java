package com.mrathena;

import com.mrathena.common.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test_5_6_数值流 {

	public static void main(String[] args) {

		List<Dish> menu = Dish.demo();
		System.out.println(menu);

		// 暗含拆箱成本
		System.out.println();
		System.out.println(menu.stream().map(Dish::getCalories).reduce(0, Integer::sum));

		// IntStream
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		System.out.println(intStream.sum());

		// 装箱
		intStream = menu.stream().mapToInt(Dish::getCalories);
		Stream<Integer> integerStream = intStream.boxed();

		// OptionalInt
		System.out.println();
		intStream = menu.stream().mapToInt(Dish::getCalories);
		OptionalInt optionalInt = intStream.max();
		System.out.println(optionalInt);
		// 没有值的话返回1
		intStream = Arrays.stream(new int[]{1, 2});
		System.out.println(intStream.max().orElse(1));
		intStream = Arrays.stream(new int[1]);
		System.out.println(intStream.max().orElse(1));


	}

}
