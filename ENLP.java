package mx.slam.fbgpt;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import opennlp.tools.sentiment.SentimentME;
import opennlp.tools.sentiment.SentimentModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class ENLP {

    public static void main(String[] args) throws Exception {
        // Configuración del Analizador de Sentimientos OpenNLP
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        // Cargar modelo del tokenizador
        TokenizerModel tokenModel = new TokenizerModel(chooser.getSelectedFile());
        Tokenizer tokenizer = new TokenizerME(tokenModel);

        // Cargar modelo del analizador de sentimientos
        chooser.showOpenDialog(null);
        SentimentModel model = new SentimentModel(chooser.getSelectedFile());
        SentimentME sentimentAnalyzer = new SentimentME(model);

        // Ejemplo de textos de prueba
        List<String> textos = tests();

        // Procesamiento de cada texto
        for (String texto : textos) {
            // Análisis de sentimiento con OpenNLP
            String[] tokens = tokenizer.tokenize(texto);
            Span[] pred = sentimentAnalyzer.predict2(tokens);

            for (Span s : pred) {
                double prob = s.getProb();
                System.out.println("Probabilidad: " + prob);
                String sentimientoOpenNLP = obtenerSentimientoOpenNLP(prob);

                // Imprime los resultados
                System.out.println("Texto: " + texto);
                System.out.println("Sentimiento (OpenNLP): " + sentimientoOpenNLP);
                System.out.println();
            }
        }
    }

    private static String obtenerSentimientoOpenNLP(double probabilidad) {
        // Mapea la probabilidad de OpenNLP a categorías de sentimiento
        if (probabilidad < 0.2) {
            return "Negativo";
        } else if (probabilidad < 0.4) {
            return "Ligeramente Negativo";
        } else if (probabilidad < 0.6) {
            return "Neutral";
        } else if (probabilidad < 0.8) {
            return "Ligeramente Positivo";
        } else {
            return "Positivo";
        }
    }

    public static List<String> tests() {
        // Ejemplo de textos de prueba
        List<String> textos = new ArrayList<>();
        textos.add("Me parece algo bueno");
        textos.add("Esta marca no sirve");
        textos.add("Compro todos los días");
        textos.add("Ya no me convence como antes");
        textos.add("Hubo un escándalo reciente que me afectó");
        return textos;
    }
}
