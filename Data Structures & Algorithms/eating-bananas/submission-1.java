public class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Minimum possible speed is 1 banana/hour
        int l = 1;

        // Maximum possible speed is the largest pile
        // (eat the biggest pile in one hour)
        int r = Arrays.stream(piles).max().getAsInt();

        // Store the minimum valid speed found
        int res = r;

        // Binary search on eating speed
        while (l <= r) {

            // Try a middle speed
            int k = (l + r) / 2;

            long totalTime = 0;

            // Calculate how many hours it takes to eat all piles at speed k
            for (int p : piles) {

                // p / k gives hours needed for pile p
                // Use ceil because partial hours count as full hours
                // Example: p=7, k=3 → 7/3 = 2.33 → 3 hours
                totalTime += Math.ceil((double) p / k);
            }

            // If Koko can finish within h hours
            if (totalTime <= h) {

                // This speed works, try to find a smaller one
                res = k;
                r = k - 1;
            } 
            // If it takes too long, speed is too slow
            else {
                l = k + 1;
            }
        }

        // Minimum speed that allows eating all bananas in h hours
        return res;
    }
}
