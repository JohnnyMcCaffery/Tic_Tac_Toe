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

    private void endTheGame(String message){
        hasGameEnded = true;
        drawTheBoard();
        drawBoxWithMessage(message);
    }

    String drawLineForBox(int messageLength){

        String line = "  ";

        messageLength = messageLength == 36 ? 27 : messageLength;

        for(int i = 0; i < messageLength; i++){
            line = line+"-";
        }

        return line;
    }

    private void drawBoxWithMessage(String message){
        System.out.println(drawLineForBox(message.length()));
        System.out.println(message);
        System.out.println(drawLineForBox(message.length()));
    }

    private void showWinningGameMessage(){
        String message = "    | "+activeUser+" has won the game! |";
        endTheGame(message);

    }

    private void showEndGameMessage(){
        String message = "    | Stalemate! game is over! |";
        endTheGame(message);
    }

    private void changeUser(){
        activeUser = activeUser.equals(xUser) ? oUser : xUser;
    }
}
