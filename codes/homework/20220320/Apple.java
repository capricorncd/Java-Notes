/**
2.苹果的价格
在农业星球 Appleside 上，绝大多数居民的主要收入来源都是
将银河系这一侧最好的苹果卖给联邦商船和来访的游客。
让我们与一个抽象买家建立业务关系。
考虑到这个季节即将结束，我们必须想个办法熬过冬天：编写一个方法来提高苹果的价格！
计算苹果的总费用。
苹果的总费用与 public static int applePrice 相对应。

public class 类名{
    public static void main(String[] args) {

        Apple apple = new Apple();
        apple.addPrice(50);
        Apple apple2 = new Apple();
        apple2.addPrice(100);
        System.out.println("苹果的价格为 " + Apple.applePrice);
    }    
}
public class Apple {
        public static int applePrice = 0;

        public void addPrice(int applePrice) {
            //在此编写你的代码

        }
}
 */
public class Test {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.addPrice(50);
        Apple apple2 = new Apple();
        apple2.addPrice(100);
        System.out.println("apple price is " + Apple.price);
        // apple price is 150
    }
}

public class Apple {
    public static int price = 0;

    // 修改所有Apple实例的价格
    public void addPrice(int applePrice) {
        price = applePrice;
    }
}