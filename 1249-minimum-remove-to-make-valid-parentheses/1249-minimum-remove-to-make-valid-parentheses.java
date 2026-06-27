class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Set<Integer> set = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i<n ; i++ ){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(i);
            }
            else if(ch==')'){
                if(!st.isEmpty()) st.pop();
                else set.add(i);
            }
        }

        while(!st.isEmpty()){
            set.add(st.pop());
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i<n;i++){
            if(!set.contains(i)){
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}