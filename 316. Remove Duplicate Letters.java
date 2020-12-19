public String removeDuplicateLetters(String sr) {
    int[] res = new int[26];
    boolean[] visited = new boolean[26];
    char[] ch = sr.toCharArray();
    for (char c : ch) res[c - 'a']++;
    Stack<Character> st = new Stack<>();
    int index;
    for (char s : ch) {
        index = s - 'a';
        res[index]--;
        if (visited[index]) continue;
        //if current character is smaller than last character in stack which occurs later in the string again
        //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
        while (!st.isEmpty() && s < st.peek() && res[st.peek() - 'a'] != 0)
            visited[st.pop() - 'a'] = false;
        st.push(s);
        visited[index] = true;
    }

    StringBuilder sb = new StringBuilder();
    while (!st.isEmpty()) sb.insert(0, st.pop());
    return sb.toString();
}