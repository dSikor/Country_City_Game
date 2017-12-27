package pl.game;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Task_CountdownOfTime extends Thread{

	int valueTimeCountDown;
	JLabel labelToShowTime;
	List<JTextField> objectToModify;

					
	public Task_CountdownOfTime(int czas , JLabel o, List<JTextField> l) {		
	
		this.valueTimeCountDown=czas;
		this.labelToShowTime=o;			
		objectToModify=l;
	}
				
				
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		synchronized (this) {

						
			int timeToFinish=0;
			
			for(int count=0;count<=valueTimeCountDown;count++)
			{
				setEditableAllEditField(true);
				timeToFinish=valueTimeCountDown-count;
				
				try {
					wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(timeToFinish>=11) 
				{
					labelToShowTime.setText(Integer.toString(timeToFinish));
				}	
				else if((0<timeToFinish)&&(timeToFinish<11))	
				{	
					labelToShowTime.setText((Integer.toString(timeToFinish)+" !!!"));
				}
				else
				{
					labelToShowTime.setText("Koniec");
					setEditableAllEditField(false);
				}				
			}	
		}
		
	}
	
	public void setEditableAllEditField(boolean stan)
	{
		for(int i=0;i<objectToModify.size();i++)
		{
			objectToModify.get(i).setEditable(stan);
		}
	}	
}
