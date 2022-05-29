#https://leetcode.com/problems/number-of-islands/
from typing import List


"""
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count: int = 0
        for x in range(0, len(grid)):
            for y in range(0, len(grid[x])):
                if grid[x][y] == "1":
                    count += 1
                    self.fill(x, y, grid)
        return count

        
    def fill(self, x: int, y: int, grid: List[List[str]]) -> None:
        if len(grid) == x or x < 0:
            return
        if len(grid[x]) == y or y < 0:
            return
        if grid[x][y] == "-1" or grid[x][y] == "0":
            return 
        
        grid[x][y] = "-1"

        #up
        self.fill(x - 1, y, grid)
        #down
        self.fill(x + 1, y, grid)
        #left
        self.fill(x, y - 1, grid)
        #right
        self.fill(x, y + 1, grid)
        
