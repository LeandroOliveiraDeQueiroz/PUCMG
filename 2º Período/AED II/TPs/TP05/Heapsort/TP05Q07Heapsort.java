/**
 * TP05Q01 Ordenação Heapsort por dia do nascimento.
 * @author Gabriel Luciano Gomes
 * @version 1 09/2016
 */
import java.util.*;
import java.io.*;

class TP05Q07Heapsort{
    static Lista lista = new Lista(1000);
    public static void main(String[] args) throws Exception {
        Pessoa pessoa;
	MyIO.setCharset("UTF-8");
        int id;
        for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = MyIO.readLine()){
            pessoa = new Pessoa();
            pessoa.ler(nomeArquivo);
            lista.inserirFim(pessoa);
        }
	long  comeco = lista.now();
        lista.heapsort();
	long fim = lista.now();
        for(int i = 0; i<lista.getN();i++){
            lista.getArray()[i].imprimir();
        }
	Arq.openWrite("matrícula_heapsort.txt", "UTF-8");
	Arq.print("569631\t");
	Arq.print(lista.getComparacoes()+"\t");
	Arq.print(lista.getMovimentacoes()+"\t");
	Arq.print(((fim-comeco)/1000.0)+"\t");
	Arq.close();
        

    }
}
class Pessoa
{
    private int id;
    private int idade;
    private String nome;
    private String nacionalidade;
    private String nascimento;
    private String localNascimento;
    private String morte;
    private String localMorte;

    public void imprimir(){
        MyIO.println(this.id + " ## " + 
                this.nome + " ## " + 
                this.nacionalidade + " ## " +
                this.nascimento + " ## " +
                this.localNascimento + " ## " +
                this.morte + " ## " +
                this.localMorte + " ## " +
                this.idade + //" " + 
                "");
    }

    Pessoa(){
        setId(0);
        setNome("");
        setNacionalidade("");
        setNascimento("");
        setLocalNascimento("");
        setMorte("");
        setIdade(0);

    }

    Pessoa(int id, String nome, String nacionalidade, String nascimento, String localnascimento, String morte, String localmorte, int idade){
        setId(id);
        setNome(nome);
        setNacionalidade(nacionalidade);
        setNascimento(nascimento);
        setLocalNascimento(localnascimento);
        setMorte(morte);
        setLocalMorte(localmorte);
        setIdade(idade);
    }


