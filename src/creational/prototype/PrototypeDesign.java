package creational.prototype;

class Car implements Cloneable {
    private final String make;
    private final String model;
    private final String submodel;
    private final int madeYear;

    Car(String make, String model, String submodel, int madeYear) {
        this.madeYear = madeYear;
        this.make = make;
        this.model = model;
        this.submodel = submodel;
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Car(this.make, this.model, this.submodel, this.madeYear);
        }
    }

    @Override
    public String toString() {
        return "Car [make=" + make + ", model=" + model + ", submodel=" + submodel + ", madeYear=" + madeYear + "]";
    }
}

public class PrototypeDesign {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "S23", "XYZ", 2020);
        Car protoCar = car.clone();

        System.out.println("Original Car HashCode: " + car.hashCode());
        System.out.println("Cloned Car HashCode: " + protoCar.hashCode());

        System.out.println("Original Car: " + car.toString());
        System.out.println("Cloned Car: " + protoCar.toString());
    }
}
