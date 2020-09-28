import java.util.Scanner;
public class NQueens
{    
    private static int[][] board;
    private static int n;
    private static int solutions;

    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        n = kb.nextInt();
        board = new int[n][n];
        solutions = 0;
        check_row(0);
        System.out.println("The number of valid arrangements is " + solutions);
    }

    private static boolean check_row(int r)
    {
        if (r == n)
        {
            solutions++;
            return true;
        }
        boolean solution = false;
        for (int i = 0; i < n; i++)
        {
            if (canPlace(r, i))
            {
                board[r][i] = 1;
                solution = check_row(r + 1) || solution;
                board[r][i] = 0;
            }
        }
        return solution;
    }

    private static boolean canPlace(int r, int c)
    {
        for (int i = 0; i < r; i++)
        {
            if (board[i][c] == 1)
            {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 1)
            {
                return false;
            }
        }
        for (int i = r, j = c; j < n && i >= 0; i--, j++)
        {
            if (board[i][j] == 1)
            {
                return false;
            }
        }
        return true;
    }

    private static void place(int r, int c)
    {
        board[r][c] = 1;
    }

    private static void unPlace(int r, int c)
    {
  
        board[r][c] = 0;
    }

    public static void print()
    {
        for (int i = 0; i < board.length; i++)
        {
            System.out.printf("\n-");
            for (int j = 0; j < board.length; j++)
            {
                System.out.print("----");
            }
            System.out.print("|");
            for (int j = 0; j < board.length; j++)
            {
                System.out.printf(" %d |", board[i][j]);
            }
            System.out.printf("\n-");
        }
    }
}
