import java.util.ArrayList;
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
        ArrayList<Saint> subLista = new ArrayList<Saint>();
        //
        for (Saint saint : this.saints) {
            if (saint.getArmadura().getCat().equals(categoria)) {
                subLista.add(saint);
            }
        }
        return subLista;
    }
    public ArrayList<Saint> buscarPorStatus(Status status){
        ArrayList<Saint> listaPorStatus = new ArrayList<>();
        for (int i = 0; i<saints.size();i++){
            Saint test = this.saints.get(i);
            if(test.getStatus().equals(status)) listaPorStatus.add(test);
        }
        return listaPorStatus;
    } 
    
    public Saint getSaintMaiorVida(){
        double vida = 0.0;
        Saint saint=null;
        for (int x = 0; x<saints.size();x++){
            Saint test = saints.get(x);
            if (test.getVida()>vida){
                saint = test;
                vida=test.getVida();
            }
        }
        return saint;
    }
    public Saint getSaintMenorVida(){
        double vida = 100.0;
        Saint saint = null;
        for (int x = 0; x<saints.size();x++){
            Saint test = saints.get(x);
            if (test.getVida()<vida){
                saint = test;   
                vida=test.getVida();
            }
        }
        return saint;
    }
    
    public void ordenar(){
        Saint saint = null;
        for(int i = 0; i<saints.size(); i++){
            for(int x = 1; x < saints.size(); x++){
                if(saints.get(i).getVida()>saints.get(x).getVida()){
                    saint = saints.get(i);
                    saints.add(i, saints.get(x));
                    saints.add(x, saint);
                }
            }
        
        }
    }
}