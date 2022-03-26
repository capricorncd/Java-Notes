import java.util.regex.*;

/**
 * 6.人
 * 创建人意味着巨大的责任，但这不是我们现在讨论的主题。
 * 我们需要说明和展示如何创建不同的类，而你的任务是理解这些概念并将其付诸实践。
 * 具体点说，我们来创建 Person 类。一个人应该有名字 (name)、年龄 (age)、地址 (address) 和性别 (sex)。
 * 还有别的吗？
 * Person 类应包含 String 变量 name、int 变量 age、String 变量 address 和 char 变量 sex。
 * 
 */
class Test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Tom");
        p1.setSex('m');
        System.out.println(p1);
    }
}

public class Person {
    private String name;
    private int age;
    private String address;
    // M or F
    private char sex;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setSex(char sex) {
        if (this.isSex(sex)) {
            // 统一为大写字母
            this.sex = String.valueOf(sex).toUpperCase().charAt(0);
        } else {
            throw new Error("Invalid sex input, please enter M or F.");
        }
    }

    public char getSex() {
        return this.sex;
    }

    public String toString() {
        String sex = "Unknown";
        // null check
        if (this.sex != '\0') {
            sex = this.sex == 'M' ? "Male" : "Female";
        }
        return this.name + " is " + this.age + " years old. " + sex + ", " + this.address;
    }

    /**
     * sex check
     * 
     * @param str
     * @return
     */
    private boolean isSex(char str) {
        String regex = "^[mfMF]$";
        Matcher m = Pattern.compile(regex).matcher(String.valueOf(str));
        return m.matches();
    }
}
