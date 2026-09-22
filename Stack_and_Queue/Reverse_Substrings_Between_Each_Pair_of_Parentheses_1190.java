class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int[] pair = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int direction = 1;
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                direction = -direction;
            }
            else {
                sb.append(s.charAt(i));
            }
            i = i + direction;
        }

        return sb.toString();
    }
} 
