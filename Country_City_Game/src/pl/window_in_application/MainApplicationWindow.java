package pl.window_in_application;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import pl.game.GameRound;
import pl.game.Task_CountdownOfTime;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainApplicationWindow {

	private JFrame frameGame;
	private JTextField edit_textField_Country;
	private JTextField edit_textField_Town;
	private JTextField edit_textField_Name;
	private JTextField edit_textField_Thing;
	private JTextField edit_textField_Plant;
	private JLabel lblTime;
	
	static Point perfectLocation = new Point(350,100);
	static Point locationOfMainWindow = new Point(350,150);
	private JButton buttonStartOfCountdown;
	GameRound round_1;
		
	public static void main(String[] args) {
										
				FrameWelcome Frame1WithTitle=new FrameWelcome();	
				Frame1WithTitle.setLocation(perfectLocation);
				Frame1WithTitle.setVisible(true);
				try {
					Thread.sleep(4000);
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Frame1WithTitle.dispose();
								
				MainApplicationWindow window1 = new MainApplicationWindow();
				window1.frameGame.setVisible(true);
								
	}

	public MainApplicationWindow() {
		
		round_1=new GameRound();
		initialize();	
				
	}

	private void initialize() {
		
		
		frameGame = new JFrame();
		frameGame.setResizable(false);
		frameGame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frameGame.getContentPane().setBackground(Color.YELLOW);
		frameGame.getContentPane().setForeground(Color.WHITE);
		frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGame.setTitle("Pa\u0144stwo Miasto ");
		
		
		edit_textField_Country = new JTextField();
		edit_textField_Country.setColumns(10);
		
		JLabel lblPastwo = new JLabel("Pa\u0144stwo ");
		lblPastwo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		edit_textField_Town = new JTextField();
		edit_textField_Town.setColumns(10);
		
		edit_textField_Name = new JTextField();
		edit_textField_Name.setColumns(10);
		
		edit_textField_Thing = new JTextField();
		edit_textField_Thing.setColumns(10);
		
		edit_textField_Plant = new JTextField();
		edit_textField_Plant.setColumns(10);
		
		
		JLabel lblMiasto = new JLabel("Miasto");
		lblMiasto.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblImi = new JLabel("Imi\u0119");
		lblImi.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblRzecz = new JLabel("Rzecz");
		lblRzecz.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblRolina = new JLabel("Ro\u015Blina");
		lblRolina.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblTime = new JLabel("Czas ");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton ButtonLosujLiterke = new JButton("Losuj literk\u0119 ");
		
		
		ButtonLosujLiterke.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent arg0) {
						
			round_1.wylosujiUstawLiterke(frameGame);
			
			
			}
		});
		
		buttonStartOfCountdown = new JButton("Start");
		buttonStartOfCountdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				List<JTextField> editTextWithAnswer = new ArrayList<JTextField>();  
				editTextWithAnswer.add(edit_textField_Country);
				editTextWithAnswer.add(edit_textField_Town);
				editTextWithAnswer.add(edit_textField_Name);
				editTextWithAnswer.add(edit_textField_Thing);
				editTextWithAnswer.add(edit_textField_Plant);
					
				
			round_1.ustawCzasRozgrywki();					
			int liczba=round_1.getCzas();
		
			Task_CountdownOfTime LicznikCzasu = new Task_CountdownOfTime(liczba,lblTime,editTextWithAnswer);		
			LicznikCzasu.start();
				
			}
		});
		
		JButton ButtonUstawCzas = new JButton("Ustaw czas");
		ButtonUstawCzas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				round_1.podajCzasRozgrywki();
		
			}
		});
		
		JButton btnSprawd = new JButton("Sprawdz odpowiedzi ");
		btnSprawd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
								
				round_1.setOdpowiedzi(edit_textField_Country.getText(),0);
				round_1.setOdpowiedzi(edit_textField_Town.getText(),1);
				round_1.setOdpowiedzi(edit_textField_Name.getText(),2);
				round_1.setOdpowiedzi(edit_textField_Thing.getText(),3);
				round_1.setOdpowiedzi(edit_textField_Plant.getText(),4);

				
				boolean czyJest=false;
				
				for(int i=0;i<5;i++)
				{
					switch (i) {
					
					case 0:
							
						czyJest=round_1.sprawdzOdpowiedz("Panstwa.txt",0);
						
						break;
						
					case 1:
						
						czyJest=round_1.sprawdzOdpowiedz("Miasta.txt",1);
													
						break;
						
					case 2:
						
						czyJest=round_1.sprawdzOdpowiedz("Imie.txt",2);
						
						break;
						
						
					case 3:
						
						czyJest=round_1.sprawdzOdpowiedz("Rzecz.txt",3);
						
						break;
						
							
					case 4:
						czyJest=round_1.sprawdzOdpowiedz("Roœliny.txt",4);
						
						break;
						
					default:
						break;
					}
					
					if(czyJest)
					{
						round_1.setZwiekszLiczbePoprawnychOdpowiedzi();
						czyJest=false;
					}
					
					
				}

				round_1.wyswietlOkienkoZPoprawnymiOdpowiedziami(frameGame);
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frameGame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(edit_textField_Country)
						.addComponent(lblPastwo, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(ButtonLosujLiterke, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblMiasto, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(edit_textField_Town)
						.addComponent(ButtonUstawCzas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblImi, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(buttonStartOfCountdown, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(edit_textField_Name))))
					.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRzecz, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(edit_textField_Thing, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(lblRolina, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(edit_textField_Plant, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
							.addGap(66))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSprawd)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblTime)
							.addGap(31))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(edit_textField_Country, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(edit_textField_Town, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(edit_textField_Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(edit_textField_Thing, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(edit_textField_Plant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPastwo, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
								.addComponent(lblImi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMiasto, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRzecz, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRolina, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(22)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTime)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(ButtonLosujLiterke)
							.addComponent(ButtonUstawCzas)
							.addComponent(buttonStartOfCountdown)
							.addComponent(btnSprawd)))
					.addGap(26))
		);
		frameGame.getContentPane().setLayout(groupLayout);
		frameGame.setSize(Frame.WIDTH,Frame.HEIGHT);
		
		frameGame.setLocation(locationOfMainWindow);
		frameGame.pack();
	}
}
