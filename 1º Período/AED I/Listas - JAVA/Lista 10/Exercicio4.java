import java.util.*;
public class Exercicio4{
   public static void main(String[] args){
      saudacao();
      double[][] b = new double[][]{{3,2},{-2,1},{5,1},{9,3}};
      if(ehpositivo(b)){
         System.out.println("Todos os termos s�o positivos");
      }else{
         System.out.println("Um ou mais termos s�o negativos");   
      }//fim if/else
         
   }//fim da main
   
   public static void saudacao(){
      System.out.println("Ser� verificado se todos os termos de uma matr�z s�o positivos ");
      
   }// fim sauda��o
   
   public static boolean ehpositivo(double[][]a){
      for(int i = 0 ; i<a.length; i++){
         for(int j = 0; j<a[i].length; j++){
            if(a[i][j] < 0 ) return false;
         }
      }   
      return true;
   }//fim ehpositivo        
       
}//fim classe          