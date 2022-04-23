# https://leetcode.com/problems/implement-stack-using-queues/

from queue import Queue
import queue

class MyStack:

    def __init__(self):
        self.queue = Queue()

    def push(self, x: int) -> None:
        self.queue.put(x)
        
    def pop(self) -> int:
        return self._top_or_pop(True)

    def top(self) -> int:
        return self._top_or_pop(False)

    def _top_or_pop(self, delete: bool) -> int:
        size: int = self.queue.qsize()
        ret: int = 0
        for i in range(size):
            ret = self.queue.get()
            if i + 1 == size and delete:
                pass
            else:
                self.queue.put(ret)
        return ret


    def empty(self) -> bool:
        return self.queue.empty()
        

stack = MyStack()
result1 = stack.push(1)
result2 = stack.pop()
result3 = stack.empty()
result4 = stack.empty()
