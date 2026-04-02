import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int network = 0;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }        
        
        for(int i = 0; i < n; ++i) {
            bfs(i);
        }
        
        answer = network;
        
        return answer;
    }
    
    public void bfs(int start) {
        if(visited[start]) return;
        
        network++;
        
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}