package icpclive;

import java.util.Scanner;


public class Abbreviation7770 {
    public static void main(String arg[]){
        Scanner in =new  Scanner(System.in);
        while(in.hasNextLine()){
            String original = in.nextLine();
            String line = original.replaceAll("([\\.\\,])"," $1 ");
            String cad[] =  line.split("\\s");
            int cont = 0;
            String abbreviation="";
            String aux="";
            int j = 0;
            for(int i=0; i<cad.length;i++){
                j = i;
                while(j<cad.length && cad[j].matches("^[A-Z][a-z]+")){
                    cont++;
                    abbreviation = abbreviation +""+ cad[j].charAt(0);
                    aux = aux + cad[j]+" ";
                    j++;
                }
                if(cont>=2){
                    cont = 0;
                    abbreviation = abbreviation + " ("+aux.trim()+")";
                    original = original.replaceAll(aux.trim(),abbreviation);
                    aux = abbreviation = "";
                    i = j-1;
                }else{
                    aux = abbreviation = "";
                    cont=0;
                }
            }
            System.out.println(original);
        }
    }
}
