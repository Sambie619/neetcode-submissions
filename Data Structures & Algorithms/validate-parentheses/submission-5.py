class Solution:
    def isValid(self, s: str) -> bool:
        close2open={"}":"{","]":"[",")":"("}
        stack=[]
        for bra in s:
            if bra not in close2open:
                stack.append(bra)
                continue
            else:
                if not stack or stack[-1]!=close2open[bra]:
                    return False
                stack.pop()
        return not stack
