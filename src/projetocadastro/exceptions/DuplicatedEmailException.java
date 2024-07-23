package projetocadastro.exceptions;

public class DuplicatedEmailException extends Exception {
  public DuplicatedEmailException() {
    super("Já existe uma conta com esse E-mail!");
  }
}
