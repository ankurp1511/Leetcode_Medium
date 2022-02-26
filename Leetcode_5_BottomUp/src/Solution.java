public class Solution {

    public static void main(String[] args) {
        String s = "aaaa";

        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }

        int left = 0, right = 0; String palindrome = "";
        int length1 = 0;
        int length2 = 0;

        for (int i=0 ;i < s.length()-1; i++) {

            if (s.charAt(i) == s.charAt(i+1)) {
                left = i-1;
                right = i+2;

                while (left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                length1 = right - left - 1;
                if (length1 > palindrome.length()) {
                    palindrome = s.substring(left + 1, right);
                }
            }
            left = i-1;
            right = i+1;
            while (left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            length2 = right - left - 1;

            if (length2 > length1 && length2 > palindrome.length()) {
                palindrome = s.substring(left+1, right);
            }
        }

        return palindrome;
    }
}
