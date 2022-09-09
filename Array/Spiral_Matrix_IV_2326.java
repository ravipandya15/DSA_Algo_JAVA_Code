package Array;

public class Spiral_Matrix_IV_2326 {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = -1;
            }
        }
        int startingRow = 0, startingCol = 0, endingRow = m-1, enddingCol = n-1;
        while (head != null)
        {
            for (int j = startingCol; head != null && j <= enddingCol; j++)
            {
                matrix[startingRow][j] = head.val;
                head = head.next;
            }
            if (head == null) break;
            startingRow++;
            for (int i = startingRow; head != null && i <= endingRow; i++)
            {
                matrix[i][enddingCol] = head.val;
                head = head.next;
            }
            if (head == null) break;
            enddingCol--;
            for (int j = enddingCol; head != null && j >= startingCol; j--)
            {
                matrix[endingRow][j] = head.val;
                head = head.next;
            }
            if (head == null) break;
            endingRow--;
            for (int i = endingRow; head != null && i >= startingRow; i--)
            {
                matrix[i][startingCol] = head.val;
                head = head.next;
            }
            if (head == null) break;
            startingCol++;
        }
        return matrix;
    }
}
