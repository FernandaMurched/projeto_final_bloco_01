package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Camisetas;
import projeto_final_bloco_01.model.Discos;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		
		ProdutoController produtos = new ProdutoController();
		int opcao, id;
		String nome, tamanho, cor, formato;
		float preco;
		
		Discos d1 = new Discos(produtos.gerarId(), "Ceremonials", 1, 80.0f, "Vinil - LP");
		produtos.cadastrar(d1);
		
		Camisetas c1 = new Camisetas(produtos.gerarId(), "Shake It Out", 2, 150.0f, "M", "Preta");
		produtos.cadastrar(c1);
		
		while (true) {
			System.out.print(Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_BLUE_BRIGHT);
			System.out.println("╔═════════◇─◇──◇─◇═════════╗");
			System.out.println("                                                     ");
			System.out.println("         🎵 Florence + The Machine Store 🎵           ");
			System.out.println("                                                     ");
			System.out.println("╚═════════◇─◇──◇─◇═════════╝");
			System.out.println("                                                    ");
			System.out.println("           1 - Cadastrar um produto                 ");
			System.out.println("           2 - Visualizar todos os produtos          ");
			System.out.println("           3 - Buscar produtos por ID               ");
			System.out.println("           4 - Atualizar produto                    ");
			System.out.println("           5 - Deletar produto                      ");
			System.out.println("           0 - Sair                                 ");
			System.out.println("                                                    ");
			System.out.println(" ═══════════════════════════════════════════════════ ");
			System.out.println("─◇             Escolha a opção desejada           ◇─");
			System.out.println(" ╚══════════════════════════════════════════════════╝");

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nFlorence + the Machine Store\n");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("\nCadastrar um produto");

				System.out.println("Digite o nome do produto: ");
				leia.skip("\\R");
				nome = leia.nextLine();

				System.out.println("Digite o tipo do produto: (1 - Discos | 2 - Camisetas)");
				int tipo = leia.nextInt();

				System.out.println("Digite o preço do produto: ");
				preco = leia.nextFloat();

				id = produtos.gerarId();

				switch (tipo) {
					case 1 -> {
						System.out.println("Digite o formato (Vinil ou CD): ");
						leia.skip("\\R");
						formato = leia.nextLine();
						produtos.cadastrar(new Discos(id, nome, tipo, preco, formato));
					}
					case 2 -> {
						System.out.println("Digite o tamanho da camiseta (P, M, G, GG): ");
						leia.skip("\\R");
						tamanho = leia.nextLine();
						System.out.println("Digite a cor da camiseta: ");
						cor = leia.nextLine();
						produtos.cadastrar(new Camisetas(id, nome, tipo, preco, tamanho, cor));
					}
					default -> System.out.println("Tipo inválido.");
				}

				keyPress();
				break;

			case 2:
				System.out.println("\nVisualizar todos os produtos");
				produtos.listarTodos();
				keyPress();
				break;

			case 3:
				System.out.println("\nBuscar produtos por ID");
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				produtos.procurarPorId(id);
				keyPress();
				break;

			case 4:
				System.out.println("\nAtualizar produto");

				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();

				Optional<Produto> produto = produtos.buscarNaCollection(id);

				if (produto.isPresent()) {
					System.out.println("Digite o nome do produto: ");
					leia.skip("\\R");
					nome = leia.nextLine();

					tipo = produto.get().getTipo();

					System.out.println("Digite o preço do produto: ");
					preco = leia.nextFloat();

					switch (tipo) {
						case 1 -> {
							System.out.println("Digite o formato (Vinil ou CD): ");
							leia.skip("\\R");
							formato = leia.nextLine();
							produtos.atualizar(new Discos(id, nome, tipo, preco, formato));
						}
						case 2 -> {
							System.out.println("Digite o tamanho da camiseta (P, M, G, GG): ");
							leia.skip("\\R");
							tamanho = leia.nextLine();
							System.out.println("Digite a cor da camiseta: ");
							cor = leia.nextLine();
							produtos.atualizar(new Camisetas(id, nome, tipo, preco, tamanho, cor));
						}
					}
				} else {
					System.out.println("Produto não encontrado.");
				}

				keyPress();
				break;

			case 5:
				System.out.println("\nDeletar produto");

				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();

				produtos.deletar(id);

				keyPress();
				break;

			default:
				System.out.println("\nOpção inválida. Tente novamente.");
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println(" ░░                                                                ░░");
		System.out.println(" 	   ✦ Projeto desenvolvido por: Fernanda Murched;                 ");
		System.out.println("       ✦ Generation Brasil - fernanda_murched@outlook.com.br;        ");
		System.out.println("       ✦ GitHub - https://github.com/FernandaMurched.               ");
		System.out.println(" ░░                                                                ░░");
		System.out.println(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			int input;
			while ((input = System.in.read()) != '\n') {
				if (input == -1) {
					throw new IOException("Entrada encerrada inesperadamente");
				}
			}
		} catch (IOException e) {
			System.err.println("Erro de entrada/saída: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
		}
	}
}
