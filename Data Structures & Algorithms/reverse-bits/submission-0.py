class Solution:
    def reverseBits(self, n: int) -> int:
        '''Input: n = 00000000000000000000000000010101
        Output:    2818572288 (10101000000000000000000000000000)'''
        res=0
        for i in range(32):
            bit=(n>>i)&1
            res+=(bit<<(31-i))
        return res

        