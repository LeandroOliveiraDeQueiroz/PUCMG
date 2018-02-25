import java.util.*;
public class DiagonalPrincipal{
   public static void main(String[] args){
      saudacao();
      double[][] matriz = new double[leValorlinha()][leValorcoluna()];
      MontaMatriz(matriz);  
      double x = MaiorValorDiagonal(matriz);
      if(x == 0){
         System.out.println("A Matriz n�o inserida n�o � quadrada.");
      }else{
         System.out.println("O maior valor abaixo da diagonal principal �: "+ x+" .");
      }//finaliza IF/ELSE       
          
         
   }
   public static void saudacao(){
      System.out.println("Ser� verificado o maior valor posicionado abaixo da diagonal principal");
   }//finaliza saudacao    
   public static void MontaMatriz(double[][] a){
      Scanner scanner = new Scanner(System.in);
      for(int i = 0; i<a.length; i++){
         for(int j = 0; j<a[i].length; j++){
            System.out.println("Digite o valor do elemento v [" + i+"]["+j+"].");
            a[i][j] = scanner.nextDouble();
            }//fim for
      }//fim for
   }//finaliza Monta Matriz
   public static int leValorlinha(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite quantas linhas a matr�z tem");
      return scanner.nextInt();
   }//finaliza leValorlinha   
   public static int leValorcoluna(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite quantas colunas a matr�z tem");
      return scanner.nextInt();
   }//finaliza leValorcoluna   
   
   public static double MaiorValorDiagonal(double[][] x){
      if(x.length != x[0].length) return 0;
      double maiorvalor= 0;
      for(int i = 1; i<x.length; i++){
         for(int j = i-1; j<x.length; j++){
            if(x[i][j] > maiorvalor){
               maiorvalor = x[i][j];
            }//finaliza IF
         }//finaliza FOR
      }//finaliza FOR         
    return maiorvalor;  
   
   }//finaliza MaiorValorDiagonal
 }// fim classe