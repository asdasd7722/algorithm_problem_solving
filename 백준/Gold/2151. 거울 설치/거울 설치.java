import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        dist = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < N; ++j) {
                map[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                if(map[i][j] == '#') {
                    System.out.println(bfs(i, j));
                    return;
                }
            }
        }
    }

    static int bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        dist[i][j] = 0;
        visited[i][j] = true;
        q.add(new Node(i, j));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for(int[] d : direct) {
                int ni = curr.i;
                int nj = curr.j;

                while (true) {
                    ni += d[0];
                    nj += d[1];

                    if(!(0 <= ni && ni < N && 0 <= nj && nj < N)) break;
                    if(map[ni][nj] == '*') break;

                    if(!visited[ni][nj]) {
                        visited[ni][nj] = true;
                        dist[ni][nj] = dist[curr.i][curr.j];
                        if(map[ni][nj] == '#') return dist[ni][nj];
                        if(map[ni][nj] == '!') {
                            dist[ni][nj] = dist[curr.i][curr.j] + 1;
                            q.add(new Node(ni, nj));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}