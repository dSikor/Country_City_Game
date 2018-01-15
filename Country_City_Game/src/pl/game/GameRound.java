package pl.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameRound {

	ArrayList<String> odpowiedzi;
	DrawnLetter litera;
	GameTime czas;
	int iloscPoprawnychOdpowiedzi;
	int iloscBlednychOdpowiedzi;
			
	public GameRound() {
				
		odpowiedzi= new ArrayList<>();	
		odpowiedzi.add("");
		odpowiedzi.add("");
		odpowiedzi.add("");
		odpowiedzi.add("");
		odpowiedzi.add("");
				
		litera=new DrawnLetter();
		czas=new GameTime();
			
		iloscPoprawnychOdpowiedzi=0;
		iloscBlednychOdpowiedzi=0;
						
	}
	
	public void setZwiekszLiczbeBlednychOdpowiedzi() {
		this.iloscBlednychOdpowiedzi = iloscBlednychOdpowiedzi+1;
	}
	
	public void setZwiekszLiczbePoprawnychOdpowiedzi() {
		this.iloscPoprawnychOdpowiedzi = iloscPoprawnychOdpowiedzi+1;
	}
	
	public int getIloscPoprawnychOdpowiedzi() {
		return iloscPoprawnychOdpowiedzi;
	}
	


	public DrawnLetter getLitera() {
		return litera;
	}

	public char wyswietlLiterke()
	{
		return litera.getLiterka();
	}
		
	public int getCzas() {
		return czas.getCzas();
	}
		
	public void setLitera(DrawnLetter litera) {
		this.litera = litera;
	}	
		
	public void wylosujiUstawLiterke(JFrame n)
	{
		litera.losujLitere(n,'A','Z');//zmiana		
	}
	
	public void podajCzasRozgrywki()
	{
		
		czas.podajCzasRozgrywki();
		
	}
	
	public void ustawCzasRozgrywki()
	{
		czas.ustawCzas();
	}
	
	
	public void setOdpowiedzi(String trescOdpowiedzi,int index) {
	
		odpowiedzi.set(index,trescOdpowiedzi);
		
	}
	
	public String getZwrocDanaOdpowiedzi(int index) {
		return odpowiedzi.get(index);
	}
	
	
	public void wyswietlOkienkoZPoprawnymiOdpowiedziami(JFrame windowToSetLocation)
	{
		JOptionPane.showMessageDialog(windowToSetLocation,"Zdoby³aœ/eœ nastêpuj¹c¹ liczbê punktów : "+getIloscPoprawnychOdpowiedzi(),"Wynik",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public boolean sprawdzOdpowiedz(String nazwaPliku, int identyfikatorKategorii)
	{
		File Plik_odpowiedzi = new File(nazwaPliku);	
		
		try (BufferedReader br = new BufferedReader(new FileReader(Plik_odpowiedzi))) {
		    	
			String line;
							
		    while ((line = br.readLine()) != null) {
		     
		    	if(line.equals(odpowiedzi.get(identyfikatorKategorii)))
		    	{
		    		
		    		return true; 
		    	}	
		    }
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return false; 
		
	}
	
}
