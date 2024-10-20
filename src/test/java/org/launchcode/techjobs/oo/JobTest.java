package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job firstJob = new Job();
        Job secondJob = new Job();

        assertNotEquals(firstJob.getId(), secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job listing = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", listing.getName());

        assertTrue(listing instanceof Job);

    }

    @Test
    public void testJobsForEquality(){
        Job firstJob = new Job("Code Tester", new Employer("Mastercard"), new Location("St. Louis"),
                new PositionType("QA"), new CoreCompetency("Good Attitude"));

        Job secondJob = new Job("Code Tester", new Employer("Mastercard"), new Location("St. Louis"),
                new PositionType("QA"), new CoreCompetency("Good Attitude"));

        assertFalse(firstJob.equals(secondJob));
    }
}
