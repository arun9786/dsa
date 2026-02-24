import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path leetcodePath = Paths.get("/Users/arunr/Documents/DSA/LeetCode");
        
        // Scan all .java files recursively
        final int[] count = {0};
        try (Stream<Path> paths = Files.walk(leetcodePath)) {
            paths.filter(Files::isRegularFile)
                 .filter(path -> path.toString().endsWith(".java"))
                 .forEach(path -> {
                     count[0]++;
                     System.out.println(path.getFileName());
                 });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total .java files: " + count[0]);
    }
}
