import java.util.Scanner;

class UtopiasCoins {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the amount of money: ");
        int amount = input.nextInt();

        int[] coins = {1, 7, 10, 22};

        int[] table = new int[amount + 1];

        table[0] = 0;

        for(int i = 1; i <= amount; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if(sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
                }
            }
        }

        System.out.println("The minimum number of coins is: " + table[amount]);

        int[] coins_count = new int[coins.length];

        for(int i = 0; i < coins.length; i++) {
            coins_count[i] = 0;
        }

        int i = amount;

        while(i > 0) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if(sub_res != Integer.MAX_VALUE && sub_res + 1 == table[i]) {
                        coins_count[j]++;
                        i = i - coins[j];
                        break;
                    }
                }
            }
        }

        for(int j = 0; j < coins.length; j++) {
            System.out.println("The number of " + coins[j] + " coins is: " + coins_count[j]);
        }

    }

}