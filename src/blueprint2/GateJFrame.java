package blueprint2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GateJFrame extends JFrame {
	// ���⿡ �ʵ� ����
	private JPanel mainPanel;
	private JPanel gamePanelCommon;
	private JPanel gamePanelJava;
	private JPanel gamePanelPython;
	
	GateJFrame() {	// ������ ����		
		this.setTitle(("[�� ����] JAVA/python �н� ������"));
		int g_W = 1024;
		int g_H = 768;
		int estimated_TopbarSize = 37;
		int estimated_MenubarSize = 25;
		this.setSize(g_W+14, g_H + estimated_TopbarSize + estimated_MenubarSize);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// �̰� ������ ȭ�鿡�� ������� ������, �޸� �ݳ��� ���� ����. ��� �ݵ�� �����!		this.setSize(900, 600);
		
		mainPanel = new MainPanel();
//		gamePanelCommon = new GamePanelCommon();

		setContentPane(mainPanel);

		mainPanel.setVisible(true);
//		gamePage.setVisible(false);
		//��ư�� ���̽� ���� ���̽��� if�� ����, �������� �����ϸ� �� ��
		
	    this.setResizable(false); 			// ����ڰ� â�� ũ�⸦ �������� ���ϰ� ��
		this.setLocationRelativeTo(null);	// ȭ�� ���߾ӿ� ������
		this.setVisible(true);				// ȭ�鿡 ���̰� ����ּ���.
	}
	
	class MainPanel extends JPanel {
		// ���������� - �ȳ�����
		JLabel main_la = new JLabel("�н��� �� �����ϼ���");
		// ���������� - �ڹ� ��ư ���
		JButton main_j_btn = new JButton();						// ��ư����_�ڹ�
		JLabel main_j_la_img = new JLabel("�̹���_�ΰ�_JAVA.");
		JLabel main_j_la_txt = new JLabel(" JAVA");
		// ���������� - ���̽� ��ư ���
		JButton main_p_btn = new JButton();						// ��ư����_���̽�
		JLabel main_p_la_img = new JLabel("�̹���_�ΰ�_python");
		JLabel main_p_la_txt = new JLabel(" python");
		
		//�г� ������
		MainPanel() {
			setLayout(null);
			int g_W = 1024;
			int g_H = 768;
//			
			int main_la_W = 625;				int main_la_H = 150;
			int main_la_x = 512-(main_la_W/2);	int main_la_y = 96;
		    main_la.setFont(new Font("���� ���", Font.BOLD, 50));
		    main_la.setBounds(main_la_x, main_la_y, main_la_W, main_la_H);
		    main_la.setOpaque(true);	main_la.setBackground(Color.YELLOW);
		    main_la.setHorizontalAlignment(JLabel.CENTER);
		    

		    int brd_LR = (int)((g_W/2)/3);
		    int brd_LR2 = 80;
		    int brd_T = 70;		// int brd_T2 = 20;
		    
					
		    int btn_W = (g_W - (brd_LR+brd_LR2)*2);
		    int btn_H = 125;
		    int j_btn_x = brd_LR + brd_LR2;
		    int j_btn_y = (main_la_y+main_la_H)+brd_T;
			main_j_btn.setBounds(j_btn_x, j_btn_y, btn_W, btn_H);
			main_j_btn.setOpaque(false);	main_j_btn.setBackground(Color.RED);
		    main_j_btn.addActionListener(new btnActionJava());
			int p_btn_x = brd_LR + brd_LR2;
		    int p_btn_y = (g_H - (main_la_y+brd_T)) - btn_H;
		    main_p_btn.setBounds(p_btn_x, p_btn_y, btn_W, btn_H);
			main_p_btn.setOpaque(false);	main_p_btn.setBackground(Color.MAGENTA);
		    main_p_btn.addActionListener(new btnActionPython());
			
			int jp_la_txt = btn_H; 
		    main_j_la_txt.setFont(new Font("Source Sans Pro", Font.BOLD, 60));
		    main_j_la_txt.setBounds((brd_LR + brd_LR2) + jp_la_txt, (main_la_y+main_la_H)+brd_T, btn_W - jp_la_txt, btn_H);
		    main_j_la_txt.setOpaque(true);	main_j_la_txt.setBackground(Color.ORANGE);
		    main_j_la_txt.setHorizontalAlignment(JLabel.LEFT);
			main_p_la_txt.setFont(new Font("Consolas", Font.BOLD, 60));
		    main_p_la_txt.setBounds((brd_LR + brd_LR2) + jp_la_txt, (g_H - (main_la_y+brd_T)) - btn_H, btn_W - jp_la_txt, btn_H);
		    main_p_la_txt.setOpaque(true);	main_p_la_txt.setBackground(Color.BLUE);
		    main_p_la_txt.setHorizontalAlignment(JLabel.LEFT);
		    

		    int la_img_square = btn_H;		// j, p ���� ����; la_img_W, la_img_H ��Ÿ��
		    int j_la_img_x = j_btn_x;
		    int j_la_img_y = j_btn_y;
		    main_j_la_img.setBounds(j_la_img_x, j_la_img_y, la_img_square, la_img_square);
		    main_j_la_img.setOpaque(true);	main_j_la_img.setBackground(Color.PINK);
		    main_j_la_img.setHorizontalAlignment(JLabel.CENTER);
		    int p_la_img_x = p_btn_x;
		    int p_la_img_y = p_btn_y;
		    main_p_la_img.setBounds(p_la_img_x, p_la_img_y, la_img_square, la_img_square);
		    main_p_la_img.setOpaque(true);	main_p_la_img.setBackground(Color.YELLOW);
		    main_p_la_img.setHorizontalAlignment(JLabel.CENTER);


		    add(main_la);
		    add(main_j_btn);	add(main_p_btn);
		    add(main_j_la_img);	add(main_j_la_txt);	add(main_p_la_img);	add(main_p_la_txt);			
		    
		}
		
	    class btnActionJava implements ActionListener {
	    	@Override
			public void actionPerformed(ActionEvent e) {
	    		switchToGamePanelJava();
	    	}
	    }
		
		private void switchToGamePanelJava() {
			mainPanel.setVisible(false);
//	        gamePageJava.setVisible(true);
		}
		
	    class btnActionPython implements ActionListener {
	    	@Override
			public void actionPerformed(ActionEvent e) {
	    		switchToGamePanelPython();
	    	}
	    }
		
		private void switchToGamePanelPython() {
			mainPanel.setVisible(false);
//	        gamePagePython.setVisible(true);
		}
	
	}
	

	public static void main(String[] args) {
		new GateJFrame();			// ��ü ���� / ������ ���Ǹ� �ϸ� �ȵ˴ϴ�. ������ �ؾ���.
									// �̰� GUI �ڵ�, ���� �ַܼ� �ȶ߰� ������� ��ϴ�.
	}

}
