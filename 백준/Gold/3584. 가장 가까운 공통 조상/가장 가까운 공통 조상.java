import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; ++t) {
            int N = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            visited = new boolean[N + 1];

            for(int i = 1; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parent[b] = a;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            int res = solve(t1, t2);
            System.out.println(res);
        }
    }

    static public int solve(int t1, int t2) {
        while (parent[t1] != 0) {
            visited[t1] = true;
            t1 = parent[t1];
        }

        while (parent[t2] != 0) {
            if(visited[t2]) break;
            t2 = parent[t2];
        }
        
        return t2;
    }
}