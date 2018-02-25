public class Exercicio8{
   public static void main(String[] args){
      saudacao();
      double[] a = new double[20];  
      iniciaArray(a);
      System.out.println(verificaDivisao(a,0, 0,2) + " termos do arranjo s�o divis�veis por 2.");                
   }//fim da main
   
   public static void saudacao(){
      System.out.println("Ser� verificado o n�mero de elementos de um arranjo divis�vel por 2");
   }//fim saudacao
   
   public static void iniciaArray(double[] a){
      for(int i = 0; i < a.length; i++){
         a[i] = 7*i;  
      }//fim for array 
   }//fim verificaArray 
   
   public static int verificaDivisao(double [] a,int b, int i,int x){
      if(i == a.length) return b;
      else if(a[i] % x == 0) b++;
      return verificaDivisao(a,b,i+1,x);
   }//fim verificaValor                  
   
}//fim da classe      