import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by parcpaes on 02/10/2017.
 */
public class testWallbreaker {
    public static void main(String arg[]){
        Random r = new Random();

        for(int i=0; i< 100; i++){
            int row= 2+r.nextInt(98);
            int column= 2+r.nextInt(98);
            System.out.printf("%d %d\n", row, column);
            char [] caracter = {'*','*','*','#','*','*','#','*','*','*','.'};
            for(int k=0; k<row; k++){
                for(int j=0; j< column; j++){
                    System.out.printf("%c",caracter[r.nextInt(11)]);
                }
                System.out.printf("\n");
            }
        }
    }
}
