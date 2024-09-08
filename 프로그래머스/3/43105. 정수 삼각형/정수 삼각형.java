class Solution {
    public int solution(int[][] triangle) {
        int totalSum = 0;
        
        for(int i=1 ; i < triangle.length ; i++){
            for(int j=0 ; j <= i ; j ++){
                if(j == 0){
                    triangle[i][j] += triangle[i-1][j];
                } else if(i == j){
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
                if(i == triangle.length -1){
                    totalSum = Math.max(triangle[i][j] , totalSum);
                }
            }
        }
        return totalSum;
    }
}