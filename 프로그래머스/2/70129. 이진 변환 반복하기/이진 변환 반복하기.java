class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(true) {
            if(s.equals("1")) break;
            int len = s.length();
            int erase = 0;
            for(int i = 0; i < len; ++i) {
                if(s.charAt(i) == '0') erase++;
            }
            answer[1] += erase;
            len -= erase;
            StringBuilder sb = new StringBuilder();
            while(len > 0) {
                sb.append(len % 2);
                len /= 2;
            }
            s = sb.reverse().toString();
            answer[0]++;
        }
        return answer;
    }
}