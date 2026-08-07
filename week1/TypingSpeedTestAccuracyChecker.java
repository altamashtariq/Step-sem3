
public class TypingSpeedTestAccuracyChecker {


    static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Error: original and typed text must be non-null and of equal length.");
            return;
        }

        int length = original.length();
        int matchedCount = 0;
        int firstMismatchPosition = -1; 
        char originalMismatchChar = ' ';
        char typedMismatchChar = ' ';

        for (int i = 0; i < length; i++) {
            char originalChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (originalChar == typedChar) {
                matchedCount++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1; 
                originalMismatchChar = originalChar;
                typedMismatchChar = typedChar;
            }
        }

        double accuracy = ((double) matchedCount / length) * 100;

        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matchedCount).append("/").append(length);
        result.append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");

        if (firstMismatchPosition == -1) {
            result.append(" | No Mismatches");
        } else {
            result.append(" | First Mismatch at position ").append(firstMismatchPosition);
            result.append(" ('").append(originalMismatchChar).append("' vs '").append(typedMismatchChar).append("')");
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("Input: original=\"hello world\", typed=\"hello worlt\"");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println();

        System.out.println("Input: original=\"coding\", typed=\"coding\"");
        checkTypingAccuracy("coding", "coding");
    }
}
