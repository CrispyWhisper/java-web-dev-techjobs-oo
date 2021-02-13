package org.launchcode.techjobs_oo.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {
    Job testJob;
    Job testJob2;
    Job testJob3;
    Job emptyTestJob;
    private PositionType Employer;

    @Before
    public void createTestJob(){
        testJob = new Job("Test Job", new Employer("Test Employer"), new Location("Test Location"), new PositionType("Test Position"), new CoreCompetency("Test Competency"));
        testJob2 = new Job("Test Job 2", new Employer("Test Employer 2"), new Location("Test Location 2"), new PositionType("Test Position 2"), new CoreCompetency("Test Competency 2"));
        testJob3 = new Job("Test Job", new Employer("Test Employer"), new Location("Test Location"), new PositionType("Test Position"), new CoreCompetency("Test Competency"));
        emptyTestJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void emptyTest(){
        assertEquals(0,0);
    }

    @Test
    public void setNameInJob(){
        assertEquals("Test Job",testJob.getName());
    }

    @Test
    public void TestIds(){
        assertNotEquals(testJob.getId(), testJob2.getId());
        assertEquals(1, testJob2.getId() - testJob.getId());
    }

    @Test
    public void TestSettingIds(){
        assertEquals(1,testJob.getId());
    }


    @Test
    public void testAllFieldAreProperlyCalledAndSet(){
        assertEquals("Test Employer",testJob.getEmployer().getValue());
        assertEquals("Test Location",testJob.getLocation().getValue());
        assertEquals("Test Position",testJob.getPositionType().getValue());
        assertEquals("Test Competency",testJob.getCoreCompetency().getValue());

    }

    @Test
    public void testEquals(){
        assertFalse(testJob.equals(testJob3));
    }


    @Test
    public void testToStringStartsAndEndsWithBlankLine() {
        assertEquals(true, testJob.toString().startsWith("\n"));
        assertEquals(true, testJob.toString().endsWith("\n"));
    }

    @Test
    public void testToStringMatchesLabels() {
        assertEquals("\n" +
                "ID: " + testJob.getId() +
                "\nName: " + testJob.getName() +
                "\nEmployer: " + testJob.getEmployer() +
                "\nLocation: " + testJob.getLocation() +
                "\nPositionType: " + testJob.getPositionType() +
                "\nCoreCompetency: " + testJob.getCoreCompetency() +
                "\n", testJob.toString());
    }
    @Test
    public void testEmptyFields() {
        //Empty Name Test
        emptyTestJob = new Job("", new Employer("a"), new Location("a"), new PositionType("a"), new CoreCompetency("a"));
        assertEquals(true, emptyTestJob.toString().contains("Data not available"));
        //Empty Employer Test
        emptyTestJob = new Job("a", new Employer(""), new Location("a"), new PositionType("a"), new CoreCompetency("a"));
        assertEquals(true, emptyTestJob.toString().contains("Data not available"));
        //Empty Location Test
        emptyTestJob = new Job("a", new Employer("a"), new Location(""), new PositionType("a"), new CoreCompetency("a"));
        assertEquals(true, emptyTestJob.toString().contains("Data not available"));
        //Empty PositionType Test
        emptyTestJob = new Job("a", new Employer("a"), new Location("a"), new PositionType(""), new CoreCompetency("a"));
        assertEquals(true, emptyTestJob.toString().contains("Data not available"));
        //Empty Competency Test
        emptyTestJob = new Job("a", new Employer("a"), new Location("a"), new PositionType("a"), new CoreCompetency(""));
        assertEquals(true, emptyTestJob.toString().contains("Data not available"));

        //All Empty Test
        emptyTestJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("OOPS! This job does not seem to exist.", emptyTestJob.toString());
    }

}