    //Métodos Setters dos atributos da classe Pessoa	
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setNacionalidade(String nacionalidade){
        this.nacionalidade = nacionalidade;
    }
    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }
    public void setLocalNascimento(String localNascimento){
        this.localNascimento = localNascimento;
    }
    public void setMorte(String morte){
        this.morte = morte;
    }
    public void setLocalMorte(String localMorte){
        this.localMorte = localMorte;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    //Métodos Getters dos atributos da classe Pessoa
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getNacionalidade(){
        return this.nacionalidade;
    }
    public String getNascimento(){
        return this.nascimento;
    }
    public String getLocalNascimento(){
        return this.localNascimento;
    }
    public String getMorte(){
        return this.morte;
    }
    public String getLocalMorte(){
        return this.localMorte;
    }
    public int getIdade(){
        return this.idade;
    }

    public Pessoa clone (){
        Pessoa resp = new Pessoa();
        resp.setId(this.getId());
        resp.setIdade(this.getIdade());
        resp.setNome(this.getNome());
        resp.setNacionalidade(this.getNacionalidade());
        resp.setNascimento(this.getNascimento());
        resp.setLocalNascimento(this.getLocalNascimento());
        resp.setMorte(this.getMorte());
        resp.setLocalMorte(this.getLocalMorte());
        return resp;
    }


    public int getMes(String data){
        int resp = 0;
        if(data.contains("janeiro") == true){
            resp = 1;
        } else if(data.contains("fevereiro") == true){
            resp = 2;
        } else if(data.contains("março") == true){
            resp = 3;
        } else if(data.contains("abril") == true){
            resp = 4;
        } else if(data.contains("maio") == true){
            resp = 5;
        } else if(data.contains("junho") == true){
            resp = 6;
        } else if(data.contains("julho") == true){
            resp = 7;
        } else if(data.contains("agosto") == true){
            resp = 8;
        } else if(data.contains("setembro") == true){
            resp = 9;
        } else if(data.contains("outubro") == true){
            resp = 10;
        } else if(data.contains("novembro") == true){
            resp = 11;
        } else if(data.contains("dezembro") == true){
            resp = 12;
        } else if(data.contains("ca.") == true){
            resp = 00;
        } else if(data.contains("Não conhecida") == true){
            resp = 00;
        }                   

        return resp;
    }
		
    public int getAno(String data){
        int resp = 0;
        if(data.contains("Não conhecida") == true){
            resp = 0000;
        } else if(data.contains("a.C.") == true){
            data = data.substring(4,7);
            resp = 0 - Integer.parseInt(data);
        } else{
            String[] ano = getNascimento().split( " de " );
            resp = Integer.parseInt(ano[2]);
        }
        return resp;
    }  
    
    public int getDia(){
        return getDia(getNascimento());
    }
    public int getDia(String data){   
	    int resp = 0;
	    if(data.contains("Não conhecida") == true){
		resp = 0;
	    } else if(data.contains("ca.") == true){
		resp = 0;
	    }else{        
            	String[] dia = data.trim().split(" de ");
            	resp = Integer.parseInt(dia[0]);
	    }         
        return resp;
    }
        
     




    public void parsePessoa(String s){
        String array[] = s.split(" ## ");
        this.id = new Integer(array[0]).intValue();
        this.nome = array[1];
        this.nacionalidade = array[2];
        this.nascimento = array[3];
        this.localNascimento = array[4];
        this.morte = array[5];
        this.localMorte = array[6];
        this.idade = new Integer(array[7]).intValue();
    }

    public String getSubstringEntre(String s, String antes, String depois){
        String resp = "";
        int posInicio , posFim;

        posInicio = s.indexOf(antes) + antes.length();

        if(antes.compareTo(depois) != 0){
            posFim = s.indexOf(depois);
        } else {
            posFim = s.indexOf(depois, posInicio);
        }

        if(0 <= posInicio && posInicio < posFim && posFim < s.length()){
            resp = s.substring(posInicio, posFim);
        }

        return resp;
    }

    public int getIntEntre(String s, String antes, String depois){
        return (new Integer(getSubstringEntre(s, antes, depois).replace(".","").trim())).intValue();
    }

    public double getDoubleEntre(String s, String antes, String depois){
        return (new Double(getSubstringEntre(s, antes, depois).replace(",",".").trim())).doubleValue();
    }

    public String removeTags(String s){
        String resp = "";

        for (int i = 0; i < s.length(); i++){

            //Perguntas: (1) Pq o while abaixo? (2) Pq as clausulas do while abaixo nao podem ser invertidas?
            while(i < s.length() && s.charAt(i) == '<'){
                for (i++; s.charAt(i) != '>'; i++);
                i++;

                //Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
                while(i < s.length() && s.charAt(i) == '&'){
                    for (i++; s.charAt(i) != ';'; i++);
                    i++;
                }
            }

            //Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
            while(i < s.length() && s.charAt(i) == '&'){
                for (i++; s.charAt(i) != ';'; i++);
                i++;
                resp += ' ';
            }

            //Perqunta: Pq nao colocamos apenas resp += s.charAt(i)?
            if(i < s.length()){
                resp += s.charAt(i);
            }
        }

        while(resp.length() > 0 && resp.charAt(0) == ' '){
            resp = resp.substring(1);
        }

        return resp;
    }

    public void ler(String nomeArquivo){
        String linha;

        //Abrir o arquivo para leitura
        Arq.openRead(nomeArquivo, "UTF8");//ISO-8859-1");

        //Definir atributo id
        this.id = (nomeArquivo.charAt(nomeArquivo.length() - 8) - 48) * 100;
        this.id += (nomeArquivo.charAt(nomeArquivo.length() - 7) - 48) * 10;
        this.id += (nomeArquivo.charAt(nomeArquivo.length() - 6) - 48);

        //Definir atributo nome
        for(linha = Arq.readLine(); linha.contains("<h1") == false; linha = Arq.readLine());
        this.nome = getSubstringEntre(linha, "lang=\"pt\">", "</h1>");

        //Definir atributo nacionalidade
        for(linha = Arq.readLine(); linha.contains("Nacionalidade") == false; linha = Arq.readLine());
        this.nacionalidade = removeTags(Arq.readLine());

        //Definir atributo nascimento
        for(linha = Arq.readLine(); linha.contains("Nascimento") == false; linha = Arq.readLine());
        this.nascimento = removeTags(Arq.readLine());

        //Se vivo
        if(this.nascimento.charAt(this.nascimento.length()-1) == ')'){
            String tmp = this.nascimento.substring(this.nascimento.indexOf('(') + 1);
            tmp = tmp.substring(0, tmp.indexOf(' '));
            this.idade = (new Integer(tmp)).intValue();
            this.nascimento = this.nascimento.substring(0, this.nascimento.indexOf('('));
            this.morte = "vivo";
            this.localMorte = "vivo";
        } else {
            this.morte = "";
            this.localMorte = "";
        }

        //Definir atributo local de nascimento
        for(linha = Arq.readLine(); linha.contains("Local") == false; linha = Arq.readLine());
        this.localNascimento = removeTags(Arq.readLine());

        //Definir atributos morte e local de morte
        if (this.morte.length() == 0){
            for(linha = Arq.readLine(); linha.contains("Morte") == false; linha = Arq.readLine());
            this.morte = removeTags(Arq.readLine());

            if(this.morte.contains("(") == true){
                String tmp = this.morte.substring(this.morte.indexOf('(') + 1);
                tmp = tmp.substring(0, tmp.indexOf(' '));
                this.idade = (new Integer(tmp)).intValue();
                this.morte = this.morte.substring(0, this.morte.indexOf('('));
            }

            for(linha = Arq.readLine(); linha.contains("Local") == false; linha = Arq.readLine());
            this.localMorte = removeTags(Arq.readLine());
        }

        //Fechar o arquivo para a leitura
        Arq.close();
    }
}


