package loquequieras;

public class Celda {
	private int fila, columna;
	private EfectoCelda efecto;
	private Ente ente;
	private Celda anterior, siguiente;
	
	public Celda getAnterior() {
		return anterior;
	}
	
	public Celda getSiguiente() {
		return siguiente;
	}
	
	public void setAnterior(Celda c) {
		anterior = c;
	}
	
	public void setSiguiente(Celda c) {
		siguiente = c;
	}
	
	public Ente getEnte() {
		return ente;
	}
	
	public EfectoCelda getEfecto() {
		return efecto;
	}
	
	public void setEnte(Ente e) {
		ente = e;
	}
}
