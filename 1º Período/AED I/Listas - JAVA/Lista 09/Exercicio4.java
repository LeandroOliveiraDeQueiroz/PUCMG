public class Exercicio4{
   public static void main(String[] args){
      saudacao();
      double[] a = new double[5];  
      System.out.println("O arranjo possui "+ verificaArray(a)+ " v�lidos");    
       
   }//fim da main
   
   public static void saudacao(){
      System.out.println("Ser� verificado o n�mero de elementos v�lidos em 1 arranjo");
   }//fim saudacao
    
   
   public static int verificaArray(double[] a){
      int b= 0;
      for(int i = 1; i <= a.length; i++){
         a[i] = 4-i; 
         b++;
         if(a[i] ==0){
         return b;        
         }//fim if  
      }//fim for array
      return b; 
   }//fim verificaArray             
         
   
   
}//fim da classe      