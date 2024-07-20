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
}
