public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            for (int j = 0; j < gas.length; j++) {
                tank += gas[j];
                tank -= cost[i];
                if (tank < 0) {
                    break;
                }
            }
            if (tank >= 0) {
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];

        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                start--;
                sum += gas[start] - cost[start];
            }
        }

        return sum < 0 ? -1 : start;
    }

}