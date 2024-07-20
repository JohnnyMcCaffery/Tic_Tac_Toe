package Game;

import Game.CheckWhoHasWon.CheckWhoHasWon;

public class Game extends CheckWhoHasWon {

    public void runGame(){

        resetGame();

        while(!hasGameEnded){

            drawTheBoard();

            checkUserInput();

            checkIfUserHasWon();

        }

        doYouWantToPlayAgain();
    }

    private void drawTheBoard(){
        System.out.println();
        System.out.println("  "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
        System.out.println(" ---+---+----");
        System.out.println("  "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
        System.out.println(" ---+---+----");
        System.out.println("  "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
        System.out.println();
    }

    private void checkUserInput(){

        int newNumber;

        while((selectedNumber > 8 || selectedNumber < 0)) {
            System.out.print("(" + activeUser + ") Please select your number:\t");
            if(scanner.hasNextInt()){
                newNumber = scanner.nextInt() -1;

                int board1 = newNumber / 3;
                int board2 = newNumber % 3;

                if(board[board1][board2].length() > 1){
                    selectedNumber = 10;
                } else {
                    board[board1][board2] = activeUser;
                    selectedNumber = newNumber;
                }
            } else {
                scanner.next();
            }
        }
    }

    private void doYouWantToPlayAgain(){
        System.out.println("\n\nDo you want to play again? (y/n): ");
        String yOrN = scanner.next();

        if(yOrN.equals("y")){
            resetGame();
            runGame();
        }
    }


}
