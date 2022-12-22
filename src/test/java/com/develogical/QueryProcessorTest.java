package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsTeamName() throws Exception {
        assertThat(queryProcessor.process("What is your name?"), containsString("Cat"));
    }

    @Test
    public void knowsLargest() throws Exception {
        assertThat(queryProcessor.process("Which of the following numbers is the largest: 47, 59, 68?"), containsString("68"));
    }

    @Test
    public void knowsSum() throws Exception {
        assertThat(queryProcessor.process("What is 3 plus 20?"), containsString("23"));
    }

    @Test
    public void knowsProduct() throws Exception {
        assertThat(queryProcessor.process("What is 72 multiplied by 27?"), containsString("1944"));
    }

    @Test
    public void knowsCube() throws Exception {
        assertThat(queryProcessor.process("Which of the following numbers is both a square and a cube: 1431, 100, 4074, 1, 1133, 2197, 274?"), containsString("1"));
    }

    @Test
    public void knowsMinue() throws Exception {
        assertThat(queryProcessor.process("What is 320 minus 3?"), containsString("317"));
    }


}
