package tmp;

public class ContadorTiempo extends Thread {

	private Juego juego;

	ContadorTiempo(Juego j) {
		juego = j;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.mover();
		}
	}
}