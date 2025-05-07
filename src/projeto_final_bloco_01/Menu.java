package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		int opcao = -1;

		while (true) {
			System.out.print(Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_BLUE_BRIGHT);
			System.out.println("╔═════════◇─◇──◇─◇═════════╗");
			System.out.println("                                                     ");
			System.out.println("                    MENU PRINCIPAL                   ");
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
				System.out.println("\n Cadastrar um produto");
				
				keyPress();
				break;

			case 2:
				System.out.println("\nVisualizar todos os produtos");
				break;

			case 3:
				System.out.println("\nBuscar produtos por ID");

				keyPress();
				break;

			case 4:
				System.out.println("\nAtualizar produto");

				keyPress();
				break;

			case 5:
				System.out.println("\nDeletar produto");

				keyPress();
				break;

			case 0:
				System.out.println("\nSair do sistema. Até logo!");
				leia.close();
				System.exit(0);

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
		System.out.println("       ✦ GitHub- https://github.com/FernandaMurched.                 ");
		System.out.println(" ░░                                                                ░░");
		System.out.println(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");

			// Lê apenas a tecla Enter e ignora outras teclas
			int input;
			while ((input = System.in.read()) != '\n') {
				// Ignora qualquer outra tecla diferente do Enter
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
