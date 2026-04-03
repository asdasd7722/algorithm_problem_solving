class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int[] p : puddles) {
            dp[p[1]][p[0]] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if ((i == 1 && j == 1) || dp[i][j] == -1) continue;
                int up = 0;
                int left = 0;
                if (dp[i][j - 1] != -1) left = dp[i][j - 1] % 1000000007;
                if (dp[i - 1][j] != -1) up = dp[i - 1][j] % 1000000007;
                
                dp[i][j] = (up + left)  % 1000000007;
            }
        }

        answer = dp[n][m];
        return answer;
    }
}