#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int rows = matrix.size();
        int cols = matrix[0].size();
        
        int lo = 0; 
        int hi = rows - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (matrix[m][cols - 1] < target) {
                ++lo;
            } else {
                --hi;
            }
        }
        if (lo == rows) return false;
        if (matrix[lo][cols - 1] == target) return true;
        
        int bound = cols - 2;
        int r = 0;
        
        while (bound >= 0 && r < rows) {
            int id = binarySearch(matrix[r], 0, bound, target);
            if (id > bound) return false;
            if (matrix[r][id] == target) return true;
            bound = id - 1;
            ++r;
        }
        return false;
    }
    
    int binarySearch(vector<int>& a, int left, int right, int target) {
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (a[m] < target) {
                ++left;
            } else {
                --right;
            }
        }
        return left;
    }

    int main(int argc, char const *argv[]) {
        vector<vector<int>> v(vector<int>(1, 4), vector<int>(2, 5));
        cout << searchMatrix(v, 2);
        return 0;
    }
};