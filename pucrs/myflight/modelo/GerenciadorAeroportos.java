package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {

    private ArrayList<Aeroporto> listaAeroportos;

   public void ordenarNomes() {
     Collections.sort(listaAeroportos);
   }
}
