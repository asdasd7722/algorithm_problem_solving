import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            int a = e[0];
            int b = e[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        answer = bfs(n);
        
        return answer;
    }
    
    public int bfs(int n) {
        boolean[] visited = new boolean[n + 1];
        int[] level = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    level[next] = level[curr] + 1;
                    q.add(next);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i <= n; ++i) {
            max = Math.max(max, level[i]);
            System.out.print(level[i] + " ");
        }

        int cnt = 0;
        for(int i = 0; i <= n; ++i) {
            if(max == level[i]) {
                cnt++;
            }
        }
        
        return cnt;
    }
}