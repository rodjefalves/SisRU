package br.sisru;

public class RefeicaoRealizada {
	private Data dataRefeicao;
	private String matriculaUsuario;
	private String tipoRefeicao;
	
	public RefeicaoRealizada(Data dataRefeicao , String matriculaUsuario, String tipoRefeicao) {
		this.dataRefeicao = dataRefeicao;
		this.matriculaUsuario = matriculaUsuario;
		this.tipoRefeicao = tipoRefeicao;
	}

	public Data getDataRefeicao() {
		return this.dataRefeicao;
	}
	
	public void setDataRefeicaoa(int dia,int mes, int ano) {
		this.dataRefeicao = new Data(dia,mes,ano);
	}
	
	public String getMatriculaUsuario() {
		return this.matriculaUsuario;
	}
	
	public void setMatriculaUsuario(String matUsu) {
		this.matriculaUsuario = matUsu;
	}
	
	public String getTipoRefeicao() {
		return this.tipoRefeicao;
	}
	
	public void setTipoRefeicao(String tipRef) {
		this.tipoRefeicao = tipRef;
	}
	public static final String TIPO_CAFE = "Café da manhã";
	public static final String TIPO_ALMOCO = "Almoço";
	public static final String TIPO_JANTAR = "Jantar";

	@Override
	public String toString() {
		return "RefeicaoRealizada [dataRefeicao=" + dataRefeicao + ", matriculaUsuario=" + matriculaUsuario
				+ ", tipoRefeicao=" + tipoRefeicao + "]";
	}
		
}