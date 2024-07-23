package projetocadastro.classes;


public class User {
  private String name;
  private String email;
  private int age;
  private float height;

  public User(String[] infos) {
    name = infos[0];
    email = infos[1];
    age = Integer.parseInt(infos[2]);
    height = Float.parseFloat(infos[3]);
  }
  
  public String getName() {
    return name;
  }
  public String getEmail() {
    return email;
  }
  public int getAge() {
    return age;
  }

  public float getHeight() {
    return height;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public void setHeight(float height) {
    this.height = height;
  }
}
