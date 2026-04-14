import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<List<Edge>> graph;
    static boolean[] exclusive;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        exclusive = new boolean[M + 1];
        for(int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, i));
            graph.get(to).add(new Edge(from, i));
        }

        StringBuilder sb = new StringBuilder();
        int prev = -1;
        while(K-- > 0) {
            if(prev == 0) {
                sb.append(0).append(" ");
            }
            else {
                int res = mst();
                prev = res;
                sb.append(res).append(" ");
            }
        }

        System.out.println(sb);
    }

    static int mst() {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new Edge(1, 0));
        int mst_w = 0;
        int ex_edge_w = M;

        while (!q.isEmpty()) {
            Edge curr = q.poll();

            if(exclusive[curr.w]) continue;
            if(visited[curr.to]) continue;

            visited[curr.to] = true;
            mst_w += curr.w;
            if(curr.w != 0) ex_edge_w = Math.min(ex_edge_w, curr.w);

            for(Edge next : graph.get(curr.to)) {
                if(!visited[next.to]) {
                    q.add(next);
                }
            }
        }

        exclusive[ex_edge_w] = true;
        for(int i = 1; i <= N; ++i) {
            if(!visited[i]) return 0;
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