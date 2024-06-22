package chapter6.commandpattern;

import java.util.Arrays;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        Arrays.fill(onCommands,noCommand);
        Arrays.fill(offCommands,noCommand);
        undoCommand = noCommand;
    }

    public void setCommand(int slot,Command on,Command off){
        onCommands[slot] = on;
        offCommands[slot] = off;
    }

    public void pressOnButton(int slot){
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void pressOffButton(int slot){
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void pressUndoButton(){
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------RemoteControl------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("slot["+i+"]"+onCommands[i].getClass().getName()
                            + "\t\t" + offCommands[i].getClass().getName()+"\n");
        }

        return sb.toString();
    }
}
