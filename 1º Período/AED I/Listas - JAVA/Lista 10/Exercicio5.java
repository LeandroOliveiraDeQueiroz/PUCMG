import java.util.*;
public class Exercicio5{
   public static void main(String[] args){
      saudacao();
      int[][]a = new int[5][1];
      for(int i = 0 ; i<a.length; i++){
         a[i][0] = 2*i -1;
      }//fim do for
      System.out.println("A m�dia � = " + mediacoluna(a));   
               
   }//fim da main
   
   public static void saudacao(){
      System.out.println("Ser� feita uma m� dos termos de 1 coluna de 1 matr�z");
      
   }// fim sauda��o
   
   public static double mediacoluna(int[][]a){
      int acumulador = 0 ;
      for(int i = 0 ; i<a.length;i++){
         acumulador += a[i][0];
      }//fim for
      
      return ((double)acumulador/a.length); 
            
   }//fim mediacoluna        
       
}//fim classe          