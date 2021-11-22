package ProjetoFinalPOO;

public class ProdutoAlimentar extends Produto{
	int num_calorias;
	int perc_gord;
	
	
	public ProdutoAlimentar(int identificador, String nome, int preco, int stock, int num_calorias, int perc_gord) {
		super(identificador, nome, preco, stock);
		this.num_calorias = num_calorias;
		this.perc_gord = perc_gord;
	}
	
	

}
