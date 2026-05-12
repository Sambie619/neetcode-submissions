class Solution:
    def isValid(self, s: str) -> bool:
        close2open={"}":"{","]":"[",")":"("}
        stack=[]
        for c in s:
            if c not in close2open:
                stack.append(c)
                continue
            if not stack or stack[-1]!=close2open[c]:
                return False
            stack.pop()
        return not stack
