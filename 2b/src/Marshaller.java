import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;


public class Marshaller {

    private Document dom = null;
    private ArrayList<Libro> libros = null;

    public Marshaller(ArrayList<Libro> l){
        libros = l;
    }

    public void creaDoc(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
        }catch (ParserConfigurationException pce){
            pce.printStackTrace();
        }
    }

    public void arbolDom(){
        Element docEle = dom.createElement("libros");
        dom.appendChild(docEle);

        Iterator<Libro> it = libros.iterator();
        while(it.hasNext()){
            Libro lib = (Libro) it.next();
            Element libroEle = setLibro(lib);
            docEle.appendChild(libroEle);
        }
    }

    private Element setLibro(Libro l){
        Element libroEle = dom.createElement("libro");
        Element tituloEle = dom.createElement("titulo");
        tituloEle.setAttribute("publicacion", Integer.toString(l.getPublicacion()));
        Text tituloTexto = dom.createTextNode(l.getTitulo());
        tituloEle.appendChild(tituloTexto);
        libroEle.appendChild(tituloEle);

//ELEMENTO AUTOR
        Element autorEle = dom.createElement("autor");
        Text autorTexto = dom.createTextNode(l.getAutor());
        autorEle.appendChild(autorTexto);
        libroEle.appendChild(autorEle);

//ELEMENTO APELLIDO
        Element apellidoEle = dom.createElement("apellido");
        Text apellidoTexto = dom.createTextNode(l.getApellido());
        apellidoEle.appendChild(apellidoTexto);
        libroEle.appendChild(apellidoEle);

//ELEMENTO EDITOR
        Element editorEle = dom.createElement("editor");
        Text editorTexto = dom.createTextNode(l.getEditor());
        editorEle.appendChild(editorTexto);
        libroEle.appendChild(editorEle);

//ELEMENTO PAGINAS
        Element paginasEle = dom.createElement("paginas");
        Text paginasTexto = dom.createTextNode(Integer.toString(l.getPaginas()));
        paginasEle.appendChild(paginasTexto);
        libroEle.appendChild(paginasEle);

        return libroEle;
    }

    public void classToXml(File xmlSalida)throws TransformerException{
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT,"yes");

        StreamResult result = new StreamResult(xmlSalida);
        DOMSource source = new DOMSource(dom);
        trans.transform(source,result);
    }

}



