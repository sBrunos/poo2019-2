import java.util.ArrayList;
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


