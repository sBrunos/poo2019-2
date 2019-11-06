package pucrs.myflight.modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
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

    public void inserirVoo(Voo voos){

        this.voos.add(voos);
    }

    @Override
    public String toString() {
        return this.voos.toString();
    }
}



/*import java.util.ArrayList;
import java.time.LocalDate;

public class GerenciadorVoos
{
   private ArrayList<Voo> cadastroVoos;
   
   public GerenciadorVoos(){
   cadastroVoos = new ArrayList<Voo>(); 
    }
    
    public void adicionar (Voo voo){
    cadastroVoos.add (voo);
    }
    
    public ArrayList<Voo> listarTodos(){
    return cadastroVoos;
    }
    
}
*/

