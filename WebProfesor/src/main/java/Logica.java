import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	
	PImage rect; 
	PImage rect2;
	PImage rect1;
	PImage logo;
	PImage cale;
	PImage estu;
	PImage homeIcono;
	PImage lupa;
	PImage bus;
	
	private PApplet app;
	private int pantalla;
	private Calendario calendario;
	private Usuario usuario;
	private Home home;

	public Logica(PApplet app) {
		this.app = app;
		pantalla = 1;
		
		iniVariables();
		
		home = new Home(app, this);
		calendario = new Calendario(app, this);
		usuario = new Usuario(app);
		
	}
	
	public void pintar() {
		
		switch (pantalla) {
		case 0:// pantalla de carga
			// insertar gif
			break;
		case 1:
			
			pintarNavegacion();
			
			home.pintar();
			
			break;
		case 2:
			
			pintarNavegacion();
			
			calendario.pintar();
			
			break;
		case 3:
			usuario.pintar();;
			break;
		}
	}
	
	
	public void mouse() {
		
		switch (pantalla) {
		case 0:

			break;
		case 1:
			home.mouse();
			break;
		case 2:
			calendario.mouse();
			break;
		case 3:
			usuario.mouse();
			break;
		}	
	}
	
	
	public void pintarNavegacion() {
		app.imageMode(app.CORNER);
		app.image(rect,112,19);
		app.image(bus, 630, 36);
		app.image(lupa,923 ,44 );
		app.image(estu,1086 ,32 );
		app.image(rect2,0 ,0 );
		if(pantalla == 1) {
			app.image(rect1,8 ,124 );
			
		}
		
		if(pantalla == 2) {
			app.image(rect1,8 ,230 );
			
		}
		app.image(logo,26 ,19 );
		app.image(homeIcono,32 ,151);
		app.image(cale, 32, 258);
		
		
		
	}
	public void iniVariables() {
		rect = app.loadImage("Rectangle.png");
		rect2 = app.loadImage("Rectangle1.png");
		bus = app.loadImage("bus.png");
		logo = app.loadImage("Frame.png");
		homeIcono = app.loadImage("home.png");
		cale = app.loadImage("cal.png");
		estu = app.loadImage("estu.png");
		lupa = app.loadImage("Group 3.png");
		rect1 = app.loadImage("Rectangle-1.png");
	
	}

	public int getPantalla() {
		return pantalla;
	}

	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}
	
	
	
}
