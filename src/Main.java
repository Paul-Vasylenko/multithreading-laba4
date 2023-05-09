import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Folder folder = Folder.fromDirectory(new File("D:\\KPI\\six_semestr\\java\\laba4\\texts"));

        Set<String> keywords = new HashSet<String>(List.of(
                "keyword1",
                "keyword2",
                "keyword3"
        ));
        var keywordsAnalyzer = new KeywordsTask();
        var result = keywordsAnalyzer.analyze(folder, keywords);

        result.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
}

