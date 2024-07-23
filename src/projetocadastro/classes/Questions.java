package projetocadastro.classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import projetocadastro.exceptions.DuplicatedEmailException;
import projetocadastro.exceptions.InvalidEmailFormatException;
import projetocadastro.exceptions.InvalidHeightFormatException;
import projetocadastro.exceptions.NameTooShortException;
import projetocadastro.exceptions.UnderageException;

public class Questions {
  public static String[] answer() throws NameTooShortException, InvalidEmailFormatException, UnderageException, DuplicatedEmailException, InvalidHeightFormatException {
    File file = new File("src\\projetocadastro\\forms\\formulario.txt");
    int numQuestions = countQuestions(file);
    String[] infos = new String[numQuestions]; 
    
    try (FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)) {
        Scanner scanner = new Scanner(System.in);
        String line;
        int index = 0;
        while((line = br.readLine()) != null) {
          System.err.println(line);
          infos[index] = scanner.nextLine();
          index++;
        }
        scanner.close();
        validAnswers(infos);

      } catch(IOException e) {
        System.err.println(e);
      }

      new User(infos);

      for (String info : infos) { // Talvez isso vire uma função?
        System.err.println(info);
      }

      registerUser(infos);

      return infos;
  }

  public static void registerUser(String[] answers) {
    File folder = new File("src\\projetocadastro\\usersInfo");
    File[] fileList = folder.listFiles();
    int numFiles = fileList.length;

    String fileName = answers[0].replaceAll(" ", "").toUpperCase();
    File file = new File("src\\projetocadastro\\usersInfo\\" + (numFiles + 1) + "-" + fileName + ".txt"); // Aqui tem coisa pra poder resolver o esquema dos números errados, o número tem que ser refeito, todos os nomes tem que ser refeitos com os números novos

    try (FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw)) {
        for (String answer : answers) {
          bw.write(answer);
          bw.newLine();
        }
        } catch (IOException e) {
          System.err.println(e);
        }
    }

  public static void read() {
    File file = new File("src\\projetocadastro\\forms\\formulario.txt");
    try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)) {
          String line;
          while((line = br.readLine()) != null) {
            System.err.println(line);
          }
        } catch (IOException e) {
          System.err.println(e);
        }
  }

  public static int countQuestions(File file) {
    int numQuestions = 0;
    try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)) {
          while(br.readLine() != null) {
            numQuestions++;
          }
        } catch (IOException e) {
          System.err.println(e);
        }

    return numQuestions;
  }

  public static void validAnswers(String[] list) throws NameTooShortException, InvalidEmailFormatException, UnderageException, DuplicatedEmailException, InvalidHeightFormatException { // Usar try e catch nas condições não faz o programa parar, o txt é criado do mesmo jeito, por isso usei throws
    if (list[0].length() <= 10) {
      throw new NameTooShortException();
    }

    if(!(list[1].contains("@"))) {
      throw new InvalidEmailFormatException();
    }
    
    if (Integer.parseInt(list[2]) < 18) {
      throw new UnderageException();
    }

    File folder = new File("src\\projetocadastro\\usersInfo");
    if (checkEmail(list[1], folder)) {
      throw new DuplicatedEmailException();
    }

    if (!checkHeightFormat(list[3])) {
      throw new InvalidHeightFormatException();
    }

  }

  public static List<String> createEmailList(File folder) {
    File[] files = folder.listFiles();
    List<String> emailList = new ArrayList<>();
    
    for (File file : files) {
      if (file.isFile()) {
        try(FileReader fr = new FileReader(file);
          BufferedReader br = new BufferedReader(fr)) {
            String line;
            int index = 1;
            while ((line = br.readLine()) != null) {
              if (index == 2) {
                emailList.add(line);
              }
              index++;
            }
          } catch(Exception e) {
            System.err.println(e);
          }
      }
    }
    return emailList;      
  }

  public static boolean checkEmail(String emailToCheck, File folder) {
    boolean isDuplicated = false;
    List<String> emailList = createEmailList(folder);
    for (String email : emailList) {
      if (email.equals(emailToCheck)) {
        isDuplicated = true;
        break;
      }
    }
    return isDuplicated;
  }

  public static boolean checkHeightFormat(String height) {
    String regex = "^[12]\\.\\d{2}$"; // Regex pattern: one digit, a dot, two digits
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(height);

    if (matcher.matches()) {
      return true;
    }

    return false;
  }

}

  