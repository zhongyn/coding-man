class Solution:
    # @param {integer[]} nums
    # @return {string[]}
    def summaryRanges(self, nums):
        result = []
        i = 0
        while i < len(nums):
            j = i
            while j + 1 < len(nums) and nums[j] + 1 == nums[j + 1]:
                j += 1
            if i == j:
                result.append(str(nums[i]))
            else:
                result.append('{}->{}'.format(nums[i], nums[j]))
            i = j + 1
        return result

if __name__ == '__main__':
    test = Solution()
    a = [1,2,3,5,6,8]
    print test.summaryRanges(a)

        