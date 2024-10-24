package org.launchcode.techjobs.oo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class JobTest {
    //TODO: Create your unit tests here

    @Before
    public void resetId(){
        Job.resetId();
    }

    @Test
    public void testSettingJobId(){
        Job firstJob = new Job();
        Job secondJob = new Job();

        assertNotEquals(firstJob.getId(), secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job listing = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Java"));

        assertEquals("Product tester", listing.getName());

        assertTrue(listing instanceof Job);

    }

    @Test
    public void testJobsForEquality(){
        Job firstJob = new Job("Code Tester", new Employer("Mastercard"), new Location("St. Louis"),
                new PositionType("QA"), new CoreCompetency("JavaScript"));

        Job secondJob = new Job("Code Tester", new Employer("Mastercard"), new Location("St. Louis"),
                new PositionType("QA"), new CoreCompetency("Java"));

        assertNotEquals(firstJob, secondJob);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job("Code Tester", new Employer("Mastercard"), new Location("St. Louis"),
                new PositionType("QA"), new CoreCompetency("Java"));

        String test = testJob.toString();
        String newLine = System.lineSeparator();

        assertTrue(test.startsWith(newLine));
        assertTrue(test.endsWith(newLine));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Code Tester", new Employer("Mastercard"), new Location("St. Louis"),
                new PositionType("QA"), new CoreCompetency("Java"));

        String test = testJob.toString();
        String expectedResult = "ID: 1";
        String trueResult = "ID: " + testJob.getId();

        assertEquals("ID should be 1", expectedResult, trueResult);
        assertTrue("ID should be 1", test.contains("ID: " + testJob.getId()));
        assertTrue("Name should be Code Tester", test.contains("Name: Code Tester"));
        assertTrue("Employer should be Mastercard", test.contains("Employer: Mastercard"));
        assertTrue("Location should be St. Louis", test.contains("Location: St. Louis"));
        assertTrue("Position Type should be in QA", test.contains("Position Type: QA"));
        assertTrue("Core Competency should be in Java", test.contains("Core Competency: Java"));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJobEmpty = new Job("", new Employer(""), new Location(""),
                new PositionType(null), new CoreCompetency(null));

        String test = testJobEmpty.toString();

        assertTrue("Name should be unavailable", test.contains("Name: Data not available"));
        assertTrue("Employer should be unavailable", test.contains("Employer: Data not available"));
        assertTrue("Location should be unavailable", test.contains("Location: Data not available"));
        assertTrue("Position Type should be unavailable", test.contains("Position Type: Data not available"));
        assertTrue("Core Competency should be unavailable", test.contains("Core Competency: Data not available"));
    }
//comment for github
}
