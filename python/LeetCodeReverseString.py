# https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/

from typing import List

class Solution:

    def __init__(self):
        self.tmp = "0"


    def reverseString(self, s) -> None:
        self.helper(s, 0)

    def helper(self, s, index):
        if not s:
            return
        if len(s) % 2 == 0 and index == len(s) / 2:
            return
        elif len(s) % 2 != 0 and index == (len(s) - 1) / 2:
            return
        self.tmp = s[index]
        s[index] = s[(len(s) - 1) - index]
        s[(len(s) - 1) - index] = self.tmp
        self.helper(s, index + 1)

                


solution = Solution()
strings = []

solution.reverseString(strings)
print(strings)




