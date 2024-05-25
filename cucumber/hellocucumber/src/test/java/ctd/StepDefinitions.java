package ctd;

import io.cucumber.java.en.Given;

public class StepDefinitions {

    /** @param cukes */
    @Given("I have {int} cukes in my belly")
    public void iHaveCukesInMyBelly(final int cukes) {
        Belly belly = new Belly();
        belly.eat(cukes);
    }

    /** @param int1 */
    @Given("I have {int} cukes on my arm")
    public void iHaveCukesOnMyArm(final Integer int1) {
        Belly belly = new Belly();
        belly.eat(int1);
    }

    /** @param int1 */
    @Given("I have {int} cukes 0n my leg")
    public void iHaveCukesOnMyLeg(final Integer int1) {
        Belly belly = new Belly();
        belly.eat(int1);
    }
}
