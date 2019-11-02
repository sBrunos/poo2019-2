package pucrs.myflight.modelo;

public class GerenciadorAeroportos {

   public void ordenarNomes() {
     Collections.sort(aeroportos);
   }


    public ArrayList<Aeroporto> listarTodos() {
        return new ArrayList<>(aeroportos.values());
    }

    public Aeroporto buscarCodigo(String codigo) {
        return aeroportos.get(codigo);
    }

    public ArrayList<Aeroporto> listarTodosDeUmPais(ArrayList<Rota> rotas) {

        ArrayList<Aeroporto> listaDeAero = new ArrayList<>();

        for (Rota r : rotas) {
            if (r.getOrigem().getPais().equals(r.getDestino().getPais())) {
                if (!listaDeAero.contains(r.getOrigem()) && !listaDeAero.contains(r.getDestino())) { //Adiciona aeroportos
                    listaDeAero.add(r.getOrigem());
                    listaDeAero.add(r.getDestino());
                } else if ((listaDeAero.contains(r.getOrigem()) && !listaDeAero.contains(r.getDestino()))) { //Adiciona destino
                    listaDeAero.add(r.getDestino());
                } else if (!(listaDeAero.contains(r.getOrigem())) && listaDeAero.contains(r.getDestino())) { //Adiciona origem
                    listaDeAero.add(r.getOrigem());
                }
            }
        }
        return listaDeAero;
    }

    public ArrayList<Aeroporto> listarTodosOrdenado() {
        ArrayList<Aeroporto> list = new ArrayList<>(aeroportos.values());
        list.sort(Comparator.comparing(Aeroporto::getCodigo));
        return list;
    }

}
