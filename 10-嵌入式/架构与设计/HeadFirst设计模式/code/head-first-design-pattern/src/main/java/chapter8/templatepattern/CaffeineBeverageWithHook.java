package chapter8.templatepattern;

public abstract class CaffeineBeverageWithHook {

    void prepareRecipe(){
        boidWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }

    abstract void addCondiments();

    abstract void brew();

    void pourInCup(){
        System.out.println("pouring in cup...");
    }

    void boidWater(){
         System.out.println("boiling water...");
    }
    boolean customerWantsCondiments(){
        return true;
    }

}
