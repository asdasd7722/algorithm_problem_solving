import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph;
    static int[] level;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        level = new int[N + 1];
        graph = new ArrayList<>();
        for(int i = 0; i <= N; ++i){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            level[to]++;
        }

        System.out.println(solve());

    }

    static String solve() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; ++i) {
            if(level[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();

            sb.append(curr).append(" ");

            for(int next : graph.get(curr)) {
                level[next]--;
                if(level[next] == 0) {
                    q.add(next);
                }
            }
        }

        return sb.toString();
    }
}