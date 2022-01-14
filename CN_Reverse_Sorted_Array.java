import java.util.ArrayList;

class CN_Reverse_Sorted_Array
{
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        // Write your code here.
        
    }

    public static void print(ArrayList<Integer> arr)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.println(arr.get(i) + " ");
        }
    }
    public static void main(String[] args)
    {
        System.out.println("CN_Reserve_Sorted_Array");
        ArrayList<Integer> arr = new ArrayList<Integer>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        reverseArray(arr, 2);
        print(arr);
    }
}