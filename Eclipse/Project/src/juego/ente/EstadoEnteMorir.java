package juego.ente;

import grafica.GraficoEnte;
import juego.Juego;

public class EstadoEnteMorir extends EstadoEnte {

	public void doAction(GraficoEnte g) {
		g.setVisible(false);
		g.repaint();
		Juego.getJuego().getInterfaz().getPanelMapa().remove(g);
		System.out.println("se murio un chabon");
	}
	
	@Override
	public boolean esMorir() {
		return true;
	}
}
