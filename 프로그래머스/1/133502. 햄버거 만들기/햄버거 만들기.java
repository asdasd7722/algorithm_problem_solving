import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> q = new Stack<>();
        int answer = 0;

        for(int i : ingredient) {
            q.add(i);
            if(i == 1 && q.size() >= 4) {
                int i1 = q.pop();
                int i2 = q.pop();
                int i3 = q.pop();
                int i4 = q.pop();
                if(i2 == 3 && i3 == 2 && i4 == 1) answer++;
                else {
                    q.add(i4);
                    q.add(i3);
                    q.add(i2);
                    q.add(i1);
                }
            }
        }

        return answer;
    }
}