import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
    @Test
    public void testarAddSaint() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        
        ListaSaints lista = new ListaSaints();
        lista.adicionar(hyoga);
        
        assertEquals(hyoga, lista.get(0));
    }
    @Test
    public void removerSaintRemoveSaint() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint lala = new BronzeSaint("lala", "Cisne");
        ListaSaints lista = new ListaSaints();
        lista.adicionar(hyoga);
        lista.adicionar(lala);
        lista.remover(hyoga);
        assertEquals(lala, lista.get(0));
    }
    @Test
    public void getIndiceRetornaOSaintNoIndice() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint lala = new BronzeSaint("lala", "Cisne");
        ListaSaints lista = new ListaSaints();
        lista.adicionar(hyoga);
        lista.adicionar(lala);
        Saint testeSaint = lista.get(0);
        assertEquals(testeSaint, lista.get(0));
    }
    
    @Test public void buscarPorNomeBuscaPorNome() throws Exception{
    ListaSaints lista = new ListaSaints();
    Saint lala = new BronzeSaint("lala", "Cisne");
    lista.adicionar(lala);
    assertEquals(lala, lista.buscaPorNome("lala"));
    }
     
    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
       GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        GoldSaint Hakata = new GoldSaint("Hakata","Peixes");
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionar(Seya);
        listaSaint.adicionar(Shiryu);
        listaSaint.adicionar(Hakata);
        listaSaint.adicionar(ikki);
        
        ArrayList<Saint> categorias = new ArrayList<Saint>(); 
        categorias = listaSaint.buscarPorCategoria(Categoria.OURO);
        
        assertEquals(Seya, categorias.get(0));
        assertEquals(Hakata, categorias.get(1));
    }
 
    @Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(misty, listaSaints.getSaintMaiorVida());
    }
    
    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint maiorVida = listaSaints.getSaintMaiorVida();
        assertNull(maiorVida);
    }
    @Test
    public void getSaintMenorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }   
    
    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }
    
    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }
    
    @Test
    public void ordenarComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }
    
    @Test
    public void ordenarComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
   @Test
    public void ordenarTipoOrdenacaoComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarTipoOrdenacaoComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarTipoOrdenacaoComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    // TipoOrdenacao.DESCENDENTE

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
       Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new BronzeSaint("Shun","Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
     @Test
 
    public void testarUnir() throws Exception {
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        lista1.adicionar(shun);
        lista2.adicionar(misty);
        lista2.adicionar(june);
        lista1.unir(lista2);
        ArrayList<Saint> resultado = lista1.todos();
        assertEquals(shun,resultado.get(0));
        assertEquals(misty,resultado.get(1));
    }
    
       @Test
    public void getCSVComApenasUmSaint() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Gênero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, lista.getCSV());
    }
}