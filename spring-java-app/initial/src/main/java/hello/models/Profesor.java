package hello;

import java.util.List;
import java.util.ArrayList;

public class Profesor {
  private int id;
  private String nume;
  private String prenume;
  private String titlu;
  

  public Profesor() {}

  public Profesor(int id, String nume, String prenume, String titlu) {
      this.id = id;
	  this.nume = nume;
	  this.prenume = prenume;
	  this.titlu = titlu;
      
  }
  
  public String getPrenume(){
	  return this.prenume;

	  }
  
  public String getNume() {
      return this.nume;
  }
  
  public String getTitlu(){
	  return this.titlu;
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
  
  public void setTitlu( String titlu){
	  this.titlu = titlu;
  }
}
