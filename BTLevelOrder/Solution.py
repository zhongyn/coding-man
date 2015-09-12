# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque

class Solution:
    # @param {TreeNode} root
    # @return {integer[][]}
    def levelOrderBottom(self, root):
        p = deque([])
        q = deque([])
        p.append(root)
        result = []
        level = []
        if not root:
            return result
        
        while p:
            n = p.popleft()
            level.append(n.val)
            if n.left is not None:
                q.append(n.left)
            if n.right is not None:
                q.append(n.right)
            if not p:
                result.append(level)
                p = q
                q = deque([])
                level = []
        return result[::-1]

    def levelOrderBottom(self, root):
        result = []
        dfs(root, result, 0)
        return result

    def dfs(root, result, level):
        if root is None:
            return
        if len(result) == level:
            result.append([])
        result[level].append(root.val)
        dfs(root.left, result, level + 1)
        dfs(root.right, result, level + 1)
