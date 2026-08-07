/**
 * Week 1 - Problem 3: The Traffic Signal Streak Analyzer
 *
 * Scans a signal log and reports the longest streak of consecutive
 * identical signal readings.
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Finds the longest streak of consecutive identical characters in the
     * given signal log and prints its color and length.
     *
     * @param signalLog string of signal readings, e.g. "RRGGGYRR"
     */
    static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("Signal log is empty.");
            return;
        }

        char longestStreakColor = signalLog.charAt(0);
        int longestStreakLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreakLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);

            if (c == currentColor) {
                currentStreakLength++;
            } else {
                currentColor = c;
                currentStreakLength = 1;
            }

            if (currentStreakLength > longestStreakLength) {
                longestStreakLength = currentStreakLength;
                longestStreakColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestStreakColor + "' repeated " + longestStreakLength + " times");
    }

    public static void main(String[] args) {
        System.out.println("Input: \"RRGGGYRR\"");
        findLongestStreak("RRGGGYRR");

        System.out.println();

        System.out.println("Input: \"RRRRYYGG\"");
        findLongestStreak("RRRRYYGG");
    }
}
