public class GetterSetter {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        GetterSetter obj = new GetterSetter();
        obj.setAge(10);
        obj.setName("Pedro");
        System.out.println("A idade do objeto é " + obj.age);
        System.out.println("O nome do objeto é " + obj.name);
    }
}
