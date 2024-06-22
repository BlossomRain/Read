package chapter9.componentpattern;

public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void speakMenu(){
        allMenus.print();
    }
}
