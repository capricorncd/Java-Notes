/**
 * 2.乘法表
 * 在古代，几乎没有机器人，因此人类的孩子必须学习乘法表。
 * 太残忍了！他们一遍又一遍地将乘法表写在笔记本中。
 * 多浪费时间啊！我们不会使用任何纸张，也没有必要教你学习乘法表。
 * 我们只是在屏幕上显示这个表。
 */
class Test {
    public static void main(String[] args) {
        // 实例化对象
        MultiplicationTable mt = new MultiplicationTable();
        mt.createAndPrint();
    }
}

public class MultiplicationTable {
    /**
     * 创建并打印乘法表
     */
    public void createAndPrint() {
        StringBuffer[] arr = new StringBuffer[9];

        // 初始化StringBuffer
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuffer("| ");
        }

        // 创建乘法表
        int temp;
        for (int i = 1; i <= 9; i++) {
            for (int j = i; j <= 9; j++) {
                temp = i * j;
                // 小于10的结果增加一个空格，使其对齐 ixj= 8 | ixj=10
                arr[j - 1].append(i + "x" + j + "=" + (temp < 10 ? " " + temp : temp) + " | ");
            }
        }

        for (StringBuffer stringBuffer : arr) {
            // 打印输出
            System.out.println(stringBuffer.toString());
        }
    }
}

/**
 * 1x1=1 |
 * 1x2=2 | 2x2= 4 |
 * 1x3=3 | 2x3= 6 | 3x3= 9 |
 * 1x4=4 | 2x4= 8 | 3x4=12 | 4x4=16 |
 * 1x5=5 | 2x5=10 | 3x5=15 | 4x5=20 | 5x5=25 |
 * 1x6=6 | 2x6=12 | 3x6=18 | 4x6=24 | 5x6=30 | 6x6=36 |
 * 1x7=7 | 2x7=14 | 3x7=21 | 4x7=28 | 5x7=35 | 6x7=42 | 7x7=49 |
 * 1x8=8 | 2x8=16 | 3x8=24 | 4x8=32 | 5x8=40 | 6x8=48 | 7x8=56 | 8x8=64 |
 * 1x9=9 | 2x9=18 | 3x9=27 | 4x9=36 | 5x9=45 | 6x9=54 | 7x9=63 | 8x9=72 | 9x9=81
 */
