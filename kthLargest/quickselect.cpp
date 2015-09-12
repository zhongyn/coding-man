class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int left = 0;
        int right = nums.size() - 1;
        int p = 0;
        
        while (true) {
            p = partition(nums, left, right);
            if (p == k - 1) return nums[p];
            if (p < k - 1) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
    }
    
    int partition(vector<int>& nums, int left, int right) {
        int p = nums[left];
        int lo = left;
        int hi = right;
        
        while (lo < hi) {
            while (lo <= right && nums[lo] >= p) lo++;
            while (hi >= left && nums[hi] < p) hi--;
            if (lo < hi) swap(nums[lo], nums[hi]);
        }
        
        swap(nums[left], nums[hi]);
        return hi;
    }

    void shuffle(vector<int>& v) {
        for(int i = v.size() - 1; i > 0; --i) {
            int j = rand() % (i + 1);
            swap(v[i], v[j]);
        }
    }
    
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> p(nums.begin(), nums.end());

        for (int i = 0; i < k - 1; i++) {
            p.pop();
        }
        return p.top();
    }


};