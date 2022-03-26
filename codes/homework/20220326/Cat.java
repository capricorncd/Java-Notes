/**
 * 1.创建猫
 * 萨利·约翰逊有 500 只猫，另外还有几百只毛茸茸的动物以客人身份来拜访她们。
 * 因此，萨利决定制作一本特别的猫咪相册来记录它们的特征：
 * 名字 (name)、年龄 (age)、体重 (weight) 和力量 (strength)。
 * “为什么要记录力量？”你也许会问。
 * 在下一个任务中你就会明白我们为什么需要力量。现在，我们来实现 Cat 类。
 * 创建 Cat 类。Cat 类必须包含
 * String 变量 name、int 变量 age、int 变量 weight 以及 int 变量 strength。
 * 
 * 2.实现 fight 方法
 * 退休的上校西奥·巴斯利姆在年轻时曾经目睹过激烈的战斗场面，但是现在他很无聊。
 * 当得知邻居萨利·约翰逊收养了五百只猫时，他提议安排几场不流血的猫咪大战（她不会接受血腥战役）。
 * 只有一个小细节：我们需要实现一种基于体重、年龄和力量的猫咪作战机制。
 * 实现 boolean fight(Cat anotherCat) 方法：
 * 基于猫的体重、年龄和力量实现一种猫咪作战机制。
 * 你可以自行决定猫的性格如何影响战斗。
 * 方法应确定我们 (this) 是否赢得战斗，即，如果我们赢了，则返回 true，否则将返回 false。
 * 
 * 必须满足以下条件：
 * 如果 cat1.fight(cat2)，则返回 true，
 * 如果 cat2.fight(cat1)，则必须返回 false
 * 
 * 
 * 3.Dog/Cat 类的 getter 和 setter
 * 我们来创建 Dog/Cat 类。Dog/Cat 类应包含变量 name 和 age，以及这两个变量的 getter 和 setter。
 * getter 是将变量的当前值返回给调用方的方法。
 * setter 是狗的品种。
 * 但是，虽然我们目前谈论的是狗，此术语实际上与狗无关：在编程上下文中，setter 是将变量设置为新值的方法。
 * 创建 Dog/Cat 类。Dog/Cat 类应该包含 String 变量 name 和 int 变量 age。
 * 为 Dog/Cat 类的所有变量创建 getter 和 setter。
 * 
 * 
 * 4.三个“火枪手”
 * 在几个任务之前，CodeGym 秘密中心的学生创建了 Cat 类。
 * 现在来根据 Cat 类的形象和样式实际创建几只猫，或者更确切地说，将该类用作模式。
 * 应该有三只猫。为这三只猫注入新生命（或特定数据）。
 * 在 main 方法中，创建三个 Cat 对象并填充数据。
 * 使用第一个任务中的 Cat 类。你无需创建 Cat 类。
 * 
 * 
 * 5.猫类大屠杀
 * 如果你以为所有的猫都是可爱的小毛球，那你可能没有遇到过在某一区域为争夺霸权而进行激烈斗争的野猫。
 * 现在你可以见到它们了。
 * 更确切地说，现在要模拟一场决斗，参加者为附近三只最威猛的猫。
 * 对于战斗，我们将使用 boolean fight(Cat anotherCat) 方法。
 * 使用 Cat 类创建三只猫。
 * 在猫之间举行三组两两对战。
 * 你无需创建 Cat 类。对于战斗，请使用 boolean fight (Cat anotherCat) 方法。
 * 在屏幕上显示每场战斗的结果，每行显示一个结果。
 */
class Test {
    public static void main(String[] args) {
        // 4.三个“火枪手”
        Cat cat1 = new Cat("Tom");
        System.out.println(cat1);

        Cat cat2 = new Cat("Jack");
        System.out.println(cat2);

        Cat cat3 = new Cat("Jack");
        System.out.println(cat3);

        // 5.猫类大屠杀
        System.out.println("cat1 vs cat2, result: " + cat1.fight(cat2));
        System.out.println("cat1 vs cat3, result: " + cat1.fight(cat3));
        System.out.println("cat2 vs cat3, result: " + cat2.fight(cat3));
    }
}

public class Cat {
    private String name;
    private int age;
    private int weight;
    private Long strength;

    public Cat(String name) {
        this.name = name;
        this.age = (int) Math.round(Math.random() * 10);
        this.weight = (int) Math.round(Math.random() * 20);
        // 随机生成猫的力量值
        this.strength = Math.round(Math.random() * 3000);
    }

    // 3.Dog/Cat 类的 getter 和 setter
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 2.实现 fight 方法
     * 
     * @param anothrCat
     * @return boolean
     */
    public boolean fight(Cat anothrCat) {
        if (this.strength > anothrCat.strength) {
            return true;
        }
        return false;
    }

    /**
     * toString
     */
    public String toString() {
        return this.name + " cat " + this.age + " years old, weight " + this.weight + "kg, strength " + this.strength;
    }
}
