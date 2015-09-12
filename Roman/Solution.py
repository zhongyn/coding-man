class Solution:
    # @param {string} s
    # @return {integer}
    def romanToInt(self, s):
        r = 0
        for i in s[::-1]:
            if i == 'I':
                if r >= 5:
                    r -= 1
                else:
                    r += 1
            elif i == 'V':
                r += 5
            elif i == 'X':
                if r >= 50:
                    r -= 10
                else:
                    r += 10
            elif i == 'L':
                r += 50
            elif i == 'C':
                if r >= 500:
                    r -= 100
                else:
                    r += 100
            elif i == 'D':
                r += 500
            elif i == 'M':
                r += 1000
        return r
                