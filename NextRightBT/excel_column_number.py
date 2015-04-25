class Solution:
    # @return a string
    def convertToTitle(self, num):
        title = []
        while num > 0:
            digit = (num-1) % 26
            title.append(chr(ord('A')+digit))
            num = (num-digit)/26
            
        return ''.join(title[::-1])

test = Solution()
print test.convertToTitle(39)