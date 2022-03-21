/**
1.这个年龄不适合我...
有时我们所有人都想更改自己的年龄。例如，当他们不想向你出售香烟或啤酒时。
或者，当你的头发开始稀疏，背部又酸又痛时！程序员可能无法控制时间，但是他们可以完全控制程序中的数据。
在此任务中，我们将纠正一个错误，以使 Person 对象的 age 变量收到不同的值。
考虑一下程序该怎么做。
修复编程错误，以使 person.age 可以正确更改值。（考虑一下this关键字）

public class 类名{

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("年龄：" + person.age);
        person.adjustAge(person.age);
        System.out.println("调整后的年龄：" + person.age);
    }

    public static class Person {
        public int age = 20;

        public void adjustAge(int age) {
            age = age + 20;
            System.out.println("adjustAge() 中的年龄为 " + age);
        }
    }
}
 */

public class AgeCheat {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("age: " + person.age);
        person.adjustAge(20);
        System.out.println("new age: " + person.age);
    }

    // error: non-static variable this cannot be referenced from a static context
    // public class Person {
    public static class Person {
        // Person默认年龄
        public int age = 20;

        /**
         * 调整年龄，使设置的年龄增加20
         * @param age
         */
        public void adjustAge(int age) {
            this.age = age + 20;
            System.out.println("age after adjustAge(): " + this.age);
        }
    }
}
