package chapter6.commandpattern.impl;

import chapter6.commandpattern.Command;
import chapter6.commandpattern.beans.GarageDoor;

public class GarageDoorOpenCommand implements Command {
    GarageDoor door;

    public GarageDoorOpenCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.up();
    }

    @Override
    public void undo() {
        door.down();
    }
}
