https://leetcode.com/problems/min-stack/description/

155. Min Stack
Solved
Medium
Topics
premium lock icon
Companies
Hint
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

Solution:-
class MinStack {
    long min;
    Stack<Long> stk;

    public MinStack() {
        stk=new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()){
            stk.push((long)val);
            min=val;
        } else{
            if(val<min){
                long lookup=2L*val-min;
                stk.push(lookup);
                min=val;
            } else{
                stk.push((long)val);
            }
        }
    }
    
    public void pop() {
        long top=stk.pop();
        if(top<min){
            min=2L*min-top;
        }
    }
    
    public int top() {
        long top=stk.peek();
        if(top<min){
            return (int)min;
        } else{
            return (int)top;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */