import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(String fileName){
        this.hamletData = loadFile(fileName);
    }

    private String loadFile(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public int findHamlet(String text) {
        Pattern p = Pattern.compile("(?<!\\w)Hamlet(?!\\w)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        int count = 0;
        while(m.find()) {
            count++;
        }
        return count;
    }

    public int findHoratio(String text) {
        Pattern p = Pattern.compile("(?<!\\w)Horatio(?!\\w)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        int count = 0;
        while(m.find()) {
            count++;
        }
        return count;
    }

    public String replaceText(String fullTxt, String textToReplace, String replaceWith) {
        int count = 0;
        Pattern p = Pattern.compile("(?<!\\w)" + textToReplace + "(?!\\w)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(fullTxt);
        StringBuffer strBuffer = new StringBuffer();
        while(m.find()) {
            m.appendReplacement(strBuffer, replaceWith);
            count++;
        }
        System.out.println(fullTxt);
        return String.format("%d replacements", count);
    }

    public String writeHamletToNewFile(String fullTxt) throws IOException {
        int count = 0;
        int ha = 0;
        FileWriter writer = new FileWriter("/Users/nicholasmcnamara/dev/labs/Maven.Regex-Hamlet-Parser/src/main/resources/newHT.txt", true);
        Pattern p = Pattern.compile("(?<!\\w)Hamlet(?!\\w)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(fullTxt);
        while (m.find()) {
            writer.append(fullTxt, count, m.start());
            writer.append("Leon");
            count = m.end();
            ha++;
        }
        writer.append(fullTxt.substring(count));
        return String.format("Hamlet replaced with 'Leon' %d times.", ha);
    }

    public String writeHoratioToNewFile(String fullTxt) throws IOException {
        int count = 0;
        int ho = 0;
        FileWriter writer = new FileWriter("/Users/nicholasmcnamara/dev/labs/Maven.Regex-Hamlet-Parser/src/main/resources/newHT.txt", true);
        Pattern p = Pattern.compile("(?<!\\w)Horatio(?!\\w)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(fullTxt);
        while (m.find()) {
            writer.append(fullTxt, count, m.start());
            writer.append("Tariq");
            count = m.end();
            ho++;
        }
        writer.append(fullTxt.substring(count));
        return String.format("Horatio replaced with 'Tariq' %d times", ho);
    }
}
