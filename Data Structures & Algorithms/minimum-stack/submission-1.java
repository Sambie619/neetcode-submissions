class MinStack {
    Stack<Integer>stack;//declaration of type
    Stack<Integer>minstack;  
    public MinStack() {
        stack=new Stack<>();//intializing 
        minstack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty()||val<=minstack.peek()){
            minstack.push(val);
        }
    }
    
    public void pop() {
        int removed=stack.pop();
        if (minstack.peek().equals(removed))minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
