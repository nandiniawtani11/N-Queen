class Solution {

    public List<List<String>> solveNQueens(int n) {
        
        int[][] grid = new int[n][n];
        List<List<String>> list = new ArrayList<>();
            
        fillNQueen(grid, n, 0, list);
                
        return list;
    }
	
	public void copyGrid(int[][] grid, int n, List<List<String>> list) {
		List<String> ll = new ArrayList<>();
		 for(int i=0;i<n;i++) {
	        StringBuilder str = new StringBuilder();
	        for(int j=0;j<n;j++) {
	            str.append((grid[i][j] == 0 ? "." : "Q"));
	        }
	        ll.add(str.toString());
	    }
		 list.add(ll);
	}
    
    public boolean fillNQueen(int[][] grid, int n, int row, List<List<String>> list){
        
    	if(row >= n) {
    		copyGrid(grid, n, list);
    		return true;
    	}
    	
    	for(int i=row, j= 0;i<n && j<n;j++) {
    		if(isSafe(grid, i, j, n)) {
    			grid[i][j] = 1;
                fillNQueen(grid, n, i+1, list);
    			grid[i][j] = 0;
      		}
    	}
    	return false;
    }
    public boolean isSafe(int[][] arr,int x,int y,int n)
    {
        for(int row=0;row<x;row++)
        {
            if(arr[row][y]==1)
                return false;
        }
        int row=x;
        int col=y;
        while(row>=0 && col>=0 )
        {
            if(arr[row][col]==1)
                return false;
            row--;
            col--;
        }
         row=x;
        col=y;
        while(row>=0 && col<n )
        {
            if(arr[row][col]==1)
                return false;
            row--;
            col++;
        }
        return true;  
    }        
    }
