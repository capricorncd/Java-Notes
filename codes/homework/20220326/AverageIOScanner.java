import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 7.算术平均值
 * 算术平均值是统计中经常使用的值。使用算术平均值的公式可以精确计算出医院的平均温度。现在我们进入关键部分：编写一个程序，该程序从键盘获取数字，对其求和，然后计算平均值，直至用户输入数字
 * -1 为止。
 * 使用键盘输入数字，然后计算算术平均值。
 * 如果用户输入 -1，则显示所有输入数字的算术平均值并结束程序。
 * -1 不应包含在计算中。
 * 
 * 下面是一些示例：
 * a) 如果输入以下数字
 * 1
 * 2
 * 2
 * 4
 * 5
 * -1
 * 则显示
 * 2.8
 * 
 * b) 如果输入以下数字
 * 4
 * 3
 * 2
 * 1
 * -1
 * 则显示
 * 2.5
 * 
 * 提示：解决这个问题的方法之一使用以下结构：
 * 
 * while (true) {
 * int number = 读取数字;
 * if (检查数字是否是 -1)
 * break;
 * }
 */
class Test {
    public static void main(String[] args) {
        AverageIOScanner.run();
    }
}

public class AverageIOScanner {
    public static void run() {
        List<Integer> inputs = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an integer, the program ends when -1 is entered\n");

        int input;
        while (true) {
            // check number
            if (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Please enter an integer...\n");
            } else {
                input = sc.nextInt();
                if (input == -1)
                    break;
                inputs.add(input);
            }
        }

        sc.close();

        double sum = 0;
        for (int i = 0; i < inputs.size(); i++) {
            sum += inputs.get(i);
        }

        double result = sum / inputs.size();

        // 保留一位小数
        System.out.println("Average is " + String.format("%.1f", result));
    }
}
