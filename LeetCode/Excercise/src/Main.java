import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    private static final Path ROOT_DIR =
            Paths.get("/Users/arunr/documents/dsa/leetcode");

    public static void main(String[] args) throws IOException {
        int totalProblems = 15;
        // Distribution: 20% Easy, 60% Medium, 20% Hard
        int easyCount = (int) Math.round(totalProblems * 0.20);
        int mediumCount = (int) Math.round(totalProblems * 0.60);
        int hardCount = totalProblems - easyCount - mediumCount;
        
        pickProblems(easyCount, mediumCount, hardCount);
    }

    // ===================== MAIN LOGIC =====================
    private static void pickProblems(int easyCount, int mediumCount, int hardCount)
        throws IOException {

          Map<Integer, String> questions = getProblemDifficultyMap(ROOT_DIR);

          // Step 1: Separate questions by difficulty
          List<Integer> easyQuestions = new ArrayList<>();
          List<Integer> mediumQuestions = new ArrayList<>();
          List<Integer> hardQuestions = new ArrayList<>();
          
          questions.forEach((id, diff) -> {
               if (diff.equals("Easy")) {
                    easyQuestions.add(id);
               } else if (diff.equals("Medium")) {
                    mediumQuestions.add(id);
               } else if (diff.equals("Hard")) {
                    hardQuestions.add(id);
               }
          });

          // Step 2: Shuffle each difficulty group
          Collections.shuffle(easyQuestions);
          Collections.shuffle(mediumQuestions);
          Collections.shuffle(hardQuestions);

          // Step 3: Pick limited number from each difficulty
          int selectedEasy = Math.min(easyCount, easyQuestions.size());
          int selectedMedium = Math.min(mediumCount, mediumQuestions.size());
          int selectedHard = Math.min(hardCount, hardQuestions.size());

          System.out.println(String.format("Easy (%d/%d):", selectedEasy, easyCount));
          for (int i = 0; i < selectedEasy; i++) {
               System.out.println((i+1) + ". " + easyQuestions.get(i));
          }

          System.out.println(String.format("\nMedium (%d/%d):", selectedMedium, mediumCount));
          for (int i = 0; i < selectedMedium; i++) {
               System.out.println((i+1) + ". " + mediumQuestions.get(i));
          }

          System.out.println(String.format("\nHard (%d/%d):", selectedHard, hardCount));
          for (int i = 0; i < selectedHard; i++) {
               System.out.println((i+1) + ". " + hardQuestions.get(i));
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
