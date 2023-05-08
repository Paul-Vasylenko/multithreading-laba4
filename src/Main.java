import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Folder folder = Folder.fromDirectory(new File("D:\\KPI\\six_semestr\\java\\laba4\\texts"));

        var textAnalyzer = new CommonWordsTask();
        var result = textAnalyzer.analyze(folder);

        System.out.println(Arrays.toString(result.toArray()));
    }
}

