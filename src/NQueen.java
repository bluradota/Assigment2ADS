import java.util.Scanner;

public class NQueen {
    int n;
    int[] queens;
    int count;
    int[] row;
    int[] column;
    int[] diagonal1;
    int[] diagonal2;

    public NQueen(int n) {
        this.n = n;
        queens = new int[n];
        row = new int[n];
        column = new int[n];
        diagonal1 = new int[2 * n - 1];
        diagonal2 = new int[2 * n - 1];
    }

    public void solve() {
        long startTime = System.currentTimeMillis();
        count = 0;
        search(0);
        long endTime = System.currentTimeMillis();
        System.out.println("The number of solutions is " + count);
        System.out.println("The time is " + (endTime - startTime) + " ms");
    }

    private void search(int i) {
        if (i == n) {
            count++;
            NQueen.printSolution(queens);
        } else {
            for (int j = 0; j < n; j++) {
                if (row[i] == 0 && column[j] == 0 && diagonal1[i + j] == 0 && diagonal2[i - j + n - 1] == 0) {
                    queens[i] = j;
                    row[i] = 1;
                    column[j] = 1;
                    diagonal1[i + j] = 1;
                    diagonal2[i - j + n - 1] = 1;
                    search(i + 1);
                    row[i] = 0;
                    column[j] = 0;
                    diagonal1[i + j] = 0;
                    diagonal2[i - j + n - 1] = 0;
                }
            }
        }
    }

    static void printSolution(int[] queens) {
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    System.out.print("♛ ");
                } else {
                    System.out.print("☐ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int n = input.nextInt();
        //for n >3
        if (n > 3) {
            NQueen nQueen = new NQueen(n);
            nQueen.solve();
        } else {
            System.out.println("No solution");
        }
    }

}
