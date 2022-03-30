package programmers.lv3;

// 프로그래머스 - 힙 - 디스크 컨트롤러
// https://programmers.co.kr/learn/courses/30/lessons/42627

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;


// 프로그래머스 - 힙 - 디스크컨트롤러
// https://programmers.co.kr/learn/courses/30/lessons/42627

// 요청시간을 기준으로 오름차순 정렬
public class Solution_heap01 {
    class Disk {
        int reqTime;
        int workTime;

        Disk(int reqTime, int workTime) {
            this.reqTime = reqTime;
            this.workTime = workTime;
        }
    }

    public int solution(int[][] jobs) {

        LinkedList<Disk> waitList = new LinkedList<>();
        PriorityQueue<Disk> diskPriorityQueue = new PriorityQueue<>(((o1, o2) -> o1.workTime - o2.workTime));

        for (int[] job : jobs) {
            waitList.add(new Disk(job[0], job[1]));
        }
        Collections.sort(waitList, ((o1, o2) -> o1.reqTime - o2.reqTime));

        int cnt = 0;
        int answer = 0;
        int time = waitList.peek().reqTime;

        while (cnt < jobs.length) {

            while (!waitList.isEmpty() && waitList.peek().reqTime <= time) {
                diskPriorityQueue.add(waitList.pollFirst());
            }

            if (!diskPriorityQueue.isEmpty()) {
                Disk disk = diskPriorityQueue.poll();
                time += disk.workTime;
                answer += time - disk.reqTime;
                cnt++;
            } else {
                time++;
            }
        }
        return answer / cnt;
    }
}
