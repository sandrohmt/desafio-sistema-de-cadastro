package projetocadastro.exceptions;

public class InvalidHeightFormatException extends Exception {
  public InvalidHeightFormatException() {
    super("Formato da altura inválido! Formato: 1.80");
  }
}
