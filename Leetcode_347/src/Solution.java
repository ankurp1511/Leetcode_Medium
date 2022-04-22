import java.util.*;

public class Solution {

    static class Node implements Comparable<Node> {

        int freq;
        int data;

        public Node(int freq, int data) {
            this.freq = freq;
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            return o.freq < this.freq ? 1 : -1;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1,-1};
        System.out.println(Arrays.toString(topKFrequent(nums, 1)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Node> pq = new PriorityQueue<>();
        int[] result = new int[k];

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num: map.keySet()) {
            pq.add(new Node(map.get(num), num));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int ctr = pq.size();
        for (int i = ctr - 1; i >= 0; i--) {
             result[i] = pq.poll().data;
        }
        return result;
    }
}
