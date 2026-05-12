class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //to store [d,speed]pairs
        int[][]pair=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
        Arrays.sort(pair,(a,b)->Integer.compare(b[0],a[0]));
        //sorting pair array using comparator using lambda
        //based on position of car near target
        Stack<Double>stack=new Stack<>();
        for(int[]p:pair){
            stack.push((double)(target-p[0]) / p[1]);
            //push times onto stack
            if(stack.size()>=2 && stack.peek()<=stack.get(stack.size()-2)){
                stack.pop();
                //if top of stack time is le one below it pop it
                //it goes to one flock or joins that back
            }
        }
        return stack.size();
    }
}