import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean isTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean[] visited = new boolean[n + 1];
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    isTree = true;
                    visited[i] = true;
                    dfs(0, i, graph, visited);

                    if (isTree) cnt++;
                }
            }

            String result;
            if (cnt == 0) result = "No trees.";
            else if (cnt == 1) result = "There is one tree.";
            else result = "A forest of " + cnt + " trees.";

            System.out.println("Case " + T++ + ": " + result);
        }
    }

    static void dfs(int parent, int curr, List<List<Integer>> graph, boolean[] visited) {
        for(int next : graph.get(curr)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(curr, next, graph, visited);
            }
            else if(next != parent) {
                isTree = false;
            }
        }
    }
}