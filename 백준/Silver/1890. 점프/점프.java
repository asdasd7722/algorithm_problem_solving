import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dir = {{1,0},{0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                if(i == N - 1 && j == N - 1) break;
                for(int[] d : dir) {
                    int ni = i + map[i][j] * d[0];
                    int nj = j + map[i][j] * d[1];

                    if(!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
                    if(dp[i][j] > 0) dp[ni][nj] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);

    }
}