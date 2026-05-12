class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        #build adjacency list of prereq
        prereq={c:[]for c in range(numCourses)}
        for crs,pre in prerequisites:
            prereq[crs].append(pre)
        #a crs has 3 states
        #visited added to o/p
        #visiting not added to o/p but cycle
        #unvisited crs not added to o/p or cycle
        output=[]
        visit,cycle=set(),set()
        def dfs(crs):
            if crs in cycle:
                return False #we're already visiting it
            if crs in visit:
                return True#we dont need to visit it twice
            cycle.add(crs)#curr path
            for pre in prereq[crs]:#iter thr pre in do dfs in all of them
                if dfs(pre)==False:
                    return False#it just detected cycle
            cycle.remove(crs)#we're no longer along this path
            visit.add(crs)#snc we visited all its pre and itself
            output.append(crs)#our goal after weve added all its prereq here
            return True#ever thng wnt fine

        for c in range(numCourses):
            if dfs(c)==False:
                return []#cycle detected
        return output