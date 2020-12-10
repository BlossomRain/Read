package chapter6.commandpattern;

import chapter6.commandpattern.beans.GarageDoor;
import chapter6.commandpattern.beans.Light;
import chapter6.commandpattern.impl.GarageDoorOpenCommand;
import chapter6.commandpattern.impl.LightOnCommand;

public class RemoteControlTest {
    public static void main(String[] args){
        SimpleRemoteControl control = new SimpleRemoteControl();
        Command command = new LightOnCommand(new Light());
        control.setCommand(command);
        control.pressButton();

        control.setCommand(new GarageDoorOpenCommand(new GarageDoor()));
        control.pressButton();
    }
}
