package chapter8.templatepattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

    @Override
    void addCondiments() {
        System.out.println("adding Milk and Sugar...");
    }

    @Override
    void brew() {
        System.out.println("dripping coffee through filter...");
    }

    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();
        if("y".equals(answer.toLowerCase()))
            return true;
        else
            return false;
    }

    private String getUserInput() {
        String answer = null;
        System.out.println("Would you like milk and sugar with your coffee ? (y/n)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            answer = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (answer == null)return "n";

        return answer;
    }
}
