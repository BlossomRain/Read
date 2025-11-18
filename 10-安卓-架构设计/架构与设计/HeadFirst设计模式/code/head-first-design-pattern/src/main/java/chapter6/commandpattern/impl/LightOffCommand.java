package chapter6.commandpattern.impl;

import chapter6.commandpattern.Command;
import chapter6.commandpattern.beans.Light;

public class LightOffCommand implements Command {

    Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
