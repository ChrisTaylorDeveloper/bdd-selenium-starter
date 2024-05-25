package io.cucumber.skeleton;

import io.cucumber.java.en.Given;

public class StepDefinitions {

    /** @param cukes */
    @Given("I have {int} cukes in my belly")
    public void iHaveCukesInMyBelly(final int cukes) {
        Belly belly = new Belly();
        belly.eat(cukes);
    }
}
