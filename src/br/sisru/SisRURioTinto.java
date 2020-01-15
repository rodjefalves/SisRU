package br.sisru;


import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class SisRURioTinto implements SisRU {

	private List<Usuario> usuarios;
	private List<RefeicaoRealizada> refeicoes;

	public SisRURioTinto() {
		this.usuarios = new ArrayList<Usuario>();
		this.refeicoes = new ArrayList<RefeicaoRealizada>();
	}

	public boolean cadastraUsuario(Usuario u) {
		for (Usuario user : this.usuarios) {
			if (user.getMatricula().equals(u.getMatricula())) {
				return false;
			}
		}
		this.usuarios.add(u);
		return true;
	}

	public List<Usuario> pesquisaUsuariosDaCidade(String cidade) {
		ArrayList<Usuario> UsuariosDaCidade = new ArrayList<Usuario>();
		for (Usuario user : this.usuarios) {
			if (user.getCidadeResidencia().equals(cidade)) {
				UsuariosDaCidade.add(user);
			}
		}
		return UsuariosDaCidade;
	}

	public Usuario pesquisaUsuarioPelaMatricula(String matricula) throws UsuarioNaoExisteException {
		for (Usuario user : this.usuarios) {
			if (user.getMatricula().equals(matricula)) {
				return user;
			}
		}
		throw new UsuarioNaoExisteException("Não existe usuário com esta matrícula");
	}

	public List<Usuario> pesquisaUsuariosComNomeComecandoCom(String prefixoNome) {
		ArrayList<Usuario> UsuariosComPref = new ArrayList<Usuario>();
		for (Usuario user : this.usuarios) {
			if (user.getNome().startsWith(prefixoNome)) {
				UsuariosComPref.add(user);
			}
		}
		return UsuariosComPref;
	}

	public void gravarDados() {
		GravadorDeDados gravador = new GravadorDeDados();
		try {
			gravador.gravarUsuarios(this.usuarios);
		} catch (IOException e) {
			System.out.println("Erro ao gravar os dados. " + e.getMessage());
		}
	}
	public void gravarRefeicao() {
		GravadorDeDados gravador = new GravadorDeDados();
		try {
			gravador.gravaRefeicoes(this.refeicoes);
		} catch (IOException e) {
			System.out.println("Erro ao gravar os dados. " + e.getMessage());
		}
	}

	public void recuperarDados() {
		GravadorDeDados recuperar = new GravadorDeDados();
		try {
			this.usuarios = recuperar.recuperarUsuarios();
		} catch (IOException e) {
			System.out.println("Erro ao recuperar os dados!" + e.getMessage());
		}
	}
	
	public void recuperarRefeicao() {
		GravadorDeDados recuperar = new GravadorDeDados();
		try {
			this.refeicoes = recuperar.recuperaRefeicoes();
		} catch (IOException e) {
			System.out.println("Erro ao recuperar os dados!" + e.getMessage());
		}
	}

	public void cadastrarRefeicaoRealizada(int dia, int mes, int ano, String matricula, String tipoRefeicao)
			throws UsuarioNaoExisteException {
		for (Usuario u : this.usuarios) {
			if (u.getMatricula().equals(matricula)) {
				RefeicaoRealizada r = new RefeicaoRealizada(new Data(dia, mes, ano), matricula, tipoRefeicao);
				refeicoes.add(r);
				return;
			}
		}
		throw new UsuarioNaoExisteException("Usuário não está autorizado para fazer refeição");

	}

	public int refeicaoTotalDoDia(int dia, int mes, int ano) {
		int refeicaoTotal = 0;
		for (RefeicaoRealizada ref : this.refeicoes) {
			if (ref.getDataRefeicao().equals(new Data(dia, mes, ano))) {
				refeicaoTotal += 1;
			}
		}
		return refeicaoTotal;
	}

	public int pesquisarTotalDeUsuarioEmCertoMes(int dia, int mes, int ano) {
		int totalDeUsuarioCertoMes = 0;
		for (RefeicaoRealizada ref : this.refeicoes) {
			if (ref.getDataRefeicao().equals(new Data(dia, mes, ano))) {
				totalDeUsuarioCertoMes += 1;
			}
		}
		return totalDeUsuarioCertoMes;
	}

	public int pesquisarTotalDeUsuarioEmCertoMes(int mes, int ano) {
		int totalDeUsuarioCertoMes = 0;
		for (RefeicaoRealizada ref : this.refeicoes) {
			Data compara = new Data(ref.getDataRefeicao().getMes(), ref.getDataRefeicao().getAno());
			if (compara.equals(new Data(mes, ano))) {
				totalDeUsuarioCertoMes += 1;
			}
		}
		return totalDeUsuarioCertoMes;
	}

	public int pesquisarTotalDeRefeicaoDeTipo(String tipoRef, int mes, int ano) {
		int quantTipo = 0;
		for (RefeicaoRealizada ref : this.refeicoes) {
			if (ref.getTipoRefeicao().equals(tipoRef) && ref.getDataRefeicao().getMes() == mes
					&& ref.getDataRefeicao().getAno() == ano) {
				quantTipo += 1;
			}
		}
		return quantTipo;
	}

	public List<String> pesquisarUsuarioRefeicoesDia(int dia, int mes, int ano) throws UsuarioNaoExisteException {
		ArrayList<String> listaMatriculas = new ArrayList<String>();
		ArrayList<String> nomesUsuarios = new ArrayList<String>();
		for (RefeicaoRealizada ref : this.refeicoes) {
			if (ref.getDataRefeicao().getDia() == dia && ref.getDataRefeicao().getMes() == mes
					&& ref.getDataRefeicao().getAno() == ano) {
				if (listaMatriculas.contains(ref.getMatriculaUsuario()) == false) {

					listaMatriculas.add(ref.getMatriculaUsuario());
				}

			}
		}
		for (String mat : listaMatriculas) {

			try {
				Usuario u = this.pesquisaUsuarioPelaMatricula(mat);
				nomesUsuarios.add(u.getNome());
			} catch (UsuarioNaoExisteException e) {
				System.out.println("Sem sucesso" + e.getMessage());
			}
		}
		return nomesUsuarios;
	}
}