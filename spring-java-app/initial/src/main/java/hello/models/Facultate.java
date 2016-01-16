package hello;

import java.util.List;
import java.util.ArrayList;

public class Facultate {
	private int id;
	private String nume;
  private String shortName;
    private int numarStudenti;

  

  public Facultate() {}

  public Facultate(int id, String nume, String shortName, int numarStudenti) {
	 
      
      this.id = id;
	  this.nume = nume;
	   this.shortName = shortName;
	  this.numarStudenti = numarStudenti;
  }

  public String getShortName(){
	  return this.shortName;
  }
  
  public int getNumarStudenti (){
	  return this.numarStudenti;
  }
  
  public String getNume() {
      return this.nume;
  }

  public int getId() {
    return this.id;
  }
  public void setNume( String nume){
	  this.nume = nume;
  }
  
  public void setNumarStudenti( int numarStudenti){
	  this.numarStudenti = numarStudenti;
  }
  
  public void setShortName( String shortName){
	  this.shortName = shortName;
  }
}
