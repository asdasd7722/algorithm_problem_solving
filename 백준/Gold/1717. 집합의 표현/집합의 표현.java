import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 1; i <= N; ++i) {
            parent[i] = i;
        }

        for(int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == 0) union(a, b);
            else {
                if(find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if(root_a != root_b) parent[root_b] = root_a;
    }
}
