import java.util.*;

class Solution {
    List<List<Edge>> graph;
    int[] dist;
    public int solution(int N, int[][] road, int K) {
        dist = new int[N + 1];
        graph = new ArrayList<>();
        for(int i = 0; i <= N; ++i) {
            dist[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }
        
        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int w = r[2];
            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }
        
        int answer = 0;

        dijkstra();
        
        for(int i = 1; i <= N; ++i) {
            if(dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    public void dijkstra() {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        dist[1] = 0;
        q.add(new Edge(1, 0));
        
        
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
        
        @Override
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }
}