public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if (words == null || words.length == 0 || L < 0) return result;
        List<String> line = new ArrayList<String>();
        int lineLength = 0;
        // process one line strings, then convert it to the desired format and add to result
        for (int i = 0; i < words.length; i++) {
            if (lineLength + words[i].length() + line.size() <= L) {
                line.add(words[i]);
                lineLength += words[i].length();
            } else {
                StringBuilder sb = new StringBuilder();
                if (line.size() == 1) {
                    sb.append(line.get(0));
                    for (int j = L; j > line.get(0).length(); j--) sb.append(' ');
                } else {
                    int space = (L - lineLength) / (line.size() - 1), remain = (L - lineLength) % (line.size() - 1);
                    for (int j = 0; j < line.size() - 1; j++) {
                        sb.append(line.get(j));
                        for (int k = 0; k < space; k++) sb.append(' ');
                        if (remain > 0) {
                            sb.append(' ');
                            remain--;
                        }
                    }
                    sb.append(line.get(line.size() - 1));
                }
                result.add(sb.toString());
                line.clear();
                line.add(words[i]);
                lineLength = words[i].length();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.size() - 1; i++) sb.append(line.get(i) + ' ');
        sb.append(line.get(line.size() - 1));
        int remain = L - sb.length();
        for (int i = remain; i > 0; i--) sb.append(' ');
        result.add(sb.toString());
        return result;
    }
}