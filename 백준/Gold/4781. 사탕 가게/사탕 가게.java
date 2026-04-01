import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double d_m = Double.parseDouble(st.nextToken());
            int m = (int) Math.round(d_m * 100);
            if (n == 0 && m == 0) break;

            int[] calorie = new int[n + 1];
            int[] price = new int[n + 1];

            for(int i = 1; i <= n; ++i) {
                st = new StringTokenizer(br.readLine());
                calorie[i] = Integer.parseInt(st.nextToken());
                double d_p = Double.parseDouble(st.nextToken());
                price[i] = (int) Math.round(d_p * 100);
            }

            int[] dp = new int[m + 1];

            for(int i = 1; i <= n; ++i) {
                for(int j = 1; j <= m; ++j) {
                    if(j - price[i] >= 0) dp[j] = Math.max(dp[j], dp[j - price[i]] + calorie[i]);
                }
            }

            System.out.println(dp[m]);

        }

    }
}
