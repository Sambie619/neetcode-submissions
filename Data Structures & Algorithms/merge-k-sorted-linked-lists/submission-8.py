# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        if len(lists)==0 or not lists:
            return None
        while len(lists)>1:
            mergedlist=[]
            for i in range(0,len(lists),2):
                i1=lists[i]
                i2=lists[i+1]if (i+1)<len(lists) else None
                mergedlist.append(self.mergedlists(i1,i2))
            lists=mergedlist
        return lists[0]
    
    def mergedlists(self,l1,l2):
        node=dummy=ListNode()
        while l1 and l2:
            if l1.val<=l2.val:
                node.next=l1
                l1=l1.next
            else:
                node.next=l2
                l2=l2.next
            node=node.next
        node.next=l1 or l2
        return dummy.next








