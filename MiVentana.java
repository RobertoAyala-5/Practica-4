import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.Random;
import java.applet.AudioClip;

class MiVentana extends JFrame implements KeyListener, ActionListener{

	BufferedImage imagen;
	BufferedImage subImagen;
	Monito monito;
	Monito1 monito1;
	Thread enemigo1;
	Thread enemigo2;
	Thread enemigo3;
	Thread enemigo4;
	Thread enemigo5;
	int indiceX;
	int indice = 0;
	int t;

	JLabel pared;
	JLabel pared1;
	JLabel pared2;
	JPanel panel;
	JLabel fuego;
	JLabel fuego1;
	JLabel fuego2;
	JLabel fuego3;
	JLabel fuego4;
	JLabel portal;
	JLabel gameover;

	JLabel alien1;
	JLabel alien2;
	JLabel alien3;

	JButton restart;

	Rectangle m;
	Rectangle m1;
	Rectangle m2;
	Rectangle m3;
	Rectangle m4;
	Rectangle hb;
	Rectangle win;
	int tiempo;

	boolean hilo1;
	boolean hilo2;
	boolean hilo3;
	boolean hilo4;
	boolean hilo5;

	boolean k1;
	boolean k2;
	boolean k3;
	boolean k4;
	boolean k5;

	int b1;
	int b2;
	int b3;
	int b4;
	int b5;

	int speed;

	int puntuacion; 

	JLabel puntos;

	AudioClip dog;
	AudioClip fondo;

	public MiVentana()
	{

		panel = new JPanel();
		panel.setLayout(null);

		try{
			imagen = ImageIO.read(new File("./imagenes/48389841_204443183824787_1483351678198480896_n.png"));
			//imagen1 = ImageIO.read(new File("./imagenes/png-sprite-generator-7.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		pared = new JLabel();
		pared.setIcon(new ImageIcon("maxresdefault.jpg"));
		pared.setBounds(0,0,1280,25);

		pared1 = new JLabel();
		pared1.setIcon(new ImageIcon("maxresdefault.jpg"));
		pared1.setBounds(0,175,1000,25);

		pared2 = new JLabel();
		pared2.setIcon(new ImageIcon("maxresdefault.jpg"));
		pared2.setBounds(0,335,1280,25);

		fuego = new JLabel();
		fuego.setIcon(new ImageIcon("56079bda3325d326dc4307a9cc8aed63-silueta-de-dibujos-animados-de-fuego.png"));
		fuego.setBounds(0,335,25,25);

		fuego1 = new JLabel();
		fuego1.setIcon(new ImageIcon("56079bda3325d326dc4307a9cc8aed63-silueta-de-dibujos-animados-de-fuego.png"));
		fuego1.setBounds(0,335,25,25);

		fuego2 = new JLabel();
		fuego2.setIcon(new ImageIcon("56079bda3325d326dc4307a9cc8aed63-silueta-de-dibujos-animados-de-fuego.png"));
		fuego2.setBounds(0,335,25,25);

		fuego3 = new JLabel();
		fuego3.setIcon(new ImageIcon("56079bda3325d326dc4307a9cc8aed63-silueta-de-dibujos-animados-de-fuego.png"));
		fuego3.setBounds(0,335,25,25);

		fuego4 = new JLabel();
		fuego4.setIcon(new ImageIcon("56079bda3325d326dc4307a9cc8aed63-silueta-de-dibujos-animados-de-fuego.png"));
		fuego4.setBounds(0,335,25,25);

		portal = new JLabel();
		portal.setIcon(new ImageIcon("magic-portal-png-3.png"));
		portal.setBounds(50,216,80,100);

		gameover = new JLabel();
		gameover.setIcon(new ImageIcon("Copia-de-GAMEOVER-3.png"));
		gameover.setBounds(0,50,938,225);

		alien1 = new JLabel();
		alien1.setBounds(1000,0,272,480);
		alien1.setIcon(new javax.swing.ImageIcon("giphy (2).gif"));

		alien2 = new JLabel();
		alien2.setBounds(950,0,400,480);
		alien2.setIcon(new javax.swing.ImageIcon("giphy (1).gif"));

		alien3 = new JLabel();
		alien3.setBounds(1000,-100,272,480);
		alien3.setIcon(new javax.swing.ImageIcon("giphy.gif"));

		Font fuenteBtn = new Font("Bahnschrift", 0, 100);
		restart = new JButton("Restart");
		restart.setBounds(0,225,938,100);
		restart.setBackground(Color.BLACK);
		restart.setFont(fuenteBtn);
		restart.setForeground(Color.WHITE);

		puntuacion = 0;

		puntos = new JLabel(Integer.toString(puntuacion));
		puntos.setBounds(1100,-10,300,400);

		subImagen = imagen.getSubimage(0,0,48,48);
		monito = new Monito(subImagen);
	
		this.setTitle("Runnalien");
		this.setSize(1500, 400);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setOpaque(false);
		panel.add(pared);
		panel.add(pared1);
		panel.add(pared2);
		panel.add(fuego);
		panel.add(fuego1);
		panel.add(fuego2);
		panel.add(fuego3);
		panel.add(fuego4);
		panel.add(portal);
		panel.add(puntos);
		panel.add(gameover);
		panel.add(alien1);
		panel.add(alien2);
		panel.add(alien3);
		panel.add(restart);

		this.add(monito);
		this.setVisible(true);
		this.addKeyListener(this);

		gameover.setVisible(false);
		alien1.setVisible(false);
		alien2.setVisible(false);
		alien3.setVisible(false);
		restart.setVisible(false);

		tiempo = 100;
		hilo1 = false;
		hilo2 = false;
		hilo3 = false;
		hilo4 = false;
		hilo5 = false;

		k1 = false;
		k2 = false;
		k3 = false;
		k4 = false;
		k5 = false;

		b1 = 1;
		b2 = 1;
		b3 = 1;
		b4 = 1;
		b5 = 1;

		speed = 5;

		Font fuente = new Font("Calibri", 0, 250);
        puntos.setFont(fuente); 
        puntos.setForeground(Color.WHITE);
		this.add(panel);
		this.setVisible(true);

		fondo = java.applet.Applet.newAudioClip(getClass().getResource("Fondo.wav"));
		fondo.loop();

		monito.setLocation(-85,-25);
		
		restart.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event)
	{
			if(event.getSource() == this.restart)
			{
				dog.stop();
				MiVentana.this.setVisible(false);
				MiVentana.this.dispose();
				new MiVentana();
			}
	}
	
	public void keyPressed(KeyEvent e)
	{
		System.out.println("tiempo = " + tiempo);
		t = e.getKeyCode();
		Point pos = monito.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();


		if(t==68)
		{
			x = x + speed;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48*2,48,48);
		}

		else if(t==65)
		{

			x = x - speed;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48,48,48);
				
		}

