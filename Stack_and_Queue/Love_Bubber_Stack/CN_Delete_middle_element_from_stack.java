package Stack_and_Queue.Love_Bubber_Stack;
import java.util.Stack;

public class CN_Delete_middle_element_from_stack {
    
    public static void solve(Stack<Integer> stack, int count, int size)
    {
        // base case
        if (count == size/2) 
        {
            stack.pop();
            return;
        }

        int num = stack.peek();
        stack.pop();

        // recursive call
        solve(stack, count + 1, size);

        stack.push(num);
    }

    public static void deleteMiddle(Stack<Integer> inputStack, int N) {
        int count = 0;
        solve(inputStack, count, N);
	}
}
