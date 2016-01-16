package hello;

import java.util.List;
import java.util.ArrayList;

public class Student {
  private int id;
  private String nume;
  private String prenume;
  private int varsta;
  
  public Student() {}

  public Student(int id, String nume, String prenume, int varsta) {
      this.nume = nume;
	  this.prenume = prenume;
	  this.varsta = varsta;
      this.id = id;
  }

  
  public String getNume() {
      return this.nume;
  }

  public String getPrenume(){
	  return this.prenume;
  }
  
  public int getVarsta(){
	  return this.varsta;
  }
  
  public int getId() {
    return this.id;
  }
  
  public void setNume( String nume){
	  this.nume = nume;
  }
  
  public void setPrenume( String prenume){
	  this.prenume = prenume;
  }
  
  public void setVarsta( int varsta){
	  this.varsta = varsta;
  }
}
