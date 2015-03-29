public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int v1Section = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int v2Section = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (v1Section != v2Section) return v1Section > v2Section ? 1 : -1;
        }
        return 0;
    }
}