package recursive;

/**
 * Created by parcpaes on 04/04/2018.
 */
public class RatMaze {
    final int N = 4;

    void printSolution(int sol[][]){
        for(int i=0; i<N;i++){
            for(int j=0;j<N; j++)
                System.out.print(" "+sol[i][j] + " ");
            System.out.println();
        }
    }

    boolean isSafe(int maze[][], int x, int y){
        return (x>= 0 && x<N  && y>=0 && y<N && maze[x][y] == 1);
    }

    boolean solveMaze(int maze[][]){
        int sol[][] = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        if(!solveMazeUtil(maze, 0,0, sol)){
            System.out.println("Solution doesn't exist");
            return false;
        }
        printSolution(sol);
        return true;
    }

    boolean solveMazeUtil(int maze[][], int x, int y , int sol[][]){
        if(x == N - 1 && y == N -1){
            sol[x][y] = 1;
            return true;
        }
        if(isSafe(maze, x ,y )){
            sol[x][y] = 1;

            //Move forward in x direction
            if(solveMazeUtil(maze, x + 1, y, sol))  return true;

            //if moving in x direction doesn't give solution
            //then Move down in y direction
            if(solveMazeUtil(maze, x, y + 1, sol)) return true;

            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    public static void main(String arg[]){
        RatMaze rat = new RatMaze();
        int maze [][] = {
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,1,1},
                {0,0,1,1,0},
                {0,0,0,1,1}};
        rat.solveMaze(maze);
    }
}
