public class CatName {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Shinba");
        System.out.println(cat.name);
    }

    public static class Cat {
        public String name;

        public void setName(String name) {
            this.name = name;
        }
    }
}
