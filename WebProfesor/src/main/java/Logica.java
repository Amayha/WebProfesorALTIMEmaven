import java.awt.Image;
import java.io.InputStream;

import gifAnimation.Gif;
import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	private PApplet app;
	private int pantalla;
	private Home home;
	private Calendario calen;
	private Usuario us;
	private int encima;
	private PImage nav, barra, cuaLog, casa, casa2, estu, cal, cal2, ojo, lupa, buscador, login;
	private boolean contra, usuario;
	private Gif nonLoopingGif, barras, lineas;
	boolean pause, reproducir;

	public Logica(PApplet app) {
		this.app = app;
		pantalla = 0;
		pause = false;
		reproducir = false;
		home = new Home(app, this);
		calen = new Calendario(app, this);
		us = new Usuario(app);
		nonLoopingGif = new Gif(app, "coso.gif");
		barras = new Gif(app, "barras.gif");
		lineas = new Gif(app, "lineas.gif");

		buscador = app.loadImage("buscador.png");
		lupa = app.loadImage("buscar.png");
		nav = app.loadImage("barra-nav.png");
		barra = app.loadImage("barra-arriba.png");
		cuaLog = app.loadImage("cuadros-logo.png");
		casa = app.loadImage("home.png");
		estu = app.loadImage("estu.png");
		cal2 = app.loadImage("cal2.png");
		cal = app.loadImage("cal.png");
		casa2 = app.loadImage("ppal.png");
		ojo = app.loadImage("ojo.png");
		login = app.loadImage("Login.png");
		encima = 1;
		usuario = false;
		contra = false;
	}

	public void pintar() {
		if (pantalla != 0) {
			navegacion();
		}

		switch (pantalla) {
		case 0:
			app.imageMode(app.CENTER);
			app.image(login, app.width / 2, app.height / 2);
			app.imageMode(app.CORNER);
			if (usuario == true) {
				app.textSize(20);
				app.fill(30);
				app.text("1153458759", 456, 330);
			} else {
				app.textSize(20);
				app.fill(150);
				app.text("Usuario", 456, 330);
			}
			if (contra == true) {
				app.textSize(20);
				app.fill(30);
				app.text("*******", 456, 408);
			} else {
				app.textSize(20);
				app.fill(150);
				app.text("Contraseña", 456, 408);
			}
			break;
		case 1:
			home.pintar();
			app.image(nonLoopingGif, 190, 350);
			app.image(barras, 190, 130);
			app.image(lineas, 490, 360);
			app.textSize(12);
			app.fill(30);
			app.text("Rendimiento Por Materia", 570, 375);


			break;
		case 2:
			calen.pintar();
			break;
		case 3:

			us.pintar();

			pantalla++;
			break;
		}

		if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 130 && app.mouseY < 200) {
			encima = 1;
		} else if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 240 && app.mouseY < 300) {
			encima = 2;
		} else if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 360 && app.mouseY < 410) {
			encima = 3;
		} else {
			encima = 0;
		}
	}

	public void mouse() {
		System.out.println(app.mouseX + " " + app.mouseY);
		if (pantalla != 0) {
			if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 130 && app.mouseY < 200) {
				pantalla = 1;
			}
			if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 240 && app.mouseY < 300) {
				pantalla = 2;
			}
			if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 350 && app.mouseY < 420) {
				pantalla = 3;
			}

		}
		switch (pantalla) {
		case 0:
			if (app.mouseX > 456 && app.mouseX < 530 && app.mouseY > 310 && app.mouseY < 330) {
				usuario = true;
			}
			if (app.mouseX > 505 && app.mouseX < 680 && app.mouseY > 450 && app.mouseY < 508 && usuario == true
					&& contra == true) {
				pantalla++;
				nonLoopingGif.play();
				nonLoopingGif.ignoreRepeat();
				barras.play();
				barras.ignoreRepeat();
				lineas.play();
				lineas.ignoreRepeat();
			}
			if (app.mouseX > 456 && app.mouseX < 560 && app.mouseY > 390 && app.mouseY < 410) {
				contra = true;
			}
			break;
		case 1:
			home.mouse();
			break;
		case 2:
			calen.mouse();
			break;
		case 3:
			us.mouse();
			break;

		}
	}

	public void navegacion() {
		app.image(nav, 0, 0);
		app.image(barra, 112, 19);
		app.image(ojo, 26, 19);
		app.image(casa2, 29, 149);
		app.image(cal, 28.16f, 258.57f);
		app.image(estu, 1086, 32);
		app.fill(226, 166, 14);
		app.textSize(20);
		app.text("Profesor", 985, 63);
		app.image(lupa, 923, 44);
		app.image(buscador, 630, 36);
		app.fill(144, 144, 144);
		app.text("Buscar", (float) 649.73, 60);
		if (pantalla != 0 && pantalla != 4) {
			if (pantalla == 1 || encima == 1) {
				app.image(cuaLog, 6, 124);
				app.image(casa, 29, 149);
				app.fill(209, 59, 78);
				app.textSize(18);
				app.text("Inicio", 22, 226);
			}
			if (pantalla == 2 || encima == 2) {
				app.image(cuaLog, 6, 231);
				app.image(cal2, 28.16f, 258.57f);
				app.fill(241, 135, 104);
				app.textSize(16);
				app.text("Calendario", 6, 330);
			}

		}
	}

}
