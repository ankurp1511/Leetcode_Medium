import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        System.out.println(checkInclusion("trinitrophenylmethylnitramine",
                "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i< s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }

        int i = 0;
        int j = 0;
        int count = map.size();
        int k = s1.length();

        while (j < s2.length()) {

            if (map.containsKey(s2.charAt(j))) {
                map.put(s2.charAt(j), map.get(s2.charAt(j))  - 1);
                if (map.get(s2.charAt(j)) == 0) {
                    count--;
                }
            }

            if (j - i + 1 == k) {
                if (count == 0) {
                    return true;
                }
                if (map.containsKey(s2.charAt(i))) {
                    map.put(s2.charAt(i), map.get(s2.charAt(i))  + 1);
                    if (map.get(s2.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return false;
    }
}
