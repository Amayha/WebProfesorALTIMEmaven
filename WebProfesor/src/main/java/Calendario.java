import java.io.FileInputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import processing.core.PApplet;
import processing.core.PImage;

public class Calendario {

	// Prueba
	
	PApplet app;
	Logica log;
	PImage rectC;
	PImage add;
	PImage mes;
	PImage aviso;
	PImage aviso2;
	PImage aviso11;
	PImage aviso12;
	PImage aviso13;
	PImage mes2;
	PImage mes16;
	PImage mes20;
	PImage evento;
	PImage fondoGris;
	PImage fondoFijo;
	Boolean diaSeleccionado;
	Boolean oprimirAgregar;
	Boolean espacioConsulta;
	Boolean reservaEspacio;
	Boolean cancelacion;
	Boolean siguiente;
	Boolean cancelar;
	Boolean guardar;
	int pantalla;
	Noticia n16;
	Noticia n20;
	int contadorEventos = 0;

	FirebaseDatabase db;
	DatabaseReference referencia;
	FileInputStream serviceAccount;

	public Calendario(PApplet app, Logica log) {

		this.app = app;
		iniVariables();
		this.log = log;
		diaSeleccionado = false;
		oprimirAgregar = false;
		espacioConsulta = false;
		reservaEspacio = false;
		cancelacion = false;
		siguiente = false;
		cancelar = false;
		guardar = false;
		pantalla = 1;

		n16 = new Noticia();
		n16.setDiasemana("LUN");
		n16.setNumerodia("16");
		n16.setIdnoticia("88888");
		n16.setTexto("");
		n16.setTiponoticia("1");

		n20 = new Noticia();
		n20.setDiasemana("VIE");
		n20.setNumerodia("20");
		n20.setIdnoticia("99999");
		n20.setTexto("");
		n20.setTiponoticia("1");

		try {
			serviceAccount = new FileInputStream("altime-c395e-firebase-adminsdk-k12xi-56b27b28a8.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://altime-c395e.firebaseio.com/").build();

			FirebaseApp.initializeApp(options);

			// paso 1 para vincular la base de datos
			db = FirebaseDatabase.getInstance();
			// paso 2 crear la consulta a la base de datos
			referencia = db.getReference().child("noticias");// cambiar referencia

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pintar() {
		setFont();
		pintarCalen();

	}

	private void pintarCalen() {

		switch (pantalla) {
		case 1:
			pantalla1();
			break;

		case 2:
			pantalla2();
			break;

		case 3:
			pantalla3();
			break;

		case 4:
			pantalla4();
			break;

		case 5:
			pantalla5();
			break;
		case 6:
			pantalla6();
			break;
		case 7:
			pantalla7();
			break;
		case 8:
			pantalla8();
			break;
		case 9:
			pantalla9();
			break;

		}
	}

	public void pantalla1() {
		app.image(rectC, 112, 121);
		app.image(add, 157, 27);
		app.image(mes, 401, 121);
		System.out.println("Pantalla 1");
	}

	public void pantalla2() {
		// paso uno : seleccionar el dia
		if (diaSeleccionado == true) {
			app.image(rectC, 112, 121);
			app.image(add, 157, 27);
			
			if(contadorEventos == 16) {
				app.image(mes16, 401, 121);
			}
			
			if(contadorEventos == 20) {
				app.image(mes20, 401, 121);
			}
			
		}
		System.out.println("Pantalla 2");
	}

	public void pantalla3() {
		app.image(rectC, 112, 121);
		app.image(add, 157, 27);
		app.image(mes20, 401, 121);

		// paso 2 oprimir agregar a ese dia
		// sin ninguna seleccion
		if (diaSeleccionado == true && oprimirAgregar == true) {
			app.image(fondoGris, 86, 0);
			app.image(aviso, 408, 240);
		}
		System.out.println("Pantalla 3");
	}

	public void pantalla4() {
		// Se debe pintar la imagen del calendario con la seleccion del menu
		// espacio de consulta en resaltado.
		app.image(rectC, 112, 121);
		app.image(add, 157, 27);
		if(contadorEventos == 16) {
			app.image(mes16, 401, 121);
		}
		
		if(contadorEventos == 20) {
			app.image(mes20, 401, 121);
		}
		if (diaSeleccionado == true && oprimirAgregar == true) {
			app.image(fondoGris, 86, 0);
			
			app.image(aviso11, 408, 240);
		}
		System.out.println("Pantalla 4");
	}

	public void pantalla5() {
		// Se debe pintar la imagen del calendario con la seleccion del menu
		// reserva de espacio en resaltado.
		app.image(rectC, 112, 121);
		app.image(add, 157, 27);
		if(contadorEventos == 16) {
			app.image(mes16, 401, 121);
		}
		
		if(contadorEventos == 20) {
			app.image(mes20, 401, 121);
		}
		if (diaSeleccionado == true && oprimirAgregar == true) {
			app.image(fondoGris, 86, 0);
			// cambiar la imagen de aviso
			app.image(aviso12, 408, 240);
		}
		System.out.println("Pantalla 5");
	}

	public void pantalla6() {
		// Se debe pintar la imagen del calendario con la seleccion del menu
		// cancelar clase en resaltado.
		app.image(rectC, 112, 121);
		app.image(add, 157, 27);
		if(contadorEventos == 16) {
			app.image(mes16, 401, 121);
		}
		
		if(contadorEventos == 20) {
			app.image(mes20, 401, 121);
		}
		if (diaSeleccionado == true && oprimirAgregar == true) {
			app.image(fondoGris, 86, 0);
		
			app.image(aviso13, 408, 240);
		}
		System.out.println("Pantalla 6");
	}

	public void pantalla7() {
		app.image(rectC, 112, 121);
		app.image(add, 157, 27);
		app.image(mes2, 401, 121);
		if (diaSeleccionado == true && oprimirAgregar == true) {
			app.image(fondoGris, 86, 0);
			app.image(aviso2, 408, 240);
		}
		System.out.println("Pantalla 7");
	}

	public void pantalla8() {
		if (guardar == true) {
			// app.image(fondoFijo, 0, 0);
			app.image(rectC, 112, 121);
			app.image(add, 157, 27);
			app.image(mes2, 401, 121);
			app.image(evento, 112, 251);

		}
		System.out.println("Pantalla 8");
	}

	public void pantalla9() {

	}

	public void mouse() {
		switch (pantalla) {
		case 1:
			mousePantalla1();
			break;

		case 2:
			mousePantalla2();
			break;

		case 3:
			mousePantalla3();
			break;
		case 4:
			mousePantalla4();
			break;
		case 5:
			mousePantalla5();
			break;
		case 6:
			mousePantalla6();
			break;

		case 7:
			mousePantalla7();
			break;
			
		case 8:
			mousePantalla8();
			break;

		}

		// condicion para el boton de home
		// Debe estar en todas las pantallas
		if (app.mouseX >= 27 && app.mouseX <= 57 && app.mouseY >= 147 && app.mouseY <= 173) {
			log.setPantalla(1);
		}

	}

	private void mousePantalla1() {
		// condicion para el dia
		if (app.mouseX >= 510 && app.mouseX <= 619 && app.mouseY >= 316 && app.mouseY <= 415) {
			diaSeleccionado = true;
			pantalla = 2;
			contadorEventos = 16;
			System.out.println("Pantalla 1 diaSeleccionado 16");
		}

		// cambiar cordenadas
		if (app.mouseX >= 941 && app.mouseX <= 1050 && app.mouseY >= 316 && app.mouseY <= 415) {
			diaSeleccionado = true;
			pantalla = 2;
			contadorEventos = 20;
			System.out.println("Pantalla 1 diaSeleccionado 20");
		}

	}

	private void mousePantalla2() {
		// condicion para el boton de agregar
		if (app.mouseX >= 157 && app.mouseX <= 219 && app.mouseY >= 31 && app.mouseY <= 93) {
			oprimirAgregar = true;
			pantalla = 3;
			System.out.println("Pantalla 2 oprimirAgregar");
		}
	}

	private void mousePantalla3() {
		// condicion para Espacio de consulta
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 309 && app.mouseY <= 342) {
			espacioConsulta = true;
			pantalla = 4;
		}

		// condicion para reservar un espacio
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 365 && app.mouseY <= 398) {
			reservaEspacio = true;
			pantalla = 5;
		}

		// condicion para cancelar clase
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 417 && app.mouseY <= 450) {
			cancelacion = true;
			pantalla = 6;
		}
		// coloco todas las opciones de evento por separado para poder enviar los 3
		// tipos de mensaje

