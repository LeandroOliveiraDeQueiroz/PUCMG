public class Exercicio1{
   public static void main(String[] args){
      saudacao();
      double[] a = new double[5];
      double[] b = new double[5];      
      double[] c = new double[5];
      iniciaArray(a,b);           
      somaArray(a,b,c);
      
      for(int i = 0; i< a.length ; i++){
         System.out.println("A soma das arrays � no "+ (i+1) +"� termo = " + c[i]);
      }//fim do for   
   }//fim da main
   
   public static void saudacao(){
      System.out.println("Ser� feito a soma de dois arranjos");
   }//fim saudacao
   
   public static void somaArray(double[] a, double[] b, double[] c){          
      if(a.length == b.length){         
         for(int i =0; i< a.length;i++){
            c[i] = a[i] + b[i];
         }//fim do for soma das arrays
      }//fim do if 
      else{
         System.out.println("As arrays a serem somadas n�o possuem o mesmo tamanho.");}          
   }//fim somaArray  
   public static void iniciaArray(double[] a,double[] b){
      for(int i = 0; i < a.length; i++){
         a[i] = 2*i;
         b[i] = 3*i;
      }//fim for array a e b
   }//fim iniciaArray             
         
   
   
}//fim da classe      