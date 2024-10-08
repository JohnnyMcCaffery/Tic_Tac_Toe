package Game;

import Game.CheckWhoHasWon.CheckWhoHasWon;

public class Game extends CheckWhoHasWon {

    public void gameOpening(){
        String dashLine = "--------------------------------";

        System.out.println("\n\t"+dashLine);
        System.out.println("\t | Pick your game             |");
        System.out.println("\t"+dashLine);
        System.out.println("\t | 1: Tic Tac Toe             |");
        System.out.println("\t | 2: Plus One                |");
        System.out.println("\t | 3: Minus One               |");
        System.out.println("\t"+dashLine);
        System.out.print("\n\tWhat game do you want to play? ");
        int gameSelector = scanner.nextInt();

        plusOne = gameSelector == 2;
        minusOne = gameSelector == 3;
    }

    public void runGame(){

        gameOpening();
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

                int num = scanner.nextInt();

                if(plusOne) {
                    if(num == 9) num = 0;
                 } else if (minusOne) {
                     if(num == 1) num = 8;
                     else num = num -2;

                     
                 }else {
                    num = num -1;
                 }

                selectedNumber = num;


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
        System.out.println("\nWho wants to go first? ("+xUser+" or "+oUser+") ");
        String xOrO = scanner.next().toLowerCase();

        activeUser = xOrO.equals("x") ? xUser : oUser;
    }

    private void doYouWantToPlayAgain(){
        System.out.print("\n\nDo you want to play again? (y/n): ");
        String yOrN = scanner.next().toLowerCase();

        if(!yOrN.equals("n")){
            resetGame();
            runGame();
        }
    }


}
