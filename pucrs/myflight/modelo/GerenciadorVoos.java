package pucrs.myflight.modelo;
import java.util.ArrayList;
import java.util.Comparator;

public class GerenciadorVoos {

    private ArrayList<Voo> voos;

    public GerenciadorVoos() {

        this.voos = new ArrayList<>();

    }

    public void ordenarDataHora() {

        voos.sort(Comparator.comparing(Voo::getDataHora));
    }

    public void ordenaDataHoraDuracao() {

        voos.sort(Comparator.comparing(Voo::getDataHora).thenComparing(Voo::getDuracao));
    }


    public void inserirVoo(Voo voos) {

        this.voos.add(voos);

    }

    public String toString(){
        String voo = " ";

        System.out.println( "\n Ordenação duração: \n"  );
        for(int i = 0; i < voos.size(); i++){
            voo += voos.get(i) +  "\n";
        }
        return voo + "\n Duracao: " + super.toString();
    }
}
