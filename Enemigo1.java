import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Enemigo1 implements Runnable{
	JLabel fuego;
	int x;
	int speed;
	boolean hilo = false;

	public Enemigo1(JLabel fuego, int x, int speed, boolean hilo)
	{
		this.fuego = fuego;
		this.x = x;
		this.speed = speed;
		this.hilo = hilo;
	}
	public void run()
	{
		
		while(hilo)
		{
			//System.out.println("Hola, soy un proceso paralelo");
			for (int y=25; y<150; y=y+5) 
			{
				this.fuego.setLocation(x,y);
				retorno(speed);
			}

			for (int y=150; y>25; y=y-5) 
			{
				this.fuego.setLocation(x,y);
				retorno(speed);
			}


		}

	}

	public void retorno(int duracion)
	{
		try{
		Thread.sleep(duracion);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}