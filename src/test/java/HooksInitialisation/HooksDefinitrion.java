package HooksInitialisation;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class HooksDefinitrion {



    @BeforeStep
    public void steps(){
        System.out.println("this is before step");
    }

    @After
    public void teardown() {
        System.out.println("after");

    }
    @AfterStep
    public void aftersteps(){
        System.out.println("this is after step");
    }
}
