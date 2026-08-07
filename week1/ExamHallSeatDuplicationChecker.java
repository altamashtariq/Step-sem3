
public class ExamHallSeatDuplicationChecker {

   
     
    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            boolean isFirstOccurrence = true;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    isFirstOccurrence = false;
                    break;
                }
            }
            if (!isFirstOccurrence) {
                continue;
            }

           
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("Input: {101, 102, 103, 102, 105}");
        checkDuplicateSeats(new int[] {101, 102, 103, 102, 105});

        System.out.println();

        System.out.println("Input: {101, 102, 103, 104, 105}");
        checkDuplicateSeats(new int[] {101, 102, 103, 104, 105});
    }
}
