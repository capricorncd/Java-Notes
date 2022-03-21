/**
6.名字登记
行星总领事鲁弗斯·安德鲁·肖被卡在星际铁路上，因为负责登记联邦外交旅客宠物的程序发生了异常。
该程序用于记录名字的方法已被破坏。
我们来解决这个问题：编写铁路工人所需的 setName 方法。
完成 setName 方法的代码编写，让成员变量fullName的值与方法计算之后得到的fullName的值相等。

public class Cat {
    private String fullName;

    public void setName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;

        //在此编写你的代码
    }

    public static void main(String[] args) {

    }
}
 */
class Test {
    public static void main(String[] args) {
        NameRegistration cat = new NameRegistration();
        cat.setName("Abigail", "Doe");
        System.out.println("Cat's name is " + cat.getName());
    }
} 

public class NameRegistration {
    private String fullName;

    public void setName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;

        //在此编写你的代码
        this.fullName = fullName;
    }

    public String getName() {
        return this.fullName;
    }
}
