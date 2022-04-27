package programmers.lv2;

// 프로그래머스 - 2020 KAKAO BLIND RECRUITMENT - 문자열 압축
// https://programmers.co.kr/learn/courses/30/lessons/60057

public class Solution_60057 {
    public int solution(String s) {
        int answer = s.length();
        int len = s.length() % 2 == 0 ? s.length() / 2 : (s.length() / 2) + 1;

        // unit 단위만큼 잘라서 비교
        for (int unit = 1; unit <= len; unit++) {
            StringBuilder sb = new StringBuilder("");   //압축된 문자열을 저장할 객체

            // 검사할 문자열 위치
            int start = 0;
            int end = start + unit;
            int repeatCnt = 1;

            // unit 만큼 자른 문자열
            String curWord = s.substring(start, end);
            String nextWord;

            sb.append(curWord);

            while (end + unit <= s.length()) {

                nextWord = s.substring(end, end + unit);
                if (!curWord.equals(nextWord)) {
                    if (repeatCnt > 1) {
                        sb.insert(sb.length() - unit, repeatCnt); //중복된 값이 있으면, 그 문자열 앞에 중복 횟수 추가
                    }
                    sb.append(curWord);//압축 문자열에 현재까지 만들어준 문자열을 저장
                    curWord = nextWord;
                    start = end;
                    repeatCnt = 1;
                } else {
                    repeatCnt++;
                }
                end += unit;
            }
            //마지막 오른쪽 값을 압축 문자열에 추가해주는 과정
            if (repeatCnt > 1) {
                sb.insert(sb.length() - unit, repeatCnt);
            }
            sb.append(s.substring(end));
            answer = Math.min(sb.length(), answer);
        }

        return answer;
    }


    public static void main(String[] args) {

        Solution_60057 sol = new Solution_60057();
        String s = "ababcdcdababcdcd "; //2ababcdcd
        System.out.println("sol = " + sol.solution(s));

    }
}
