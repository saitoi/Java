public class Principal {
    public static void main(String[] args) {
        ShapeFactory sf1 = new ShapeFactory();
        String forma = "Circle"; /* Recebe do usuário */
        Shape sh1 = sf1.getShape(forma);
        sh1.draw();
    }
}