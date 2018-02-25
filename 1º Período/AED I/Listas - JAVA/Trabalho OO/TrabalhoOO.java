import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

/*    --- > EXPLICA��O SOBRE PROPRIEDADES EST�TICAS < ---
 *  OS ATRIBUTOS EST�TICOS S�O AQUELES QUE PERTENCEM SOMENTE � CLASSE
 *  LOGO, TODO M�TODO DA CLASSE PODE ACESSAR ESSE ATRIBUTO.
 *  SENDO QUE, PARA RECUPERAR OS VALORES DO MESMO EM OUTRA CLASSE, �
 *  NECESS�RIO APENAS A INICIALIZA��O DE MODO EST�TICO, OU SEJA,
 *  NOME DA CLASSE + . + NOME DO M�TODO QUE CONTEM O ATRIBUTO.  
*/

   // --> HIPERCLASSE 
abstract class FiguraGeo{
   abstract double perimetro();
}//fim clase abstrata

   // --> CLASSE MAIN
public class TrabalhoOO{
   public static void main(String[]args){
      saudacao();
      Arquivo.criaArquivo("triangulo.txt");
      Arquivo.criaArquivo("circulo.txt");
      Metodos metodos = new Metodos();
      metodos.Menu();
      
   } 
   public static void saudacao(){
      System.out.println("   --- BEM VINDO --- "); 
   }    
}

   // --> CLASSE OBJETO TRI�NGULO
class Triangulo extends FiguraGeo{
   private double ladoA,
                  ladoB,
                  ladoC;
   private static int contador = 0;
   Triangulo(double l1, double l2, double l3){
      setLadoA(l1);
      setLadoB(l2);
      setLadoC(l3);
      contaTriangulo();
   }
   Triangulo(){
      setLadoA(0);
      setLadoB(0);
      setLadoC(0);
      contaTriangulo();
   }      
      // --> M�TODOS SETTERS 
   public void setLadoA(double lado){
      if(lado>0) this.ladoA=lado;
      else this.ladoA=0;
   }
   public void setLadoB(double lado){
      if(lado>0) this.ladoB=lado;
      else this.ladoB=0;
   }
   public void setLadoC(double lado){
      if(lado>0) this.ladoC=lado;
      else this.ladoC=0;
   }
   
      // --> M�TODOS GETTERS
   public double getLadoA(){
      return this.ladoA;
   }
   public double getLadoB(){
      return this.ladoB;
   }
   public double getLadoC(){
      return this.ladoC;
   }   
      // -->  M�TODO CONTADOR DE TRI�NGULOS
   private static void contaTriangulo(){
      contador++;
   }//fim contador 
      // --> M�TODO GET CONTADOR DE TRI�NGULO
   public static int getContadorTriangulo(){
      return contador;
   }//fim get contador Triangulo 
      // -- > M�TODO SET CONTADOR TRIANGULO   
   public static void setContadorTriangulo(){
      if(contador>0){
         contador--;
      }   
   }//fim set contador  
       
      // --> M�TODO ESCREVE TRI�NGULOS EXISTENTES         
   public static void escreveContadorTriangulo(){
      System.out.println("--> " + getContadorTriangulo() + " Triangulo(s) Existente(s)");
   }//fim escreve contador  
   
   // --> M�TODO ESCREVER
   public void escreve(){
      System.out.println("Lado A: "+getLadoA()+"\nLado B: "+getLadoB()+"\nLado C: "+getLadoC()+"\n");
   }
   
   // --> M�TODO VERIFICA EXIST�NCIA TRI�NGULO
   public boolean ehTriangulo(){
      if((this.ladoA+this.ladoB<this.ladoC)||(this.ladoB+this.ladoC<this.ladoA)||(this.ladoA+this.ladoC<this.ladoB)) 
         return false;
      return true;
   }
   
   // --> M�TODO TIPO DO TRI�NNGULO
   public int Tipo(){
      if(ehTriangulo()==false) 
         return 0;
      if((this.ladoA==this.ladoB)&&(this.ladoA==this.ladoC)) 
         return 1;
      if(((this.ladoA==this.ladoB)&&(this.ladoA!=this.ladoC))||((this.ladoA==this.ladoC)&&(this.ladoA!=ladoB))||((this.ladoB==this.ladoC)&&(this.ladoB!=this.ladoA))) 
         return 2;
      if((this.ladoA!=this.ladoB)&&(this.ladoA!=this.ladoC)&&(this.ladoB!=this.ladoC)) 
         return 3;
      return 0;
   }   
   public void escreveTipo(){
      int tipoTriangulo=Tipo();
      if(tipoTriangulo==0) System.out.println("N�o � tri�ngulo.");
      if(tipoTriangulo==1) System.out.println("Equil�tero.");
      if(tipoTriangulo==2) System.out.println("Is�celes.");
      if(tipoTriangulo==3) System.out.println("Escaleno.");
   }
   
