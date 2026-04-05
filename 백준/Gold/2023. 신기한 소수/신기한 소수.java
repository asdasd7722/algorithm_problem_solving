import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solve(1, 2);
        solve(1, 3);
        solve(1, 5);
        solve(1, 7);

        System.out.println(sb);
    }

    static void solve(int cnt, int result) {
        if(cnt == N) {
            sb.append(result).append('\n');
            return;
        }

        for(int i = 0; i < 10; ++i) {
            int next = result * 10 + i;
            if(is_prime(next)) {
                solve(cnt + 1, next);
            }
        }
    }

    static boolean is_prime(int x) {
        if(x < 2) return false;

        for(int i = 2; i * i <= x; ++i) {
            if(x % i == 0) return false;
        }
        return true;
    }
}