class Lista {
    private Pessoa[] array;
    private int n;
    private int comparacoes=0, movimentacoes=0;


    /**
     * Construtor da classe.
     */
    Lista () {
        this(1000);
    }


    /**
     * Construtor da classe.
     * @param tamanho Tamanho da lista.
     */
    public Lista (int tamanho){
        array = new Pessoa[tamanho];
        n = 0;
    }

    public int getN(){
        return this.n;
    }

    public Pessoa[] getArray(){
        return this.array;
    }

    /**
     * Insere uma pessoa na primeira posicao da lista e move os demais
     * elementos para o fim da lista.
     * @param x Pessoa pessoa a ser inserida.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirInicio(Pessoa x) throws Exception {

        //validar insercao
        if(n >= array.length){
            throw new Exception("Erro ao inserir!");
        } 

        //levar elementos para o fim do array
        for(int i = n; i > 0; i--){
            array[i] = array[i-1].clone();
        }

        array[0] = x.clone();
        n++;
    }


    /**
     * Insere uma pessoa na ultima posicao da lista.
     * @param x Pessoa pessoa a ser inserida.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirFim(Pessoa x) throws Exception {

        //validar insercao
        if(n >= array.length){
            throw new Exception("Erro ao inserir!");
        }

        array[n] = x.clone();
        n++;
    }


    /**
     * Insere uma pessoa em uma posicao especifica e move os demais
     * elementos para o fim da lista.
     * @param x Pessoa pessoa a ser inserida.
     * @param pos Posicao de insercao.
     * @throws Exception Se a lista estiver cheia ou a posicao invalida.
     */
    public void inserir(Pessoa x, int pos) throws Exception {

        //validar insercao
        if(n >= array.length || pos < 0 || pos > n){
            throw new Exception("Erro ao inserir!");
        }

        //levar elementos para o fim do array
        for(int i = n; i > pos; i--){
            array[i] = array[i-1].clone();
        }

        array[pos] = x.clone();
        n++;
    }


    /**
     * Remove uma pessoa da primeira posicao da lista e movimenta 
     * as demais pessoas para o inicio da mesma.
     * @return resp Pessoa pessoa a ser removida.
     * @throws Exception Se a lista estiver vazia.
     */
    public Pessoa removerInicio() throws Exception {

        //validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        Pessoa resp = array[0].clone();
        n--;

        for(int i = 0; i < n; i++){
            array[i] = array[i+1].clone();
        }

        return resp;
    }


    /**
     * Remove uma Pessoa da ultima posicao da lista.
     * @return resp Pessoa pessoa a ser removida.
     * @throws Exception Se a lista estiver vazia.
     */
    public Pessoa removerFim() throws Exception {

        //validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        return array[--n].clone();
    }


