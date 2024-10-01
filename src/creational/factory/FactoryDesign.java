package creational.factory;

abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units);
    }
};

class DomesticPlan extends Plan{
    @Override
    void getRate() {
        rate = 7.5;
    }
};

class CommercePlan extends Plan{
    @Override
    void getRate() {
        rate = 11.5;
    }
};

class PlanFactory{
    public Plan getPlan(String string){
        switch (string){
            case "Domestic":
                return new DomesticPlan();
            case "Commerce":
                return new CommercePlan();
            default:
                return null;
        }
    }
};

public class FactoryDesign {
    public static void main(String[] args) {
        PlanFactory planFactory = new PlanFactory();
        Plan plan = planFactory.getPlan("Domestic");
        System.out.println(plan);
    }
}