   // --> M�TODO PER�METRO
   public double perimetro(){
      if(ehTriangulo()==true) 
         return this.ladoA+this.ladoB+this.ladoC;
      else 
         return 0.0;
   }   
   
   // --> M�TODO LEITURA DE LADOS DE UM TRI�NGULO
   public void le(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o valor para o lado A do tri�ngulo:");
      setLadoA(scanner.nextDouble());
      System.out.println("Digite o valor para o lado B do tri�ngulo:");
      setLadoB(scanner.nextDouble());
      System.out.println("Digite o valor para o lado C do tri�ngulo:");
      setLadoC(scanner.nextDouble());
   }
}
   // --> CLASSE OBJETO C�RCULO
class Circulo extends FiguraGeo{
   private double raio;
   private static int contador = 0;
   
   Circulo(){
      setRaio(0);
      contaCirculo();
   }//construtor sem par�metro
   Circulo(double raio){
      setRaio(raio);
      contaCirculo();
   }//construtor com par�metro      

      // -- > M�TODO SET
   public void setRaio(double raio){
      this.raio = raio;
   }//fim set
      // --> M�TODO GET
   public double getRaio(){
      return this.raio;
   }//fim get   
      
      // -->  M�TODO CONTADOR DE C�RCULOS
   private static void contaCirculo(){
      contador++;
   }//fim contador 
   // --> M�TODO GET CONTADOR DE C�RCULOS
   public static int getContadorCirculo(){
      return contador;
   }//fim get contador Triangulo 
    // -- > M�TODO SET CONTADOR CIRCULO 
   public static void setContadorCirculo(){
      if(contador>0){
         contador--;
      }     
         
   }
      // --> M�TODO ESCREVE C�RCULOS EXIST�NTES
   public static void escreveContadorCirculo(){
      System.out.println("--> " + contador + " C�rculo(s) Existente(s)");
   }//fim escreve contador             
   
   // --> M�TODO ESCREVER C�RCULO
   public void escreve(){
      System.out.println("O C�rculo possui raio: " + getRaio());
   }//fim m�todo escreve
   
   // --> M�TODO LEITURA DE UM NOVO C�RCULO
   public void le(){
      Scanner leraio = new Scanner(System.in); 
      System.out.println("Digite o valor do raio: ");
      int a = leraio.nextInt();
      setRaio(a);
   }//fim m�todo le
  
  // --> M�TODO PER�METRO 
   public double perimetro(){
      return 2*Math.PI*getRaio();
   }//fim m�todo perimetro      
        
}
   // --> CLASSE RESPONS�VEL PELO MENU
class Metodos{   
   int contador = 0, contador2 = 0;    
   int posicao, posicao2;
   Triangulo[] arranjo = new Triangulo[100];
   Circulo[] arranjo2 = new Circulo[100];   
   
   // --> M�TODO MENU PRINCIPAL
   public void Menu(){  
      int menu;
      
      // RECUPERA DADOS J� EXISTENTES
      Arquivo.recuperaDados("triangulo.txt", arranjo);
      Arquivo.recuperaDados("circulo.txt",arranjo2);
      Scanner scanner = new Scanner(System.in);  
      contador+= Triangulo.getContadorTriangulo();
      contador2+= Circulo.getContadorCirculo();  
      do{
         System.out.println(" --- MENU PRINCIPAL --- \n (0) - Finaliza o Programa \n (1) - Menu Triangulo \n (2) - Menu Circulo");
         menu=scanner.nextInt();
         switch(menu){
            case 0: System.out.println(" --- Fim do Programa --- ");
               break;                  
            case 1: MenuTriangulo();
               break;
            case 2: MenuCirculo();
               break;
            
            default: System.out.println(" Op��o Inv�lida");
               break;
         }
      }while(menu!=0);
   }//finaliza m�todo Menu   
   
