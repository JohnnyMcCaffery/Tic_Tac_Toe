package Game.CheckWhoHasWon.Variables;

import java.util.Scanner;

public class GameVariables {
    protected final String startOfColour = "\u001b[";
    protected final String escapeColour = startOfColour+"0m";
    protected final String xUser = setUser("34mX");
    protected final String oUser = setUser("31mO");
    protected final Scanner scanner = new Scanner(System.in);

    protected String[][] board;
    protected String activeUser;
    protected Boolean hasGameEnded;
    protected int numberOfTurns;
    protected int selectedNumber;

    private String setUser(String user) {
        return startOfColour+user+escapeColour;
    }

    protected void resetGame(){
        hasGameEnded = false;
        activeUser = xUser;
        numberOfTurns = 0;
        selectedNumber = 10;
        board = new String[][]{
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
        };
    }

    protected void drawTheBoard(){
        System.out.println();
        System.out.println("  "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
        System.out.println(" ---+---+----");
        System.out.println("  "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
        System.out.println(" ---+---+----");
        System.out.println("  "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
        System.out.println();
    }
}
