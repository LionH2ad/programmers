public class App {
    public static void main(String[] args) throws Exception {
        int[] sequence = {1,2,3,4,5};
        int k = 7;
        int[] answer = {0 , 0};
        answer = solution(sequence, k);
        System.out.println("["+answer[0]+", "+answer[1]+"]");
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end;
        int count = Integer.MAX_VALUE;
        int sum =0;
        for(end = 0 ; end < sequence.length ; end++){
            sum += sequence[end];
            while(sum > k && start < end){
                sum -= sequence[start++];
            }
            if(sum == k){
                if(count > end - start){
                    count = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
            }

        }
        
        return answer;
    }
}
