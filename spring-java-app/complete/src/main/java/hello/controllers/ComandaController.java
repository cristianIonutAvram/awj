package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class ComandaController{
  private List<Comanda> comenzi = new ArrayList<Comanda>();

  ComandaController() {
    Comanda c1 = new Comanda(1, "first");
    Comanda c2 = new Comanda(2, "second");
    Comanda c3 = new Comanda(3, "third");

    comenzi.add(c1);
    comenzi.add(c2);
    comenzi.add(c3);
  }
    
    
    
    
    //create
    @RequestMapping(value="/comanda/{id>},{nume}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("id") int id,@PathVariable("nume") String nume) {
   this.comenzi.create (new Comanda (id, "Nume"));
      Comanda c = new Comanda(id,nume);
      this.comanda.add(c);
      return new ResponseEntity<Comanda>(c, new HttpHeaders(), HttpStatus.OK);
  }
    
    
    //Update
    @RequestMapping(value="/comanda/{id>},{nume}", method = RequestMethod. PUT)
    public ResponseEntity update(@PathVariable("id") int id,@PathVariable("nume") String nume) {
        for(Comanda c: this.comenzi) {
            if(c.getId() == id) {
                c.setName(nume);
            }
        }
    }
    
    
    
    
    
    //Show all
  @RequestMapping(value="/comanda", method = RequestMethod.GET)
  public List<Comanda> index() {
    return this.comenzi;  //returneaza lista comenzilor
  }

    
    
    //show id
  @RequestMapping(value="/comanda/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Comanda c : this.comenzi) {
      if(c.getId() == id) {
        return new ResponseEntity<Comanda>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
    
    
    
    
    //delete

  @RequestMapping(value="/comanda/{id}", method = RequestMethod.DEL)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Comanda c : this.comenzi) {
      if(c.getId() == id) {
        this.comenzi.remove(c);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}