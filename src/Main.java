import java.util.Scanner;

public class Main {
    private static final char[][] gameGrid = new char[3][3];

    public static void main(String[] args) {

        printGameGrid();
        playerMove();
    }

    public static void printGameGrid() {
        System.out.println("---------");
        for (int i = 0; i < gameGrid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < gameGrid[i].length; j++) {
                System.out.print(gameGrid[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    public static void checkState() {
        int xCells = 0;
        int oCells = 0;
        int emptyCells = 0;
        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid[i].length;j++) {
                if (gameGrid[i][j] == 'X') {
                    xCells++;
                } else if (gameGrid[i][j] == 'O') {
                    oCells++;
                } else if (gameGrid[i][j] != 'X' && gameGrid[i][j] != 'O') {
                    emptyCells++;
                    gameGrid[i][j] = ' ';
                }
            }
        }

        boolean xWon = hasPlayerWon('X');
        boolean oWon = hasPlayerWon('O');
        boolean possible = !(xWon && oWon) && Math.abs(xCells - oCells) < 2;

        if (possible) {
            if (xWon) {
                System.out.println("X wins");

            } else if (oWon) {
                System.out.println("O wins");
            } else if (emptyCells == 0) {
                System.out.println("Draw");
            } else {
                playerMove1();
            }
        }
    }

    public static void checkState1() {
        int xCells = 0;
        int oCells = 0;
        int emptyCells = 0;
        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid[i].length;j++) {
                if (gameGrid[i][j] == 'X') {
                    xCells++;
                } else if (gameGrid[i][j] == 'O') {
                    oCells++;
                } else if (gameGrid[i][j] != 'X' && gameGrid[i][j] != 'O') {
                    emptyCells++;
                }
            }
        }

        boolean xWon = hasPlayerWon('X');
        boolean oWon = hasPlayerWon('O');
        boolean possible = !(xWon && oWon) && Math.abs(xCells - oCells) < 2;

        if (possible) {
            if (xWon) {
                System.out.println("X wins");
            } else if (oWon) {
                System.out.println("O wins");
            } else if (emptyCells == 0) {
                System.out.println("Draw");
            } else {
                playerMove();
            }
        }
    }

    public static boolean hasPlayerWon(char player) {
        boolean result = false;
        for (int i = 0; i < gameGrid.length; i++) {
            if (gameGrid[i][0] == player && gameGrid[i][1] == player && gameGrid[i][2] == player
                    || gameGrid[0][i] == player && gameGrid[1][i] == player && gameGrid[2][i] == player) {
                result = true;
                break;
            }
        }
        if (gameGrid[0][0] == player && gameGrid[1][1] == player && gameGrid[2][2] == player
                || gameGrid[0][2] == player && gameGrid[1][1] == player && gameGrid[2][0] == player) {
            result = true;
        }
        return result;

    }


    public static void playerMove() {
        char symbol = 'X';
        System.out.println("Enter the coordinates: ");
        Scanner scanner = new Scanner(System.in);
        int coordinateX = 0;
        int coordinateY = 0;
        if (scanner.hasNextInt()){
            coordinateX = scanner.nextInt();
            coordinateY = scanner.nextInt();
        } else {
            System.out.println("You should enter numbers!");
            playerMove();
        }

        if (coordinateX > 3 || coordinateY > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            playerMove();
        } else if (gameGrid[coordinateX - 1][coordinateY - 1] == 'X' || gameGrid[coordinateX - 1][coordinateY - 1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            playerMove();
        } else {
            gameGrid[coordinateX - 1][coordinateY - 1] = symbol;
            printGameGrid();
            checkState();
        }
    }

    public static void playerMove1() {
        char symbol = 'O';
        System.out.println("Enter the coordinates: ");
        Scanner scanner = new Scanner(System.in);
        int coordinateX = 0;
        int coordinateY = 0;
        if (scanner.hasNextInt()){
            coordinateX = scanner.nextInt();
            coordinateY = scanner.nextInt();
        } else {
            System.out.println("You should enter numbers!");
            playerMove1();
        }

        if (coordinateX > 3 || coordinateY > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            playerMove1();
        } else if (gameGrid[coordinateX - 1][coordinateY - 1] == 'X' || gameGrid[coordinateX - 1][coordinateY - 1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            playerMove1();
        } else {
            gameGrid[coordinateX - 1][coordinateY - 1] = symbol;
            printGameGrid();
            checkState1();
        }
    }
}

