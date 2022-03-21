/**
5.设置猫的数量
萨利·约翰逊曾经在泰若星球“无名小镇”星际车站的自助餐厅里工作，但是到了退休年龄她就停止工作了。
现在的她在收集猫。
多年以来，控制猫的数量变得越来越难：猫的繁殖速度太快了。
我们不会为萨利解决这个问题，但我们将编写一个方法来记录猫的数量。
编写方法，该方法必须设置猫的数量，并在main方法中正确的打印出猫的数量。

// 设置猫的数量
public class Cat {
    private static int catCount = 0;

    public static void setCatCount(int catCount) {
        //在此编写你的代码
    }

    public static void main(String[] args) {

    }
}
 */

class Test {
    public static void main(String[] args) {
        Cat.setCatCount(1);
        Cat.setCatCount(2);
        Cat.setCatCount(5);
        System.out.println(Cat.getCatCount()); // 8
    }
}

public class Cat {
    private static int catCount = 0;

    public static void setCatCount(int count) {
        catCount += count;
    }

    public static int getCatCount() {
        return catCount;
    }
}
