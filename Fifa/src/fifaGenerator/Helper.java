package fifaGenerator;

public class Helper implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu.start.doClick();
	}

}