		// condicion para siguiente
		if (app.mouseX >= 799 && app.mouseX <= 897 && app.mouseY >= 512 && app.mouseY <= 545) {
			siguiente = true;
			pantalla = 7;
		}

		// condicion para cancelar
		if (app.mouseX >= 712 && app.mouseX <= 783 && app.mouseY >= 518 && app.mouseY <= 837) {
			cancelar = true;
			pantalla = 1;

			diaSeleccionado = false;
			siguiente = false;

		}

		System.out.println("Pantalla 3 pasa a la pantalla: " + pantalla);
	}

	private void mousePantalla4() {
		// condicion para Espacio de consulta
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 309 && app.mouseY <= 342) {

			reservaEspacio = false;
			espacioConsulta = true;
			cancelacion = false;

			pantalla = 4;
		}

		// condicion para reservar un espacio
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 365 && app.mouseY <= 398) {
			reservaEspacio = true;
			espacioConsulta = false;
			cancelacion = false;
			pantalla = 5;
		}

		// condicion para cancelar clase
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 417 && app.mouseY <= 450) {

			reservaEspacio = false;
			espacioConsulta = false;
			cancelacion = true;
			pantalla = 6;
		}
		// coloco todas las opciones de evento por separado para poder enviar los 3
		// tipos de mensaje

		// condicion para siguiente
		if (app.mouseX >= 799 && app.mouseX <= 897 && app.mouseY >= 512 && app.mouseY <= 545) {
			siguiente = true;
			pantalla = 7;
		}

		// condicion para cancelar
		if (app.mouseX >= 712 && app.mouseX <= 783 && app.mouseY >= 518 && app.mouseY <= 837) {
			cancelar = true;
			pantalla = 1;
			diaSeleccionado = false;
			siguiente = false;
		}

		System.out.println("Pantalla 4 pasa a la pantalla: " + pantalla);
	}

	private void mousePantalla5() {
		// condicion para Espacio de consulta
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 309 && app.mouseY <= 342) {

			reservaEspacio = false;
			espacioConsulta = true;
			cancelacion = false;

			pantalla = 4;
		}

		// condicion para reservar un espacio
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 365 && app.mouseY <= 398) {
			reservaEspacio = true;
			espacioConsulta = false;
			cancelacion = false;
			pantalla = 5;
		}

		// condicion para cancelar clase
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 417 && app.mouseY <= 450) {

			reservaEspacio = false;
			espacioConsulta = false;
			cancelacion = true;
			pantalla = 6;
		}
		// coloco todas las opciones de evento por separado para poder enviar los 3
		// tipos de mensaje

		// condicion para siguiente
		if (app.mouseX >= 799 && app.mouseX <= 897 && app.mouseY >= 512 && app.mouseY <= 545) {
			siguiente = true;
			pantalla = 7;
		}

		// condicion para cancelar
		if (app.mouseX >= 712 && app.mouseX <= 783 && app.mouseY >= 518 && app.mouseY <= 837) {
			cancelar = true;
			pantalla = 1;
			diaSeleccionado = false;
			siguiente = false;
		}

		System.out.println("Pantalla 5 pasa a la pantalla: " + pantalla);
	}

	private void mousePantalla6() {
		// condicion para Espacio de consulta
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 309 && app.mouseY <= 342) {

			reservaEspacio = false;
			espacioConsulta = true;
			cancelacion = false;

			pantalla = 4;
		}

		// condicion para reservar un espacio
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 365 && app.mouseY <= 398) {
			reservaEspacio = true;
			espacioConsulta = false;
			cancelacion = false;
			pantalla = 5;
		}

		// condicion para cancelar clase
		if (app.mouseX >= 444 && app.mouseX <= 887 && app.mouseY >= 417 && app.mouseY <= 450) {

			reservaEspacio = false;
			espacioConsulta = false;
			cancelacion = true;
			pantalla = 6;
		}
		// coloco todas las opciones de evento por separado para poder enviar los 3
		// tipos de mensaje

		// condicion para siguiente
		if (app.mouseX >= 799 && app.mouseX <= 897 && app.mouseY >= 512 && app.mouseY <= 545) {
			siguiente = true;
			pantalla = 7;
		}

		// condicion para cancelar
		if (app.mouseX >= 712 && app.mouseX <= 783 && app.mouseY >= 518 && app.mouseY <= 837) {
			cancelar = true;
			pantalla = 1;
			diaSeleccionado = false;
			siguiente = false;
		}

		System.out.println("Pantalla 6 pasa a la pantalla: " + pantalla);
	}

	private void mousePantalla7() {
		// condicion para guardar
		if ((app.mouseX >= 799 && app.mouseX <= 897 && app.mouseY >= 512 && app.mouseY <= 545) && siguiente == true) {
			guardar = true;
			pantalla = 8;
			if (contadorEventos == 16) {
				if (espacioConsulta == true) {
					n16.setTexto("Espacio de comsulta");
				}
				if (reservaEspacio == true) {
					n16.setTexto("Reserva de espacio fisico");
				}
				if (cancelacion == true) {
					n16.setTexto("Cancelacion de clases");
				}

				// Grabamos el evento en firebase
				referencia.child(n16.getIdnoticia()).setValue(n16, null);

			} else {
				if (espacioConsulta == true) {
					n20.setTexto("Espacio de comsulta");
				}
				if (reservaEspacio == true) {
					n20.setTexto("Reserva de espacio fisico");
				}
				if (cancelacion == true) {
					n20.setTexto("Cancelacion de clases");
				}

				// Grabamos el evento en firebase
				referencia.child(n20.getIdnoticia()).setValue(n20, null);

			}

			System.out.println("Pantalla 7 pasa a la pantalla: " + pantalla);
		}

		// condicion para cancelar
		if (app.mouseX >= 712 && app.mouseX <= 783 && app.mouseY >= 518 && app.mouseY <= 837) {
			cancelar = true;
			pantalla = 1;
			espacioConsulta = false;
			reservaEspacio = false;
			cancelacion = false;
			
			System.out.println("Pantalla 7 pasa a la pantalla: " + pantalla);
		}
	}

	private void mousePantalla8() {
		// condicion para el dia
		if (app.mouseX >= 510 && app.mouseX <= 619 && app.mouseY >= 316 && app.mouseY <= 415) {
			diaSeleccionado = true;
			pantalla = 2;
			contadorEventos = 16;
			System.out.println("Pantalla 1 diaSeleccionado 16");
		}

		// cambiar cordenadas
		if (app.mouseX >= 941 && app.mouseX <= 1050 && app.mouseY >= 316 && app.mouseY <= 415) {
			diaSeleccionado = true;
			pantalla = 2;
			contadorEventos = 20;
			System.out.println("Pantalla 1 diaSeleccionado 20");
		}
		espacioConsulta = false;
		reservaEspacio = false;
		cancelacion = false;
	}

	public void setFont() {
		// app.textFont(app.createFont("Roboto-Regular.tff", 160));
		app.textSize(24);
		app.fill(0);
	}

	private void iniVariables() {

		rectC = app.loadImage("RectangleC.png");
		add = app.loadImage("Group.png");
		mes = app.loadImage("Group 7.2.png");
		mes2 = app.loadImage("calendario2.png");
		mes16 = app.loadImage("mes16.png");
		mes20 = app.loadImage("mes20.png");
		aviso = app.loadImage("aviso1.png");
		aviso11 = app.loadImage("aviso11.png");
		aviso12 = app.loadImage("aviso12.png");
		aviso13 = app.loadImage("aviso13.png");
		aviso2 = app.loadImage("aviso2.png");
		fondoGris = app.loadImage("fondoGris.png");
		fondoFijo = app.loadImage("fondoFijo.png");
		evento = app.loadImage("evento.png");

	}

}
