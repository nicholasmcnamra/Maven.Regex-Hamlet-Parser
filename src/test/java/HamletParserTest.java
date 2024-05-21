import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser("hamlet.txt");
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String expected = String.format("%d replacements", 471);
        String actual = hamletParser.replaceText(hamletText, "Hamlet", "Leon");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String expected = String.format("%d replacements", 158);
        String actual = hamletParser.replaceText(hamletText, "Horatio", "Tariq");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {

        int expected = 158;
        int actual = hamletParser.findHoratio(hamletText);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        // parse text
        // find each occurrence of Hamlet
        int expected = 471;
        int actual = hamletParser.findHamlet(hamletText);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeHamletToNewFile() throws IOException {
        String expected = "Hamlet replaced with 'Leon' 471 times.";
       String actual =  hamletParser.writeHamletToNewFile(hamletText);
       Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeHoratioToNewFile() throws IOException {
        HamletParser hamP = new HamletParser("newHT.txt");
        String expected = "Horatio replaced with 'Tariq' 156 times";
        String hamletText = hamP.getHamletData();
        String actual = hamP.writeHoratioToNewFile(hamletText);
        Assert.assertEquals(expected, actual);
    }

}