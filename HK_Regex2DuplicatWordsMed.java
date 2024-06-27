import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HK_Regex2DuplicatWordsMed {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)(\\s+\\1\\b)+"; // RegEx para encontrar palabras repetidas.
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1)); // Reemplazar con la primera aparición.
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }
}
