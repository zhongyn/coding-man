from collections import deque


# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None

class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
        if root is not None:
            # init a queue and add root to it
            # None is an anchor for the end of this level
            queue = deque([root, None])
            while queue:
                # print queue
        		# get the current node
                node = queue.popleft()
                if node is not None:
            		# assign next right node to current node
                    if queue:
                        node.next = queue[0]
            		# add the children of current node to queue
                    # print node.left
                    # print node.right
                    if node.left is not None:
                        queue.append(node.left)
                    if node.right is not None:
                        queue.append(node.right)
                    # add ending anchor
                    if queue[0] is None:
                        queue.append(None)
        root = None

if __name__ == '__main__':
   root = TreeNode(5)
   root.left = TreeNode(2)
   root.right = TreeNode(3)
   test = Solution()
   test.connect(root)
   print root.left.next
   print root.right.next



