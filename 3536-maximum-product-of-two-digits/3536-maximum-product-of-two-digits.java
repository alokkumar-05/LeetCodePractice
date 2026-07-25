class Solution {
    public int maxProduct(int n) {
        int[] count = new int[10];

        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }

        int max1 = -1, max2 = -1;

        // Traverse from 9 down to 0
        for (int digit = 9; digit >= 0; digit--) {
            while (count[digit] > 0) {
                if (max1 == -1) {
                    max1 = digit;
                } else if (max2 == -1) {
                    max2 = digit;
                    return max1 * max2; // Found top 2 digits!
                }
                count[digit]--;
            }
        }

        return max1 * max2;

    }
}