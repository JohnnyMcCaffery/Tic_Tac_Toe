package Game.CheckWhoHasWon;

import Game.CheckWhoHasWon.Variables.GameVariables;

public class CheckWhoHasWon extends GameVariables {
    protected void checkIfUserHasWon(){
        if(
                ( // top line
                        board[0][0].equals(activeUser) &&
                                board[0][1].equals(activeUser) &&
                                board[0][2].equals(activeUser)
                ) || ( // middle line
                        board[1][0].equals(activeUser) &&
                                board[1][1].equals(activeUser) &&
                                board[1][2].equals(activeUser)
                ) || ( //  bottom line
                        board[2][0].equals(activeUser) &&
                                board[2][1].equals(activeUser) &&
                                board[2][2].equals(activeUser)

                ) ||( // left line
                        board[0][0].equals(activeUser) &&
                                board[1][0].equals(activeUser) &&
                                board[2][0].equals(activeUser)
                ) || ( // middle line
                        board[0][1].equals(activeUser) &&
                                board[1][1].equals(activeUser) &&
                                board[2][1].equals(activeUser)
                ) || ( // right line
                        board[0][2].equals(activeUser) &&
                                board[1][2].equals(activeUser) &&
                                board[2][2].equals(activeUser)
                ) || ( // top right to bottom left line
                        board[0][2].equals(activeUser) &&
                                board[1][1].equals(activeUser) &&
                                board[2][0].equals(activeUser)
                ) || ( // top left to bottom right line
                        board[0][0].equals(activeUser) &&
                                board[1][1].equals(activeUser) &&
                                board[2][2].equals(activeUser)
                )
        ){
            showWinningGameMessage();
        } else {
            numberOfTurns++;

            if(numberOfTurns == 9) showEndGameMessage();
            else {
                changeUser();
                selectedNumber = 10;
            }
        }
    }

    private void showWinningGameMessage(){
        hasGameEnded = true;
        System.out.println("\n "+activeUser+" has won the game!");
    }

    private void showEndGameMessage(){
        hasGameEnded = true;
        System.out.println("\n Stalemate!  The game is over");
    }

    private void changeUser(){
        activeUser = activeUser.equals(xUser) ? oUser : xUser;
    }
}
