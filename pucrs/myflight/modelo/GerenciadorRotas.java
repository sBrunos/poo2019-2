package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GerenciadorRotas {

    private ArrayList<Rota> listaRotas;

    public GerenciadorRotas() {
        listaRotas = new ArrayList<>();
    }

    public void adicionar(Rota r) {
        listaRotas.add(r);
    }

    public void ordenaRotas(){
        Collections.sort(listaRotas);
    }

    public void ordenaCia() {
        try{
            listaRotas.sort((Rota r1, Rota r2) -> r1.getCia().getNome().compareTo(r2.getCia().getNome()));
        }catch (Exception e){
            System.out.print(e);
        }

    }

    public void ordenaOrigem() {
        listaRotas.sort((Rota r1, Rota r2) -> r1.getOrigem().getNome().compareTo(r2.getOrigem().getNome()));
    }

    public void ordenaOrigemCia() {
        listaRotas.sort(Comparator.comparing((Rota r) -> r.getOrigem().getNome()).
                thenComparing(r -> r.getCia().getNome()));
    }


    public String toString(){
        String ret = " ";

        System.out.println( "\n TAMANHO: \n"  );
        for(int i = 0; i < listaRotas.size(); i++){
            ret += listaRotas.get(i) +  "\n";
        }
        return ret;
    }
}



