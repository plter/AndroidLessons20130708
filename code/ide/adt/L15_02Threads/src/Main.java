import javax.swing.JFrame;


public class Main extends JFrame implements Runnable{
	
	
	
	public static void main(String[] args) {
		
		new Main();
	}
	
	public Main() {
		
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		new Thread(this).start();
	}
	
	
	@Override
	public void run() {
		System.out.println("Thread starts");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello");
	}
}
