import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter1 {
    public static void main(String[] args) {
        String input = "tu_string_aqui"; // Reemplaza esto con tu cadena de texto.

        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter) // Filtrar solo letras
                .map(Character::toLowerCase)  // Convertir a minúsculas
                .collect(HashMap::new,
                        (map, letter) -> map.merge(letter, 1L, Long::sum),
                        (map1, map2) -> map2.forEach((key, value) -> map1.merge(key, value, Long::sum)));

        frequencyMap.forEach((letter, count) -> System.out.println(letter + ": " + count));
    }
}
