package br.sisru;

public class Usuario {

    private String nome;
    private String matricula;
    private String cidadeResidencia;
    
    public Usuario (String nome, String matricula, String cidadeResidencia) {
        this.nome = nome;
        this.matricula = matricula;
        this.cidadeResidencia = cidadeResidencia;
    }
    
    public String toString() {
        return nome+" de matrícula "+this.matricula;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String n) {
        this.nome = n;
    }
    
    public String getMatricula() {
    	return this.matricula;
    }
    
    public void setMatricula(String mat) {
    	this.matricula = mat;
    }
    
    public String getCidadeResidencia() {
    	return this.cidadeResidencia;
    }
    
    public void setCidadeResidencia(String cidRes) {
    	this.cidadeResidencia = cidRes;
    }
}