package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;


public class ProdutoController implements ProdutoRepository {
	
	// Criar a Collection ArrayList
		private ArrayList<Produto> listaProduto = new ArrayList<Produto>();

		// Variável para controlar os números das contas
		int id = 0;

		@Override
		public void procurarPorId(int id) {

			Optional<Produto> produto = buscarNaCollection(id);

			if (produto.isPresent())
				produto.get().visualizar();
			else
				System.out.printf("\nOps... O Produto %d não foi encontrado!", id);

		}

		@Override
		public void listarTodos() {
			for (var produto : listaProduto) {
				produto.visualizar();
			}
		}

		@Override
		public void cadastrar(Produto produto) {
			listaProduto.add(produto);
			System.out.println("O Produto foi cadastrado com sucesso!");
		}

		@Override
		public void atualizar(Produto produto) {
			Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());

			if (buscaProduto.isPresent()) {
				listaProduto.set(listaProduto.indexOf(buscaProduto.get()), produto);
				System.out.printf("\nOs dados do produto %d foram atualizados com sucesso! ", produto.getId());
			} else
				System.out.printf("\nO produto informado %d não foi encontrado ", produto);
		}

		@Override
		public void deletar(int id) {
			Optional<Produto> produto = buscarNaCollection(id);

			if (produto.isPresent()) {
				if (listaProduto.remove(produto.get()) == true)
					
				System.out.printf("\nO produto ID %d foi excluído com sucesso!", id);
			} else
				System.out.printf("\nO produto informado %d não foi encontrado ", id);
			
		}
		
		// Métodos Auxiliares

		public int gerarId() {
			return ++id;
		}

		public Optional<Produto> buscarNaCollection(int id) {
			for (var produto : listaProduto) {
				if (produto.getId() == id)
					return Optional.of(produto);
			}

			return Optional.empty();
		}	

}
