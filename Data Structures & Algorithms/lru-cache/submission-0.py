class Node:
    def __init__(self,key,val):
        self.key,self.val=key,val
        self.next=self.prev=None
class LRUCache:

    def __init__(self, capacity: int):
        self.cap=capacity
        self.cache={}#to map key to node
        #left=LRU   right=MRU
        self.left,self.right=Node(0,0),Node(0,0)
        self.left.next,self.right.prev=self.right,self.left
    #remove node from the list
    def remove(self,node):
        pre,nxt=node.prev,node.next
        pre.next,nxt.prev=nxt,pre

    #insert node @ right
    def insert(self,node):
        pre,nxt=self.right.prev,self.right
        pre.next=nxt.prev=node
        node.next,node.prev=nxt,pre

    def get(self, key: int) -> int:
        if key in self.cache:
            self.remove(self.cache[key])
            self.insert(self.cache[key])
            return self.cache[key].val
        return -1
        

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.remove(self.cache[key])
        self.cache[key]=Node(key,value)
        self.insert(self.cache[key])
        if len(self.cache)>self.cap:
            lru=self.left.next
            self.remove(lru)
            del self.cache[lru.key]
        
