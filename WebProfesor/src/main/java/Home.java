import processing.core.PApplet;
import processing.core.PImage;

public class Home {
	Logica log;
	
	PApplet app;
	PImage rectM1;
	PImage rectM2;
	PImage rectM3;
	PImage rectM4;
	PImage rectM5;
	
	public Home(PApplet app, Logica log) {
		
		this.app = app;
		iniVariables();
		this.log = log;
	}
	
	
	public void pintar() {
		setFont();
		//pintarNavegacion();
		pintarMenu();
	}


	public void mouse() {
		// condicion para el boton de calendario 
		if(app.mouseX >=32 && app.mouseX <= 64 && app.mouseY >= 258 && app.mouseY <= 287) {
			log.setPantalla(2);
		}
		
	}
	
	
	public void setFont() {
		//app.textFont(app.createFont("Roboto-Regular.tff", 160));
		app.textSize(24);
		app.fill(0);
	}
	
	public void iniVariables() {
		rectM1 = app.loadImage("RectangleMenu1.png");
		rectM2 = app.loadImage("RectangleMenu2.png");
		rectM3 = app.loadImage("RectangleMenu3.png");
		rectM4 = app.loadImage("RectangleMenu4.png");
		rectM5 = app.loadImage("RectangleMenu5.png");
	}
	
	
	
	public void pintarMenu() {
		
		app.image(rectM1,190,124);
		app.image(rectM3,190,335);
		app.image(rectM2,497,335);
		app.image(rectM4,497,124);
		app.image(rectM5,804,124);
		
		
	}

}

