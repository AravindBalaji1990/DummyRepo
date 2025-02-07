package HooksInitialisation;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksDefinitrion {

    @Before
    public void setup() {
        System.out.println("before");
    }

    @After
    public void teardown() {
        System.out.println("after");

    }
}
