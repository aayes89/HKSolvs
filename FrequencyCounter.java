import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyCounter {
    public static void main(String[] args) {
        String input = "tu_string_aqui"; // Reemplaza esto con tu cadena de texto.

        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        frequencyMap.forEach((letter, count) -> System.out.println(letter + ": " + count));
    }
}
