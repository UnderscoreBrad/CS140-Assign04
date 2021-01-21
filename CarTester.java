package assignment04;
public class CarTester {
    public static void main(String[] args) {
        Car car = new Car(34, 10.0);
        double GG1 = 9.0;
        double DD1 = 30.0;
        double GG2 = 2.0;
        double DD2 = 60.0;
        car.addGas(GG1);
        car.drive(DD1);
        try {
            car.addGas(GG2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            car.drive(DD2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}