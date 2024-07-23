package projetocadastro.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AddQuestion {
  public static void add() {
    Scanner scanner = new Scanner(System.in);
    System.err.println("Digite a pergunta que você deseja adicionar: ");
    String question = scanner.nextLine();
    scanner.close();
    File file = new File("src\\projetocadastro\\forms\\formulario.txt");
    try (FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw)) {
          int count = countQuestions();
          bw.newLine();
          bw.write(count + " - " + question);
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public static int countQuestions() {
    File file = new File("src\\projetocadastro\\forms\\formulario.txt");
    int count = 1;
    try (FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)) {
        while((br.readLine()) != null) {
          count++;
        }
    } catch (Exception e) {
      System.err.println(e);
    }
    return count;
  }
}
