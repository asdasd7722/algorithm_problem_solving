class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = count_one(n);
        
        int i = n + 1;
        while(true) {
            int c = count_one(i);
            if(c == cnt) return i;
            i++;
        }
    }
    
    public int count_one(int n) {
        int cnt = 0;
        while(n > 0) {
            int i = n % 2;
            if(i == 1) cnt++;
            n /= 2;
        }
        return cnt;
    }
}