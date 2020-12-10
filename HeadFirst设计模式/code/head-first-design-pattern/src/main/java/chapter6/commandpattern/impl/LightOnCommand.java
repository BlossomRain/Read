package chapter6.commandpattern.impl;

import chapter6.commandpattern.Command;
import chapter6.commandpattern.beans.Light;

public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
