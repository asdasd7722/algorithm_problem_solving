class Solution {
    int result = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int len = numbers.length;
        
        dfs(numbers, 0, len, target, 0);
        
        answer = result;
        
        return answer;
    }
    
    
    public void dfs(int[] numbers, int cnt, int len, int target, int sum) {
        if(cnt == len) {
            if(target == sum) result++;
            return;
        }
        
        dfs(numbers, cnt + 1, len, target, sum + numbers[cnt]);
        dfs(numbers, cnt + 1, len, target, sum - numbers[cnt]);
    }
}