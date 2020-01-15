package br.sisru;

import java.util.List;

public interface SisRU {
    
    public boolean cadastraUsuario(Usuario u);
    public List<Usuario> pesquisaUsuariosDaCidade(String cidade);
    public Usuario pesquisaUsuarioPelaMatricula(String matricula) throws UsuarioNaoExisteException;
    public List<Usuario> pesquisaUsuariosComNomeComecandoCom(String prefixoNome);
    public void gravarDados();
    public void gravarRefeicao();
    public void recuperarDados();
    public void recuperarRefeicao();
    public void  cadastrarRefeicaoRealizada(int dia,int mes, int ano, String matricula, String tipoRefeicao) throws UsuarioNaoExisteException;
    public int refeicaoTotalDoDia(int dia, int mes, int ano);
    public int pesquisarTotalDeRefeicaoDeTipo(String tipoRefeicao, int mes, int ano);
    public int pesquisarTotalDeUsuarioEmCertoMes(int dia, int mes, int ano);
    public int pesquisarTotalDeUsuarioEmCertoMes(int mes, int ano);
    public List<String> pesquisarUsuarioRefeicoesDia(int dia, int mes, int ano) throws UsuarioNaoExisteException;
}
	