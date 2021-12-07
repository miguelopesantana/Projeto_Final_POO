package com.company;

public class Compra {
    protected String nome;
    protected int quantidade;
    float preco;
    boolean promo;

    /**
     * Construtor
     * @param produto corresponde ao nome do produto
     * @param quantidade corresponde à quantidade de produtos do mesmo tipo que o cliente pertende comprar
     * @param preco corresponde ao preço total da compra a realizar
     */

    public Compra(String produto, int quantidade , float preco, boolean promocao){
        this.nome = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Função que recebe como parâmetro um inteiro e define a variável preço com o valor desse inteiro
     * @param preco corresponde ao preço total da compra a realizar
     */

    public void setPreco(float preco) {
        this.preco = preco;
    }

//    /**
//     * Método que permite imprimir as características de uma compra
//     * @return retorna uma string com todas as características da Classe Compra
//     */

//    @Override
//    public String toString() {
//        return "Compra{" +
//                "produto='" + nome + '\'' +
//                ", quantidade=" + quantidade +
//                '}';
//    }
}
