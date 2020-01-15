package br.sisru;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int	dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	
	
	public Data(int mes, int ano) {
		super();
		this.mes = mes;
		this.ano = ano;
	}





	public String toString() {
		return this.dia + "/" + this.mes + "/" + this.ano;
	}
	
	public int getDia() {
		return this.dia;
	}
	
	public void setDia(int d) {
		this.dia = d;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public void setMes(int m) {
		this.mes = m;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public void setAno(int a) {
		this.ano = a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (ano != other.ano)
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}

}