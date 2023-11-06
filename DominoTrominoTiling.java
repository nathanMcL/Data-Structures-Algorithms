public class DominoTrominoTiling {
    // Define the modulus value for the result because the number of ways can be very large
    private static final int MOD = 1000000007;

    /**
     * Calculate the number of ways to tile a 2 x n board using 2 x 1 dominos and L-shaped trominos.
     *
     * @param n The length of the board to be tiled.
     * @return The number of different tilings modulo 10^9 + 7.
     */
    public int numTilings(int n) {
        // Base cases
        if (n <= 2) return n; // For a board of length 1 or 2, the number of ways to tile is the same as n.
        if (n == 3) return 5; // For a board of length 3, there are 5 ways to tile.

        // Initialize the dp array where dp[i] will store the number of ways to tile a 2 x i board.
        long[] dp = new long[n + 1];
        dp[0] = 1; // 1 way to tile a 2 x 0 board (empty board)
        dp[1] = 1; // 1 way to tile a 2 x 1 board (a single vertical domino)
        dp[2] = 2; // 2 ways to tile a 2 x 2 board (two vertical or two horizontal dominos)
        dp[3] = 5; // 5 ways to tile a 2 x 3 board

        // Compute number of tilings for boards larger than 3 units using the recurrence relation
        for (int i = 4; i <= n; i++) {
            // The current number of ways is derived from the previous one:
            //  - dp[i - 1] * 2 accounts for the two ways to place a domino on a 2 x (i - 1) board
            //  - dp[i - 3] accounts for the ways to tile a 2 x (i - 3) board and then place a tromino
            dp[i] = (dp[i - 1] * 2 % MOD + dp[i - 3]) % MOD;

            // This loop accounts for all the ways to place trominos on the board in combination with dominos
            // to make up the total length of the board.
            for (int j = 4; j <= i; j++) {
                dp[i] = (dp[i] + (dp[i - j] * 2) % MOD) % MOD;
            }
        }

        // Return the number of ways to tile a 2 x n board, modulo 10^9 + 7 to keep the result within integer limits
        return (int) dp[n];
    }

    // Main method for running the program and testing the numTilings function.
    public static void main(String[] args) {
        // Create an instance of the tiling class
        DominoTrominoTiling dominoTrominoTiling = new DominoTrominoTiling();

        // Example input n = 4
        int n = 4;

        // Calculate and print the number of ways to tile a 2 x n board
        System.out.println("Number of ways to tile a 2x" + n + " board is: " + dominoTrominoTiling.numTilings(n));
    }
}
