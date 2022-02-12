package Stack_and_Queue.Love_Bubber_Stack;

import java.util.Stack;

public class CN_Reverse_Stack_Using_Recursion {
    
    public static void insertAtBottom(Stack <Integer> myStack, int x)
    {
        // base case
        if (myStack.isEmpty()) {
            myStack.push(x);
            return;
        }

        int element = myStack.peek();
        myStack.pop();

        // recursive call
        insertAtBottom(myStack, x);

        myStack.push(element);
    }

    // TC -> O(N^2)
    // SC -> ?
    public static void reverseStack(Stack<Integer> stack) {	
        // base case
        if (stack.empty())
        {
            return;
        }

        int element = stack.peek();
        stack.pop();

        // recursive call
        reverseStack(stack);

        insertAtBottom(stack, element);
	}

}
