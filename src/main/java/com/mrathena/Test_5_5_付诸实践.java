package com.mrathena;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Test_5_5_付诸实践 {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);

		// (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
		System.out.println();
		transactions.stream().filter(item -> item.getYear() == 2011).sorted((o1, o2) -> o1.getValue() - o2.getValue()).forEach(System.out::println);
		transactions.stream().filter(item -> item.getYear() == 2011).sorted(comparing(item -> item.getValue())).forEach(System.out::println);
		transactions.stream().filter(item -> item.getYear() == 2011).sorted(comparing(Transaction::getValue)).forEach(System.out::println);
		Comparator<Transaction> comparator = new Comparator<Transaction>() {
			@Override
			public int compare(Transaction o1, Transaction o2) {
				return 0;
			}
		};
		comparator = (o1, o2) -> 0;
		BiFunction<Transaction, Transaction, Integer> biFunction = (o1, o2) -> 0;

		// (2) 交易员都在哪些不同的城市工作过？
		System.out.println();
		transactions.stream().map(item -> item.getTrader().getCity()).distinct().forEach(System.out::println);
		// 还可以
		System.out.println(transactions.stream().map(item -> item.getTrader().getCity()).collect(Collectors.toSet()));

		// (3) 查找所有来自于剑桥的交易员，并按姓名排序。
		System.out.println();
		transactions.stream().map(Transaction::getTrader).distinct().filter(item -> item.getCity().equals("Cambridge")).sorted(comparing(Trader::getName)).forEach(System.out::println);

		// (4) 返回所有交易员的姓名字符串，按字母顺序排序。
		System.out.println();
		transactions.stream().map(item -> item.getTrader().getName()).distinct().sorted(comparing(Function.identity())).forEach(System.out::println);
		// 答案
		transactions.stream().map(item -> item.getTrader().getName()).distinct().sorted().reduce((o1, o2) -> o1 + ", " + o2).ifPresent(System.out::println);
		// 还可以
		System.out.println(transactions.stream().map(item -> item.getTrader().getName()).distinct().sorted().collect(Collectors.joining()));

		// (5) 有没有交易员是在米兰工作的？
		System.out.println();
		boolean milan = transactions.stream().anyMatch(item -> item.getTrader().getCity().equals("Milan"));
		System.out.println(milan);

		// (6) 打印生活在剑桥的交易员的所有交易额。
		System.out.println();
		transactions.stream().filter(item -> item.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);

		// (7) 所有交易中，高的交易额是多少？
		System.out.println();
		transactions.stream().max(comparing(Transaction::getValue)).ifPresent(item -> System.out.println(item.getValue()));
		// 还可以
		transactions.stream().mapToInt(Transaction::getValue).reduce((o1, o2) -> o1 > o2 ? o1 : o2).ifPresent(System.out::println);
		transactions.stream().mapToInt(Transaction::getValue).reduce((o1, o2) -> Math.max(o1, o2)).ifPresent(System.out::println);
		transactions.stream().mapToInt(Transaction::getValue).reduce(Math::max).ifPresent(System.out::println);
		transactions.stream().mapToInt(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
		System.out.println(transactions.stream().mapToInt(Transaction::getValue).reduce(0, Integer::max));

		// (8) 找到交易额最小的交易
		System.out.println();
		transactions.stream().min(comparing(Transaction::getValue)).ifPresent(System.out::println);
		// 还可以
		transactions.stream().reduce((o1, o2) -> o1.getValue() > o2.getValue() ? o2 : o1).ifPresent(System.out::println);

	}

}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Trader {
	private String name;
	private String city;
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Transaction {
	private Trader trader;
	private int year;
	private int value;
}