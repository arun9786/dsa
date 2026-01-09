import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    private static final Path ROOT_DIR =
            Paths.get("/Users/arunr/documents/dsa/leetcode");

    public static void main(String[] args) throws IOException {
        int totalProblems = 10;
        pickProblems(totalProblems, null);
        //pickProblems(totalProblems, Set.of("Medium"));
    }

    // ===================== MAIN LOGIC =====================
    private static void pickProblems(int totalProblems, Set<String> difficultyFilter)
        throws IOException {

          Map<Integer, String> questions = getProblemDifficultyMap(ROOT_DIR);

          boolean allowAll = difficultyFilter == null || difficultyFilter.isEmpty();

          // Step 1: Filter questions
          List<Integer> eligible = new ArrayList<>();
          questions.forEach((id, diff) -> {
               if (allowAll || difficultyFilter.contains(diff)) {
                    eligible.add(id);
               }
          });

          if (eligible.isEmpty()) {
               System.out.println("❌ No questions available for selected difficulty");
               return;
          }

          // Step 2: Shuffle ONCE (this is the key fix)
          Collections.shuffle(eligible, new Random());

          // Step 3: Pick first N (no repeats possible)
          int limit = Math.min(totalProblems, eligible.size());

          System.out.println("\nSelected Problems:");
          for (int i = 0; i < limit; i++) {
               int id = eligible.get(i);
               System.out.println(id + " -> " + questions.get(id));
          }
     }



    // ===================== FILE SCAN =====================
    private static Map<Integer, String> getProblemDifficultyMap(Path rootDir)
            throws IOException {

        Map<Integer, String> map = new TreeMap<>();

        try (Stream<Path> paths = Files.walk(rootDir)) {
            paths.filter(p -> p.toString().toLowerCase().endsWith(".java"))
                 .forEach(p -> parseFileName(p.getFileName().toString(), map));
        }
        return map;
    }

    // ===================== PARSING =====================
    private static void parseFileName(String fileName, Map<Integer, String> map) {
        try {
            int dot = fileName.indexOf('.');
            int dash = fileName.lastIndexOf('-');

            if (dot < 0 || dash < 0) return;

            int number = Integer.parseInt(fileName.substring(0, dot));
            char code = fileName.charAt(dash + 1);

            String difficulty = switch (code) {
                case 'E' -> "Easy";
                case 'M' -> "Medium";
                case 'H' -> "Hard";
                default -> null;
            };

            if (difficulty != null) {
                map.put(number, difficulty);
            }
        } catch (Exception ignored) {
        }
    }
}
