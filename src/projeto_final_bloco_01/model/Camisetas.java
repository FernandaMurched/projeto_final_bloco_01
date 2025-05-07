package projeto_final_bloco_01.model;

public class Camisetas extends Produto {

	private String tamanho;
	private String cor;

	public Camisetas(int id, String nome, int tipo, float preco, String tamanho, String cor) {
		super(id, nome, tipo, preco);
		this.tamanho = tamanho;
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tamanho: " + this.tamanho);
		System.out.println("Cor: " + this.cor);
	}
}
