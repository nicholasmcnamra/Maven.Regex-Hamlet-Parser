import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
    }

    @Test
    public void testChangeHoratioToTariq() {
    }

    @Test
    public void testFindHoratio() {
        HamletParser hp = new HamletParser();
        int expected = 158;
        String hamletText = hp.getHamletData();
        int actual = hp.findHoratio(hamletText);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        HamletParser hp = new HamletParser();
        // parse text
        // find each occurrence of Hamlet
        int expected = 471;
        String hamletText = hp.getHamletData();
        int actual = hp.findHamlet(hamletText);
        Assert.assertEquals(expected, actual);
    }
}