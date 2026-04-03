class Solution {
    int result = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        
        int answer = 0;
        int size = words.length;
        
        boolean[] visited = new boolean[size];
        solve(0, begin, target, words, visited);
        
        if(result == Integer.MAX_VALUE) result = 0;
        answer = result;
        return answer;
    }
    
    public void solve(int cnt, String curr, String target, String[] words, boolean[] visited) {
        if(curr.equals(target)) {
            result = Math.min(result, cnt);
            return;
        }
        
        for(int i = 0; i < words.length; ++i) {
            int diff = 0;
            for(int j = 0; j < curr.length(); ++j) {
                if(curr.charAt(j) != words[i].charAt(j)) diff++;
            }
            
            if(diff == 1) {
                if(!visited[i]) {
                    visited[i] = true;
                    solve(cnt + 1, words[i], target, words, visited);
                    visited[i] = false;
                }
                
            }
        }
    }
}