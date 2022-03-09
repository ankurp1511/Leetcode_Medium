import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int answer = 0;
        int i = 0, j=0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {

            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
            } else {
                map.put(s.charAt(j), map.get(s.charAt(j))+1);
            }


            if (map.size() == j-i+1) {
                answer = Math.max(answer, j-i+1);
            } else {
                if (map.size() < j-i+1) {
                    while (map.size() < j-i+1) {
                        if (map.containsKey(s.charAt(i))) {
                            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                            if (map.get(s.charAt(i)) == 0) {
                                map.remove(s.charAt(i));
                            }
                        }
                        i++;
                    }
                }
            }
            j++;
        }
        return answer;
    }
}
