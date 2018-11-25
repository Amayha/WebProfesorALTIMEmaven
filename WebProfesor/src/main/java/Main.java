import java.io.FileInputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import processing.core.PApplet;
import processing.core.PFont;

public class Main extends PApplet {

	private Logica log;
	PFont font;

	public static void main(String[] args) {
	
		PApplet.main("Main");
	}

	public void settings() {
		size(1200, 700);

	}

	public void setup() {
		log = new Logica(this);
		//font = createFont("Roboto-Bold.ttf", 32);
		//textFont(font);
	}
	
	public void draw() {
		background(255);
		log.pintar();
	}

	public void mousePressed() {
		log.mouse();
	}

}