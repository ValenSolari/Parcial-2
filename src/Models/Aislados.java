package Models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
///Clase utilizada para el ejercicio que se tiene que utilizar el json, este lo permite pasar de forma mas ordenada
public class Aislados {
    private Integer kit;
    private String dni;
    private int temperatura;

    ///region Constructor

    public Aislados(Integer kit, String dni, int temperatura) {
        this.kit = kit;
        this.dni = dni;
        this.temperatura = temperatura;
    }

    public Aislados() {
    }
    ///endregion

    ///region Get and Set

    public Integer getKit() {
        return kit;
    }

    public void setKit(Integer kit) {
        this.kit = kit;
    }

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
        return "Aislados{" +
                "kit=" + kit +
                ", dni='" + dni + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }



    ///endregion
}
