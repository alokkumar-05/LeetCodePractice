class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = getMin(time);
        long right = (long) left * totalTrips;
        long res = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isValid(time, mid, totalTrips)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;

    }

    private long getMin(int[] time) {
        long min = time[0];
        for (int t : time) {
            min = Math.min(t, min);
        }
        return min;
    }

    private boolean isValid(int[] time, long mid, int totalTrips) {
        long trips = 0;
        for (int t : time) {
            trips += mid / t;
        }
        return trips >= totalTrips;
    }
}