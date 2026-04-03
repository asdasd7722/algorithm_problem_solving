class Solution {
        public int solution(int[][] triangle) {
            int len = triangle.length;
            int[][] dp = new int[len + 1][len + 1];
            
            for(int i = 1; i <= len; ++i) {
                for(int j = 1; j < i + 1; ++j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i - 1][j - 1];
                }
            }
            
            int answer = 0;
            for(int i = 1; i <= len; ++i) {
                answer = Math.max(answer, dp[len][i]);
            }
            return answer;
        }
    }
