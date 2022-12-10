package Shared.TransferObjects;

import java.io.Serializable;

public class User implements Serializable
{
  private String username;
  private String email;
  private String password;
  private String fname;
  private String lname;
  private String birth;

  public User(String username, String email, String password, String fname,
      String lname, String birth)
  {
    this.username = username;
    this.email = email;
    this.password = password;
    this.fname = fname;
    this.lname = lname;
    this.birth = birth;
  }

  public String getUsername()
  {
    return username;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPassword()
  {
    return password;
  }

  public String getFname()
  {
    return fname;
  }

  public String getLname()
  {
    return lname;
  }

  public String getBirth()
  {
    return birth;
  }
}
