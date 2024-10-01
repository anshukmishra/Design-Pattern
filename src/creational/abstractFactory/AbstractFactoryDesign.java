package creational.abstractFactory;

interface CarFactory{
    Car getCar(String s);
    CarSpecs getCarSpecs(String s);
};

class NormalCarFactory implements CarFactory{
    @Override
    public Car getCar(String string){
        switch (string){
            case "sedan":
                return new Sedan();
            case "toyota":
                return new Toyota();
            default:
                return null;
        }
    }

    @Override
    public CarSpecs getCarSpecs(String string){
        switch (string){
            case "north":
                return new North();
            case "south":
                return new South();
            default:
                return null;
        }
    }
};

class PremiumCarFactory implements CarFactory{
    @Override
    public Car getCar(String string){
        switch (string){
            case "mercedes":
                return new Mercedes();
            case "bugatti":
                return new Bugatti();
            default:
                return null;
        }
    }

    @Override
    public CarSpecs getCarSpecs(String string){
        switch (string){
            case "north":
                return new North();
            case "south":
                return new South();
            default:
                return null;
        }
    }
};

interface Car{
    public void assemble();
};

class Sedan implements Car{
    @Override
    public void assemble(){
        System.out.println("Assembling Sedan");
    }
};

class Toyota implements Car{
    @Override
    public void assemble(){
        System.out.println("Assembling Toyata");
    }
};

class Mercedes implements Car{
    @Override
    public void assemble(){
        System.out.println("Assembling Mercedes");
    }
};

class Bugatti implements Car{
    @Override
    public void assemble(){
        System.out.println("Assembling Bugatti");
    }
};

interface CarSpecs{
    public void add();
};

class North implements CarSpecs{
    @Override
    public void add(){
        System.out.println("Adding north");
    }
};

class South implements CarSpecs{
    @Override
    public void add(){
        System.out.println("Adding south");
    }
};

class East implements CarSpecs{
    @Override
    public void add(){
        System.out.println("Adding east");
    }
};

class West implements CarSpecs{
    @Override
    public void add(){
        System.out.println("Adding west");
    }
};

class AbstractCarFactory{
    public CarFactory getCarFactoryInstance(String s){
        switch(s) {
            case "middle":
                return new NormalCarFactory();
            case "high":
                return new PremiumCarFactory();
            default:
                return null;
        }
    }
}

class Animal{
    private void het(){
        System.out.println("dsfh");
    }
}

class Dog extends Animal{
    public void het(){
        System.out.println("gsfdkjashdfgklfa");
    }
}

public class AbstractFactoryDesign {
    public static void main(String []args){
        AbstractCarFactory abstractCarFactory = new AbstractCarFactory();
        CarFactory carFactory = abstractCarFactory.getCarFactoryInstance("middle");
        Car car = carFactory.getCar("toyota");
        CarSpecs carSpecs = carFactory.getCarSpecs("north");
        car.assemble();
        carSpecs.add();
        Dog animal = new Dog();
        animal.het();
    }
}
