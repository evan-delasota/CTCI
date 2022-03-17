class DynamicPMethods {
  public static int zeroOneKnapsack(int[] profits, int[] weights, int capacity) {
    int[][] dp = new int[profits.length][capacity + 1];
    return knapsackRec(dp, profits, weights, capacity, 0);
  }

  public static int knapsackRec(int[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
    // Base case
    if (capacity <= 0 || currentIndex >= profits.length) {
      return 0;
    }
    // If value already computed, return value
    if (dp[currentIndex][capacity] != null) {
      return dp[currentIndex][capacity];
    }

    int profit1 = 0;
    // Recursive call after choosing the element at the currentIndex
    // If the weight of the element at currentIndex exceeds the capacity, we shouldn't process it
    if (weights[currentIndex] <= capacity) {
      profit1 = profits[currentIndex] + knapsackRec(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);
    }
    // Recursive call after excluding the element at the currentIndex
    int profit2 = knapsackRec(dp, profits, weights, capacity, currentIndex + 1);

    dp[currentIndex][capacity] = Math.max(profit1, profit2);
    return dp[currentIndex][capacity];
  }
}