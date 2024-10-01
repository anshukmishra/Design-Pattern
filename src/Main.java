import creational.singleton.DoubleCheckSingleton;
import creational.singleton.SingletonDesign;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SingletonDesign singletonDesign = SingletonDesign.getInstance();
        SingletonDesign singletonDesign1 = SingletonDesign.getInstance();
        if(singletonDesign1 == singletonDesign){
            System.out.println("kaam kr gya");
        }

        DoubleCheckSingleton doubleSingletonDesign = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleSingletonDesign1 = DoubleCheckSingleton.getInstance();
        if(doubleSingletonDesign == doubleSingletonDesign1){
            System.out.println("kaam kr gya1");
        }
    }
}