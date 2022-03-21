/**
7.宇宙中的猫
在 2010 年，猫控制了互联网，而在 3258 年，它们在 PurPurr 行星上发动了软政变。
PurPurr 行星位于“星系冲击”行星系统的中心。
无人反抗的政变称为软政变。
有一个问题：猫很多，尽管它们处于统治地位，但它们基本上不知道如何计数。
我们来帮助它们生成一个计数器。
编写代码以正确对所创建的猫的数量进行计数 (count)，并在屏幕上显示猫的正确数量。

public class 类名{

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        //在此编写你的代码

        Cat cat2 = new Cat();
        //在此编写你的代码

        System.out.println("猫的计数为 " + Cat.count);
    }

    public static class Cat {
        public static int count = 0;
    }
}
 */
class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        //在此编写你的代码
        cat1.setCount();

        Cat cat2 = new Cat();
        //在此编写你的代码
        cat2.setCount();

        System.out.println("猫的计数为 " + Cat.count);
    }
}

class Cat {
    public static int count = 0;

    public void setCount() {
        count++;
    }
}
