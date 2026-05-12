class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[]output=new int[n-k+1];
        //deque to str indeces of eles in dec order of its vals
        Deque<Integer>q=new LinkedList<>();
        int l=0,r=0;
        while(r<n){
            while(!q.isEmpty()&& nums[q.getLast()]<nums[r]){
                //rem eles from q till the curr ele gt the last
                //smaller eles
                q.removeLast();
            }
            q.addLast(r);
            //If the left pointer passes the front index,
            // remove it (it’s outside the window).
            if(l>q.getFirst()){
                q.removeFirst();
            }
            //Once the window reaches size k, the front 
            //of the deque represents the maximum 
            if((r+1)>=k){
                output[l]=nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
