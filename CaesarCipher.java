import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        // go through each character
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                // handle upper vs lower case
                char base = Character.isLowerCase(character) ? 'a' : 'A';

                // shift the letter by the given amount
                char shifted = (char) ((character - base + shift) % 26 + base);

                result.append(shifted);
            } else {
                // keep spaces, numbers, punctuation as is
                result.append(character);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter text to encrypt: ");
        String inputText = scanner.nextLine();

        System.out.print("enter shift key (0-25): ");
        int shiftKey = scanner.nextInt();

        String encrypted = encrypt(inputText, shiftKey);
        System.out.println("encrypted text: " + encrypted);
    }
}
