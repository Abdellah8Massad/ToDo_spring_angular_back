package com.massad.todo.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j;

import java.util.Arrays;

import static org.assertj.core.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StepDefinition {

    private Personne p1;
    private Personne p2;
    private String messageFromP1;

    @Given("{chambre} Lucy is located/position {int} metre(s) from Sean")
    public void lucy_is_located_metres_from_sean(Chambre chambre,Integer _distance) {
        p1 = new Personne();
        p2 = new Personne();
        System.out.println("chambre is : ---> "+ chambre.getNom());
        p2.moveTo(_distance);
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String _message) {
        p1.shout(_message);
        messageFromP1 = _message;
    }
    @Then("Lucy hears Sean’s message")
    public void lucy_hears_sean_s_message() {
        System.out.println(messageFromP1);
        System.out.println(p2.getMessagesHeard().get(0));
        assertEquals(Arrays.asList(messageFromP1),p2.getMessagesHeard());
    }


}

