public class Rota {
    private CiaAerea cia;
    private Aeroporto origem;
    private Aeroporto destino;
    private Aeronave aeronave;

    public Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
        this.cia = cia;
        this.origem = origem;
        this.destino = destino;
        this.aeronave = aeronave;
    }

    public CiaAerea getCia() {
        return cia;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public double calculaDistancia() {

        //raio Terra
        double raioTerra = 6371;

        //converte para radianos as coordenadas dos aeroportos de origem e destino
        double latitudeRadOrigem = Math.toRadians(origem.getLocal().getLatitude());
        double longitudeRadOrigem = Math.toRadians(origem.getLocal().getLongitude());
        double latitudeRadDestino = Math.toRadians(destino.getLocal().getLatitude());
        double longitudeRadDestino = Math.toRadians(destino.getLocal().getLongitude());

        //calcula senos e cossenos
        double senoLatitudes = Math.sin((latitudeRadOrigem-latitudeRadDestino)*1.0)/2;
        double senoLongitudes = Math.sin((longitudeRadOrigem-longitudeRadDestino)*1.0)/2;
        double cossenoLatOrigem = Math.cos(latitudeRadOrigem);
        double cossenoLatDestino = Math.cos(latitudeRadDestino);

        //calcula a parte interna da raiz da fórmula de haversine
        double raiz = senoLatitudes*senoLatitudes + senoLongitudes*senoLongitudes*cossenoLatOrigem*cossenoLatDestino;

        //calcula a distância
        double distancia = 2*raioTerra*Math.asin(Math.sqrt(raiz));

    return distancia;
    }

    public double getDuracao(){
        //distancia em km
        double distancia = calculaDistancia();

        //velocidade do aviao em Km/h
        double velocidade = 805.1;

        //tempo em horas
        double duracaoHoras = distancia*1.0/velocidade;

        return duracaoHoras;
    }

    public String toString(){
        return "\nCiaAérea: " + cia + " - " + aeronave + "\nOrigem: " + origem + "Destino: " + destino;
    }
}
