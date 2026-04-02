import java.util.*;

class Solution {
    List<List<Edge>> graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        int[][] dist = new int[4][n + 1];
        for(int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i <= 3; ++i) {
            for(int j = 0; j <= n; ++j) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int[] f : fares) {
            int v1 = f[0];
            int v2 = f[1];
            int w = f[2];
            graph.get(v1).add(new Edge(v2, w));
            graph.get(v2).add(new Edge(v1, w));
        }
        
        dijkstra(n, s, dist[1]);
        dijkstra(n, a, dist[2]);
        dijkstra(n, b, dist[3]);
        
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; ++i) {
            answer = Math.min(answer, dist[1][i] + dist[2][i] + dist[3][i]);
        }
        
        
        return answer;
    }
    
    public void dijkstra(int n, int start, int[] dist) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        dist[start] = 0;
        q.add(new Edge(start, 0));
        
        while(!q.isEmpty()) {
            Edge curr = q.poll();
            
            for(Edge next : graph.get(curr.to)) {
                int next_dist = dist[curr.to] + next.w;
                if(dist[next.to] > next_dist) {
                    dist[next.to] = next_dist;
                    q.add(new Edge(next.to, next_dist));
                }
            }
        }
        
        
    }
    
    public class Edge implements Comparable<Edge> {
        int to;
        int w;
        
        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
        
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }
}