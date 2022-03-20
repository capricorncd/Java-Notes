public class CatCount {
    private static int catCount = 0;

    public static void setCatCount(int count) {
        catCount += count;
    }

    public static void main(String[] args) {
        CatCount.setCatCount(1);
        CatCount.setCatCount(2);
        CatCount.setCatCount(5);
        System.out.println(CatCount.catCount); // 8
    }
}
