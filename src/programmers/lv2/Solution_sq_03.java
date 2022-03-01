package programmers.lv2;


// 프로그래머스 - 스택/큐 - 다리를 지나는 트럭
// https://programmers.co.kr/learn/courses/30/lessons/42583

// 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는 지


import java.util.LinkedList;
import java.util.Queue;

// bridge_length : 최대 올라갈 수 있는 트럭 수
// weight : 최대 무게
// truck_weights : 트럭 무게
public class Solution_sq_03 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            while (true) {
                if (queue.isEmpty()) {   // 큐가 비어있는 경우
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {     // 큐가 꽉 찬 경우
                    sum -= queue.poll();
                } else {        // 큐가 가득 차지 않은 경우

                    if (sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        return (time + bridge_length);
    }

    public static void main(String[] args) {
        Solution_sq_03 sq03 = new Solution_sq_03();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(sq03.solution(bridge_length, weight, truck_weights));
    }
}
