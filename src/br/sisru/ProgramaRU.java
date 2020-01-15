package br.sisru;

import javax.swing.JOptionPane;

public class ProgramaRU {
	public static void main(String[] args) throws UsuarioNaoExisteException {
		SisRU sistema = new SisRURioTinto();
		sistema.recuperarDados();

		while (true) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção:" 
					+ "\n1.Cadastrar usuário"
					+ "\n2.Pesquisa usuários da cidade" 
					+ "\n3.Pesquisa usuário pela matrícula"
					+ "\n4.Pesquisa Usuário com o prefixo do seu nome"
					+ "\n5.Sair" 
					+ "\n6.Cadastrar refeição realizada"
					+ "\n7.Pesquisar número de refeições totais realizadas em um certo dia"
					+ "\n8.Pesquisar número de refeições de um certo tipo realizadas em um certo mês de um ano"
					+ "\n9.Pesquisar número de usuários que fizeram refeições em um certo mês de um ano"
					+ "\n10. Pesquisar usuários que fizeram refeições em um certo dia" 
					+ "\n11.Salvar dados"));

			if (opcao == 1) {
				String nome = JOptionPane.showInputDialog("Digite seu nome:");
				String matricula = JOptionPane.showInputDialog("Digite sua matricula:");
				String cidade = JOptionPane.showInputDialog("Digite sua cidade:");
				Usuario u = new Usuario(nome, matricula, cidade);
				boolean cadastrou = sistema.cadastraUsuario(u);
				if (cadastrou == true) {
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Já existe usuário com esta matrícula. Tente novamente");
				}
			} else if (opcao == 2) {
				String cidResi = JOptionPane.showInputDialog("Digite o nome da cidade para pesquisar os Usuários:");
				JOptionPane.showMessageDialog(null, sistema.pesquisaUsuariosDaCidade(cidResi));
			} else if (opcao == 3) {
				try {
					String mat = JOptionPane.showInputDialog("Digite a matrícula do usuário");
					Usuario u = sistema.pesquisaUsuarioPelaMatricula(mat);
					JOptionPane.showMessageDialog(null, u.toString());
				} catch (UsuarioNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} finally {
					System.out.println("Ok. Tentei cadastrar");
				}
			} else if (opcao == 4) {
				String pesquisaPrefixo = JOptionPane.showInputDialog("Digite o prefixo do nome:");
				JOptionPane.showMessageDialog(null, sistema.pesquisaUsuariosComNomeComecandoCom(pesquisaPrefixo));
			} else if (opcao == 5) {
				JOptionPane.showMessageDialog(null, "Até mais");
				sistema.gravarDados();
				sistema.gravarRefeicao();
				break;
			} else if (opcao == 6) {
				try {
					int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia:"));
					int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês:"));
					int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
					String matricula = JOptionPane.showInputDialog("Digite a matrícula:");
					String tipoRefeicao = JOptionPane.showInputDialog("Digite o tipo de refeição:\n- Café da manhã\n- Almoço\n- Jantar:");
					sistema.cadastrarRefeicaoRealizada(dia, mes, ano, matricula, tipoRefeicao);
				} catch (UsuarioNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			} else if (opcao == 7) {
				int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia:"));
				int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês:"));
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
				JOptionPane.showMessageDialog(null, sistema.refeicaoTotalDoDia(dia, mes, ano));
			} else if (opcao == 8) {
				String tipoRefeicao = JOptionPane.showInputDialog("Digite o tipo de refeição:\\n- Café da manhã\\n- Almoço\\n- Jantar:");

				int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês:"));
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
				JOptionPane.showMessageDialog(null, sistema.pesquisarTotalDeRefeicaoDeTipo(tipoRefeicao, mes, ano));
			} else if (opcao == 9) {
				int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês:"));
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
				JOptionPane.showMessageDialog(null, sistema.pesquisarTotalDeUsuarioEmCertoMes(mes, ano));
			} else if (opcao == 10) {
				int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia:"));
				int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês:"));
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
				JOptionPane.showMessageDialog(null, sistema.pesquisarUsuarioRefeicoesDia(dia, mes, ano));
			} else if (opcao == 11) {
				sistema.gravarDados();
				sistema.gravarRefeicao();

			}
		}
	}
}