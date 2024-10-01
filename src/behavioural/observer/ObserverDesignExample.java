package behavioural.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
};

class User implements Observer {
    String name;
    int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }

    void sendMessage(String message, Subject subject) {
        System.out.println(name + " sent message: " + message);
        subject.notifyObservers(message, this);
    }
};

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message, Observer sender);
};

class UserManagement implements Subject {
    List<Observer> userList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        userList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        userList.remove(observer);
    }

    @Override
    public void notifyObservers(String message, Observer sender) {
        for (Observer observer : userList) {
            if (observer != sender) {
                observer.update(message);
            }
        }
    }
};

public class ObserverDesignExample {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();

        User user1 = new User("Alice", 1);
        User user2 = new User("Bob", 2);
        User user3 = new User("Charlie", 3);
        User user4 = new User("Dave", 4);
        User user5 = new User("Eve", 5);

        userManagement.addObserver(user1);
        userManagement.addObserver(user2);
        userManagement.addObserver(user3);
        userManagement.addObserver(user4);
        userManagement.addObserver(user5);

        user1.sendMessage("Hello everyone!", userManagement);
    }
}

