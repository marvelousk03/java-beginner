package jadvanced; // Package name (matches your project structure)

import java.io.*;   // Import for file reading (BufferedReader, FileReader)
import java.util.*; // Import for HashMap, List, Map, Arrays, etc.

/**
 * LeagueLegend
 * -------------
 * A fun Java console application that reads soccer match results from a text file,
 * calculates each team's total points, sorts them in ranking order,
 * and displays the final league table with a colorful animated effect.
 */
public class LeagueLegend {

    // ===== Console Colors (for fancy terminal output) =====
    public static final String RESET = "\u001B[0m";   // Reset color
    public static final String GREEN = "\u001B[32m";  // Green color for success messages
    public static final String YELLOW = "\u001B[33m"; // Yellow color for highlights
    public static final String CYAN = "\u001B[36m";   // Cyan color for neutral info
    public static final String BOLD = "\u001B[1m";    // Bold text style
    public static final String RED = "\u001B[31m";    // Red color for errors

    public static void main(String[] args) {
        // Path to your input file containing match results
        String fileName = "C:\\Bootcamp\\javab\\my_code\\javab\\src\\jadvanced\\matches.txt";

        // HashMap to store each team and its total accumulated points
        Map<String, Integer> teamPoints = new HashMap<>();

        // Display the banner/header for the program
        showBanner();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // BufferedReader reads the file line by line
            String line;
            int matchCount = 0; // Keep track of how many matches were processed

            System.out.println(CYAN + "📖 Reading match results...\n" + RESET);

            // Read each line (each represents a match)
            while ((line = br.readLine()) != null) {
                // Process the match and update the points table
                processMatch(line, teamPoints);
                matchCount++;

                // Print a confirmation message for each processed match
                System.out.println(GREEN + "✅ Processed match #" + matchCount + ": " + line + RESET);

                // Small delay to make the output look animated (optional)
                Thread.sleep(300);
            }

            System.out.println("\n" + YELLOW + "⚽ All matches processed successfully!" + RESET);

        } catch (IOException e) {
            // Handles case when file not found or can’t be read
            System.out.println(RED + "Error reading file: " + e.getMessage() + RESET);
            return; // Exit program gracefully
        } catch (InterruptedException e) {
            // Handle potential Thread.sleep interruption (not critical)
            Thread.currentThread().interrupt();
        }

        // ===== SORTING THE FINAL RANKING =====
        // Convert the HashMap into a List for sorting
        List<Map.Entry<String, Integer>> rankingList = new ArrayList<>(teamPoints.entrySet());

        // Sort by points (descending), and then alphabetically if points are tied
        rankingList.sort((a, b) -> {
            int comparePoints = b.getValue().compareTo(a.getValue());
            if (comparePoints == 0) return a.getKey().compareToIgnoreCase(b.getKey());
            return comparePoints;
        });

        // Display the final league ranking table
        System.out.println("\n" + BOLD + "🏆 Final League Rankings 🏆" + RESET);
        printRanking(rankingList);

        // Closing message
        System.out.println("\n" + CYAN + "🎉 Thanks for using League Legend! See you next season! ⚽" + RESET);
    }

    /**
     * Reads a match result line, parses team names and scores,
     * and updates each team's total points in the HashMap.
     */
    private static void processMatch(String line, Map<String, Integer> teamPoints) {
        // Example line: "Liverpool 3, ManchesterUnited 3"
        String[] parts = line.split(","); // Split teams by comma (2 parts)

        // First team info
        String[] team1Data = parts[0].trim().split(" ");
        // Second team info
        String[] team2Data = parts[1].trim().split(" ");

        // Extract team names (everything except the last element, which is the score)
        String team1Name = String.join(" ", Arrays.copyOf(team1Data, team1Data.length - 1));
        String team2Name = String.join(" ", Arrays.copyOf(team2Data, team2Data.length - 1));

        // Extract scores (last number in each part)
        int team1Score = Integer.parseInt(team1Data[team1Data.length - 1]);
        int team2Score = Integer.parseInt(team2Data[team2Data.length - 1]);

        // Initialize both teams in the map if they’re not already there
        teamPoints.putIfAbsent(team1Name, 0);
        teamPoints.putIfAbsent(team2Name, 0);

        // Award points based on the match result:
        // Win = 3 pts, Draw = 1 pt, Loss = 0 pts
        if (team1Score > team2Score) {
            teamPoints.put(team1Name, teamPoints.get(team1Name) + 3);
        } else if (team1Score < team2Score) {
            teamPoints.put(team2Name, teamPoints.get(team2Name) + 3);
        } else {
            teamPoints.put(team1Name, teamPoints.get(team1Name) + 1);
            teamPoints.put(team2Name, teamPoints.get(team2Name) + 1);
        }
    }

    /**
     * Prints the ranked league table with team positions and points.
     */
    private static void printRanking(List<Map.Entry<String, Integer>> rankingList) {
        int rank = 1;            // Actual rank displayed (accounts for ties)
        int previousPoints = -1; // To track points from the previous team
        int position = 0;        // Absolute position in sorted list

        // Loop through the sorted list of teams
        for (Map.Entry<String, Integer> entry : rankingList) {
            position++;

            // If this team's points differ from the previous one, update the rank
            if (entry.getValue() != previousPoints) {
                rank = position;
                previousPoints = entry.getValue();
            }

            // Use “pt” for 1 point and “pts” for more
            String pointWord = entry.getValue() == 1 ? "pt" : "pts";

            // Print the team, rank, and points in color
            System.out.printf(
                    BOLD + "%d. %-20s" + RESET + CYAN + "%d %s%n" + RESET,
                    rank, entry.getKey(), entry.getValue(), pointWord
            );
        }
    }

    /**
     * Prints the cool header banner for the app.
     */
    private static void showBanner() {
        System.out.println(YELLOW + "===================================================" + RESET);
        System.out.println(BOLD + "        ⚽  LEAGUE LEGEND: Soccer Rankings  ⚽" + RESET);
        System.out.println(YELLOW + "===================================================\n" + RESET);
    }
}
