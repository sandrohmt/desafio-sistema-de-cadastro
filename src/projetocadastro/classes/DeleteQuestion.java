package projetocadastro.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteQuestion {
  public static void delete() {
    File file = new File("src\\projetocadastro\\forms\\formulario.txt");
    int numQuestions = Questions.countQuestions(file);

    if (numQuestions == 4) {
      System.err.println("Nenhuma pergunta pode ser deletada!");
      System.exit(0);
    }

    Scanner scanner = new Scanner(System.in);
    Questions.read();
    System.err.println("Escolha uma pergunta para deletar: ");
    int answer;

    while (((answer = scanner.nextInt()) <= 4) || (answer > numQuestions)) { 
      if (answer <= 4) {
        System.err.println("As 4 primeiras perguntas não podem ser deletadas!");
      }
      else {
        System.err.println("Pergunta não existe!");
      }
      System.err.println("Escolha uma pergunta para deletar: ");
      Questions.read();
    }

    scanner.close();

    List<String> fileList = new ArrayList<>();
    File tempFile = new File("src\\projetocadastro\\forms\\temp.txt");

    try(FileWriter fw = new FileWriter(tempFile, true); // Talvez transformar todo o try em função, talvez até com a criação do file junto
        BufferedWriter bw = new BufferedWriter(fw);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);) {

          String line;
          int index = 1;
          while ((line = br.readLine()) != null) {
            if (index != answer) {
              fileList.add(line);
            }
            index++;
          }

          int index2 = 1;
          for (String question : fileList) {
            bw.write(question);
            if (index2 != fileList.size()) {
              bw.newLine();
            }
            index2++;
          }

  } catch (Exception e) {
      System.err.println(e);
    }

    deleteAndRename(file, tempFile);
    RenameQuestions.rename();
  }

  public static void deleteAndRename(File file, File tempFile) {
    if (file.delete()) { // Transformar isso em função
      System.err.println("Pergunta deletada com sucesso");
    } else {
      System.err.println("Erro ao deletar pergunta!");
    }
    tempFile.renameTo(file);
  }

  
}

// Se digitar uma que não existe também vai dar erro
// Resolver o problema de deletar a pergunta e ela ficar com um número errado 