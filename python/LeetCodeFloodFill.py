#https://leetcode.com/problems/flood-fill/
from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        """ 
            sr:1, sc:0, newColor:2


            1, 1, 1  -> 2, 2, 2 
            1, 0, 1     2, 0, 2
            1, 3, 1     2, 3, 2 
        """

        """
        up: (0, -1)
        down: (0, 1)
        right: (1, 0)
        left: (0,-1)
        """
        self.helper(image[sr][sc], newColor, sr, sc, image)
        return image


    
    def helper(self, color:int, newColor:int, x:int, y:int, image: List[List[int]]) -> None:
        if len(image) == x or x < 0:
            return
        if len(image[x]) == y or y < 0:
            return
        if image[x][y] != color:
            return
        if image[x][y] == newColor:
            return
        
        image[x][y] = newColor

        #up
        self.helper(color, newColor, x, y - 1, image)
        #down
        self.helper(color, newColor, x, y + 1, image)
        #right
        self.helper(color, newColor, x + 1, y, image)
        #left
        self.helper(color, newColor, x - 1, y, image)
        