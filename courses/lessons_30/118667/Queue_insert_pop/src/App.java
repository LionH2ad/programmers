import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int answer = 0;
        answer = solution(queue1, queue2);
        System.out.println(answer);
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sumL = 0;
        long sumR = 0;
        for(int i = 0 ; i < queue1.length ; i++) {
            q1.offer(queue1[i]);
            sumL += queue1[i];
        }
        for(int i = 0 ; i < queue2.length ; i++) {
            q2.offer(queue2[i]);
            sumR += queue2[i];
        }
        while(sumL != sumR) {
            if(sumL > sumR) {
                int num = q1.poll();
                sumL -= num;
                sumR += num;
                q2.offer(num);
            } else {
                int num = q2.poll();
                sumR -= num;
                sumL += num;
                q1.offer(num);
            }
            answer++;
            if(answer > 600000) return -1;
        }
        return answer;
    }

}
