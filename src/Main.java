import java.util.Scanner;

class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            String playerA = getPlayerMove(scanner, "Player A");
            String playerB = getPlayerMove(scanner, "Player B");

            displayResult(playerA, playerB);

            System.out.print("Do you want to play again? [Y/N]: ");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    private static String getPlayerMove(Scanner scanner, String player) {
        String move;
        do {
            System.out.print(player + ", enter your move (R, P, S): ");
            move = scanner.nextLine();
        } while (!isValidMove(move));
        return move.toUpperCase();
    }

    private static boolean isValidMove(String move) {
        return move.equalsIgnoreCase("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S");
    }

    private static void displayResult(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            System.out.println(playerA + " vs " + playerB + " it's a Tie!");
        } else if ((playerA.equals("R") && playerB.equals("S")) ||
                (playerA.equals("P") && playerB.equals("R")) ||
                (playerA.equals("S") && playerB.equals("P"))) {
            System.out.println(getResultPhrase(playerA, playerB) + " - Player A wins!");
        } else {
            System.out.println(getResultPhrase(playerB, playerA) + " - Player B wins!");
        }
    }

    private static String getResultPhrase(String winMove, String loseMove) {
        if (winMove.equals("R") && loseMove.equals("S")) return "Rock breaks Scissors";
        if (winMove.equals("P") && loseMove.equals("R")) return "Paper covers Rock";
        if (winMove.equals("S") && loseMove.equals("P")) return "Scissors cuts Paper";
        return "";
    }
}
