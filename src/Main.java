import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Folder folder = Folder.fromDirectory(new File("D:\\KPI\\six_semestr\\java\\laba4\\texts"));

        var parStart = System.currentTimeMillis();
        var textAnalyzer = new TextAnalyzerTask();
        var result = textAnalyzer.analyze(folder);
        var parEnd = System.currentTimeMillis();
        var parTime = parEnd - parStart;
        calcRandomVar(result);


        System.out.println("Parallel algo took " + parTime);
        System.out.println();

        var seqStart = System.currentTimeMillis();
        var result1 = simpleAlgo(folder.getPath());
        var seqEnd = System.currentTimeMillis();
        var seqTime = seqEnd - seqStart;
        calcRandomVar(result1);


        System.out.println("Simple algo took " + seqTime);
        System.out.println("Parallel is faster than simple for " + (seqTime- parTime) + "ms");
    }

    public static void calcRandomVar(ArrayList<Integer> arr) {
        RandomVariable rand = new RandomVariable(arr);

        System.out.println("Expected value = " + rand.getExpectedValue());
        System.out.println("Dispersion = " + rand.getDispersion());
        System.out.println("Standart Error = " + rand.getStandartError());
    }
    final static ArrayDeque<File> fileArrayDeque = new ArrayDeque<>();

    public static ArrayList<Integer> simpleAlgo(String path) {
        try {
        fileArrayDeque.add(new File(path));
        File currentFile;
        ArrayList<Integer> lengths = new ArrayList<>();

        while ((currentFile = fileArrayDeque.poll()) != null) {
            if (currentFile.isDirectory()) {
                var subFiles = currentFile.listFiles();
                assert subFiles != null;
                fileArrayDeque.addAll(Arrays.asList(subFiles));
            } else {

                    List<String> lines = new LinkedList<>();

                    try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
                        String line = reader.readLine();
                        while (line != null) {
                            lines.add(line);
                            line = reader.readLine();
                        }
                    }
                    for (var line : lines) {
                        String[] words = line.trim().split("(\\s|\\p{Punct})+");

                        for (var word : words) {
                            lengths.add(word.length());
                        }
                    }


            }
        }
        return lengths;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

