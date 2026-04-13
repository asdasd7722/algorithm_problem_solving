import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, S, X, Y;
    static int[][] map;
    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    static List<Node> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        list = new ArrayList<>();

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) list.add(new Node(i, j, map[i][j], 0));
            }
        }

        Collections.sort(list);

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        int res = bfs();
        System.out.println(res);
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for(Node n : list) {
            visited[n.i][n.j] = true;
            q.add(n);
        }

        while(!q.isEmpty()) {
            Node curr = q.poll();

            if(curr.i == X && curr.j == Y) return curr.num;
            if(curr.level == S) break;

            for(int[] m : move) {
                int ni = curr.i + m[0];
                int nj = curr.j + m[1];
                if(!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;

                if(!visited[ni][nj]) {
                    visited[ni][nj] = true;
                    map[ni][nj] = map[curr.i][curr.j];
                    q.add(new Node(ni, nj, curr.num, curr.level + 1));
                }
            }
        }

        return 0;
    }

    static class Node implements Comparable<Node> {
        int i;
        int j;
        int num;
        int level;

        public Node(int i, int j, int num, int level) {
            this.i = i;
            this.j = j;
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Node node) {
            return this.num - node.num;
        }
    }
}