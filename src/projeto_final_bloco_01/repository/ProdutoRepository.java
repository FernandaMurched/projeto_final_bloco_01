package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface ProdutoRepository {

	// Métodos do CRUD (Create, Read, Update e Delete) //
	public void procurarPorID(int numero);

	public void listarTodas();

	public void cadastrar(Produto produto);

	public void atualizar(Produto produto);

	public void deletar(int numero);

}
