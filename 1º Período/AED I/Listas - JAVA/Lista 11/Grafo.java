/*
Funcionalidades:
Um menu dever� prover as seguintes funcionalidades:

0 � Sair do Programa

1 � Cadastrar os nomes das sete pessoas

2 � Cadastrar as rela��es de amizade de uma pessoa
	Ler qual a pessoa em quest�o [0..6].
Em seguida, verificar se ela tem rela��o de amizade com cada uma das outras seis pessoas. Se o usu�rio informar que sim, armazenar 1 (verdadeiro), caso contr�rio, armazenar 0 (falso).

3 � Pesquisar quais s�o os amigos de uma pessoa.
	Ler a pessoa chave da pesquisa [0..6] e escrever o nome de todos os seus amigos.

4 � Pesquisar qual a pessoa com o maior n�mero de amigos
	Escrever o nome da pessoa que tem o maior n�mero de amigos e escrever esse n�mero.

5 - 	Verificar inconsist�ncia
	Verificar se h� na matriz alguma anomalia relativa ao fato de uma pessoa estar representada na matriz com amizade com ela mesma. Se houver, escrever o nome(s) dessa(s) pessoa(s).

6 - 	Verificar amizades n�o correspondidas
	Listar as rela��es de amizades n�o correspondidas.   
*/   

import java.util.*;
public class Grafo{
   public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      saudacao();
      String[] nomes = new String[7];
      int[][] B = new int[7][7];      
      int n;
      char resposta;
      
      System.out.println("Digite: \n (0) para Finalizar o Programa \n (1) Para Cadastro de nomes \n (2) Para  Cadastro Rela��o de amizades " +
                           "\n (3) Para pesquisar os amigos de uma pessoa \n (4) Para a pesquisa de pessoa com mais amigos " +
                           "\n (5) Para verificar inconsist�ncias  \n (6) Para Verificar amizadaes n�o correspondidas");
      n = scanner.nextInt();  
      if(n==0){
         System.out.println("Programa Encerrado.");
      }//fim if        
      
      while( n!= 0){                            
         switch(n){
            case 0:
               System.out.println("Programa Encerrado");
            case 1: 
               Cadastro(nomes);            
               break;
            case 2:              
               Grafo(nomes,B);
               break;
            case 3:
               AmigosPessoa(nomes,B);            
               DesejaContinuar();            
               break;
            case 4:
               MaisAmigos(nomes,B);
               DesejaContinuar();
               break;
            case 5:
               Iconsistencia(nomes,B);
               DesejaContinuar();
               break;
            case 6:
               AmizadesNaoCorrespondidas(nomes,B);
               DesejaContinuar();               
               break;         
            default:
               System.out.println("Op��o Inv�lida");
         }//fim switch   
         
         System.out.println("Digite: \n (0) para Finalizar o Programa \n (1) Para Cadastro de nomes \n (2) Para  Cadastro Rela��o de amizades " +
                           "\n (3) Para pesquisar os amigos de uma pessoa \n (4) Para a pesquisa de pessoa com mais amigos " +
                           "\n (5) Para verificar inconsist�ncias  \n (6) Para Verificar amizadaes n�o correspondidas");
         n = scanner.nextInt(); 
         if(n==0){
         System.out.println("Programa Encerrado.");   
         }
      }//fim FLAG
   
   }//fim main
   
   public static void saudacao(){
      System.out.println("Ser� feito a constru��o de um grafo de amizades");
   }//fim saudacao
   
   public static void Cadastro(String[] a){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Ser� feito o cadastro das sete pessoas, sendo atribu�do de 0..6 a elas de acordo com a ordem digitada.");
      for(int i = 0; i<a.length; i++){
         System.out.println("Digite nome");
         a[i] = scanner.next();        
      }//fim for     
   }//fim metodo Cadastro 
   
   public static void Grafo(String[] a, int[][] b ){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o n�mero da pessoa a ser cadastrada as amizades 0..6");
      int c = scanner.nextInt();
      char resposta;            
      for(int i = 0; i<b.length; i++){
         if((i == c) && c<b.length ){
            b[c][i] = 0;
         }//fim if
         do{      
            System.out.println( a[c] + " possui amizade com " + a[i]+ " ? [S/N]"); 
            resposta = scanner.next().charAt(0);
            resposta = Character.toUpperCase(resposta);
         }while(resposta != 'S' && resposta != 'N');   
         if(resposta == 'S'){
         b[c][i] = 1;
         }//fim if
         if(resposta == 'N'){
         b[c][i] = 0;
         }//fim if
      }//fim for
   }//fim m�todo Grafo
   
   public static void AmigosPessoa(String[] a, int[][] b){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o n�mero da pessoa a ser feito a pesquisa se quem s�o seus amigos");
      int c = scanner.nextInt();
      System.out.println("Os amigos de " + a[c] + " s�o");
      for(int i = 0; i<b.length; i++){
         if(b[c][i] == 1){ 
         System.out.println(a[i]);
         }//fim if
      }//fim for
   }//fim m�todo AmigoPessoa    
   
   public static void MaisAmigos(String[]a, int [][] b){
      int mamigos = 0, aux =0, p= 0;
      for(int i= 0; i<b.length; i++){
         for(int j = 0; j<b[i].length; j++){
            aux += b[i][j];
            if(aux>mamigos){
               mamigos = aux;
               p = i;
            }//fim if  
         }//fim for
      }//fim for  
      System.out.println("A pessoa com mais amigos � " + a[p] + " Com " + mamigos +" amigos");     
   }//fim metodo MaisAmigos
   
   public static void Iconsistencia(String[] a, int[][] b){
      for(int i = 0; i<b.length; i++){
         if(b[i][i] == 1){
            System.out.println("H� uma inconsist�ncia nas amizades de " + a[i]);
         }else{
            System.out.println("N�o h� inconsist�ncias");   
         }//fim if
      }//fim for           
   }//fim m�todo Inconsistencia      
         
   public static void AmizadesNaoCorrespondidas(String[] a, int[][]b){
      for(int i =0; i<b.length; i++){
         for(int j=0; i<b[i].length; j++){
            if(b[i][j] == 0 && b[j][i] == 0){
               System.out.println("N�o h� correspond�ncia na amizade de " + a[i] + " e " + a[j]);
            }//fim if   
         }//fim for      
      }//fim for         
   }//fim m�todo AmizadesN�oCorrespondidas 
   
   public static void DesejaContinuar(){      
      Scanner scanner = new Scanner(System.in);
      System.out.println("Desja Continuar? <enter>"); 
      scanner.nextLine();
   }//fim m�todo DesejaContinuar                                  
   
}//fim da classe      
