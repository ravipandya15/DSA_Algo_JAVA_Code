package Stack_and_Queue.Love_Bubber_Stack;

import java.util.Stack;

public class CN_Sort_a_Stack {
    
    public static void sortInsert(Stack<Integer> stack, int num)
    {
        if (stack.isEmpty() || stack.peek() < num)
        {
            stack.push(num);
            return;
        }

        int element = stack.peek();
        stack.pop();

        // recursive call
        sortInsert(stack, num);

        stack.push(element);
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty())
        {
            return;
        }

        int num = stack.peek();
        stack.pop();

        // recursive call
        sortStack(stack);

        sortInsert(stack, num);
	}
}
