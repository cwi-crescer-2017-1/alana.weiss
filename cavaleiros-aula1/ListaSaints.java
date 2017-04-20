import java.util.ArrayList;
import java.util.stream.Collectors;
public class ListaSaints{
    ArrayList<Saint> saints = new ArrayList<>();
    private int indice;
    
    public void adicionar(Saint saint){
        this.saints.add(saint);
    }
     
    public ArrayList<Saint> todos(){
        return this.saints;
    }
    
    public Saint get(int indice){
        return this.saints.get(indice);
    }
       
    public void remover(Saint saint){
         this.saints.remove(saint);
    }
    
    public Saint buscaPorNome(String s){
           for(int  i = 0; i<saints.size();i++){
            Saint test = this.saints.get(i);
            if (test.getSaint().equals(s)) {
                return test;   
            }
        }
         return null;
        
    }
    
   public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
        return (ArrayList<Saint>)this.saints.stream()
            .filter(s -> s.getArmadura().getCat().equals(categoria))
            .collect(Collectors.toList());
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status) {
        return (ArrayList<Saint>)this.saints.stream()
            .filter(s -> s.getStatus().equals(status))
            .collect(Collectors.toList());
    }
    
    public Saint getSaintMaiorVida(){
        double vida = 0.0;
        Saint saintMaior=null;
        
        if (saints.isEmpty()) {
            return null;
        }
        
        for (int x = 0; x<saints.size();x++){
            Saint test = saints.get(x);
            if (test.getVida()>vida){
                saintMaior = test;
                vida=test.getVida();
            }
        }
        return saintMaior;
    }

    public Saint getSaintMenorVida(){
        double vida = 100.0;
        Saint saint = null;
        
        if (saints.isEmpty()) {
            return null;
        }
        
        for (int x = 0; x<saints.size();x++){
            Saint test = saints.get(x);
            if (test.getVida()<vida){
                saint = test;   
                vida=test.getVida();
            }
        }
        return saint;
    }
    
    public void ordenar() {
        
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.saints.size() - 1; i++) {
                Saint atual = this.saints.get(i);
                Saint proximo = this.saints.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.saints.set(i, proximo);
                    this.saints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);   
    }   
    
    public void ordenar(TipoOrdenacao ordenacao){
        if(TipoOrdenacao.ASCENDENTE.equals(ordenacao)){
            this.ordenar();
        }else {
            boolean posicoesSendoTrocadas;
            do {
                posicoesSendoTrocadas = false;
                for (int i = 0; i < this.saints.size() - 1; i++) {
                    Saint atual = this.saints.get(i);
                    Saint proximo = this.saints.get(i + 1);
                    boolean precisaTrocar = atual.getVida() < proximo.getVida();
                    if (precisaTrocar) {
                        this.saints.set(i, proximo);
                        this.saints.set(i + 1, atual);
                        posicoesSendoTrocadas = true;
                    }
                }
            } while (posicoesSendoTrocadas);   
           }
    }
    
     public ArrayList<Saint> unir (ArrayList<Saint> array){
         ArrayList<Saint> nova = new ArrayList<>();
         nova = this.todos();
         nova.addAll(array);
         return nova;
     }
     
     public ArrayList<Saint> diff (ArrayList<Saint> recebido){
        ArrayList<Saint> saintsDiferentes = new ArrayList<>();
        boolean diferentes = true;
        for(int i = 0; i<this.saints.size();i++){
            for(int x=0; x<recebido.size();x++){
                if (saints.get(i).equals(recebido.get(x))) diferentes = false;
            }
            if(diferentes) saintsDiferentes.add(saints.get(i));
        }
        return saintsDiferentes;
     }
    
     public ArrayList<Saint> intersec (ArrayList<Saint> recebido){
         ArrayList<Saint> saintsIguais = new ArrayList<>();
         boolean iguais = false;
         for(int i = 0; i<this.saints.size();i++){
            for(int x=0; x<recebido.size();x++){
                if (saints.get(i).equals(recebido.get(x))) iguais = true;
            }
            if(iguais) saintsIguais.add(saints.get(i));
        }
         return saintsIguais;
     }
     
      public String getCSV() {
        String resultado = "";
        
        for(Saint saint : saints) {
            resultado += 
                saint.getSaint() + "," + 
                saint.getVida() + "," + 
                saint.getConstelacao().getNome() + "," + 
                saint.getArmadura().getCategoria() + "," +
                saint.getStatus() + "," + 
                saint.getGenero() + "," + 
                saint.getArmaduraVestida()  + "\n";
        }
        
        return resultado;
    }
}
