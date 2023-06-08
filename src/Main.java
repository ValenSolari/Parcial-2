import Enums.Eclaves;
import Models.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.Period;
import java.util.*;

///////////////////////// Valentin Solari///// Valentin Solari
///////////////////////// Valentin Solari///// Valentin Solari
///////////////////////// Valentin Solari///// Valentin Solari

public class Main {
    public static void main(String[] args) {
        int docis = 30;

        Hospital hospital = new Hospital();

        Person a = new Person("Paciente Cero","Gonzales",23,"Bajo flores","44859000","desocupado",null);
        Person b = new Person("Paciente uno ","Gonzales",24,"La boca","44859999","desocupado",null);
        Person c = new Person("Paciente dos ","Gonzales",25,"Palermo","03545842","desocupado",null);
        Person d = new Person("Paciente tres ","Gonzales",26,"Apache","78945623","desocupado",null);
        Person e = new Person("Paciente cuatro ","Gonzales",27,"CABA","12345698","desocupado",null);
        Person f = new Person("Paciente cinco ","Gonzales",28,"CBA","324523565","desocupado",null);
        Person g = new Person("Paciente seis ","Gonzales",29,"Santa Fe","7894355422","desocupado",null);


        docis=hospital.atender(a, docis);
        docis=hospital.atender(b, docis);
        docis=hospital.atender(c,docis);
        docis=hospital.atender(d,docis);
        docis=hospital.atender(e,docis);
        docis=hospital.atender(f,docis);
        docis=hospital.atender(g,docis);



        System.out.println(hospital);
        System.out.println(docis);

        Map tabla = hospital.testear();

        System.out.println(tabla);

        hospital.aislar(tabla);



        Map<Eclaves, List<ClaseGenerica>> exportar = new HashMap<>();

        exportar.put(Eclaves.sanos,hospital.pacientesSanos(tabla));

        List<Person> pacientesEnfermos = hospital.pacientesEnfermos(tabla);

        exportar.put(Eclaves.aislar,pasarClase(pacientesEnfermos,tabla));



        jsonEscribir(exportar);




    }

    public static void jsonEscribir (Map mapa){
        File file = new File("Mapa.json");
        ObjectMapper mapper = new ObjectMapper();

        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(file,mapa);
        }catch (IOException ex){
            System.out.println("no se puedo escribir el json");
        }

    }

    public static List pasarClase (List<Person> pacientesEnfermos, Map tabla){
        List<Aislados> enfermos = new ArrayList<>();
        for (Person x : pacientesEnfermos){
            Registro reg = (Registro) tabla.get(x.getKits());
            enfermos.add(new Aislados(x.getKits(),x.getDni(),reg.getTemperatura()));
        }
        return enfermos;
    }


}