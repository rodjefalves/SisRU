package br.sisru;

public class UsuarioNaoExisteException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoExisteException(String msg) {
        super(msg);
    }
}