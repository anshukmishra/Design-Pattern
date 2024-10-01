package creational.builder;

class Car{
    private final String make;
    private final String model;
    private final String submodel;
    private final int madeYear;
    private final int enginePower;
    private final boolean hasAC;
    private final boolean hasMusic;

    Car(CarBuilder builder){
        this.make = builder.make;
        this.model = builder.model;
        this.submodel = builder.submodel;
        this.madeYear = builder.madeYear;
        this.enginePower = builder.enginePower;
        this.hasAC = builder.hasAC;
        this.hasMusic = builder.hasMusic;
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getSubmodel() {
        return submodel;
    }

    public int getMadeYear() {
        return madeYear;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public boolean isHasAC() {
        return hasAC;
    }

    public boolean isHasMusic() {
        return hasMusic;
    }
};

interface Builder{
    public Builder buildMake(String string);
    public Builder buildModel(String string);
    public Builder buildSubmodel(String string);
    public Builder buildMadeYear(int yr);
    public Builder buildEnginePower(int power);
    public Builder buildHasAC();
    public Builder buildHasMusic();
};

class CarBuilder implements Builder{
    String make;
    String model;
    String submodel;
    int madeYear;
    int enginePower;
    boolean hasAC;
    boolean hasMusic;

    @Override
    public CarBuilder buildMake(String string) {
        this.make = string;
        return this;
    }

    @Override
    public CarBuilder buildModel(String string) {
        this.model = string;
        return this;
    }

    @Override
    public CarBuilder buildSubmodel(String string) {
        this.submodel = string;
        return this;
    }

    @Override
    public CarBuilder buildMadeYear(int yr) {
        this.madeYear = yr;
        return this;
    }

    @Override
    public CarBuilder buildEnginePower(int power) {
        this.enginePower = power;
        return this;
    }

    @Override
    public CarBuilder buildHasAC() {
        this.hasAC = true;
        return this;
    }

    @Override
    public CarBuilder buildHasMusic() {
        this.hasMusic = true;
        return this;
    }

    public Car build(){
        return new Car(this);
    }
};

public class BuilderDesignPattern {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();
        Car car = builder.buildMake("Toyota").buildEnginePower(456).buildHasAC().buildHasMusic().buildMadeYear(2020).buildModel("C53").buildSubmodel("XYZ").build();
        System.out.println(car);
    }
}
