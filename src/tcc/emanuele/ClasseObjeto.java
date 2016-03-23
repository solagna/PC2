/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.emanuele;

/**
 *
 * @author Emanuele
 */
public class ClasseObjeto {
    private String nome;
    private String descricao;
    private Double estoque;
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ClasseObjeto(String nome, String descricao, Double estoque, Double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
        this.preco = preco;
    }
    
    
}
