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
    private PositionType Employer;

    @Before
    public void createTestJob(){
        testJob = new Job("Test Job", new Employer("Test Employer"), new Location("Test Location"), new PositionType("Test Position"), new CoreCompetency("Test Competency"));
        testJob2 = new Job("Test Job 2", new Employer("Test Employer 2"), new Location("Test Location 2"), new PositionType("Test Position 2"), new CoreCompetency("Test Competency 2"));
        testJob3 = new Job("Test Job", new Employer("Test Employer"), new Location("Test Location"), new PositionType("Test Position"), new CoreCompetency("Test Competency"));
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


}
