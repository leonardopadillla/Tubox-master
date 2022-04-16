package sv.edu.catolica.workin;

public class Usuario {
    int id, RutinaPecho, RutinaAbdomen, RutinaPiernas,RutinaBrazo, RutinaTodoCuerpo;
    String Nombre, ColorFav, Password, Altura, Peso, Edad;

    public Usuario() {
    }

    public Usuario(int rutinaPecho, int rutinaAbdomen, int rutinaPiernas, int rutinaBrazo, int rutinaTodoCuerpo, String nombre, String colorFav, String password, String altura, String peso, String edad) {
        RutinaPecho = rutinaPecho;
        RutinaAbdomen = rutinaAbdomen;
        RutinaPiernas = rutinaPiernas;
        RutinaBrazo = rutinaBrazo;
        RutinaTodoCuerpo = rutinaTodoCuerpo;
        Nombre = nombre;
        ColorFav = colorFav;
        Password = password;
        Altura = altura;
        Peso = peso;
        Edad = edad;
    }

    public boolean isNull(){
        if(Nombre.equals("")&& ColorFav.equals("") &&Password.equals("") &&Altura.equals("")&&Peso.equals("")&&Edad.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", RutinaPecho=" + RutinaPecho +
                ", RutinaAbdomen=" + RutinaAbdomen +
                ", RutinaPiernas=" + RutinaPiernas +
                ", RutinaBrazo=" + RutinaBrazo +
                ", RutinaTodoCuerpo=" + RutinaTodoCuerpo +
                ", Nombre='" + Nombre + '\'' +
                ", ColorFav='" + ColorFav + '\'' +
                ", Password='" + Password + '\'' +
                ", Altura='" + Altura + '\'' +
                ", Peso='" + Peso + '\'' +
                ", Edad='" + Edad + '\'' +
                '}';
    }

    public int getRutinaPecho() {
        return RutinaPecho;
    }

    public void setRutinaPecho(int rutinaPecho) {
        RutinaPecho = rutinaPecho;
    }

    public int getRutinaAbdomen() {
        return RutinaAbdomen;
    }

    public void setRutinaAbdomen(int rutinaAbdomen) {
        RutinaAbdomen = rutinaAbdomen;
    }

    public int getRutinaPiernas() {
        return RutinaPiernas;
    }

    public void setRutinaPiernas(int rutinaPiernas) {
        RutinaPiernas = rutinaPiernas;
    }

    public int getRutinaBrazo() {
        return RutinaBrazo;
    }

    public void setRutinaBrazo(int rutinaBrazo) {
        RutinaBrazo = rutinaBrazo;
    }

    public int getRutinaTodoCuerpo() {
        return RutinaTodoCuerpo;
    }

    public void setRutinaTodoCuerpo(int rutinaTodoCuerpo) {
        RutinaTodoCuerpo = rutinaTodoCuerpo;
    }

    public String getAltura() {
        return Altura;
    }

    public void setAltura(String altura) {
        Altura = altura;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getColorFav() {
        return ColorFav;
    }

    public void setColorFav(String colorFav) {
        ColorFav = colorFav;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
