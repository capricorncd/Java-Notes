public class AgeChange {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("age: " + person.age);
        person.adjustAge(20);
        System.out.println("new age: " + person.age);
    }

    public static class Person {
        public int age = 20;

        public void adjustAge(int age) {
            // 使设置的年龄增加20
            this.age = age + 20;
            System.out.println("age after adjustAge(): " + this.age);
        }
    }
}
