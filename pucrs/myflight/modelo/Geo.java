package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}


	//Método que calcula a distância entre dois pontos com a fórmula de haversine
	public static double distancia(Geo ponto1, Geo ponto2){

		int raioTerra = 6371;

		double latitude1 = ponto1.getLatitude();
		double latitude2 = ponto2.getLatitude();

		double longitude1 = ponto1.getLongitude();
		double longitude2 = ponto2.getLongitude();

		double latDistancia = toRad(latitude2-latitude1);
		double lonDistancia = toRad(longitude2-longitude1);

		double a = Math.sin(latDistancia / 2) * Math.sin(latDistancia / 2) + 
				   Math.cos(toRad(latitude1)) * Math.cos(toRad(latitude2)) * 
				   Math.sin(lonDistancia / 2) * Math.sin(lonDistancia / 2);


		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distancia= raioTerra * c;

		return distancia;
	}

	public double distanciaAtual(Geo ponto){
		Geo atual = new Geo(latitude, longitude);
		return distancia(atual, ponto);
	}

	public static double toRad(double valor){
		return valor * Math.PI / 180;
	}

	@Override
	public String toString() {
		return "Latitude: "+ latitude + " Longitude: " + longitude;
	}
}
