package projetocadastro.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class RenameQuestions {
  public static void rename() {
    File file = new File("src\\projetocadastro\\forms\\formulario.txt");
    File tempFile = new File("src\\projetocadastro\\forms\\temp.txt");
    List<String> fileList = new ArrayList<>();
      try (FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw)) {
        String line;
        while ((line = br.readLine()) != null) {
          fileList.add(line);
        }
        int index = 1;
        for (String question : fileList) {
          String newQuestion = question.substring(4, question.length());
          newQuestion = index + " - " + newQuestion;
          System.err.println(newQuestion);
          bw.write(newQuestion);
          if (index != fileList.size()) {
            bw.newLine();
          }
          index++;
          }
        } catch(Exception e) {
          System.err.println(e);
        }
    DeleteQuestion.deleteAndRename(file, tempFile);
    }
  }


// A ideia dessa função é jogar as perguntas numa lista, mudar o índice delas e depois criar um txt novo pra substituir esse, igual quando deleta a pergunta mesmo, talvez deixar tudo junto de algum jeito que fique menos repetitivo