   // --> M�TODO MENU TRI�NGULO
   public void MenuTriangulo(){
      int menu;
      Scanner scanner = new Scanner(System.in);
      boolean continualaco1 = true,
              continualaco2 = true,
              continualaco3 = true,
              continualaco4 = true;                  
      do{
         System.out.println("\n     --- Menu Tri�ngulo ---");         
         Triangulo.escreveContadorTriangulo();
         System.out.println("(0) - Voltar ao Menu Principal.\n(1) - Cadastrar um novo tri�ngulo.\n(2) - Lista todos os tri�ngulos.\n(3) - Escreve os lados do tri�ngulo de sua escolha.\n(4) - Escreve o tipo do tri�ngulo de sua escolha.\n(5) - Escreve o per�metro do tri�ngulo de sua escolha.\n(6) - Listar tri�ngulos existentes no arquivo.");
         menu=scanner.nextInt();
         switch(menu){
            case 0: continua();
               break;
            case 1: 
               do{
                  try{
                     leTriangulo();
                     continualaco1 = false;
                  }
                  catch(ArrayIndexOutOfBoundsException erro){
                     System.out.println("Limite de Triangulos atingidos.");                                             
                  }
                  catch(InputMismatchException erro){
                     System.out.println("Apenas numeros inteiros permitidos");
                     Triangulo.setContadorTriangulo();                                            
                  } 
               }while(continualaco1);   
               break;           
            case 2: listaTriangulo();
               break;
            case 3: 
               do{
                  try{
                     enesimoTriangulo();
                     continualaco2 = false;
                  }
                  catch(InputMismatchException erro){
                     System.out.println("Apenas numeros inteiros permitidos [0..99]");                                             
                  } 
               }while(continualaco2);         
               break;
            case 4: 
               do{
                  try{
                     tipoEnesimoTriangulo();
                     continualaco3 = false;
                  }
                  catch(InputMismatchException erro){
                     System.out.println("Apenas numeros inteiros permitidos [0..99]");                                            
                  } 
               }while(continualaco3);   
               break;
            case 5:
               do{
                  try{
                     if(contador>0){
                        escrevePerimetro(getTriangulo(posicaoEnesimoTriangulo()));
                     }
                     else{                    
                        System.out.println("Nenhum tri�ngulo registrado!");}
                     continualaco4 = false;
                  }
                  catch(InputMismatchException erro){
                     System.out.println("Apenas numeros inteiros permitidos [0..99]");   
                                  
                  } 
               }while(continualaco4);   
               break;
            case 6: Arquivo.leArquivo("triangulo.txt");
               break;
            default: System.out.println("Op��o inv�lida.");
               break;
         }
      }while(menu!=0);
   }
   
   public void leTriangulo()throws ArrayIndexOutOfBoundsException, InputMismatchException{
      arranjo[contador] = new Triangulo();
      arranjo[contador].le();
      Arquivo.escreve("triangulo.txt", arranjo[contador]);
      contador+=1;
   }
   public void listaTriangulo(){
      for(int i=0; i<contador; i++){
         arranjo[i].escreve();
      }
   }
   public void enesimoTriangulo()throws InputMismatchException{      
      Scanner scanner = new Scanner(System.in);
      if(contador==0){
         System.out.println("Nenhum tri�ngulo criado.");
         return;
      }
      System.out.println("Digite a posi��o do tri�ngulo desejado no arranjo.");
      posicao=scanner.nextInt();
      while(posicao>=contador){
         System.out.println("Tri�ngulo ainda n�o criado na posi��o selecionada, escolha uma posi��o v�lida.");
         posicao=scanner.nextInt();  
      }
      arranjo[posicao].escreve();
   }
   public void tipoEnesimoTriangulo()throws InputMismatchException{
      Scanner scanner = new Scanner(System.in);
      if(contador==0){
         System.out.println("Nenhum tri�ngulo criado.");
         return;
      }
      System.out.println("Digite a posi��o do tri�ngulo desejado no arranjo. [0..99] ");
      posicao=scanner.nextInt();
      while(posicao>=contador){
         System.out.println("Tri�ngulo ainda n�o criado na posi��o selecionada, escolha uma posi��o v�lida.");
         posicao=scanner.nextInt();  
      }
      arranjo[posicao].escreveTipo();   
   }
   public int posicaoEnesimoTriangulo()throws InputMismatchException{
      Scanner scanner = new Scanner(System.in);     
      if(contador==0){
         System.out.println("Nenhum tri�ngulo criado.");
         return 0;
      }
      System.out.println("Digite a posi��o do tri�ngulo desejado no arranjo.");
      posicao=scanner.nextInt();
      while(posicao>=contador){
         System.out.println("Tri�ngulo ainda n�o criado na posi��o selecionada, escolha uma posi��o v�lida.");
         posicao=scanner.nextInt();  }        
      return posicao;
   }
   
