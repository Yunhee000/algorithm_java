import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        for (int i = 0; i < works.length; i++){
            queue.offer(works[i]);
        }
        for(int j = 0; j < n; j++){
            int k = queue.poll();
            if (k > 0) queue.offer(k-1);
            else break;
        }
        if (queue.isEmpty()) return 0;
        while(!queue.isEmpty()){
            int k = queue.poll();
            answer += Math.pow(k, 2);
        }
        return answer;
    }
}