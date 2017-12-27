package pl.window_in_application;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class PictureBackgrund extends JPanel{

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
			
	public PictureBackgrund() {
				
		super();
				
		File imageFile = new File("grafia Tytulowa.jpg");
		
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
		Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
		setPreferredSize(dimension);
					
	}
	
	@Override
    protected void paintComponent(Graphics g)
    {
    super.paintComponent(g); 
    
        g.drawImage(image, 0,0,this);
    }
		
}
