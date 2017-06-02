package BFS;
import java.util.*;

/*
 * 296. Best Meeting Point
 * 
 * Difficulty: $$$$
 * 
 * A group of two or more people wants to meet and minimize the total travel distance. 
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * For example, given three people living at (0,0), (0,4), and (2,2):
 *
 * 1 - 0 - 0 - 0 - 1
 * |     |     |    |     |
 * 0 - 0 - 0 - 0 - 0
 * |     |     |    |     |
 * 0 - 0 - 1 - 0 - 0
 * 
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 * 
 *
 * */

public class BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        
        List<Integer> rowList = new ArrayList<Integer>();
        List<Integer> colList = new ArrayList<Integer>();
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }
        
        return getMin(rowList) + getMin(colList);
    }
    
    private int getMin(List<Integer> list){
        Collections.sort(list);
        int res = 0; 
        
        int low = 0; 
        int high = list.size() - 1;
        while(low < high){
            res += list.get(high--) - list.get(low++); 
        }
        
        return res;
    }
}

