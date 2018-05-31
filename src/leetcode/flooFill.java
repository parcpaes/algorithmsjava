package leetcode;

public class flooFill {
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1, 0,-1};
    public static void flood(int x,int y, int[][] image, int replace, int newColor){
        if(x<0 || x>=image.length || y<0 || y>= image[0].length) return;
        if(image[x][y] != replace) return;
        image[x][y]= newColor;
        for(int i=0;i<4;i++){
            flood(x+dx[i], y+dy[i],image,replace,newColor);
        }
    }
    public static int [][] foolfill(int image[][], int sr, int sc, int newColor){
        if(image[sr][sc] == newColor) return image;
        flood(sr,sc,image,image[sr][sc],newColor);
        return image;
    }

    public static void main(String arg[]){
        int image[][] = {
                {0}
        };
        foolfill(image,0,0,1);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
