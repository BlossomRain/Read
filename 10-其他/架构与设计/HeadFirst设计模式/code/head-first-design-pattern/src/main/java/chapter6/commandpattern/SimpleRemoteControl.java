package chapter6.commandpattern;

public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl(){}

    public void setCommand(Command slot) {
        this.slot = slot;
    }

    public void pressButton(){
        slot.execute();
    }
}
