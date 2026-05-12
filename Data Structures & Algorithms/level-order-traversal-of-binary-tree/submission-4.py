# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res=[]
        q=collections.deque()
        if root:
            q.append(root)
        while q:
            qlen=len(q)
            lvl=[]
            for i in range(qlen):
                node=q.popleft()
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                lvl.append(node.val)
            res.append(lvl)
        return res









