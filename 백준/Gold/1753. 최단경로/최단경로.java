import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[][] edges = new int[E][3];

        for(int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = w;
        }

        Solution s = new Solution();

        String answer = s.solution(V, K, edges);

        System.out.println(answer);
    }

    static class Solution {
        List<List<Edge>> graph;
        int[] dist;
        public String solution(int V, int K, int[][] edges) {
            graph = new ArrayList<>();
            dist = new int[V + 1];

            for(int i = 0; i <= V; ++i) {
                graph.add(new ArrayList<>());
                dist[i] = Integer.MAX_VALUE;
            }

            for(int[] e : edges) {
                int a = e[0];
                int b = e[1];
                int w = e[2];
                graph.get(a).add(new Edge(b, w));
            }

            return dijkstra(V, K);
        }

        public String dijkstra(int V, int K) {
            PriorityQueue<Edge> q = new PriorityQueue<>();
            dist[K] = 0;
            q.add(new Edge(K, 0));

            while(!q.isEmpty()) {
                Edge curr = q.poll();

                if(dist[curr.to] > curr.w) continue;

                for(Edge next : graph.get(curr.to)) {
                    int next_dist = dist[curr.to] + next.w;
                    if(dist[next.to] > next_dist) {
                        dist[next.to] = next_dist;
                        q.add(new Edge(next.to, next_dist));
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= V; ++i) {
                if(dist[i] == Integer.MAX_VALUE) sb.append("INF");
                else sb.append(dist[i]);
                sb.append("\n");
            }

            return sb.toString();
        }


        static class Edge implements Comparable<Edge> {
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
}
