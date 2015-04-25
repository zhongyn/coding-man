public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(target - numbers[i], i);
        }

        int[] result = new int[2];
        int val;
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                val = map.get(numbers[i]);
                if (val != i) {
                    if (val > i) {
                        result[0] = i + 1;
                        result[1] = val + 1;
                    } else {
                        result[0] = val + 1;
                        result[1] = i + 1;
                    }
                    break;                    
                }
            }
        }
        return result;
    }

    public int[] twoSumSorted(int[] numbers, int target) {
        int smallest = 0;
        int largest = numbers.length - 1;
        int sum;

        while (smallest < largest) {
            sum = numbers[smallest] + numbers[largest];
            if (sum > target) {
                largest--;
            } else if (sum < target) {
                smallest++;
            } else {
                return new int[] {smallest, largest};
            }  
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumSorted(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int n = binarySearch(numbers, target - numbers[i], i + 1);
            if ( n != -1) {
                return new int[] {i + 1, n + 1};
            }
        }
    }

    public int binarySearch(int[] numbers, int x, int start) {
        int a = start;
        int b = numbers.length - 1;
        while (a <= b) {
            int m = (a + b) / 2;
            if (x == numbers[m]) {
                return m;
            } else if (x < numbers[m]) {
                b = m - 1;
            } else {
                a = m + 1;
            }
        }
        return -1;
    }
}

class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();

    public void add(int input) {
        if (map.containsKey(input)) {
            map.put(input, map.get(input) + 1)
        } else {
            map.put(input, 0);            
        }
    }

    public int[] find(int target) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = entry.getValue();
            if (i == target - i && j >= 2) {
                return true;
            }
            if (map.containsKey(target - i)) {
                return true;
            }
        }
        return false;
    }

}