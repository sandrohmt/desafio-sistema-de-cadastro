package projetocadastro.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class SearchUser { // No momento o search funciona para qualquer item, talvez atualizar para que você escolha pesquisar por nome, ou por email, ou por idade, separadamente.
  public static void search() {
    File folder = new File("src\\projetocadastro\\usersInfo");
    System.err.println("Digite o nome da pessoa que você deseja pesquisar: ");
    Scanner scanner = new Scanner(System.in);
    String search = scanner.next().trim().toLowerCase();
    
    List<List<String>> allUsersList = getUserInfo(folder);
    for (List<String> list : allUsersList) {
      for (String item : list) {
        if (item.trim().contains(search)) {
          System.err.println(list);
        } 
      }
    }
    scanner.close();
  }

  public static List<List<String>> getUserInfo(File folder) {
    List<File> fileList = Arrays.asList(folder.listFiles());
    List<List<String>> allUsersList = new ArrayList<>();
    for (File file : fileList) {
      if (file.isFile()) {
        List<String> userList = new ArrayList<>();
        try(FileReader fr = new FileReader(file);
          BufferedReader br = new BufferedReader(fr)) {
          String line;
          while ((line = br.readLine()) != null) {
            userList.add(line);
          }
          allUsersList.add(userList);
      } catch (IOException e) {
          System.err.println(e);
        }
      }
    }
    return allUsersList;
  }
}
