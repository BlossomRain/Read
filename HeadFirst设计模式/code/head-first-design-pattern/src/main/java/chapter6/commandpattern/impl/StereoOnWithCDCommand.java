package chapter6.commandpattern.impl;

import chapter6.commandpattern.Command;
import chapter6.commandpattern.beans.Stereo;

public class StereoOnWithCDCommand implements Command {

    Stereo stereo ;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
