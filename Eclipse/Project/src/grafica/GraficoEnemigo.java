package grafica;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.ente.Celda;
import juego.ente.Enemigo;



public class GraficoEnemigo extends Grafico {
	
	private Enemigo enemigo;	
	private String [] archivos = {"e1", "e2"};
	
	public GraficoEnemigo (Enemigo e) {
		super(calcularX(e), calcularY(e));
		
		enemigo = e;

		this.image = new Icon[4];
<<<<<<< HEAD
		this.image[0] = new ImageIcon("C:/Users/guido/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/e5.gif"); //quieto
		this.image[1] = new ImageIcon("C:/Users/guido/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/e5.gif"); //en movimiento
=======
		this.image[0] = new ImageIcon(path + archivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(path + archivos[1] + ".gif"); //en movimiento
>>>>>>> c97a0f3bd529248bad62fe74a1c300753fd99822
		//this.image[2] = new ImageIcon("C:/Users/Franco/Documents/e2.gif"); //atacando
		//this.image[3] = new ImageIcon("C:/Users/Franco/Documents/e2.gif"); //muriendo
	
		initGrafico();
		
	}
	
	private static int calcularX (Enemigo e) {
		return e.getCelda().columna * 100;
	}
	
	private static int calcularY (Enemigo e) {
		return e.getCelda().fila * 100;
	}
	
	public void mover () {
		Celda izq = enemigo.getCelda().getIzq();
		if (izq != null && izq.getEnte() != null) {
			int velocidad = enemigo.getVelocidad();
			int delta = 100 / velocidad;
			pos.setLocation(pos.x - delta, pos.y);
			cambiarGrafico(1);
		} else
			cambiarGrafico(0);
	}
	
}