public class Exercicio5{
   public static void main(String[] args){
      saudacao();
      double[] a = new double[5]; 
      constroiArray(a); 
      System.out.println("O arranjo possui "+ verificaArray(a,0)+ " v�lidos");    
       
   }//fim da main
   
   public static void saudacao(){
      System.out.println("Ser� verificado o n�mero de elementos v�lidos em 1 arranjo");
   }//fim saudacao
    
   public static void constroiArray(double[] a){
      for(int i = 0; i<a.length; i++){
         a[i] = 4-i;
      }//fim do for para constru��o da array   
   }//fim do constroiArray
   
   public static int verificaArray(double[] a, int b){
     if(a[b] == a.length) return b;
     else if(a[b] == 0) return b; 
     return  verificaArray(a,b+1);
      
   }//fim verificaArray             
         
   
   
}//fim da classe      