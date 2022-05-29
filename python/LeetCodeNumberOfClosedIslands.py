from typing import List

class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        count:int = 0
        for x in range(0, len(grid)):
            for y in range(0, len(grid[x])):
                if grid[x][y] == 0 and self.helper(x, y, grid):
                    count += 1

        print(count)
        return count


    
    def helper(self, x:int, y:int, grid: List[List[int]]) -> int:

        # index out of bound
        if x < 0 or x == len(grid):
            return False
        if y < 0 or y == len(grid[x]):
            return False
        
        if grid[x][y] == 2:
            return True
        
        # when it reaches edge
        if (x == 0 or x == len(grid) - 1 or y == 0 or y == len(grid[x]) - 1) and grid[x][y] != 1:
            return False
        
        if grid[x][y] == 1:
            return True
        
        grid[x][y] = 2
        
        return ( 
            self.helper(x - 1, y, grid) 
            * self.helper(x + 1, y, grid) 
            * self.helper(x, y - 1, grid) 
            * self.helper(x, y + 1, grid))
        
        
        
# arr = [
#     [1,0,1,1,0,1,0,0,1,0],
#     [2,1,0,1,1,0,1,1,1,0],
#     [2,0,1,1,1,0,0,1,1,0],
#     [1,1,1,0,0,0,0,1,0,1],
#     [1,0,0,0,0,0,1,1,1,0],
#     [1,1,0,1,0,1,0,1,1,1],
#     [2,0,1,0,1,1,0,0,0,1],
#     [2,1,1,1,1,1,0,0,0,0],
#     [2,1,1,0,0,1,0,1,0,1],
#     [2,1,1,0,1,1,0,1,1,0]
# ]
# solution = Solution()
# solution.closedIsland(arr)