   public Triangulo getTriangulo(int i){
      return arranjo[i];
   }   
   
   // -- > M�TODO MENU C�RCULO
   public void MenuCirculo(){
      int menu;      
      boolean continualaco = true,      
              continualaco2 = true,
              continualaco3 = true;              
      Scanner scanner = new Scanner(System.in);
      do{
         System.out.println("\n     --- Menu C�rculo --- :");
         Circulo.escreveContadorCirculo();
         System.out.println("(0) - Voltar ao Menu Principal.\n(1) - Cadastrar um novo c�rculo.\n(2) - Lista todos os c�rculos.\n(3) - Mostrar um c�rculo na posi��o desejada do arranjo.\n(4) - Escreve o per�metro do c�rculo.\n(5) - Listar c�rculos existentes no arquivo.");
         menu=scanner.nextInt();
         switch(menu){
            case 0: continua();
               break;
            case 1:  
               do{
                  try{
                     leCirculo();
                     continualaco = false;
                  }
                  catch(ArrayIndexOutOfBoundsException erro){
                     System.out.println("Limite de Circulos atingidos.");                       
                  }
                  catch(InputMismatchException erro){
                     System.out.println("Apenas numeros inteiros permitidos."); 
                     Circulo.setContadorCirculo();
                                                
                  }
               }while(continualaco);          
               break;
            case 2: listaCirculos();
               break;
            case 3: 
               do{
                  try{
                     enesimoCirculo();
                     continualaco2 = false;
                  }
                  catch(InputMismatchException erro){
                     System.out.println("Apenas numeros inteiros permitidos. [0..99]");                       
                  }
               }while(continualaco2);           
               break;            
            case 4: 
               do{
                  try{
                     if(contador2>0){
                        escrevePerimetro(getCirculo(posicaoCirculo()));
                     }
                     else{
                        System.out.println("Nenhum c�rculo registrado!");}
                     continualaco3 = false;
                  }
                  catch(InputMismatchException erro){
                     System.out.println("Apenas numeros inteiros permitidos. [0..99]");                       
                  }
               }while(continualaco3);
               break;
            case 5:Arquivo.leArquivo("circulo.txt");
               break;             
            default: System.out.println("Op��o inv�lida.");
               break;
         }
      }while(menu!=0);
   }
   
   public Circulo getCirculo(int i){
      return this.arranjo2[i];
   }
   
   public void leCirculo() throws ArrayIndexOutOfBoundsException,InputMismatchException{
      arranjo2[contador2] = new Circulo();
      arranjo2[contador2].le();
      Arquivo.escreve("circulo.txt", arranjo2[contador2]);
      contador2+=1;
   }//fim m�todo leCirculo
   
   public void listaCirculos(){
      for(int i=0; i<contador2; i++){
         arranjo2[i].escreve();
      }
   }//fim m�todo ListaCirculos
   
   public void enesimoCirculo()throws InputMismatchException{
      Scanner scanner = new Scanner(System.in);
      if(contador2==0){
         System.out.println("Nenhum c�rculo criado.");
         return;
      }
      System.out.println("Digite a posi��o do c�rculo desejado no arranjo. [0..99] ");
      posicao2=scanner.nextInt();
      while(posicao2>=contador2){
         System.out.println("Tri�ngulo ainda n�o criado na posi��o selecionada, escolha uma posi��o v�lida.");
         posicao2=scanner.nextInt();  
      }
      arranjo2[posicao2].escreve();
   }//fim m�todo enesimoCirculo
   
   public void escrevePerimetro(FiguraGeo FG){
      System.out.println("Per�metro da Figura: " + FG.perimetro());
   }//fim escrevePerimetro   
   
   public int posicaoCirculo(){
      Scanner scanner = new Scanner(System.in);
      if(contador2==0){
         System.out.println("Nenhum c�rculo criado.");
         return 0;
      }
      System.out.println("Digite a posi��o do c�culo desejado no arranjo.");
      posicao2=scanner.nextInt();
      while(posicao2>=contador2){
         System.out.println("C�rculo ainda n�o criado na posi��o selecionada, escolha uma posi��o v�lida.");
         posicao2=scanner.nextInt();  
      }      
      return posicao2;                    
   }//fim m�todo perimetroCirculo       
   
