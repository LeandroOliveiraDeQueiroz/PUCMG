/* O M�TODO RECURSIVO � RESPONS�VEL POR SOMAR TODOS OS NUMEROS
 * ENTRE 0 AT� O N�MERO DESEJADO
 */
import java.util.Scanner;


public class Exercicio6{
   public static void main(String[] args){
      System.out.println("Digite um numero a ser calculado a soma do intervalo de 0 at� ele");
      Scanner scanner = new Scanner(System.in);
      int x = scanner.nextInt();
      System.out.println("A soma do intervalo �: " + somanumeros(x));
      
   
   }
   
   public static int somanumeros(int x){
      int aux = 0;
      for(int i = 1; i<=x; i++){
         aux += i;         
      }
      return aux;
   }   
   
}   