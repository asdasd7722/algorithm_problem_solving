class Solution {
        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();
            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                int cnt = 0;
                while(true) {
                    if(cnt == index) break;
                    c += 1;
                    if('z' < c) c = 'a';
                    for(int j = 0; j < skip.length(); ++j) {
                        if(c == skip.charAt(j)) break;
                        if(j == skip.length() - 1) cnt++;
                    }
                }
                answer.append(c);
            }

            return answer.toString();
        }
    }