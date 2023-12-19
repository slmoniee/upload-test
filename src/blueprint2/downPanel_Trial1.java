package blueprint2;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class downPanel_Trial1 extends JFrame {
	// 컴포넌트는 이곳에 필드 형태로 선언하세요!
	
	downPanel_Trial1() {
		this.setTitle("쓰레드 연습");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new fstPanel());
		
		
		this.setVisible(true);
		
		
		System.out.println("메인메소드 작동");
	}
	

	
	public static void main(String[] args) {
		new downPanel_Trial1();
	}

}

class fstPanel extends JPanel {
	// 필드 선언란
	Random random = new Random();
	JLabel la;
	int P_W = this.getWidth();	//	int P_H = this.getHeight();
	int la_W = la.getWidth();	//	int la_H = la.getHeight();
	int randomX = random.nextInt(la_W, P_W-la_W);
	final int destinatedY = 200;
	
	
	fstPanel() {
		this.setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		
		fstThread th = new fstThread(randomX, destinatedY);
		th.start();
//		th.sleep(500);
			
		}
	
	class fstThread extends Thread {
		//필드 선언란
		
		fstThread(int x, int y) {

				la = new JLabel();
				la.setBackground(Color.red); la.setOpaque(true);
				la.setSize(25, 25);
				la.setLocation(50*x, 50*y);
				
				add(la);
		}
	
	}
	
}








