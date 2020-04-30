
    Lambda表达式包含3个部分
    1. 参数列表
    2. 箭头
    3. Lambda主体
    
    以下都是Lambda表达式的例子
    
    (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    (String s) -> s.length();
    
    (String s) -> s.length() > 100;
    
    () -> 42;

    (int x, int y) -> {
        System.out.print("Result:");
        System.out.println(x + y);
    };

    () -> "Raoul";

    () -> {return "Mario";}

    (List<String> list) -> list.isEmpty()
    
    () -> new Apple(10)
    
    (Apple a) -> {
        System.out.println(a.getWeight());
    }
    
    (int a, int b) -> a * b
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    