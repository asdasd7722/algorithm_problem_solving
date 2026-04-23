class Solution {
    int[][] adjacent = {{-1,0},{1,0},{0,1},{0,-1}};
    public int solution(String[][] board, int h, int w) {
        int len = board.length;
        int answer = 0;
        String color = board[h][w];
        for(int[] ad : adjacent) {
            int ni = h + ad[0];
            int nj = w + ad[1];
            if(!(0 <= ni && ni < len && 0 <= nj && nj < len)) continue;
            if(color.equals(board[ni][nj])) answer++;
        }
        return answer;
    }
}