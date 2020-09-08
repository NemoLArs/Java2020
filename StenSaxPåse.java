import java.util.Map;
import java.util.Random;
import java.util.Scanner;


/**
 * Sten > sax
 * Sax > påse
 * Påse > sten
 */
public class BasicGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, String> possibleValues = Map.of(0, "sten", 1, "sax", 2, "påse", 3, "0", 4, "1", 5, "2");

    public static void main(String[] args) {
        Random random = new Random();
        int count = 0;
        while (count <20) {
            System.out.println("Sten, sax eller påse?");
            String userInput = scanner.next();
            if (!isValidInput(userInput.toLowerCase())) {
                System.out.println("Ogiltig input");
                continue;
            }
            final String aiInput = possibleValues.get(random.nextInt(3));
            count++;
            System.out.println(checkIfUserWon(userInput.toLowerCase(), aiInput.toLowerCase()));
        }
    }

    /**
     * @param input user input to check
     * @return true if input is valid
     */
    private static boolean isValidInput(String input) {
        return possibleValues.containsValue(input);
        
        
    }


    /**
     * @param userInput user input
     * @param aiInput ai input
     * @return correct string based on result of inputs.
     */
    private static String checkIfUserWon(String userInput, String aiInput) {
    
        String userWon = String.format("Ai valde: %s. Grattis, du vann", aiInput);
        String aiWon = String.format("Ai valde: %s. Tyvärr, du förlorade", aiInput);
        String draw = String.format("Ai valde: %s. Oavgjort", aiInput);
        switch (userInput) {
            case "sten":
            case "0":
                if (aiInput.equalsIgnoreCase("Sax")) {
                    return userWon;
                }
                if (aiInput.equalsIgnoreCase("Påse")) {
                    return aiWon;
                }
                if (aiInput.equalsIgnoreCase("Sten")) {
                    return draw;
                }
                break;
            case "sax":
            case "1":
                if (aiInput.equalsIgnoreCase("Påse")) {
                    return userWon;
                }
                if (aiInput.equalsIgnoreCase("Sten")) {
                    return aiWon;
                }
                if (aiInput.equalsIgnoreCase("Sax")) {
                    return draw;
                }
                break;
            case "påse":
            case "2":
                if (aiInput.equalsIgnoreCase("Sten")) {
                    return userWon;
                }
                if (aiInput.equalsIgnoreCase("Sax")) {
                    return aiWon;
                }
                if (aiInput.equalsIgnoreCase("Påse")) {
                    return draw;
                }
                break;
        }
        return "FEL";
    }
}
