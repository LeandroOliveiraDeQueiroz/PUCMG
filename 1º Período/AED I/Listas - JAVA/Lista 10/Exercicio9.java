import java.util.*;
public class Exercicio9{
   public static void main(String[] args){
      saudacao();
      double[][]a = new double[][]{{3,2,1},{1,3,5},{8,9,7}};
      System.out.println("A m�dia �: " + media(a));
   
   }//fim da main
   
   public static void saudacao(){
      System.out.println("Ser� realizado m�dia de todos os valores acima da diagonal principal");
      
   }// fim sauda��o
   
   public static double media(double[][]a){
      return (a[0][1]+a[0][2]+a[1][2])/ 3.0;
      
   }//fim media        
       
}//fim classe          