import java.util.Scanner;

public class BankTransaction {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: Wrong length";
        }

        if (!reference.substring(0, 3).matches("[A-Za-z]{3}")) {
            return "Invalid: Non-letter bank code";
        }

        if (!reference.substring(3).matches("\\d{11}")) {
            return "Invalid: Non-digit body";
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9);

        String formattedDate = date.substring(0, 2) + "/"
                + date.substring(2, 4) + "/"
                + date.substring(4, 6);

        return "[" + bankCode + "] DATE: " + formattedDate + " | SEQ: " + sequence;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String reference = normalizeReference(raw);
        System.out.println("Normalized: " + reference);
        System.out.println(validateAndFormat(reference));

        sc.close();
    }
}