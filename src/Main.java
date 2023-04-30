import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Folder folder = Folder.fromDirectory(new File("D:\\KPI\\six_semestr\\java\\laba4\\texts"));

        var textAnalyzer = new TextAnalyzerTask();
        var result = textAnalyzer.analyze(folder);

        RandomVariable rand = new RandomVariable(result);

        System.out.println("Expected value = " + rand.getExpectedValue());
        System.out.println("Dispersion = " + rand.getDispersion());
        System.out.println("Standart Error = " + rand.getStandartError());
    }
}

