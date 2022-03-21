/**
3.猫的名字叫什么？
一个人/机器人/变量在出生/生成/创建后收到的第一样东西就是名字。
我们的大脑不太愿意接受没有名字和头衔的世界。
我们来助它们一臂之力：创建一个特殊的自动命名方法，该方法设置 private String 变量 name 的值，即为对象命名。
已知main方法如下：
public static void main(String[] args) {
    Cat cat = new Cat();
    cat.setName("辛巴");
    System.out.println(cat.name);
}
创建Cat类，注意main方法中关于Cat类的相关内容。
 */

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Shinba");
        System.out.println(cat.getName());
    }
}

public class Cat {
    private String name;

    /**
     * 设置猫的名字
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取猫的名字
     * @return
     */
    public String getName() {
        return this.name;
    }
}
