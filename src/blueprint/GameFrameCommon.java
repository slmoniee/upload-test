// [매개변수 미삽입 코드 백업]

// [2023-12-13 20:10 Code - GameFrameCommon.java]
// GameFrame_Decoupling3.java > GameFrameCommon.java
//Work With [GamePanelJava]

package blueprint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrameCommon extends JFrame {

   private JPanel GamePanelCommon;
//   private JMenuItem pauseResumeMenuItem;
   private JMenuItem gameRestartMenuItem;
//   TransparentPanel TransparentPanel = new TransparentPanel();
//   NewGamePanelJava2 NewGamePanelJava2 = new NewGamePanelJava2();

   public GameFrameCommon() { // 생성자 정의
      this.setTitle(("[세 얼간이] JFrame 유지, JPanel 변경 방식"));
      int g_W = 1024;
      int g_H = 768;
      int estimated_TopbarSize = 37;
      int estimated_MenubarSize = 25;
      this.setSize(g_W + 14, g_H + estimated_TopbarSize + estimated_MenubarSize);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이게 없으면 화면에만 사라지고 끝이지, 메모리 반납을 하지 않음. 고로 반드시 해줘야!
                                                // this.setSize(900, 600);
      roomMenu();
      
      GamePanelCommon = new GamePanelCommon();
      setContentPane(GamePanelCommon);
      GamePanelCommon.setVisible(true);
      
      GamePanelJava NewGamePanelJava2 = new GamePanelJava();
      add(NewGamePanelJava2);
      NewGamePanelJava2.setVisible(true);
      
      this.setResizable(false); // 사용자가 창의 크기를 조절하지 못하게 함
      this.setLocationRelativeTo(null); // 화면 정중앙에 생성됨
      this.setVisible(true); // 화면에 보이게 띄워주세요.
      
      
      // 메뉴바랑 등등 다 설정.
   }

   class GamePanelCommon extends JPanel {
      int g_W = 1024;
      int g_H = 768;

      GamePanelCommon() {
         setLayout(null); // int g_W = 1024; int g_H = 768;
      }

   }
   // ▲ GamePanelCommon 패널 '클래스' 끝

   // ▼ 최외각 [GameFrame_Decoupling2.java] 프레임 내부

   // 메뉴 생성
   void roomMenu() { // reference) JP_1103 - D_ch10_Ex02.java
      JMenuBar mb = new JMenuBar();
      JMenu[] menu = new JMenu[2];
      String[] menuTitle = { "게임 선택", "게임 진행" };
      // mb(메뉴바)에 menu[0, 1] 등록하는 반복문
      for (int i = 0; i < menu.length; i++) {
         menu[i] = new JMenu(menuTitle[i]);
         mb.add(menu[i]);
      }

      JMenuItem[] menuItem_slct = new JMenuItem[2];
      String[] itemTitle_slct = { "JAVA", "python" };
      // menu[0] 에 메뉴아이템 등록하는 반복문
      for (int i = 0; i < menuItem_slct.length; i++) {
         menuItem_slct[i] = new JMenuItem(itemTitle_slct[i]);
         menu[0].add(menuItem_slct[i]);
      }

      JMenuItem[] menuItem_ctrl = new JMenuItem[3];
//      String[] itemTitle_ctrl = { "첫 화면으로", "일시정지 / 재개", "지금 끝내기" };
      String[] itemTitle_ctrl = { "첫 화면으로", "게임 재시작", "지금 끝내기" };
      // 추가고려 : 난이도 조절 (현재 : #) > 난이도 상승/하락; 하강률 조절로 해결\
      // menu[1] 에 메뉴아이템 등록하는 반복문
      for (int i = 0; i < menuItem_ctrl.length; i++) {
         menuItem_ctrl[i] = new JMenuItem(itemTitle_ctrl[i]);
         menu[1].add(menuItem_ctrl[i]);
         if (i == 1) {
            menu[1].addSeparator();
         }
      }

//      pauseResumeMenuItem = menuItem_ctrl[1]; // '일시정지 / 재개' 메뉴아이템 설정
//      pauseResumeMenuItem.addActionListener(pauseResumeActionListener); // 액션 리스너 등록

      ////   ----- ▼ 테스트 코드 영역   
      
      gameRestartMenuItem = menuItem_ctrl[1]; // '게임 재시작' 메뉴아이템 설정
      gameRestartMenuItem.addActionListener(gameRestartActionListener); // 액션 리스너 등록
      
      menuItem_ctrl[2].addActionListener(exitActionListener);
////   ----- ▲ 테스트 코드 영역

      setJMenuBar(mb);
   }

////----- ▼ 테스트 코드 영역   

//   // menu[1] - menuItem_ctrl[1] 위한 새로운 ActionListener를 생성
//   private ActionListener pauseResumeActionListener = new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//         togglePauseResume();
//      }
//   };
//
//   // menu[1] - menuItem_ctrl[1] 의 일시정지 및 재개를 토글하는 메소드
//   private void togglePauseResume() {
//      if (pauseResumeMenuItem.getText().equals("일시정지 / 재개")) {
//         pauseResumeMenuItem.setText("재개");
//         // 게임 일시정지 로직 추가 (일시정지 상태에서는 특정 동작을 멈추거나 처리)
//
//      }
////        else if (pauseResumeMenuItem.getText().equals("재개")) {
////            pauseResumeMenuItem.setText("일시정지");
////            // 게임 재개 로직 추가 (재개 상태에서는 멈춰있던 동작을 다시 시작)
////            
////        } 
//      else {
//         pauseResumeMenuItem.setText("일시정지");
//         // 게임 재개 로직 추가 (재개 상태에서는 멈춰있던 동작을 다시 시작)
////         
//
////         // 기존 패널을 제거
////         Container contentPane = getContentPane();
////         contentPane.remove(this);
////
////         // 새로운 TransparentPanel 생성 및 추가
////         TransparentPanel newPanel = new TransparentPanel();
////         contentPane.add(newPanel);
////
////         // 패널 제거 후 컴포넌트를 다시 배치하도록 갱신
////         validate();
////         repaint();
//
//         // 기존 패널을 비워두기
//         getContentPane().removeAll();
//
//         // 새로운 TransparentPanel 생성 및 추가
//          NewGamePanelJava2 newPanel = new NewGamePanelJava2();
//          getContentPane().add(newPanel);
//
//         // 변경된 패널을 보여주기
//         revalidate();
//         repaint();
//      }
//   }
   
   // menu[1] - menuItem_ctrl[1] 위한 새로운 ActionListener를 생성
   private ActionListener gameRestartActionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         gameRestart();
      }
   };

   // menu[1] - menuItem_ctrl[1] 의 '재시작'를 토글하는 메소드
   private void gameRestart() { // 기존 패널을 비워두기
      getContentPane().removeAll();

      // 새로운 TransparentPanel 생성 및 추가
      GamePanelJava newPanel = new GamePanelJava();
      getContentPane().add(newPanel);

      // 변경된 패널을 보여주기
      revalidate();
      repaint();
   }


   // menu[1] - menuItem_ctrl[2] "지금 끝내기" 메뉴 아이템에 대한 ActionListener
   private ActionListener exitActionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         int result = JOptionPane.showConfirmDialog(GameFrameCommon.this, "게임을 종료하시겠습니까?", "게임 종료",
               JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.YES_OPTION) {
            // 사용자가 확인을 누르면 프레임 종료
            dispose();
            System.exit(0);
         }
      }
   };

////----- ▲ 테스트 코드 영역

   public static void main(String[] args) {
      new GameFrameCommon(); // 객체 생성 (생성자 정의만 하면 안됩니다. 생성을 해야죠.)

   }

}