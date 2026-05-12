class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        graph=defaultdict(set)
        indegree={char:0 for word in words for char in word}
        for i in range(len(words)-1):
            word1,word2=words[i],words[i+1]
            minlen=min(len(word1),len(word2))
            if word1[:minlen]==word2[:minlen]and len(word1)>len(word2):
                return ""
            for j in range(minlen):
                if word1[j]!=word2[j]:
                    if word2[j]not in graph[word1[j]]:
                        graph[word1[j]].add(word2[j])
                        indegree[word2[j]]+=1
                    break
        res=[]
        q=collections.deque()
        for char in indegree:
            if indegree[char]==0:
                q.append(char)
        while q:
            c=q.popleft()
            res.append(c)
            for nei in graph[c]:
                indegree[nei]-=1
                if indegree[nei]==0:
                    q.append(nei)
        if len(res)<len(indegree):
            return ""
        return "".join(res)
        



            
