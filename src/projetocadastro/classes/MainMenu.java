package projetocadastro.classes;

import java.util.Scanner;

import projetocadastro.exceptions.DuplicatedEmailException;
import projetocadastro.exceptions.InvalidEmailFormatException;
import projetocadastro.exceptions.InvalidHeightFormatException;
import projetocadastro.exceptions.NameTooShortException;
import projetocadastro.exceptions.UnderageException;


public class MainMenu {
  public static void showMenu() throws NameTooShortException, InvalidEmailFormatException, UnderageException, DuplicatedEmailException, InvalidHeightFormatException {
    Scanner scanner = new Scanner(System.in);
    System.err.println("1 - Cadastrar o usuário");
    System.err.println("2 - Listar todos os usuários cadastrados");
    System.err.println("3 - Cadastrar nova pergunta no formulário");
    System.err.println("4 - Deletar pergunta do formulário");
    System.err.println("5 - Pesquisar usuário por nome ou idade ou email");
    int num = scanner.nextInt();

    switch (num) {
      case 1:
        System.err.println("Cadastrando novo usuário...");
        Questions.answer();
        break;
    
      case 2:
        System.err.println("Listando usuários...");
        ListUsers.list();
        break;
      
      case 3:
        System.err.println("Cadastrando nova pergunta...");
        AddQuestion.add();
        break;

      case 4:
        DeleteQuestion.delete();
        break;

      case 5:
        System.err.println("Pesquisando usuário...");
        SearchUser.search();
        break;
    }
    scanner.close();
  }
}
