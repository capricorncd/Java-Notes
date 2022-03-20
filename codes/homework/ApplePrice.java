public class ApplePrice {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.addPrice(50);
        Apple apple2 = new Apple();
        apple2.addPrice(100);
        System.out.println("apple price is " + Apple.price);
        // apple price is 150
    }

    public static class Apple {
        public static int price = 0;

        // 每次调用该方法，所有Apple实例的价格都会增加
        public void addPrice(int applePrice) {
            price += applePrice;
        }
    }
}
