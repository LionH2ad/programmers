class Solution {
    public int[] solution(int[] sequence, int k) {
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