package Models;

public class Registro {
    private String dni;
    private int temperatura;

    ///region Constructor

    public Registro(String dni, int temperatura) {
        this.dni = dni;
        this.temperatura = temperatura;
    }

    public Registro() {
    }
    ///endregion

    ///region Get and Set

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
    ///endregion

    ///region Metodos

    @Override
    public String toString() {
        return "Registro{" +
                "dni='" + dni + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }


    ///endregion
}
