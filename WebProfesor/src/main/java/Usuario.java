import processing.core.PApplet;

public class Usuario {
	
	PApplet app;
	
	public Usuario(PApplet app) {
		
		this.app = app;
		
	}
	
	
	
	public void pintar() {
		setFont();
	}



	public void mouse() {
		// TODO Auto-generated method stub
		
	}
	
	public void setFont() {
		//app.textFont(app.createFont("Roboto-Regular.tff", 160));
		app.textSize(24);
		app.fill(0);
	}

}