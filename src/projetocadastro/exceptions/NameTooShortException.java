package projetocadastro.exceptions;

public class NameTooShortException extends Exception {
  public NameTooShortException() {
    super("Seu nome deve ter pelo menos 10 caracteres!");
  }  
}
