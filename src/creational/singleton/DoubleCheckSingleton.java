package creational.singleton;

public class DoubleCheckSingleton {
    private static DoubleCheckSingleton doubleCheckSingletonInstance;

    private DoubleCheckSingleton(){

    }

    public static DoubleCheckSingleton getInstance(){
        if(doubleCheckSingletonInstance==null){
            synchronized (DoubleCheckSingleton.class){
                doubleCheckSingletonInstance = new DoubleCheckSingleton();
            }
        }
        return doubleCheckSingletonInstance;
    }
};
