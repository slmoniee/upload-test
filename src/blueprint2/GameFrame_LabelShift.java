// [2023-12-11 20:15 Code - GameFrame_LabelShift.java]

package blueprint2;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameFrame_LabelShift extends JFrame {

	private JPanel GamePanelCommon;

//	WordList WL_inst = new WordList();
	
	GameFrame_LabelShift() {	// 생성자 정의
		this.setTitle(("[세 얼간이] 게임 진행"));
		int g_W = 1024;
		int g_H = 768;
		int estimated_TopbarSize = 37;
		int estimated_MenubarSize = 25;
		this.setSize(g_W+14, g_H + estimated_TopbarSize + estimated_MenubarSize);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 이게 없으면 화면에만 사라지고 끝이지, 메모리 반납을 하지 않음. 고로 반드시 해줘야!		this.setSize(900, 600);

		GamePanelCommon = new GamePanelCommon();

		setContentPane(GamePanelCommon);
		
		GamePanelCommon.setVisible(true);
			
		
	    roomMenu();
		
	    this.setResizable(false); 			// 사용자가 창의 크기를 조절하지 못하게 함
		this.setLocationRelativeTo(null);	// 화면 정중앙에 생성됨
		this.setVisible(true);				// 화면에 보이게 띄워주세요.
		
	}
	
	class GamePanelCommon extends JPanel {
		int g_W = 1024;
		int g_H = 768;
		// 필요한 컴포넌트 선언할 것
		JLabel room_deadline_la = new JLabel("- - - - -");
		JLabel room_bottom_la = new JLabel("하단 상태바 영역");
		JLabel room_answerBox_la = new JLabel("정답란 전체영역");
		JTextField room_answerBox_TF = new JTextField(/*"(입력대기중)", */10);
		JLabel room_clockBox_la = new JLabel("시계부착영역");
		JLabel room_clock_txt = new JLabel("경과 시간 : ");
		JLabel room_clock_ticking = new JLabel();			// 시계 쓰레드 삽입 요망
		JLabel room_scoreBox_la = new JLabel("점수부착영역");
		
		// 게임 결과 요약창
//		JPanel room_smrPanel = new JPanel();	// smr = summary
//		JLabel smrPanel_Title = new JLabel("게임 요약");
		
		
		
		
		
		// 여기에 테스트 코드 삽입하세요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//		    /*		
        WordList WordListJavaInstance = new WordList();			// `WordList` 클래스의 인스턴스를 생성합니다.
        ArrayList<String> wordListJavaShuffled = WordListJavaInstance.getWordList();
        // `WordList` 클래스의 `getWordList` 메소드를 통해 '혼합된' 단어 목록을 가져옵니다.
        
        int wordSizeJava = wordListJavaShuffled.size();		// 단어 목록의 크기를 가져옵니다.
        JLabel[] quizJava_la = new JLabel[wordSizeJava];	// 배열을 사용하여 라벨을 생성
        

        
        

			
        
        
        
        
		GamePanelCommon() {
			setLayout(null);
//			int g_W = 1024;
//			int g_H = 768;
			
			int death_y = g_H - 120;		// 단어 삭제 좌표 저장
			room_deadline_la.setBounds(0,death_y , g_W, 10);
			
			room_deadline_la.setOpaque(true);	room_deadline_la.setBackground(Color.RED);	
			room_deadline_la.setHorizontalAlignment(JLabel.CENTER);
			
			
			int bottom_la_H = 60;
			room_bottom_la.setBounds(0,g_H - bottom_la_H, g_W, bottom_la_H);
			room_bottom_la.setOpaque(true);	room_bottom_la.setBackground(Color.LIGHT_GRAY);	
			room_bottom_la.setHorizontalAlignment(JLabel.CENTER);
			int bottom_gap4LR = 15;
			int clockBox_W = 280; /* = answrBox_W; */
			int clockBox_H = 50;  /* = answrBox_H; */
			int clockBox_x = 0 + bottom_gap4LR;
			int clockBox_y = (g_H - bottom_la_H) + (bottom_la_H - clockBox_H)/2;
			room_clockBox_la.setBounds(clockBox_x, clockBox_y, clockBox_W, clockBox_H);
			room_clockBox_la.setOpaque(true);	room_clockBox_la.setBackground(Color.PINK);	
			room_clockBox_la.setHorizontalAlignment(JLabel.CENTER);
			int scoreBox_W = 280; /* = answrBox_W; */
			int scoreBox_H = 50;  /* = answrBox_H; */
			int scoreBox_x = (g_W - scoreBox_W) - bottom_gap4LR;
			int scoreBox_y = (g_H - bottom_la_H) + (bottom_la_H - scoreBox_H)/2;
			room_scoreBox_la.setBounds(scoreBox_x, scoreBox_y, scoreBox_W, scoreBox_H);
			room_scoreBox_la.setOpaque(true);	room_scoreBox_la.setBackground(Color.PINK);	
			room_scoreBox_la.setHorizontalAlignment(JLabel.CENTER);
			
			int bottom_gap4clockBoxLeftWall = 15;
			int clockBox_txtLength = 40;				// 미사용변수; 향후 시계 스레드 추가시 참조할 것
			int clockTXT_x = clockBox_x + bottom_gap4clockBoxLeftWall;
			int clockTXT_y = clockBox_y;
			int clockTXT_W = 85;
			int clockTXT_H = clockBox_H - 0;
			room_clock_txt.setBounds(clockTXT_x, clockTXT_y, clockTXT_W,clockTXT_H);
			room_clock_txt.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			room_clock_txt.setOpaque(true);	room_clock_txt.setBackground(Color.GREEN);		
			room_clock_txt.setHorizontalAlignment(JLabel.LEFT);

			int answrBox_W = 280;					int answrBox_H = 50;
			int answrBox_x = g_W/2 - answrBox_W/2;	int answrBox_y = (g_H - bottom_la_H) + (bottom_la_H - answrBox_H)/2;
			room_answerBox_la.setBounds(answrBox_x, answrBox_y, answrBox_W, answrBox_H);
			room_answerBox_la.setOpaque(true);	room_answerBox_la.setBackground(Color.WHITE);	
			room_answerBox_la.setHorizontalAlignment(JLabel.CENTER);
			int answrBox_txtLength = 40 - 40;
			int bottom_gap4answrBoxLeftWall = 15 * 2;
			int answrTF_W = answrBox_W - (answrBox_txtLength + bottom_gap4answrBoxLeftWall*2 );
			int answrTF_H = answrBox_H - 0;
			int answrTF_x = answrBox_x + answrBox_txtLength + bottom_gap4answrBoxLeftWall;
			int answrTF_y = answrBox_y;
//			int answrTF_x = g_W/2 - answrTF_W/2;	int answrTF_y = (g_H - bottom_la_H) + (bottom_la_H - answrBox_H)/2;
			room_answerBox_TF.setBounds(answrTF_x, answrTF_y, answrTF_W, answrTF_H);
			room_answerBox_TF.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			room_answerBox_TF.setOpaque(false);	room_answerBox_TF.setBackground(Color.MAGENTA);
//			room_answerBox_TF.setOpaque(true);	room_answerBox_TF.setBackground(Color.ORANGE);	
		   
			

			
			
		    add(room_deadline_la);
			add(room_answerBox_TF);		add(room_answerBox_la);
		    add(room_clock_txt);		add(room_clockBox_la);	
		    add(room_scoreBox_la);
		    add(room_bottom_la);
	
			
			
			
			
//			int smr_W = g_W * 2/3;
//			int smr_H = g_H * 3/5;
//			int smr_x = (g_W - smr_W) /2;
//			int smr_y = (g_H - smr_H) /2 - bottom_la_H;		// '하단 라벨바 제외한 영역'의 중간지점 위치하도록
//			room_smrPanel.setLayout(new BorderLayout());
//			room_smrPanel.setBounds(smr_x, smr_y, smr_W, smr_H);
////			room_smrPanel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//			room_smrPanel.setOpaque(true);		room_smrPanel.setBackground(Color.MAGENTA);
//			
//			int smrPanel_NthCPsize_W =  0;
//			int smrPanel_NthCPsize_H =  100;
//			smrPanel_Title.setPreferredSize(new Dimension(smrPanel_NthCPsize_W, smrPanel_NthCPsize_H));  // JLabel의 크기를 조절; BorderLayout에서 컴포넌트의 크기를 조절을 통해 특정 영역의 크기를 간접적으로 제어 
//			smrPanel_Title.setFont(new Font("맑은 고딕", Font.BOLD, 45));
//			smrPanel_Title.setOpaque(true);		smrPanel_Title.setBackground(Color.YELLOW);
//			smrPanel_Title.setHorizontalAlignment(JLabel.CENTER);
//			smrPanel_Title.setVerticalAlignment(JLabel.CENTER);
//			room_smrPanel.add(smrPanel_Title, BorderLayout.NORTH);
//			add(room_smrPanel);

//			room_smrPanel.setVisible(false);
		    
		    
		    
		    
		    
            
            
            

            
            
		    // RandomLabelJava 클래스의 인스턴스 생성
		    RandomLabelJava randomLabelJavaInstance = new RandomLabelJava();
		    randomLabelJavaInstance.createThreads();		     // createThreads 메서드 호출

            
            
        	
		}
		// ▲ GamePanelCommon 패널 '생성자' 끝
		

    	int startY = 20;		// 시작점 높이 지정
		
		// ▣ GamePanelCommon 패널 '생성자' 외부
    	// ▼ 단어라벨 생성 위한 [RandomLabelJava] 클래스 생성    
        class RandomLabelJava {
        	// 필요한 필드 선언
        	int la_W;				// ????? : private 써야해?
        	int la_H = 25;
//        	int threadSize = 10;		// 테스트용 임시 크기 지정
    		int threadSize = wordSizeJava;			// 				  	 스레드 개수 = 라벨 개수 = 단어 개수
//        	int startY = 20;		// 시작점 높이 지정
        	int ascendingY;
        	int ascendingGap = 25 * 2;		// 25 = la_H; > LabelThread 클래스에서 사용하는 필드 값
    		Random random = new Random();
        	int[] randomX = new int[threadSize];	// 무작위 X좌표 배열 (크기:스레드 개수)
    		LabelThread javaLabel_th[] = new LabelThread[threadSize];	// 스레드 이름 후보 : labelThreadJava
    
    		// ▼ [RandomLabelJava] 생성자 생성
        	RandomLabelJava() {
        		
        	}
        	
        	// ▼ 스레드 생성을 별도의 '메서드'로 분리하여 수행 (이전 : RandomLabelJava 클래스의 생성자에서 스레드 생성)
        	public void createThreads() {
        		for(int i=0; i < threadSize; i++) {
        			int javaLabelIndex = i;
        			String javaWord = wordListJavaShuffled.get(i);	// ArrayList 'wordListJavaShuffled'에서 인덱스별 단어 갖고와서 저장하기.
        			int javaWordLength = javaWord.length();
        			
        			if (javaWordLength >= 10) {
        				la_W = 120;// 라벨 사이즈 지정 > 매개변수로 넣기 등
        				System.out.println("TextLength : " + javaWordLength + ". LabelWidth : " + la_W + ".");
        			}
        			else if (javaWordLength >= 5) {
        				la_W = 100;
        				System.out.println("TextLength : " + javaWordLength + ". LabelWidth : " + la_W + ".");
        			}
        			
        			randomX[i] = random.nextInt(0, g_W-la_W);	// 랜덤 x좌표 발생 범위 : 단어라벨 여백 제외한 화면 가로영역
        			ascendingY = startY - ascendingGap * i;
        			
        			javaLabel_th[i] = new LabelThread(randomX[i], ascendingY, javaWord, javaLabelIndex, la_W, la_H);		// 라벨 x좌표, y좌표, 일련번호 매개변수에 입력
        			javaLabel_th[i].start();
        		
        		}
        	}
        	
        	
        	
        }
        // ▲ 단어라벨 생성 위한 [RandomLabelJava] 클래스 끝
        // ▣ GamePanelCommon 패널 '클래스' 내부
		
		
		// ▼ GamePanelCommon 패널 '클래스' 내부
		// ▼▼ ______용 [LabelThread]클래스, []클래스 在
		class LabelThread extends Thread {
			
			private int X, Y;
			private String word;
			private int labelIndex, labelIDnumber;
			int la_W, la_H;
			
			int downSpeed = 3;
			int downInterval = 1000 / 20;	// sleepTime - ms(밀리초)
			int deathLine = 700;
						
			LabelThread(int P_x, int P_y, String P_word, int P_labelIndex, int labelWidth, int labelHeight) {
				X = P_x;
				Y = P_y;
				word = P_word;
				labelIndex = P_labelIndex;
				labelIDnumber = P_labelIndex + 1;
				la_W = labelWidth;
				la_H = labelHeight;
				

				quizJava_la[labelIndex] = new JLabel(word);
				quizJava_la[labelIndex].setBounds(X, Y, la_W,la_H);
				quizJava_la[labelIndex].setFont(new Font("맑은 고딕", Font.BOLD, 15));
				quizJava_la[labelIndex].setOpaque(true);	quizJava_la[labelIndex].setBackground(Color.GREEN);		
				quizJava_la[labelIndex].setHorizontalAlignment(JLabel.CENTER);
				add(quizJava_la[labelIndex]);  // 생성된 라벨을 패널에 추가하는 부분
				
				
				

				
				
				
//				repaint();
				
				System.out.println(labelIDnumber + " label has created logically");
			}
			
			@Override
		    public void run() {
//				System.out.println(NUM + "번 생성자 생성 완료.");
//		        System.out.println(NUM + "번 쓰레드 X 좌표값 : " + X);
//		        System.out.println(NUM + "번 쓰레드 Y 좌표값 : " + Y);
				
				
		        while(true) {
					int var_x = X;
					int var_y = Y + downSpeed;
					// 좌표값 업데이트
			        X = var_x;
			        Y = var_y;
			        
			        quizJava_la[labelIndex].setLocation(X, Y);
					
			        
			        
			        
			        
//			        System.out.println(labelID + "번 쓰레드 Y 좌표값 : " + var_y);
//					System.out.println(NUM + "번 쓰레드 X 좌표값 : " + var_x);
			        
			        try {sleep(downInterval);
			        } catch(InterruptedException e) {
//		                removeFromPanel();
			        	return;
			        }
				}
		    }
			
			
		}
		// ▲ 단어라벨 생성용 [LabelThread]클래스 끝
		// ▣ GamePanelCommon 패널 '클래스' 내부
		
		
		
		
		
		
		           
		
		
		
		
	}
	// ▲ GamePanelCommon 패널 '클래스' 끝
	
	// ▼ 최외각 [GameFrame_CreateWords] 프레임 내부
	// ▼▼ 메뉴용 [roomMenu] ---, [main] 메소드 在
	
	
	
	
	
	//메뉴 생성
	void roomMenu() {						// reference) JP_1103 - D_ch10_Ex02.java
		JMenuBar mb = new JMenuBar();
		JMenu [] menu = new JMenu[2];
		String[] menuTitle = {"게임 선택", "게임 진행"};
		// mb(메뉴바)에 menu[0, 1] 등록하는 반복문
		for (int i=0; i<menu.length; i++ ) {
			menu[i] = new JMenu(menuTitle[i]);
			mb.add(menu[i]);
		}
		
		JMenuItem[] menuItem_slct = new JMenuItem[2];
		String[] itemTitle_slct = { "JAVA", "python"};
	    // menu[0] 에 메뉴아이템 등록하는 반복문
		for (int i=0; i<menuItem_slct.length; i++ ) {
			menuItem_slct[i] = new JMenuItem(itemTitle_slct[i]);
			menu[0].add(menuItem_slct[i]);
		}
		
		JMenuItem[] menuItem_ctrl = new JMenuItem[3];
		String[] itemTitle_ctrl = { "첫 화면으로", "일시정지 / 재개", "지금 끝내기"};
		// 추가고려 : 난이도 조절 (현재 : #) > 난이도 상승/하락; 하강률 조절로 해결\
		// menu[1] 에 메뉴아이템 등록하는 반복문
		for (int i=0; i<menuItem_ctrl.length; i++ ) {
			menuItem_ctrl[i] = new JMenuItem(itemTitle_ctrl[i]);
			menu[1].add(menuItem_ctrl[i]);
			if(i==1) {
				menu[1].addSeparator();
			}
		}
		setJMenuBar(mb);
	}

	// GPT가 간소화해준 코드
	/*
	void roomMenu() {
	    JMenuBar mb = new JMenuBar();
	    JMenu[] menu = new JMenu[2];
	    String[] menuTitle = {"게임 선택", "게임 진행"};

	    for (int i = 0; i < menu.length; i++) {
	        menu[i] = new JMenu(menuTitle[i]);
	        mb.add(menu[i]);

	        JMenuItem[] menuItem;
	        String[] itemTitle;

	        // 메뉴 아이템 설정
	        if (i == 0) {
	            menuItem = new JMenuItem[2];
	            itemTitle = new String[]{"JAVA", "python"};
	        } else {
	            menuItem = new JMenuItem[3];
	            itemTitle = new String[]{"첫 화면으로", "일시정지 / 재개", "지금 끝내기"};
	        }

	        // 메뉴에 메뉴 아이템 등록
	        for (int j = 0; j < menuItem.length; j++) {
	            menuItem[j] = new JMenuItem(itemTitle[j]);
	            menu[i].add(menuItem[j]);
	            if (i == 1 && j == 1) {
	                menu[i].addSeparator();
	            }
	        }
	    }

	    setJMenuBar(mb);
	}
	*/
	
	// 메뉴 액션리스너 등록 참고
/*
	void roomMenu() {							// reference) JP_1103 - C_MenuEventEx.java
		JMenuBar mb = new JMenuBar();		// �޴��� ����
		JMenu selectMenu = new JMenu("게임 선택");
		JMenuItem[] s_menuItem = new JMenuItem[2];
		String[] itemTitle = {"JAVA", "python"};
		
//		MenuAction listener = new MenuAction();
//		for (int i=0; i<s_menuItem.length; i++ ) {
//			s_menuItem[i] = new JMenuItem(itemTitle[i]);
//			s_menuItem[i].addActionListener(listener);
//			selectMenu.add(s_menuItem[i]);
//						
//		}
		mb.add(selectMenu);
		setJMenuBar(mb);		// �޴��ٸ� �����ӿ� ����
	}
//	class MenuAction implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String cmd = e.getActionCommand();
//			switch(cmd) {	// �޴� �������� ���� ����
//			case "Load":
//				//�̹� �ε��Ǿ����� ����
//				if(imgLabel.getIcon() != null)
//					return;
//				imgLabel.setIcon(new ImageIcon("images/img0.jpg"));
//				break;
//			case "Hide":
//				imgLabel.setVisible(false);
//				break;
//			case "ReShow":
//				imgLabel.setVisible(true);
//				break;
//			case "Exit":
//				System.exit(0);
//				break;
//			}
//			
//		}
//	}
 */
	

	public static void main(String[] args) {
		new GameFrame_LabelShift();			// 객체 생성 (생성자 정의만 하면 안됩니다. 생성을 해야죠.)
									
	}

}
