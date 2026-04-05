import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int Max = Integer.MIN_VALUE;
    static int Min = Integer.MAX_VALUE;
    static int[] op;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; ++i) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, arr[0], arr[0]);

        System.out.println(Max);
        System.out.println(Min);
    }

    static void solve(int cnt, int sum, int prev) {
        if(cnt == N - 1) {
            Max = Math.max(Max, sum);
            Min = Math.min(Min, sum);
            return;
        }

        for(int i = 0; i < 4; ++i) {
            if(op[i] > 0) {
                op[i]--;
                if(i == 0) solve(cnt + 1, sum += arr[cnt + 1], sum);
                else if(i == 1) solve(cnt + 1, sum -= arr[cnt + 1], sum);
                else if(i == 2) solve(cnt + 1, sum *= arr[cnt + 1], sum);
                else solve(cnt + 1, sum /= arr[cnt + 1], sum);

                sum = prev;
                op[i]++;
            }
        }
    }
}