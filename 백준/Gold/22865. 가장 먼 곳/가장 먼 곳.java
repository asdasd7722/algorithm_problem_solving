import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, A, B, C;
    static List<List<Edge>> graph;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        result = new int[N + 1];
        graph = new ArrayList<>();
        for(int i = 0; i <= N; ++i) {
            result[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; ++i) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(d).add(new Edge(e, w));
            graph.get(e).add(new Edge(d, w));
        }

        dijkstra(A);
        dijkstra(B);
        dijkstra(C);

        int max = 0;
        int idx = 0;
        for(int i = 1; i <= N; ++i) {
            if(max < result[i]) {
                max = result[i];
                idx = i;
            }
        }

        System.out.println(idx);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        for(int i = 0; i <= N; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        q.add(new Edge(start, 0));

        while (!q.isEmpty()) {
            Edge curr = q.poll();

            for(Edge next : graph.get(curr.to)) {
                int next_dist = dist[curr.to] + next.w;
                if (dist[next.to] > next_dist) {
                    dist[next.to] = next_dist;
                    q.add(new Edge(next.to, next_dist));
                }
            }
        }

        for(int i = 1; i <= N; ++i) {
            result[i] = Math.min(result[i], dist[i]);
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
