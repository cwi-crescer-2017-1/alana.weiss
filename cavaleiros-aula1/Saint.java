import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Saint {
    private String nome;
    protected Armadura armadura; 
    private String constelacao;
    private boolean armaduraVestida;
    private Gênero genero = Gênero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados; //acesso para a classe e as subclasses
    private int acumuladorProximoGolpe = 0;
    private int acumuladorProximoMovimento = 0;
    ArrayList<Movimento> listaMovimentos = new ArrayList<>();
    private static int qtdSaints = 0, acumuladorQtdSaints = 0;
    private  int id = 0;
     
    //construtor
    protected Saint(String nome, String constelacao) throws Exception{
        this.nome = nome;
        this.constelacao = constelacao;
        this.vida = 100;
        Saint.qtdSaints++;
        this.id = ++acumuladorQtdSaints;
    } 
    
    // destrutor 
    protected void finalize() throws Throwable{
        Saint.qtdSaints--;
    }
    
    public static int getQtdSaints(){
        return Saint.qtdSaints;
    }
    
    public int getId(){
        return this.id;
    }
    
    public static int getAcumuladorQtdSaints(){
        return Saint.acumuladorQtdSaints;
    }
    
    public String getSaint(){
        return this.nome;
    }
    
    public int getValorArmadura(){
        return this.armadura.getCategoria();
    }
    //metodo
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
    
    //metodo retorno para usar no teste pq a variavel era privada
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }

     public Armadura getArmadura() {
        return this.armadura;
    }

    public Gênero getGenero(){
    return this.genero;
    }

    public void setGenero(Gênero genero){
    this.genero=genero;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public int getCategoriaArmadura(){
        return this.armadura.getCategoria();
    }
    
    public void perderVida(double dano){
       if (dano<0) {
           throw new InvalidParameterException("dano negativo");
        }
       if(this.vida - dano<1){
           this.vida=0;
           this.status = Status.MORTO;
        } else {
            this.vida -= dano;
        }
    }
   
    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }
    
    public Constelacao getConstelacao(){
        return this.armadura.getConstelacao();
    }
    
    public ArrayList<Golpe> getGolpes(){
       return this.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe){
        getConstelacao().adicionarGolpe(golpe);
    }
    
     public Golpe getProximoGolpe() {
        //ArrayList golpes = getGolpes();
        ArrayList<Golpe> golpes = new ArrayList<>();
        golpes = getGolpes();
         int posicao = this.acumuladorProximoGolpe % golpes.size();
         this.acumuladorProximoGolpe++;
         return golpes.get(posicao);
     }
    
     public String getCSV() {
        
        // Interpolação de Strings: return `${nome},${vida},${status}`;
        return String.format(
            "%s,%s,%s,%s,%s,%s,%s",
            this.nome,
            this.vida,
            this.getConstelacao().getNome(),
            this.armadura.getCat(),
            this.status,
            this.genero,
            this.armaduraVestida
        );
        
        /*return  
            this.nome + "," +
            this.vida + "," +
            this.getConstelacao().getNome() + "," +
            this.armadura.getCategoria() + "," +
            this.status + "," +
            this.genero + "," +
            this.armaduraVestida;*/
    }
    
    public void adicionarMovimento(Movimento movimento){
        listaMovimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento() {
         int posicao = this.acumuladorProximoMovimento % listaMovimentos.size();
         this.acumuladorProximoMovimento++;
         return listaMovimentos.get(posicao);
     }
    
    // "agendando" execução do golpe no saint passado por parâmetro
    // o golpe de fato só será executado na batalha.
    public void golpear(Saint golpeado) {
        this.adicionarMovimento(new Golpear(this, golpeado));
    }
}