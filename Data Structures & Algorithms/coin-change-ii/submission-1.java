class Solution {
    public int change(int amount, int[] coins) {

        // dp[i] = number of ways to make amount 'i'
        int[] dp = new int[amount + 1];

        // Base case:
        // There is exactly 1 way to make amount 0
        // -> choose no coins
        dp[0] = 1;

        // Traverse each coin one by one
        for (int i = 0; i < coins.length; i++) {

            // Start from current coin value
            // and go till target amount
            for (int j = coins[i]; j <= amount; j++) {

                // Add ways:
                // ways to make current amount j
                // += ways to make remaining amount (j - current coin)
                dp[j] += dp[j - coins[i]];
            }
        }

        // Final answer:
        // total ways to make target amount
        return dp[amount];
    }
}

/*
-----------------------------------
DRY RUN EXAMPLE
-----------------------------------

amount = 5
coins = [1,2,5]

Initially:
dp = [1,0,0,0,0,0]

Using coin 1:
dp = [1,1,1,1,1,1]

Using coin 2:
dp = [1,1,2,2,3,3]

Using coin 5:
dp = [1,1,2,2,3,4]

Answer = 4

Ways:
1+1+1+1+1
1+1+1+2
1+2+2
5

-----------------------------------
TIME COMPLEXITY
-----------------------------------

Outer loop runs for all coins -> n
Inner loop runs till amount -> amount

TC = O(n * amount)

where:
n = number of coins

-----------------------------------
SPACE COMPLEXITY
-----------------------------------

We use only one 1D dp array of size (amount + 1)

SC = O(amount)

-----------------------------------
IMPORTANT IDEA
-----------------------------------

We take coins one by one,
so combinations are counted only once.

Example:
[1,2] and [2,1]
are considered same combination.

That's why this solves
"Coin Change 2" correctly.
-----------------------------------
*/