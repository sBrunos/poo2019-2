package pucrs.myflight.modelo;
import java.lang.Math;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VooEscalas extends Voo
{
    private ArrayList<Rota> rotas = new ArrayList();


    // Construtor
    public VooEscalas(LocalDateTime dh) {
        super(dh);
    }

    public void adicionarRota(Rota rota) {
        rotas.add(rota);
    }

    public Rota getRota(){ return rotas.get(0); }

    public ArrayList<Rota> getRotas() {
        return rotas;
    }

    public Duration getDuracao() {
      //  final int R = 6371;

        double oLat; double oLon;
        double dLat; double dLon;
      //  double distancia;
        Duration duracao = Duration.ofSeconds(0);

        for (Rota rota : rotas) {
            oLat= rota.getOrigem().getLocal().getLatitude();
            oLon= rota.getOrigem().getLocal().getLongitude();

            Geo geo = new Geo (oLat, oLon);

            double distancia =  geo.distanciaAtual(rota.getDestino().getLocal());

            duracao = duracao.plusSeconds( (long) ((distancia / 805) * 3600));
            duracao = duracao.plusMinutes(30);
        }

        return duracao;
    }

    public void setStatus(Status novo) {
        super.setStatus(novo);
    }

    @Override
    public String toString() {
        try {


            String retorno = "Rota: " + rotas.get(0) + " Data  e hora: " + super.getDataHora().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            if (rotas.size() > 1)
                for (int i = 1; i < rotas.size(); i++) {
                    retorno += "\n -> " + "Rota: " + rotas.get(i) + " Data  e hora: " + super.getDataHora().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                }

            return retorno + "\n Duracao: " + super.formatDuration(this.getDuracao());
        }
        catch (Exception e) {
            return "Houve um problema ao acessar as rotas. " ;
        }
    }
}
