package juego;

import juego.acciones.AccionSobreMapa;
import juego.acciones.AccionMonetaria;
import juego.acciones.AccionSobreAliado;

public class Mercado {

	private AccionSobreAliado accionSobreAliado;
	private AccionSobreMapa accionSobreMapa;
	private int monedas;
	
	public Mercado (int monedasInicials) {
		monedas = monedasInicials;
	}
	
	public int getMonedas () {
		return monedas;
	}
	
	public void agregarMonedas (int m) {
		if(m < 0)
			quitarMonedas(-m);
		else {
			monedas += m;
			Juego.getJuego().getInterfaz().getPanelTienda().setMonedas(monedas);
		}
	}
	
	public void quitarMonedas (int m) {
		if(m < 0)
			agregarMonedas(-m);
		else {
			monedas -= m;
			Juego.getJuego().getInterfaz().getPanelTienda().setMonedas(monedas);
		}
	}

	public void addAccionSobreAliado(AccionSobreAliado a) {
		if (a.getPrecio()<=monedas) {
			accionSobreAliado = a;
		}
	}
	
	public boolean isAccionSobreAliado () {
		return accionSobreAliado != null;
	}
	
	public AccionSobreAliado getAccionSobreAliado () {
		AccionSobreAliado a = accionSobreAliado;
		accionSobreAliado = null;
		return a;
	}

	public void addAccionSobreMapa(AccionSobreMapa a) {
		if (a.getPrecio()<monedas) {
			accionSobreMapa = a;
		}
	}
	
	public boolean isAccionSobreMapa () {
		return accionSobreMapa != null;
	}
	
	public AccionSobreMapa getAccionSobreMapa () {
		AccionSobreMapa a = accionSobreMapa;
		accionSobreMapa = null;
		return a;
	}
	
}
