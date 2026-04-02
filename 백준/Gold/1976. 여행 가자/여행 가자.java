import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i = 1; i <= N; ++i) {
            parent[i] = i;
        }

        for(int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; ++j) {
                int con = Integer.parseInt(st.nextToken());
                if(con == 1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken()));
        for(int i = 2; i <= M; ++i) {
            int next = Integer.parseInt(st.nextToken());
            if(root != find(next)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
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
