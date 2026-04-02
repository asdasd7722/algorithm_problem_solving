import java.util.*;

class Solution {
    int N, M;
    int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        
        int res = bfs(maps);
        if(res == 0) answer = -1;
        else answer = res;
        
        return answer;
    }
    
    public int bfs(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];
        dist[0][0] = 1;
        q.add(new Node(0, 0));
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            for(int[] m : move) {
                int nr = curr.r + m[0];
                int nc = curr.c + m[1];
                if(!(0 <= nr && nr < N && 0 <= nc && nc < M)) continue;
                
                if(!visited[nr][nc] && maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[curr.r][curr.c] + 1;
                    q.add(new Node(nr, nc));
                }
            }
        }
        
        return dist[N - 1][M - 1];
        
    }
    
    public class Node {
        int r;
        int c;
        
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}