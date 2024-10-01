package creational.lazy;

class ExpensiveResource {
    public ExpensiveResource() {
        System.out.println("ExpensiveResource initialized.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork() {
        System.out.println("ExpensiveResource is doing work.");
    }
}

class LazyInitializedResource {
    private ExpensiveResource resource;

    public ExpensiveResource getResource() {
        if (resource == null) {
            System.out.println("Creating ExpensiveResource for the first time.");
            resource = new ExpensiveResource();
        } else {
            System.out.println("ExpensiveResource already created, returning existing instance.");
        }
        return resource;
    }
}

public class LazyDesignPattern {
    public static void main(String[] args) {
        LazyInitializedResource lazyResource = new LazyInitializedResource();

        System.out.println("First call to getResource():");
        ExpensiveResource resource1 = lazyResource.getResource();
        resource1.doWork();

        System.out.println("Second call to getResource():");
        ExpensiveResource resource2 = lazyResource.getResource();
        resource2.doWork();
    }
}

