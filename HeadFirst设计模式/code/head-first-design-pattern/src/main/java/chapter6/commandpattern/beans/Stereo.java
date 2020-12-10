package chapter6.commandpattern.beans;

public class Stereo {
    public void on(){
        System.out.println("Stereo On");
    }

    public void off(){
        System.out.println("Stereo Off");
    }

    public void setCD(){
        System.out.println("Stereo setCD");
    }
    
    public void setVolume(int i){
        System.out.println("Stereo Set Volume" + i);
    }
}
