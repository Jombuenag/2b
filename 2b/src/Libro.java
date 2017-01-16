
public class Libro {

    private String titulo = "";
    private int publicacion = 0;
    private String autor = "";
    private String apellido = "";
    private String editor = "";
    private int paginas = 0;

    public Libro(String t,int p, String a, String ap, String e, int pags){

        titulo = t;
        publicacion = p;
        autor = a;
        apellido = ap;
        editor = e;
        paginas = pags;
    }


    //	GETS & SETS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void print(){
        System.out.println("Titulo : " + titulo +
                "\nFecha de publicación : " + publicacion +
                "\nAutor : " + autor + apellido +
                "\nEditor : " + editor  +
                "\nNúmero de paginas : " + paginas +
                "\n-----------------------------------");
    }

}
