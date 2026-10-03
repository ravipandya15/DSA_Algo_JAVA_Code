class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (path.charAt(i) == '/') continue;
            StringBuilder sb = new StringBuilder();

            while (i < n && path.charAt(i) != '/') {
                sb.append(path.charAt(i));
                i++;
            }

            String str = sb.toString();

            if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (str.equals(".")) continue;
            else {
                st.push(str);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            res.insert(0, st.peek());
            res.insert(0, "/");
            st.pop();
        }

        if (res.length() == 0) return "/";

        return res.toString();
    }
}
