class Solution {
    String[] zoka = {"aya","ye","woo","ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(String b : babbling) {
            String prev = "";
            boolean flag = true;
            while(true) {
                if(b.length() == 0) {
                    answer++;
                    break;
                }
                if(!flag) break;
                for(String z : zoka) {
                    if(!z.equals(prev) && b.startsWith(z)) {
                        b = b.substring(z.length());
                        prev = z;
                        flag = true;
                        break;
                    }
                    flag = false;
                }
            }

        }
        return answer;
    }
}