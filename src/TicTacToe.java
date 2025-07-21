import java.util.Scanner;

public class TicTacToe
{
    private static String[][] board = new String[3][3];
    private static String player = "X";
    private static int moveCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean playAgain = true;

        while (playAgain)
        {
            clearBoard();
            player = "X";
            moveCount = 0;
            boolean gameWon = false;

            while (moveCount < 9 && !gameWon)
            {
                display();
                System.out.println("Player " + player + "'s turn.");
                int row, col;

                while (true)
                {
                    System.out.print("Enter row (1-3): ");
                    row = scanner.nextInt() - 1;
                    System.out.print("Enter column (1-3): ");
                    col = scanner.nextInt() - 1;

                    if (row >= 0 && row < 3 && col >= 0 && col < 3)
                    {
                        if (isValidMove(row, col))
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Invalid move! That cell is already taken. Try again.");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid input! Please enter values from 1 to 3.");
                    }
                }

                board[row][col] = player;
                moveCount++;

                if (moveCount >= 5 && isWin(player))
                {
                    display();
                    System.out.println("Player " + player + " wins!");
                    gameWon = true;
                } else if (moveCount == 9)
                {
                    display();
                    System.out.println("It's a tie!");
                } else
                {
                    player = player.equals("X") ? "O" : "X";
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String answer = scanner.next();
            playAgain = answer.equalsIgnoreCase("y");
        }
    }

    private static void clearBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("-----------");
            }
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagnalWin(player);
    }

    private static boolean isRowWin(String player)
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player)
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagnalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie()
    {
        return moveCount == 9 && !isWin("X") && !isWin("O");
    }
}