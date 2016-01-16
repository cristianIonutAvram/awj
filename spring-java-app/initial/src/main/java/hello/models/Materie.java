package hello;

import java.util.List;
import java.util.ArrayList;

public class Materie {
	
  
	private int id;
	private String nume;
	private String nickName;
	
  public Materie() {}

  public Materie(int id, String nume, String nickName) {
      this.id = id;
	  this.nume = nume;
	  this.nickName = nickName;
      
  }

  public String getNume() {
      return this.nume;
  }

  public String getNickName() {
	  return this.nickName;
  }
  
  public int getId() {
    return this.id;
  }
  
  public void setNume( String nume){
	  this.nume = nume;
  }
  
  public void setNickName( String nickName){
	  this.nickName = nickName;
  }
}
