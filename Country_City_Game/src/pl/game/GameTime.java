package pl.game;

import javax.swing.JOptionPane;

import pl.window_in_application.WindowToSetTimeGame;

public class GameTime {

	
	int czas;
	WindowToSetTimeGame okienko;
	
	public GameTime() {
		// TODO Auto-generated constructor stub
	}
	
	public void podajCzasRozgrywki()
	{
			 okienko = new WindowToSetTimeGame();
	}
	
	public void ustawCzas()
	{
		if(okienko.getCzas()==0) JOptionPane.showMessageDialog(null,"Nie wprowadzono czasu!!!");
		else czas=okienko.getCzas();
				
	}
	
	public int getCzas() {
		return czas;
	}
	
	
}
