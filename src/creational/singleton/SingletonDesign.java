package creational.singleton;

public class SingletonDesign {
    private static SingletonDesign singletonDesignInstance;

    private SingletonDesign(){
    }

    public static synchronized SingletonDesign getInstance(){
        if(singletonDesignInstance==null){
            singletonDesignInstance = new SingletonDesign();
        }
        return singletonDesignInstance;
    }
};
