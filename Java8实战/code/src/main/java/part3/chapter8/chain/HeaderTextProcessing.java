package part3.chapter8.chain;

public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    public String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
