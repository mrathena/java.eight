package com.mrathena.part1.chapter3.section8;

import com.mrathena.common.Apple;

import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		// 比较器复合

		List<Apple> appleList = Apple.demo();
		System.out.println(appleList);

		System.out.println();
		appleList.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(appleList);

		System.out.println();
		appleList = Apple.demo();
		appleList.sort(Comparator.comparing(Apple::getWeight));
		System.out.println(appleList);

		System.out.println();
		appleList = Apple.demo();
		appleList.sort(Comparator.comparing(Apple::getWeight).reversed());
		System.out.println(appleList);

		System.out.println();
		appleList = Apple.demo();
		appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));
		System.out.println(appleList);
	}

}
