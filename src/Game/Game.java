package Game;

import Game.CheckWhoHasWon.CheckWhoHasWon;

public class Game extends CheckWhoHasWon {

    public void runGame(){

        resetGame();
        whoWantsToGoFirst();

        while(!hasGameEnded){
            drawTheBoard();
            checkUserInput();
            checkIfUserHasWon();
        }

        doYouWantToPlayAgain();
    }

    private void checkUserInput(){
        while(selectedNumber == 10) {
            System.out.print("(" + activeUser + ") Please select your number:\t");
            if(scanner.hasNextInt()){
                selectedNumber = scanner.nextInt() -1;


                int board1 = selectedNumber / 3;
                int board2 = selectedNumber % 3;

                if(
                        selectedNumber > 8 ||
                                selectedNumber < 0 ||
                                board[board1][board2].length() > 1
                ){
                    selectedNumber = 10;
                } else {
                    board[board1][board2] = activeUser;
                }
            } else {
                scanner.next();
            }
        }
    }

    private void whoWantsToGoFirst(){
        System.out.println("\nWho wants to go first? (X or O) ");
        String xOrO = scanner.next().toLowerCase();

        activeUser = xOrO.equals("x") ? xUser : oUser;
    }

    private void doYouWantToPlayAgain(){
        System.out.println("\n\nDo you want to play again? (y/n): ");
        String yOrN = scanner.next().toLowerCase();

        if(!yOrN.equals("n")){
            resetGame();
            runGame();
        }
    }


}
