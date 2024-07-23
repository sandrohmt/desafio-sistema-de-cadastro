package projetocadastro.exceptions;

public class UnderageException extends Exception{
  public UnderageException() {
    super("O cadastro de menores de idade não é permitida!");
  }
}
