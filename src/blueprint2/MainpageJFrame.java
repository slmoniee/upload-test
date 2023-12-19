package blueprint2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainpageJFrame extends JFrame {
   // 여기에 필드 선언
   private JPanel mainPanel;
   private JPanel gamePanelJava, gamePanelPython;
   private JPanel gamePanelCommon;            // gamePanelJava, gamePanelPython 구현시 대치시킬 것.
   
   MainpageJFrame() {   // 생성자 정의      
      this.setTitle(("[세 얼간이] JAVA/python 학습 보조기"));
      int g_W = 1024;
      int g_H = 768;
      int estimatedTopbarSize = 37;
      int estimatedMenubarSize = 25;
      this.setSize(g_W+14, g_H + estimatedTopbarSize + estimatedMenubarSize);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 이게 없으면 화면에만 사라지고 끝이지, 메모리 반납을 하지 않음. 고로 반드시 해줘야!      this.setSize(900, 600);
      
      mainPanel = new MainPanel();
      setContentPane(mainPanel);
      mainPanel.setVisible(true);
      
       this.setResizable(false);          // 사용자가 창의 크기를 조절하지 못하게 함
      this.setLocationRelativeTo(null);   // 화면 정중앙에 생성됨
      this.setVisible(true);            // 화면에 보이게 띄워주세요.

////      ▼ TestCodeHere - - -
//      gamePanelCommon = new GamePanelCommon();
//      gamePage.setVisible(false);
      //버튼별 케이스 바이 케이스로 if문 삽입, 컨텐츠팬 선택하면 될 듯
      
      
////      ▲ TestCodeHere - - -
   
   }
   
   class MainPanel extends JPanel {
      int g_W = 1024;
      int g_H = 768;

      JLabel greetingText = new JLabel("학습할 언어를 선택하세요");
      JButton btnJava = new JButton();      // 버튼영역_자바
      JLabel btnImgJava = new JLabel("이미지_로고_JAVA.");
      JLabel btnTextJava = new JLabel(" JAVA");
      JButton btnPython = new JButton();      // 버튼영역_파이썬
      JLabel btnImgPython = new JLabel("이미지_로고_python");
      JLabel btnTextPython = new JLabel(" python");
      
//      ▼ 패널 생성자
      MainPanel() {
         setLayout(null);
         
         int borderBuffer_T = 70;      // int borderBuffer_T2 = 20;
          int borderBuffer_LR = (int)((g_W/2)/3);
          int borderBuffer_LR2 = 80;
          int greetingText_W = 625;                           int greetingText_H = 150;
         int btn_W = (g_W - (borderBuffer_LR+borderBuffer_LR2)*2);   int btn_H = 125;
         int greetingText_x = 512-(greetingText_W/2);            int greetingText_y = 96;
         int btnJava_x = borderBuffer_LR + borderBuffer_LR2;          int btnJava_y = (greetingText_y+greetingText_H)+borderBuffer_T;
          int btnPython_x = borderBuffer_LR + borderBuffer_LR2;       int btnPython_y = (g_H - (greetingText_y+borderBuffer_T)) - btn_H;
          
          greetingText.setFont(new Font("맑은 고딕", Font.BOLD, 50));
          greetingText.setBounds(greetingText_x, greetingText_y, greetingText_W, greetingText_H);
          greetingText.setOpaque(true);   greetingText.setHorizontalAlignment(JLabel.CENTER);
          btnJava.setBounds(btnJava_x, btnJava_y, btn_W, btn_H);
         btnJava.setOpaque(false);   btnJava.setContentAreaFilled(false);
         btnJava.addActionListener(new btnActionJava());
         btnJava.setBackground(Color.RED);
         btnPython.setBounds(btnPython_x, btnPython_y, btn_W, btn_H);
         btnPython.setOpaque(false);   btnPython.setContentAreaFilled(false);
          btnPython.addActionListener(new btnActionPython());
          btnPython.setBackground(Color.MAGENTA);
          btnTextJava.setFont(new Font("Source Sans Pro", Font.BOLD, 60));
          btnTextJava.setBounds((borderBuffer_LR + borderBuffer_LR2) + btn_H, (greetingText_y+greetingText_H)+borderBuffer_T, btn_W - btn_H, btn_H);
          btnTextJava.setOpaque(true);   btnTextJava.setBackground(Color.ORANGE);
          btnTextJava.setHorizontalAlignment(JLabel.LEFT);
         btnTextPython.setFont(new Font("Consolas", Font.BOLD, 60));
          btnTextPython.setBounds((borderBuffer_LR + borderBuffer_LR2) + btn_H, (g_H - (greetingText_y+borderBuffer_T)) - btn_H, btn_W - btn_H, btn_H);
          btnTextPython.setOpaque(true);   btnTextPython.setBackground(Color.BLUE);
          btnTextPython.setHorizontalAlignment(JLabel.LEFT);
          btnImgJava.setBounds(btnJava_x, btnJava_y, btn_H, btn_H);
          btnImgJava.setOpaque(true);      btnImgJava.setHorizontalAlignment(JLabel.CENTER);
          btnImgJava.setBackground(Color.PINK);
          btnImgPython.setBounds(btnPython_x, btnPython_y, btn_H, btn_H);
          btnImgPython.setOpaque(true);   btnImgPython.setHorizontalAlignment(JLabel.CENTER);
          btnImgPython.setBackground(Color.YELLOW);

          add(greetingText);
          add(btnJava);   add(btnPython);
          add(btnImgJava);   add(btnTextJava);   add(btnImgPython);   add(btnTextPython);         
          
      }
      
       class btnActionJava implements ActionListener {
          @Override
         public void actionPerformed(ActionEvent e) {
             switchToGamePanelJava();            }
       }
      
      class btnActionPython implements ActionListener {
          @Override
         public void actionPerformed(ActionEvent e) {
             switchToGamePanelPython();            }
       }
      private void switchToGamePanelJava() {
         mainPanel.setVisible(false);
//           gamePageJava.setVisible(true);
      }
      private void switchToGamePanelPython() {
         mainPanel.setVisible(false);
//           gamePagePython.setVisible(true);
      }
   
   }
   

   public static void main(String[] args) {
      new MainpageJFrame();         // 객체 생성 / 생성자 정의만 하면 안됩니다. 생성을 해야죠.
                           // 이게 GUI 코딩, 이제 콘솔로 안뜨고 윈도우로 뜹니다.
   }

}