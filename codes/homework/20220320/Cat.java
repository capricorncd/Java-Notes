/**
4.对猫进行登记
有时候，猫的严重短缺比饥饿更能引起人们的关注。
为了消除这种不愉快的感觉，你需要实现 addNewCat 方法，该方法将在每次被调用时向你的程序中添加一只新猫。
请小心使用。猫越多意味着责任越大。别忘了在每创建一只猫时，将计数器加一。
每生出一只猫，就应该计数一次。

// 对猫进行登记
public class Cat {
    private static int catCount = 0;

    public static void addNewCat() {
        //在此编写你的代码
    }

    public static void main(String[] args) {

    }
}
 */

public class Cat {
    private static int catCount = 0;

    public static void addNewCat() {
        catCount++;
    }

    public static void main(String[] args) {
        Cat.addNewCat();
        Cat.addNewCat();
        Cat.addNewCat();
        System.out.println(Cat.catCount); // 3
    }
}

/**
public class Cat {
    private static int catCount = 0;

    public Cat() {
        catCount++;
    }

    public static void main(String[] args) {
        new Cat();
        System.out.println(Cat.catCount); // 1
    }
}
 */
