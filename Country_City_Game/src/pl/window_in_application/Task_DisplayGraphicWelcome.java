package pl.window_in_application;

import java.util.TimerTask;

public class Task_DisplayGraphicWelcome extends TimerTask{

		
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		
}
