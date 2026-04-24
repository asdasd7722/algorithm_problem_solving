class Solution {
    public String solution(String X, String Y) {
        int[] x_cnt = new int[10];
        int[] y_cnt = new int[10];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < X.length(); ++i) {
            x_cnt[X.charAt(i) - '0']++;
        }
        for(int i = 0; i < Y.length(); ++i) {
            y_cnt[Y.charAt(i) - '0']++;
        }

        for(int i = 9; i >= 0; --i) {
            int v = Math.min(x_cnt[i], y_cnt[i]);
            for(int j = 0; j < v; ++j) {
                sb.append(i);
            }
        }
        String answer = sb.toString();
        
        if(answer.isEmpty()) return "-1";
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}