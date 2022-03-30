package programmers.lv3;


// https://programmers.co.kr/learn/courses/30/lessons/42628
// Lv3. 이중우선순위 큐


import java.util.Collections;
import java.util.LinkedList;

public class Solution_heap02 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        LinkedList<Integer> list = new LinkedList<>();

        String[][] op = new String[operations.length][2];

        for (int i = 0; i < operations.length; i++) {
            String[] temp = operations[i].split("\\s+");
            op[i][0] = temp[0];
            op[i][1] = temp[1];
        }

        operationQueue(op, list);

        if (list.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = list.peekLast();
            answer[1] = list.peekFirst();
        }
        return answer;
    }

    public static void operationQueue(String[][] op, LinkedList list) {

        for (int i = 0; i < op.length; i++) {
            if (op[i][0].equals("I")) {
                list.add(Integer.parseInt(op[i][1]));
                Collections.sort(list);
            } else if (op[i][0].equals("D") && Integer.parseInt(op[i][1]) == -1) {
                list.pollFirst();
            } else if (op[i][0].equals("D") && Integer.parseInt(op[i][1]) == 1) {
                list.pollLast();
            }
        }
    }
}
