import java.util.*;

class Solution {
    
    class Point {
        int x, y, dist;
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        return dfs(maps, 0, 0);
    }
    
    private int dfs(int[][] maps, int row, int column){
        int mapsRow = maps.length; // 행의 개수
        int mapsColumn = maps[0].length; // 첫 번째 행의 열의 길이
        int move[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, column, 1)); //queue에 값 추가
        
        while(!queue.isEmpty()) {
            Point p = queue.poll(); //queue의 first value return & remove. 비어있다면 null 반환.
            if(p.x == mapsRow - 1 && p.y == mapsColumn - 1) return p.dist;
            
            for(int i = 0; i < 4; i++) {
                int moveX = p.x + move[i][0], moveY = p.y + move[i][1];
                
                if(moveX == -1 || moveX == mapsRow || moveY == -1 || moveY == mapsColumn)
                continue;
            
                if(maps[moveX][moveY] == 0) continue;
            
                maps[moveX][moveY] = 0;
                queue.offer(new Point(moveX, moveY, p.dist + 1));
            }
        }
        return -1;
    }
}