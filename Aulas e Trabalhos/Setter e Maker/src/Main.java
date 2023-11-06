public class Main {

    public static void main(String[] args) {

        Car car = new Car("Porsche", "Carrera", "black", 2, true);
        System.out.println("make = " + car.getMake());
        System.out.println("model = " + car.getModel());
        car.describeCar();

        Car targa = new Car("Porsche", "Targa", "red", 2, false);
        targa.describeCar();
    }
}
