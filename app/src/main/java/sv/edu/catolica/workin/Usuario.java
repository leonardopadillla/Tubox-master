package sv.edu.catolica.workin;

public class Usuario {
    int id, RutinaPecho, RutinaAbdomen, RutinaPiernas,RutinaBrazo, RutinaTodoCuerpo;
    String Nombre, Personalizada, Password, Altura, Peso, Edad, Resultado, Colorfav;

    public Usuario() {
    }

    public Usuario(int rutinaPecho, int rutinaAbdomen, int rutinaPiernas, int rutinaBrazo, int rutinaTodoCuerpo, String nombre, String personalizada, String password, String altura, String peso, String edad, String resultado, String colorfav) {
        RutinaPecho = rutinaPecho;
        RutinaAbdomen = rutinaAbdomen;
        RutinaPiernas = rutinaPiernas;
        RutinaBrazo = rutinaBrazo;
        RutinaTodoCuerpo = rutinaTodoCuerpo;
        Colorfav = colorfav;
        Nombre = nombre;
        Personalizada = personalizada;
        Password = password;
        Altura = altura;
        Peso = peso;
        Edad = edad;
        Resultado = resultado;
    }

    public boolean isNull(){
        if(Nombre.equals("")&& Personalizada.equals("") &&Password.equals("") &&Altura.equals("")&&Peso.equals("")&&Edad.equals("")&&Resultado.equals("")&&Colorfav.equals("")){
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
                ", Colorfav='" + Colorfav + '\'' +
                ", Personalizada='" + Personalizada + '\'' +
                ", Password='" + Password + '\'' +
                ", Altura='" + Altura + '\'' +
                ", Peso='" + Peso + '\'' +
                ", Edad='" + Edad + '\'' +
                ", Resultado='" + Resultado + '\'' +
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


    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String resultado) {
        Resultado = resultado;
    }


    public String getColorfav() {
        return Colorfav;
    }

    public void setColorfav(String colorfav) {
        Colorfav = colorfav;
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

    public String getPersonalizada() {
        return Personalizada;
    }

    public void setPersonalizada(String personalizada) {
        Personalizada = personalizada;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
