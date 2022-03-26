import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.我是山姆
 * 我不明白为什么苏斯博士笔下的虐待狂人物“我是山姆”要缠着别人吃绿鸡蛋和火腿，
 * 但是我们很钦佩他的执着精神。
 * 在 CodeGym 秘密中心，我们尊重经典。另外，我们也尊重组合学。
 * 因此，你的任务是：显示词语“山姆”、“我” 和“是”的所有可能的组合形式。
 */
class Test {
    public static void main(String[] args) {
        String[] input = { "山姆", "我", "是" };
        Sam<String> sam = new Sam<String>(input);
        sam.print();

        Integer[] nums = { 1, 2, 3, 4 };
        Sam<Integer> samNums = new Sam<Integer>(nums);
        samNums.print();
    }
}

public class Sam<T> {
    private List<T> input;
    private List<List<T>> result = new ArrayList<List<T>>();

    public Sam(T[] nums) {
        this.input = Arrays.asList(nums);
    }

    /**
     * handler
     * 
     * @param inputs
     */
    private void handler(List<T> inputs) {
        if (inputs.size() == this.input.size()) {
            this.result.add(inputs);
            return;
        }
        for (T item : this.input) {
            if (!inputs.contains(item)) {
                List<T> ls = new ArrayList<T>();
                ls.addAll(inputs);
                ls.add(item);
                this.handler(ls);
            }
        }
    }

    /**
     * print
     */
    public void print() {
        this.handler(new ArrayList<T>());

        for (int i = 0; i < this.result.size(); i++) {
            System.out.println(this.result.get(i));
        }
        // total
        System.out.println("Total: " + this.result.size());
    }
}