package projetocadastro.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ListUsers {
  public static void list() {
    File folder = new File("src\\projetocadastro\\usersInfo");
    File[] files = folder.listFiles();
    int index = 1;

    for (File file : files) {
      try(FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr)) {
      String line;
      line = br.readLine();
      System.err.print(index + " - ");
      System.err.println(line);
      index++;
    } catch(IOException e) {
      System.err.println(e);
    } 
  }

}
    
}
