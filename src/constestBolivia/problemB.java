package constestBolivia;

import java.util.*;


public class problemB {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = 0, j=0, i , sequence[], aux[], x, y;
        ArrayList<Integer> v = new ArrayList<>();
        TreeSet<String> edges = new TreeSet<>();
        //for(i = 0; i < 100000; i++) System.out.printf("%d ",i+1);
        while(in.hasNext()){
            n = in.nextInt();
            sequence = new int[n-2];
            aux = new int[n+1];
            for(i= 0; i< n ; i++){
                v.add(i+1);
                if(i<n-2){
                    sequence[i]=in.nextInt();
                    aux[sequence[i]]+=1;
                }
            }
            j=x=y=0;
            long inidex = System.currentTimeMillis();
            if(v.size()>2){
                for(i=0; i< n-2;){
                    if(aux[v.get(j)]>0){
                        j++;
                    }else{
                        x = sequence[i];
                        y = v.get(j);
                        if(x<y) edges.add(x+":"+y);
                        else edges.add(y+":"+x);
                        v.remove(j);
                        aux[x]--;
                        j=0;
                        i++;
                    }
                }
            }
            if(v.size() == 2){
                x = v.get(v.size()-1);
                y = v.get(v.size()-2);
                if(x<y) edges.add(x+":"+y);
                else edges.add(y+":"+x);
            }else{
                System.out.println(-1);
            }
            for (Object object : edges) {
                String edge[] = object.toString().split(":");
                System.out.printf("%s %s\n",edge[0],edge[1]);
            }
            long end = System.currentTimeMillis();
            System.out.println(end-inidex);
        }
    }
}
