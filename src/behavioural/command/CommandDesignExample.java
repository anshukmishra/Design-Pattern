package behavioural.command;

interface Command {
    void execute();
    void undo();
}

class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("The light is on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("The light is off.");
    }

    public boolean isOn() {
        return isOn;
    }
}

class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}

public class CommandDesignExample {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command turnOnLight = new TurnOnLightCommand(livingRoomLight);
        Command turnOffLight = new TurnOffLightCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnLight);
        remote.pressButton();

        remote.pressUndo();
        remote.setCommand(turnOffLight);
        remote.pressButton();
        remote.pressUndo();
    }
}
