package Models;

import Excepciones.CustomException;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Hospital {
    private Set<Person> pacientes;

    ///region Constructor

    public Hospital(Set<Person> pacientes) {
        this.pacientes = pacientes;
    }

    public Hospital() {
        this.pacientes = new LinkedHashSet<>();
    }
    ///endregion

    ///region Get and Set

    public Set<Person> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Person> pacientes) {
        this.pacientes = pacientes;
    }


    ///endregion

    ///region Metodos

    @Override
    public String toString() {
        return "Hospital{" +
                "pacientes=" + pacientes +
                '}';
    }

    public int atender (Person a, int test){

        int flag=0;

        for (Person x : pacientes){
            if (a.equals(x)==true){
                flag=1;
            }
        }
        Random random = new Random();

        if (flag==1){
            System.out.println("Error el paciente ya esta cargado");
        }else{
            try{
                if (test>= 1){
                    a.setKits(random.nextInt(0,300));
                    pacientes.add(a);
                    test--;

                }else{
                    throw new CustomException("Error de kits");
                }
            }catch (CustomException ex){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Se termiraron los test\n Ingrese Kits restantes...->");
                int aux=scanner.nextInt();

                if (aux>0){
                    a.setKits(random.nextInt(0,300));
                    pacientes.add(a);
                    test=aux--;

                }
            }
        }
        return test;
    } ////Metodo de ejercicio 1

    public Map testear (){
        Random random  = new Random();
        Map<Integer, Registro> map = new HashMap<>();

        for (Person x : pacientes){
            Registro reg = new Registro(x.getDni(), random.nextInt(36,39));
            map.put(x.getKits(),reg);
        }
        return map;
    } ///Metodo de ejercicio 2

    public void aislar (Map tabla){
        List<String> barrios=new ArrayList<>();
        List<Integer> kits = new ArrayList<>();

        File file = new File("urgente.dat");


        for (Person x : pacientes){

            Registro reg = (Registro) tabla.get(x.getKits());

            if (reg.getTemperatura()>= 38){
                try{
                    throw new CustomException("Posible enfermo, temperatura alta");

                }catch (CustomException ex){
                    barrios.add(x.getBarrio());                                     ///Cargar en el array los barrios
                    kits.add(x.getKits());                                          ///Carga en el array las temperaturas
                }
            }
        }
        try{
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
             buffer.write(barrios.toString());                                      ///Escribe en el archivo los barrios
             buffer.write(kits.toString());                                         ///Escribe en el archivo las temperaturas
            buffer.close();

        }catch (IOException e){
            System.out.println("error al escribir");
        }
    } /// Metodo de ejercicio 3

    public List pacientesSanos (Map table) {
        List<Person> sanos = new ArrayList<>();
        for (Person x : pacientes) {

            Registro reg = (Registro) table.get(x.getKits());

            if (reg.getTemperatura() < 38) {
                sanos.add(x);
            }
        }
        return sanos;
    } //// Metodo de ejericio 4

    public List pacientesEnfermos (Map table){
        List<Person> enfermos = new ArrayList<>();
        for (Person x : pacientes) {

            Registro reg = (Registro) table.get(x.getKits());

            if (reg.getTemperatura() >= 38) {
                enfermos.add(x);
            }
        }
        return enfermos;
    } //// Metodo de ejercicio 5






    ///endregion
}
