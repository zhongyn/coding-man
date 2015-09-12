public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int bucket = nums[i] / (t + 1);
            if (map.containsKey(bucket)) {
                if (i - map.get(bucket) <= k) {
                    return true;
                }
            }
            map.put(bucket, i);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = ts.floor(nums[i] + t);
            Integer ceiling = ts.ceiling(nums[i] - t);
            if ((floor != null && floor >= nums[i])|| (ceiling != null && ceiling <= nums[i])) {
                return true;
            }
            ts.add(nums[i]);
            if (i >= k) {
                ts.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = ts.floor(nums[i] + t);
            if (floor != null && floor >= nums[i] - t) {
                return true;
            }
            ts.add(nums[i]);
            if (i >= k) {
                ts.remove(nums[i - k]);
            }
        }
        return false;
    }
}