   public void continua(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Deseja continuar? < Enter > ");
      scanner.nextLine();
      
   }//fim m�todo continua    
}
   // --> CLASSE RESPONS�VEL PELA CRIA��O DO ARQUIVO     
class Arquivo{
      // --> M�TODO VERIFICA ARQUIVO
   public static void verificaArquivo(){
      Scanner scanner = new Scanner(System.in);
      System.out.print("Digite nome do arquivo: ");
      String nome_arq = scanner.nextLine();
      validaArquivo(nome_arq);
   }//fim criaArquivo
   
      // --> M�TODO VALIDA ARQUIVO
   private static boolean validaArquivo(String nomeArquivo) {
      File arquivo = new File(nomeArquivo);
      boolean existe = false;
      if (arquivo.exists()) {
         existe = true;
      }
      return existe;   
   }
      // --> M�TODO CRIA ARQUIVO
   public static void criaArquivo(String nomeArquivo){
      File arquivo = new File(nomeArquivo);
      try {
         if(!validaArquivo(nomeArquivo)){
            arquivo.createNewFile();
         }
      } 
      catch (IOException io) {
         io.printStackTrace();
      }    
   }//fim cria Arquivo    
      // --> M�TODO ESCREVE ARQUIVO TRI�NGULO
   public static void escreve(String nome_arquivo, Triangulo arranjo){
      File arquivo = new File(nome_arquivo);
      FileWriter fw = null;
      try{
         fw = new FileWriter(arquivo,true);
         fw.write(arranjo.getLadoA()+"\r\n");
         fw.write(arranjo.getLadoB()+"\r\n");
         fw.write(arranjo.getLadoC()+"\r\n");
         fw.flush();
      }catch(FileNotFoundException io){
         io.printStackTrace(); 
      } 
      catch(IOException io){
         io.printStackTrace(); 
      }
      finally{
         try{
            fw.close();
         }catch(IOException erro){
            System.out.print(erro);
         }
      }                          
   }
      // --> M�TODO ESCREVE ARQUIVO C�RCULO
   public static void escreve(String nome_arquivo, Circulo arranjo2){
      File arquivo = new File(nome_arquivo);
      try (FileWriter fw = new FileWriter(arquivo,true)){
         fw.write(arranjo2.getRaio()+"\r\n");
         fw.flush();
      } 
      catch(IOException io){
         io.printStackTrace(); 
      }   
   }
      // --> M�TODO RECUPERA DADOS TRI�NGULO   
   public static void recuperaDados(String nome_arquivo, Triangulo[] arranjo){
      try{
         File arquivo = new File(nome_arquivo);
         Scanner scanner = new Scanner(arquivo);
         int i = 0;
         while(scanner.hasNext()){
            arranjo[i] = new Triangulo();
            arranjo[i].setLadoA(Double.parseDouble(scanner.nextLine()));
            arranjo[i].setLadoB(Double.parseDouble(scanner.nextLine()));
            arranjo[i].setLadoC(Double.parseDouble(scanner.nextLine()));
            i++;
         }
         scanner.close();
      } 
      catch(FileNotFoundException fileNotFound){
         fileNotFound.printStackTrace();
      }
   }
   
      // --> M�TODO RECUPERA DADOS C�RCULO
   public static void recuperaDados(String nome_arquivo, Circulo[] arranjo2){
      try{
         File arquivo = new File(nome_arquivo);
         Scanner scanner = new Scanner(arquivo);
         int i = 0;
         while(scanner.hasNext()){
            arranjo2[i] = new Circulo(Double.parseDouble(scanner.nextLine()));            
            i++;
         }
         scanner.close();
      } 
      catch(FileNotFoundException fileNotFound){
         fileNotFound.printStackTrace();
      }
   }
      // -->  M�TODO L� ARQUIVOS TRIANGULO E CIRCULO
   public static void leArquivo(String nome_arquivo){
      try{         
         FileReader arquivo = new FileReader(nome_arquivo);         
         int x = arquivo.read();
         while(x != -1){
            System.out.print((char)x);
            x = arquivo.read();            
         }
      }catch(IOException erro){
         System.out.print(erro);         
      }  
   }
   
}