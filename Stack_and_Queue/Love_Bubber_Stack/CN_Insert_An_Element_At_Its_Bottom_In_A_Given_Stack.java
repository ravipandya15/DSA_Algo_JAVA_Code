package Stack_and_Queue.Love_Bubber_Stack;

import java.util.Stack;

public class CN_Insert_An_Element_At_Its_Bottom_In_A_Given_Stack {
    
    public static void solve(Stack <Integer> myStack, int x)
    {
        // base case
        if (myStack.isEmpty()) {
            myStack.push(x);
            return;
        }

        int element = myStack.peek();
        myStack.pop();

        // recursive call
        solve(myStack, x);

        myStack.push(element);
    }

    public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int x) 
    {
        solve(myStack, x);
        return myStack;
    }

}
