# https://leetcode.com/problems/count-sub-islands/submissions/
from typing import List


class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        count: int = 0
        for x in range(0, len(grid2)):
            for y in range(0, len(grid2[x])):
                if grid2[x][y] == 1 and self.helper(x, y, grid1, grid2):
                    count += 1
        return count
    
    def helper(self, x:int, y:int, grid1:List[List[int]], grid2:List[List[int]]) -> bool:
        if x < 0 or x >= len(grid2):
            return True
        if y < 0 or y >= len(grid2[x]):
            return True

        if grid2[x][y] == 2 or grid2[x][y] == 0:
            return True
            
        grid2[x][y] = 2

        down = self.helper(x + 1, y, grid1, grid2)
        up = self.helper(x - 1, y, grid1, grid2)
        right = self.helper(x, y + 1, grid1, grid2)
        left = self.helper(x, y - 1, grid1, grid2)
        result = grid2[x][y] == 2 and grid1[x][y] == 1
        
        return down and up and right and left and result


arr = [
    [1,1,1,0,0],
    [0,1,1,1,1],
    [0,0,0,0,0],
    [1,0,0,0,0],
    [1,1,0,1,1]]
arr2 = [
    [1,1,1,0,0],
    [0,0,1,1,1],
    [0,1,0,0,0],
    [1,0,1,1,0],
    [0,1,0,1,0]]

solution = Solution()
solution.countSubIslands(arr, arr2)

for i in arr:
    print(i)
print("*****")
for i in arr2:
    print(i)