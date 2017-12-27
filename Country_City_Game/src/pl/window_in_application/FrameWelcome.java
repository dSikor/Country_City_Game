package pl.window_in_application;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import org.eclipse.swt.graphics.Image;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FrameWelcome extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Image tlo;
	PictureBackgrund TloFrame;
	boolean czyAktywneOkno;
		
	public FrameWelcome() {
		setTitle("Witam");
		
				
		setBounds(100, 100, 194, 158);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE)
		);
	
		TloFrame = new PictureBackgrund();
					
		getContentPane().add(TloFrame);
		pack();
						
	}

}
