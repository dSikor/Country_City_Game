package pl.game;

import java.util.Random;

import javax.swing.JOptionPane;

public class DrawnLetter {
	
	char literka;
	
	
	public DrawnLetter() {
		// TODO Auto-generated constructor stub
						
	}
	
	
	public void losujLitere(char poczatekZakresuLiter,char koniecZakresuLiter)
	{
		int poczatekZakresuLiczb=(int)poczatekZakresuLiter;
		int koniecZakresuLiczb=(int)koniecZakresuLiter;
		
		Random liczbaLosowa = new Random();		
		int wylosowanaLiczba = liczbaLosowa.nextInt(koniecZakresuLiczb-poczatekZakresuLiczb+1)+poczatekZakresuLiczb;
			
		if((wylosowanaLiczba>=91)&&(wylosowanaLiczba<=96))
		{
			wylosowanaLiczba =liczbaLosowa.nextInt(koniecZakresuLiczb-poczatekZakresuLiczb+1)+poczatekZakresuLiczb;
		}
		literka=(char)wylosowanaLiczba;	
		
		String napis = "Wylosowana litera to "+(char)wylosowanaLiczba;				
		JOptionPane.showMessageDialog(null,napis,"Wylosowana litera",JOptionPane.INFORMATION_MESSAGE);
				
	}
	
public char getLiterka() {
	return literka;
}

public void setLiterka(char literka) {
	this.literka = literka;
}
		
}
