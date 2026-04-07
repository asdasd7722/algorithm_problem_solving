import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] fee;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }
        fee = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) {
            fee[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= M; ++i) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v).add(w);
            graph.get(w).add(v);
        }

        for (int i = 1; i <= N; ++i) {
            if(!visited[i]) {
                bfs(i);
            }
        }

        System.out.println(result <= K ? result : "Oh no");
    }

    static void bfs(int s) {
        int min = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()) {
            int curr = q.poll();

            if(min > fee[curr]) {
                min = fee[curr];
            }

            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        result += min;
    }
}