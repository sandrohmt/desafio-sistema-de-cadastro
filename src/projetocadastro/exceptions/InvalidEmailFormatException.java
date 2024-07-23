package projetocadastro.exceptions;

public class InvalidEmailFormatException extends Exception{
  public InvalidEmailFormatException() {
    super("Seu E-mail deve conter o caractere @!");
  }
}
