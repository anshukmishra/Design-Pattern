package structural.facade;

class TV {
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    public void setInputChannel(String channel) {
        System.out.println("TV channel set to: " + channel);
    }

    public void turnOff(){
        System.out.println("TV is turned off");
    }
};

class DVDPlayer {
    public void turnOn() {
        System.out.println("DVD Player is turned on.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void turnOff(){
        System.out.println("TV is turned off");
    }
};

class SoundSystem {
    public void turnOn() {
        System.out.println("Sound system is turned on.");
    }

    public void setVolume(int level) {
        System.out.println("Sound system volume set to: " + level);
    }

    public void turnOff(){
        System.out.println("TV is turned off");
    }
};

class Lights {
    public void dim(int level) {
        System.out.println("Lights dimmed to: " + level + "%");
    }
};

class HomeTheaterFacade {
    private TV tv;
    private DVDPlayer dvdPlayer;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade() {
        this.tv = new TV();
        this.dvdPlayer = new DVDPlayer();
        this.soundSystem = new SoundSystem();
        this.lights = new Lights();
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        tv.turnOn();
        tv.setInputChannel("HDMI");
        soundSystem.turnOn();
        soundSystem.setVolume(30);
        dvdPlayer.turnOn();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        lights.dim(100);
        tv.turnOff();
        dvdPlayer.turnOff();
        soundSystem.turnOff();
    }
}

public class FacadeDesignExample {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}
