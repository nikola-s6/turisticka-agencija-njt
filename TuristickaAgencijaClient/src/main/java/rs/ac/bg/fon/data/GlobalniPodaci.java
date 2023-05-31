package rs.ac.bg.fon.data;

import rs.ac.bg.fon.data.type.TipoviPodataka;

import java.util.HashMap;
import java.util.Map;

public class GlobalniPodaci {

    private Map<TipoviPodataka, Object> podaci;
    private static GlobalniPodaci instance;

    private GlobalniPodaci() {
        podaci = new HashMap<>();
    }

    public static GlobalniPodaci getInstance(){
        if(instance == null){
            instance = new GlobalniPodaci();
        }
        return instance;
    }

    public void add(TipoviPodataka tp, Object param){
        podaci.put(tp, param);
    }

    public Object get(TipoviPodataka tp){
        return podaci.get(tp);
    }

    public void reset(){
        podaci.clear();
    }
}