		else if(t==83)
		{
			y = y + speed;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48*0,48,48);			
		}
		else if(t==87)
		{
			y = y - speed;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48*3,48,48);
		}


		if (y < -75) 
		{
			System.out.println("colision");
			y = -75; 
		}
		if (x < -125) {
			x = -125;
		}
		if (x > 1110) {
			x = 1110;
		}

		if (y > 185) {
			y = 185;
		}

		if (y > 25 && y < 50 && -130 < x && x < 880) {
			y = 25;
		}

		if (y > 75 && y < 100 && -130 < x && x < 880) {
			y = 100;
		}

		else if (y > 25 && y < 100 && x < 880) {
			x = 880;
		}
		
		monito.setLocation(x,y);
		System.out.println(x + " " + y);
		muerte(x,y);
		avanzar(x,y);
	}

	public void keyReleased(KeyEvent e)
	{
		//System.out.println("Tecla liberada.");
	}

	public void keyTyped(KeyEvent e)
	{
		//System.out.println("Tecla en el buffer.")

	}

	public void crearHilos()
	{
		if(k1 == true && b1 == 1)
		{
		crearHilo1(hilo1);
		b1 = 0;
		}
		if(b1 == 2){
			speed = speed + 1;
			System.out.println("Velocidad subida, ya no llores");
		}


		if(k2 == true && b2 == 1)
		{
		crearHilo2(hilo2);
		b2 = 0;
		}
		if(b2 == 2){
			speed = speed - 1;
			System.out.println("Velocidad bajada JAJAJAJAJ");
		}

		if(k3 == true && b3 == 1)
		{
		crearHilo3(hilo3);
		b3 = 0;
		}
		if(b3 == 2){
			speed = speed + 1;
			System.out.println("Velocidad subida, ya no llores");
		}

		if(k4 == true && b4 == 1)
		{
		crearHilo4(hilo4);
		b4 = 0;	
		}
		if(b4 == 2){
			speed = speed - 1;
			System.out.println("Velocidad bajada JAJAJAJAJ");
		}

		if(k5 == true && b5 == 1)
		{
		crearHilo5(hilo5);
		b5 = 0;	
		}
		if(b5 == 2){
			speed = speed*(-1);
			System.out.println("Sadaetlov salcet");
		}
	}

	public void crearHilo1(boolean hilo)
	{
		Enemigo1 e1 = new Enemigo1(fuego, 200, tiempo, hilo);
		enemigo1 = new Thread(e1);
		enemigo1.start();
	}

	public void crearHilo2(boolean hilo)
	{
		Enemigo2 e2 = new Enemigo2(fuego1, 500, tiempo, hilo);
		enemigo2 = new Thread(e2);
		enemigo2.start();
	}

	public void crearHilo3(boolean hilo)
	{
		Enemigo3 e3 = new Enemigo3(fuego2, 700, tiempo, hilo);
		enemigo3 = new Thread(e3);
		enemigo3.start();
	}

	public void crearHilo4(boolean hilo)
	{
		Enemigo4 e4 = new Enemigo4(fuego3, 400, tiempo, hilo);
		enemigo4 = new Thread(e4);
		enemigo4.start();
	}

	public void crearHilo5(boolean hilo)
	{
		Enemigo5 e5 = new Enemigo5(fuego4, 600, tiempo, hilo);
		enemigo5 = new Thread(e5);
		enemigo5.start();
	}

	public void muerte(int x, int y)
	{
		Point pos1 = fuego.getLocation();
		int x1 = (int)pos1.getX();
		int y1 = (int)pos1.getY();
		m = new Rectangle(x1-115,y1-100,25,25);
		hb = new Rectangle(x,y,48,48);
		if (hb.intersects(m) || m.intersects(hb)) {
			System.out.println("colision");
			monito.setLocation(-85,-25);
			puntuacion = 0;
			pantallaGameOver();
		}

		Point pos2 = fuego1.getLocation();
		int x2 = (int)pos2.getX();
		int y2 = (int)pos2.getY();
		m1 = new Rectangle(x2-115,y2-100,25,25);
		hb = new Rectangle(x,y,48,48);
		if (hb.intersects(m1) || m1.intersects(hb)) {
			System.out.println("colision");
			monito.setLocation(-85,-25);
			puntuacion = 0;
			pantallaGameOver();
		}

		Point pos3 = fuego2.getLocation();
		int x3 = (int)pos3.getX();
		int y3 = (int)pos3.getY();
		m2 = new Rectangle(x3-115,y3-100,25,25);
		hb = new Rectangle(x,y,48,48);
		if (hb.intersects(m2) || m2.intersects(hb)) {
			System.out.println("colision");
			monito.setLocation(-85,-25);
			puntuacion = 0;
			pantallaGameOver();
		}

		Point pos4 = fuego3.getLocation();
		int x4 = (int)pos4.getX();
		int y4 = (int)pos4.getY();
		m3 = new Rectangle(x4-115,y4-100,25,25);
		hb = new Rectangle(x,y,48,48);
		if (hb.intersects(m3) || m3.intersects(hb)) {
			System.out.println("colision");
			monito.setLocation(-85,-25);
			puntuacion = 0;
			pantallaGameOver();
		}

		Point pos5 = fuego4.getLocation();
		int x5 = (int)pos5.getX();
		int y5 = (int)pos5.getY();
		m4 = new Rectangle(x5-115,y5-100,25,25);
		hb = new Rectangle(x,y,48,48);
		if (hb.intersects(m4) || m4.intersects(hb)) {
			System.out.println("colision");
			monito.setLocation(-85,-25);
			puntuacion = 0;
			pantallaGameOver();
		}

		puntos.setText(Integer.toString(puntuacion));
	}

	public void avanzar(int x, int y)
	{
		Point pos1 = portal.getLocation();
		int x1 = (int)pos1.getX();
		int y1 = (int)pos1.getY();
		win = new Rectangle(x1-115,y1-100,80,100);
		hb = new Rectangle(x,y,48,48);
		if (hb.intersects(win)) 
		{
			puntuacion = puntuacion + 1;
			Random generator = new Random();
			int r = generator.nextInt(8) + 1;
			System.out.println("colision");
			monito.setLocation(-85,-25);
			System.out.println(tiempo);
			switch(r)
			{
				case 1:
				tiempo = tiempo/2;
				System.out.println("tiempo reducido a la mitad");
				k1 = false;
				k2 = false;
				k3 = false;
				k4 = false;
				k5 = false;

				if (b1 == 0 && b2 == 0 && b3 == 0 && b4 == 0 && b5 == 0) {
					speed = speed + 3;
				}
				break;

				case 2:
				tiempo = tiempo - 50;
				System.out.println("tiempo restado");
				k1 = false;
				k2 = false;
				k3 = false;
				k4 = false;
				k5 = false;

				if (b1 == 0 && b2 == 0 && b3 == 0 && b4 == 0 && b5 == 0) {
					fuego.setVisible(false);
					fuego2.setVisible(true);
					fuego3.setVisible(true);
					fuego1.setVisible(true);
					fuego4.setVisible(false);

				}
				break;

				case 3:
				hilo2 = true;
				System.out.println("enemigo2 creado");
				k2 = true;
				k1 = false;
				k3 = false;
				k4 = false;
				k5 = false;

				if (b2 == 0) {
					b2 = 2;
				}
				crearHilos();
				break;

				case 4:
				tiempo = tiempo + 20;
				System.out.println("tiempo aumentado");
				k1 = false;
				k2 = false;
				k3 = false;
				k4 = false;
				k5 = false;

				if (b1 == 0 && b2 == 0 && b3 == 0 && b4 == 0 && b5 == 0) {
					fuego.setVisible(true);
					fuego2.setVisible(false);
					fuego3.setVisible(false);
					fuego1.setVisible(false);
					fuego4.setVisible(true);

				}
				break;

				case 5:
				hilo3 = true;
				System.out.println("enemigo3 creado");
				k3 = true;
				k1 = false;
				k2 = false;
				k4 = false;
				k5 = false;

				if (b3 == 0) {
					b3 = 2;
				}
				crearHilos();
				break;

				case 6:
				hilo4 = true;
				System.out.println("enemigo4 creado");
				k4 = true;
				k1 = false;
				k3 = false;
				k2 = false;
				k5 = false;

				if (b4 == 0) {
					b4 = 2;
				}
				crearHilos();
				break;

				case 7:
				hilo5 = true;
				System.out.println("enemigo5 creado");
				k5 = true;
				k1 = false;
				k3 = false;
				k4 = false;
				k2 = false;

				if (b5 == 0) {
					b5 = 2;
				}
				crearHilos();
				break;

				case 8:
				hilo1 = true;
				System.out.println("enemigo1 creado");
				k1 = true;
				k2 = false;
				k3 = false;
				k4 = false;
				k5 = false;

				if (b1 == 0) {
					b1 = 2;
				}
				crearHilos();
				break;

				case 9:
				k1 = false;
				k2 = false;
				k3 = false;
				k4 = false;
				k5 = false;

				if (b1 == 0 && b2 == 0 && b3 == 0 && b4 == 0 && b5 == 0) {
					fuego.setVisible(false);
					fuego2.setVisible(false);
					fuego3.setVisible(false);
					fuego1.setVisible(false);
					fuego4.setVisible(false);
				}
				break;

				case 10:
				k1 = false;
				k2 = false;
				k3 = false;
				k4 = false;
				k5 = false;

				if (b1 == 0 && b2 == 0 && b3 == 0 && b4 == 0 && b5 == 0) {
					fuego.setVisible(true);
					fuego2.setVisible(true);
					fuego3.setVisible(true);
					fuego1.setVisible(true);
					fuego4.setVisible(true);
				}
				break;
			}
			puntos.setText(Integer.toString(puntuacion));
			if(tiempo < 50)
			{
				tiempo = 50;
			}
			
		}	

	}

	public void pause(int p)
	{
			try{
			Thread.sleep(p);
			}catch(Exception e){
				System.out.println(e);
			}
	}

	public void pantallaGameOver()
	{
		fondo.stop();

		dog = java.applet.Applet.newAudioClip(getClass().getResource("The Bork Files (online-audio-converter.com).wav"));
		dog.play();

		gameover.setVisible(true);
		pared.setVisible(false);
		pared1.setVisible(false);
		pared2.setVisible(false);
		portal.setVisible(false);
		fuego.setVisible(false);
		fuego1.setVisible(false);
		fuego2.setVisible(false);
		fuego3.setVisible(false);
		fuego4.setVisible(false);
		puntos.setVisible(false);
		restart.setVisible(true);
		monito.setVisible(false);
		
		if (puntuacion < 6)
		alien1.setVisible(true);
		
		if (puntuacion > 5 && puntuacion < 8)
		alien2.setVisible(true);
		
		if (puntuacion > 7)
		alien3.setVisible(true);

	}

}
