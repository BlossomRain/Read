package chapter5;

import chapter4.Father;
import chapter4.Son;
import org.junit.Test;

public class InheritedTest {


    @Test
    public void testReflection(){

    }

    @Test
    public void testInherited(){

        Son[] sons = new Son[2];
        Father[] fathers = sons;

        fathers[0] = new Father();

        //sons[0].sunMethod();

    }
}
