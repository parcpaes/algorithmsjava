package coj;

import java.util.Scanner;

/**
 * Created by parcpaes on 10/05/2018.
 * coj
 * input
 * 7 8
 --------
 ---+++--
 ---+++--
 --++++--
 -+++++--
 --++-+--
 --------
 */
public class IslandCost {

    public static char island[][];
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};
    public static int costlines=0;
    public static void floodfill(int x, int y){
        if(x<0 || x>=island.length || y<0 || y>=island[0].length) return;
        if(island[x][y]=='0') return;
        if(island[x][y]=='-') return;
        for(int i=0;i<4;i++){
            if(island[x][y]=='+' && island[x+dx[i]][y+dy[i]]=='-'){
                island[x][y]='0';
                costlines++;
                floodfill(x+dx[i], y+dy[i]);
            }
        }
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n,m;
        while(in.hasNext()){
            n = Integer.parseInt(in.next());
            m = Integer.parseInt(in.next());
            island = new char[n][m];
            for(int i=0;i<n;i++){
                island[i]=in.next().toCharArray();
            }
            costlines=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    floodfill(i,j);
                }
            }
            System.out.println(costlines);
        }
    }
}
