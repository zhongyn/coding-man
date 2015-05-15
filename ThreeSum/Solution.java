import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3) {
            return result;
        }

        int p = 0;
        int n = 0;
        for (int k = 0; k < len; k++) {
            if (nums[k] < 0) {
                p++;
            } else if (nums[k] > 0) {
                n++;
            }
        }

        for (int i = 0; i < p; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumSorted(nums, len - n, len - 1, -nums[i], result);
            }
        }
        for (int i = len - n; i < len; i++) {
            if (i == len - n || nums[i] != nums[i - 1]) {
                twoSumSorted(nums, 0, p - 1, -nums[i], result);
            }
        }
        if (p + n < len) {
            twoSumSorted(nums, 0, len - 1, 0, result);
            if (p + n + 2 == len) {
                result.remove(result.size() - 1);
            }
        }

        for (List<Integer> ls : result) {
            ls.sort(null);
        }
        return result;        
    }

    public void twoSumSorted(int[] nums, int i, int j, int target, List<List<Integer>> result) {
        Set<Integer> explored = new HashSet<>();

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                if (!explored.contains(nums[i])) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(-target);
                    result.add(ls);
                    explored.add(nums[i]);
                    explored.add(nums[j]);
                }
                i++;
            }  
        }
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int i = 0;
        int j = 1;
        int k = nums.length - 1;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        while (i < j && j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum > 0) {
                if (i + 1 == j || nums[i] + nums[j - 1] + nums[k] < 0) {
                    k--;
                } else {
                    j--;
                }
            } else if (sum < 0) {
                if (j + 1 == k || nums[i] + nums[j + 1] + nums[k] > 0) {
                    i++;
                } else {
                    j++;
                }
            } else {
                List<Integer> ls = new ArrayList<>();
                ls.add(nums[i]);
                ls.add(nums[j]);
                ls.add(nums[k]);
                result.add(ls);

                while (i + 1 < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (k - 1 > j && nums[k] == nums[k - 1]) {
                    k--;
                }
                if (i + 1 < j) {
                    i++;
                } else if (j + 1 < k) {
                    k--;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                int target = -nums[i];
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    right--;

                } else {
                    left++;
                }
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < nums.length - 2; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                int t = target - nums[i];
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == t) {
                        List<Integer> ls = new LinkedList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                        result.add(ls);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > t) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (List<Integer> ls : threeSumTarget(nums, i + 1, target - nums[i])) {
                    ls.add(0, nums[i]);
                    result.add(ls);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, 0,-2};
        int[] a = {0,0,0,0,0};
        int[] b = {-2,-1,1,2};
        Solution so = new Solution();
        // List<List<Integer>> re = so.threeSum(nums);
        // List<List<Integer>> re = so.threeSum(a);
        List<List<Integer>> re = so.fourSum(nums, 0);
        // int close = so.threeSumClosest(nums, 10);

        // System.out.println(close);
        for (List<Integer> ls : re) {
            System.out.println(ls);
        }
    }
}