import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, A, B, C;
    static int INF = Integer.MAX_VALUE;
    static List<List<Edge>> graph;
    static int[] dist;
    static int[] shame;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new int[N + 1];
        shame = new int[N + 1];
        for(int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
            dist[i] = INF;
        }
        shame[B] = INF;

        for(int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        dijkstra();

        if(dist[B] == INF) System.out.println(-1);
        else System.out.println(shame[B]);
    }

    static void dijkstra() {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        dist[1] = 0;
        q.add(new Edge(A, 0));

        while(!q.isEmpty()) {
            Edge curr = q.poll();

            if(curr.w > dist[curr.to]) continue;

            for(Edge next : graph.get(curr.to)) {
                int next_dist = dist[curr.to] + next.w;
                if(next_dist > C) continue;

                if(dist[next.to] > next_dist) {
                    dist[next.to] = next_dist;
                    int next_shame = Math.max(shame[curr.to], next.w);
                    if(next.to == B) shame[next.to] = Math.min(shame[next.to], next_shame);
                    else shame[next.to] = next_shame;
                    q.add(new Edge(next.to, next_dist));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
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