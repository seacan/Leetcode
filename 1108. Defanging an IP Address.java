// Input: address = "255.100.50.0"
// Output: "255[.]100[.]50[.]0"
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public String defangIPaddr(String address) {
        return String.join("[.]", address.split("\\."));
    }

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            sb.append(c == '.' ? "[.]" : c);
        }
        return sb.toString();
    }
}