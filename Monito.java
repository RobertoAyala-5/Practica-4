import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class Monito extends JPanel{

	BufferedImage imagen;
	//BufferedImage imagen1;

	public Monito(BufferedImage imagen)
	{
		this.imagen = imagen;
		//this.imagen1 = imagen1;
		this.setOpaque(false);	
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
        g.drawImage(imagen,114,100,48,48,null);
        g.setColor(Color.RED);
        //g.drawImage(imagen1,200,200,48,48,null);
        
   	}

}