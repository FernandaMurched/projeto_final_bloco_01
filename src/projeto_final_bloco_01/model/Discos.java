package projeto_final_bloco_01.model;

public class Discos extends Produto {

	private String formato;


	public Discos(int id, String nome, int tipo, float preco, String formato) {
		super(id, nome, tipo, preco);
		this.formato = formato;
	
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;

	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Formato: " + this.formato);
	}
}
