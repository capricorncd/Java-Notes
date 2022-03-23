/**
 * 3.显示从 1 到 10 的 10 个数字的乘积。
 * 结果是一个数字。
 * 你的秘密武器就是：while 循环。
 */
class Test {
    public static void main(String[] args) {
        int p = Product.calc();
        System.out.println(p); // 3628800
    }
}

public class Product {
    public static int calc() {
        int num = 10;
        int result = num;
        while (num > 1) {
            result *= --num;
        }
        return result;
    }
}