    /**
     * Remove uma pessoa  de uma posicao especifica da lista e 
     * movimenta as demais pessoas para o inicio da mesma.
     * @param pos Posicao de remocao.
     * @return resp Pessoa pessoa a ser removido.
     * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
     */
    public Pessoa remover(int pos) throws Exception {

        //validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover!");
        }

        Pessoa resp = array[pos].clone();
        n--;

        for(int i = pos; i < n; i++){
            array[i] = array[i+1].clone();
        }

        return resp;
    }


    /**
     * Mostra as pessoas da lista separados por espacos.
     */
    public void mostrar (){
        for(int i = 0; i < n; i++){
            System.out.println(array[i].clone());
        }

    }


    /**
     * Procura uma Pessoa e retorna se ele existe.
     * @param x Pessoa pessoa a ser pesquisado.
     * @return <code>true</code> se o array existir,
     * <code>false</code> em caso contrario.
     */
    public boolean pesquisar(int id) {
        boolean retorno = false;
        for (int i = 0; i < n && retorno == false; i++) {
            retorno = (array[i].getId()  == id);
        }
        return retorno;
    }



    public void swap(int i, int j) {
        Pessoa temp = array[i].clone();
        array[i] = array[j].clone();
        array[j] = temp.clone();
    }
    public void mostrarRec (){
        System.out.print("[ ");
        mostrarRec(0);
        System.out.println("]");
    }

    public void mostrarRec(int i){
        if(i < n){
            System.out.print(array[i] + " ");
            mostrarRec(i + 1);
        }
    }
    /**
     * Retorna o timestamp atual
     * @return timestamp atual
     */
    public long now(){
        return new Date().getTime();
    }



    /**
     * Costrução do Heap 
     *
     */
    public void constroi(int tamHeap){

        for(int i = tamHeap;( i > 1) && array[i].getDia() > array[i/2].getDia(); i /= 2){
            swap(i, (i/2));
        }
    }


    /**
     * Construção do Heap Invertido
     * @param tamHeap int tamanho do heap.
     */ 

    public void reconstroi(int tamHeap){
        int i = 1, filho;
              
        while(i <= (tamHeap/2)){




            /*
             * Definindo os maiores Filhos.
             */

            int diaEsq = array[2*i].getDia();
            int diaDir = array[(2*i) + 1].getDia();
            int idEsq = array[2*i].getId();
            int idDir = array[(2*i) + 1].getId();
                   

            
            if ((diaEsq > diaDir) || (diaEsq == diaDir && idEsq > idDir) || (2*i == tamHeap)){
                filho = 2*i;
		comparacoes++;
            } else {
                filho = 2*i + 1;
		comparacoes++;
            }



            /*
             * Troca de pai com o filho, caso esse for maior que aquele.
             */

            int diaPai = array[i].getDia();
            int diaFilho = array[filho].getDia();
            int idPai = array[i].getId();
            int idFilho = array[filho].getId();

            if((diaPai <diaFilho) || (diaPai == diaFilho && idPai<idFilho)){
                swap(i, filho);
		movimentacoes+= 3;
		comparacoes++;
                i = filho;
            }else{
                i = tamHeap;
            }
        
        }
    }



    /**
     * Algoritmo de ordenacao Heapsort.
     */
    public void heapsort() {
        //Alterar o vetor ignorando a posicao zero
        Pessoa[] tmp = new Pessoa[n+1];
        for(int i = 0; i < getN(); i++){
            tmp[i+1] = array[i].clone();
            movimentacoes++;
        }
        array = tmp;

        //Contrucao do heap
        for(int tamHeap = 2; tamHeap <= getN() ;tamHeap++){
            constroi(tamHeap);
        }
        
        //Ordenacao propriamente dita
        int tamHeap = getN();
        while(tamHeap > 1){
            swap(1, tamHeap--);
	    movimentacoes+= 3;
            reconstroi(tamHeap);
        }
        
        //Alterar o vetor para voltar a posicao zero
        tmp = array;
        array = new Pessoa[getN()];
        for(int i = 0; i < n; i++){
            array[i] = tmp[i+1].clone();
	    movimentacoes++;
        }
    }
	 /**
     	 *Retorna o valor de movimentações realizadas no código
     	 *@return quantidade de movimentações
     	 */
	public int getMovimentacoes(){
		return this.movimentacoes;
	}
	/**
     	 *Retorna o valor de comparações realizadas no código
     	 *@return quantidade de comparações
     	 */
	public int getComparacoes(){
		return this.comparacoes;
	}
	
	



}
