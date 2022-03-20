public class CatRegistration {
    private static int catCount = 0;

    public static void addNewCat() {
        catCount++;
    }

    public static void main(String[] args) {
        CatRegistration.addNewCat();
        CatRegistration.addNewCat();
        CatRegistration.addNewCat();
        System.out.println(CatRegistration.catCount); // 3
    }
}
