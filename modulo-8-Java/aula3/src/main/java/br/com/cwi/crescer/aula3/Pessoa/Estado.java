/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.Pessoa;

/**
 *
 * @author alana.weiss
 */
public class Estado {
    private Long id;
    private String nome;
    private String uf;
    private Long Pais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getPais() {
        return Pais;
    }

    public void setPais(Long Pais) {
        this.Pais = Pais;
    }
    
    
}
