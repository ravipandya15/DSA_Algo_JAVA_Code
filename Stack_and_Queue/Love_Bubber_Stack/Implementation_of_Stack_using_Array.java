package Stack_and_Queue.Love_Bubber_Stack;

class Stack
{
    int size;
    int top;
    int[] arr;

    public Stack(int s)
    {
        this.size = s;
        arr = new int[this.size];
        top = -1;
    }

    public void push(int data)
    {
        if (size - top > 1) // or top < size
        {
            top++;
            arr[top] = data;
        }
        else
        {
            System.out.println("Stack overflow");
        }
    }

    public void pop()
    {
        if (top >= 0)
        {
            top--;
        }
        else
        {
            System.out.println("Stack underflow");
        }
    }

    public int peek()
    {
        if (top >= 0 && top < size)
        {
            return arr[top];
        }
        else
        {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }
}

public class Implementation_of_Stack_using_Array {
    public static void main(String[] args) {
        
    }
}
