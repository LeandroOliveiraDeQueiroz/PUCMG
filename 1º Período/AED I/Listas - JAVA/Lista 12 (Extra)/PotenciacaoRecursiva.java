import java.util.*;
public class PotenciacaoRecursiva{

   public static void main(String[] args){
      saudacao();
      System.out.println("O valor da potencia��o � "+potenciacao(leValorbase(),leValorexpoente()));
   }
   public static void saudacao(){
      System.out.println("Ser� feito a potencia��o de um n�mero de maneira recursiva");
   }//finaliza saudacao   
   public static int potenciacao(int a, int b){
      if (b==0) return 1;
      if (b<0) return 0;
      return a*(potenciacao(a,b-1));
   }//finaliza potenciacao
   public static int leValorbase(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite valor da base");
      return scanner.nextInt();
   }//finaliza leValorbase
   public static int leValorexpoente(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite valor da base");
      return scanner.nextInt();
   }//finaliza leValorexpoente
}//finaliza Classe      
   
      
      
      
      













