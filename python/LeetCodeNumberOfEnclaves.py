# https://leetcode.com/problems/number-of-enclaves/submissions/
from typing import List


class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        count:int = 0

        vertical_len = len(grid)
        horizontal_len = len(grid[0])

        #horizontally
        for y in range(0, horizontal_len):
            self.helper(0, y, grid)
        for y in range(0, horizontal_len):
            self.helper(vertical_len - 1, y, grid)

        #vertically
        for x in range(0, vertical_len):
            self.helper(x, 0, grid)
        for x in range(0, len(grid[len(grid) - 1])):
            self.helper(x, horizontal_len - 1, grid)

        count:int = 0
        for x in range(0, len(grid)):
            for y in range(0, len(grid[x])):
                if grid[x][y] == 1:
                    count += 1
        return count

        
    def helper(self, x:int, y:int, grid:List[List[int]]):
        
        if x < 0 or x >= len(grid):
            return 
        if y < 0 or y >= len(grid[x]):
            return 
        
        if grid[x][y] == 0:
            return 
        
        if grid[x][y] == 2:
            return  
        
        grid[x][y] = 2

        self.helper(x + 1, y, grid)
        self.helper(x - 1, y, grid)
        self.helper(x, y + 1, grid)
        self.helper(x, y - 1, grid)


# arr = [
#     [0,0,0,0],
#     [1,0,1,0],
#     [0,1,1,0],
#     [0,0,0,0]]

arr = [
    [0,0,0,1,1,1,0,1,0,0],
    [1,1,0,0,0,1,0,1,1,1],
    [0,0,0,1,1,1,0,1,0,0],
    [0,1,1,0,0,0,1,0,1,0],
    [0,1,1,1,1,1,0,0,1,0],
    [0,0,1,0,1,1,1,1,0,1],
    [0,1,1,0,0,0,1,1,1,1],
    [0,0,1,0,0,1,0,1,0,1],
    [1,0,1,0,1,1,0,0,0,0],
    [0,0,0,0,1,1,0,0,0,1]
]

solution = Solution()
print(solution.numEnclaves(arr))

for i in arr:
    print(i)


        