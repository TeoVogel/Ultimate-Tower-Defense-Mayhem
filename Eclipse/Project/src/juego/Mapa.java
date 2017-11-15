package juego;

import java.util.ArrayList;
import java.util.List;

import grafica.PanelMapa;
import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Obstaculo;

public class Mapa{

	
	private Celda[][] grilla;
	private List<Enemigo> enemigos;
	private List<Aliado> aliados;
	private List<Celda> celdas;
	private PanelMapa panelMapa;
	
	public Mapa (PanelMapa p) {
		enemigos = new ArrayList<Enemigo>();
		aliados = new ArrayList<Aliado>();
		celdas = new ArrayList<Celda>();
		panelMapa = p;
		inicializarGrilla();
	}
	
	
	// Crea grilla y setea todas las celdas con anterior y siguiente
	protected void inicializarGrilla() {
		grilla = new Celda[6][10];
		for (int i = 0; i < 6; i++)
			for (int ii = 0; ii < 10; ii++)
				grilla[i][ii] = new Celda(i, ii);
		
		for (int i = 0; i < 6; i++)
			grilla[i][0].setDer(grilla[i][1]);
		
		for (int i = 0; i < 6; i++)
			grilla[i][9].setIzq(grilla[i][8]);
			
		for (int i = 0; i < 6; i++)
			for (int ii = 1; ii < 9; ii++) {
				grilla[i][ii].setDer(grilla[i][ii+1]);
				grilla[i][ii].setIzq(grilla[i][ii-1]);
			}
	}
	
	public List<Enemigo> getEnemigos () {
		return enemigos;
	}
	
	public void addEnemigo (Enemigo e, int fila, int columna) {
		Celda c = grilla[fila][columna];
		if( c.getEnte() == null ){
			enemigos.add(e);
			panelMapa.addEnte(e);
			e.init(c);
		}
	}

<<<<<<< HEAD
	public void addAliado (Aliado a, Celda c) {
		aliados.add(a);
		panelMapa.addEnte(a);
		a.init(c);
=======
	public void addAliado (Aliado a, int fila, int columna) {
		Celda c = grilla[fila][columna];
		if( c.getEnte() == null ){
			aliados.add(a);
			panelMapa.addEnte(a);
			a.init(c);
		}
>>>>>>> f6f2d355f69c12985340b09f2c3cbe4713290c17
	}

	public void addObstaculo (Obstaculo o, int fila, int columna) {
		Celda c = grilla[fila][columna];
		if( c.getEnte() == null ){
			panelMapa.addEnte(o);
			o.init(c);
		}
	}
	
	public void mover() {
		List<Integer> enemigosMuertos = new ArrayList<Integer>();
		for (int i=0; i<enemigos.size(); i++) {
			Enemigo e = enemigos.get(i);
			if (e.getVida() <= 0) {
				//juego.sumarPuntos(e.getPuntos());
				enemigosMuertos.add(i);
			}
			e.mover();
		}
		/*for (Integer i : enemigosMuertos) {
			enemigos.remove((int) i);
			System.out.println("Removido");
		}*/
	}
	
	public void atacar () {
		List<Integer> aliadosMuertos = new ArrayList<Integer>();
		for (int i=0; i<aliados.size(); i++) {
			Aliado a = aliados.get(i);
			if (a.getVida() <= 0) 
				aliadosMuertos.add(i);
			else{ 
				a.atacar();
				a.actualizarPowerUp();
			}
		}
		for (Integer i : aliadosMuertos) {
			aliados.remove((int) i);
		}

		List<Integer> enemigosMuertos = new ArrayList<Integer>();
		for (int i=0; i<enemigos.size(); i++) {
			Enemigo e = enemigos.get(i);
			if (e.getVida() <= 0) 
				enemigosMuertos.add(i);
			else {
				e.atacar();
				e.actualizarPowerUp();
			}
		}
		for (Integer i : enemigosMuertos) {
			Juego.getJuego().getMercado().agregarMonedas(enemigos.get(i).getMonedas());
			enemigos.remove((int) i);
		}
	}
	
	public void actualizarEfectos(){
		List<Integer> efectosTerminados = new ArrayList<Integer>();
		for (int i=0; i<celdas.size(); i++) {
			Celda c= celdas.get(i);
			if(c.actualizarEfecto())
				efectosTerminados.add(i);
		}
		for(Integer i: efectosTerminados){
			celdas.remove((int) i);
		}
	}
	
	
	// TODO: elimnar esto, es solo para testear
	public Celda getCelda(int f, int c) {
		return grilla[f][c];
	}
	
}