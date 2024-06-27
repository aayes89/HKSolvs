import java.util.regex.*;

public class FilterRepeatedWords {
    public static void main(String[] args) {
        String input = "Goodbye bye bye world world world\n" +
                       "Sam went went to to to his business\n" +
                       "Reya is is the the best player in eye eye game\n" +
                       "in inthe\n" +
                       "Hello hello Ab aB";

        Pattern pattern = Pattern.compile("\\b(\\w+)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        StringBuffer result = new StringBuffer();
        String previousWord = null;
        while (matcher.find()) {
            String word = matcher.group(1);
            if (previousWord == null || !previousWord.equalsIgnoreCase(word)) {
                result.append(word).append(" ");
            }
            previousWord = word;
        }

        // Imprime la cadena filtrada
        System.out.println(result.toString().trim());
    }
}
