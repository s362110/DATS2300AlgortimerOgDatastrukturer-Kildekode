package Uke37_GenericsOgJavateknisk;

public class TernaryIf {
    public static void main(String[]args){
        for (int i = 0; i < 10; ++i){
            int a = i;
            int b = myTernaryIfTest(a);
            System.out.println(b);
        }

        int a = 17;
        int b = (a < 5) ? 13 : 17;
    }

    //Lager en funksjon
    public static int myTernaryIfTest(int value){
        /*
        if (value < 5){ //Her bruker vi 6 kodelinjer for å printe ut dette.
            return 0;
        } else{
            return 98;
        }
         */

        return (value < 5) ? 0: 98; //If value er mindre enn 5, then return 0, else return 98
    }
}