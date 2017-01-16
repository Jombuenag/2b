import javax.xml.transform.TransformerException;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by takuma on 16/01/17.
 */
public class Main {

    public static void main(String[] args){
        ArrayList<Libro> libros;

        libros = new ArrayList<Libro>();
        libros.add(new Libro("Time is Running out", 2015,"Life","McFucked","DAMnation",520));
        libros.add(new Libro("Last efforts of the year", 2016,"Frendrik","VonGunter","DAMnation",250));

        Marshaller marshaller = new Marshaller(libros);

        marshaller.creaDoc();
        marshaller.arbolDom();
        File xmlSalida = new File("catalogo.xml");
        try{
            marshaller.classToXml(xmlSalida);
        }catch (TransformerException tfe){
            tfe.printStackTrace();
        }
    }
}
