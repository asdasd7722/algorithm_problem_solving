import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Edge>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            int sum = 0;
            graph = new ArrayList<>();
            visited = new boolean[N];
            for(int i = 0; i < N; ++i) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                graph.get(x).add(new Edge(y, z));
                graph.get(y).add(new Edge(x, z));
                sum += z;
            }

            int res = prim();
            System.out.println(sum - res);
        }
    }

    static int prim() {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        int mst_w = 0;
        q.add(new Edge(0, 0));

        while (!q.isEmpty()) {
            Edge curr = q.poll();

            if(visited[curr.to]) continue;

            visited[curr.to] = true;
            mst_w += curr.w;

            q.addAll(graph.get(curr.to));
        }

        return mst_w;
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