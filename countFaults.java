import java.io.*;
import java.util.*;

class Result {

    public static int countFaults(int n, List<String> logs) {
        // Initialize a HashMap to keep track of consecutive errors for each server.
        Map<String, Integer> consecutiveErrors = new HashMap<>();
        int replacements = 0;

        for (String log : logs) {
            String[] parts = log.split(" ");
            String serverId = parts[0];
            String status = parts[1];

            // Check if the server has logged three consecutive errors.
            if (status.equals("error")) {
                consecutiveErrors.put(serverId, consecutiveErrors.getOrDefault(serverId, 0) + 1);
                if (consecutiveErrors.get(serverId) == 3) {
                    replacements++;
                    consecutiveErrors.put(serverId, 0); // Reset consecutive errors count.
                }
            } else {
                consecutiveErrors.put(serverId, 0); // Reset consecutive errors count for successful requests.
            }
        }

        return replacements;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> logs = new ArrayList<>();
        for (int i = 0; i < logsCount; i++) {
            logs.add(bufferedReader.readLine());
        }

        int result = Result.countFaults(n, logs);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
