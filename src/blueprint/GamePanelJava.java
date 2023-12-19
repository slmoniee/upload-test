// [매개변수 미삽입 코드 백업]

// [2023-12-13 20:10 Code - GamePanelJava.java]
// MainpageJFrame.java > GamePanelJava.java
//Being Attached on [GameFrameCommon.java]

package blueprint;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanelJava extends JPanel {
   int g_W = 1024;
   int g_H = 768;
   int death_y = g_H - 150; // 단어 삭제 좌표 저장
   // 필요한 컴포넌트 선언할 것
   JLabel gameUnderbarLabel = new JLabel("하단 상태바 영역");
   JLabel gameDeathYLabel = new JLabel("- - - - -");
   JLabel underbarClockboxLabel = new JLabel("시계부착영역");
   JLabel underbarAnswerboxLabel = new JLabel("정답란 전체영역");
   JLabel underbarScoreboxLabel = new JLabel("점수부착영역");

   JLabel clockboxTextLabel = new JLabel("경과 시간 : ");
   JLabel clockboxThreadLabel = new JLabel(); // 시계 쓰레드 삽입 요망
   JTextField answerboxTextField = new JTextField(/* "(입력대기중)", */10);

   WordListDecoupling WordListJavaInstance = WordListDecoupling.getInstance(); // `WordList` 클래스의 인스턴스를 생성합니다.
   List<String> wordListJavaShuffled;
  
//   WordList_Decoupling WordListPythonInstance = new WordList_Decoupling(); // `WordList` 클래스의 인스턴스를 생성합니다.
//   ArrayList<String> wordListPythonShuffled = WordListPythonInstance.getWordListPython();
   // `WordList` 클래스의 `getWordListPython` 메소드를 통해 '혼합된' 단어 목록을 가져옵니다.

   int wordSizeJava; // 단어 목록의 크기를 가져옵니다.
   JLabel[] quizLabelJava; // 배열을 사용하여 라벨을 생성
//   int wordSizePython = wordListJavaShuffled.size();
//   JLabel[] quizLabelPython = new JLabel[wordSizePython];

   GamePanelJava() {
	  this.wordListJavaShuffled = WordListJavaInstance.getWordList();
	  this.wordSizeJava = wordListJavaShuffled.size();
	  this.quizLabelJava = new JLabel[wordSizeJava];
      this.setLayout(null); // int g_W = 1024; int g_H = 768;
      //// ----- ▼ 테스트 코드 영역

      int g_W = 1024;
      int g_H = 768;
      int estimated_TopbarSize = 37;
      int estimated_MenubarSize = 25;
      this.setBounds(0, 0, g_W + 14, g_H + estimated_TopbarSize + estimated_MenubarSize);

      this.setOpaque(false);
//      this.setBackground(new Color(0, 0, 0, 255)); // 백그라운드 투명
//      setUndecorated(true);
//      출처: https://tikcode.tistory.com/18 [TikLog:티스토리]

      //// ----- ▲ 테스트 코드 영역

      int underbar_H = 60;
      int underbarBufferSize = 15;

      gameDeathYLabel.setBounds(0, death_y, g_W, 10);
      gameDeathYLabel.setOpaque(true);
      gameDeathYLabel.setHorizontalAlignment(JLabel.CENTER);
      gameDeathYLabel.setBackground(Color.RED);
      gameUnderbarLabel.setBounds(0, g_H - underbar_H, g_W, underbar_H);
      gameUnderbarLabel.setOpaque(true);
      gameUnderbarLabel.setHorizontalAlignment(JLabel.CENTER);
      gameUnderbarLabel.setBackground(Color.LIGHT_GRAY);

      int boxWidth = 280;
      int boxHeight = 50;
      int clockBox_W = boxWidth;
      int clockBox_H = boxHeight;
      int answrBox_W = boxWidth;
      int answrBox_H = boxHeight;
      int scoreBox_W = boxWidth;
      int scoreBox_H = boxHeight;
      int clockBox_x = 0 + underbarBufferSize;
      int clockBox_y = (g_H - underbar_H) + (underbar_H - clockBox_H) / 2;
      int answrBox_x = g_W / 2 - answrBox_W / 2;
      int answrBox_y = (g_H - underbar_H) + (underbar_H - answrBox_H) / 2;
      int scoreBox_x = (g_W - scoreBox_W) - underbarBufferSize;
      int scoreBox_y = (g_H - underbar_H) + (underbar_H - scoreBox_H) / 2;
      underbarClockboxLabel.setBounds(clockBox_x, clockBox_y, clockBox_W, clockBox_H);
      underbarClockboxLabel.setOpaque(true);
      underbarClockboxLabel.setHorizontalAlignment(JLabel.CENTER);
      underbarClockboxLabel.setBackground(Color.PINK);
      underbarAnswerboxLabel.setBounds(answrBox_x, answrBox_y, answrBox_W, answrBox_H);
      underbarAnswerboxLabel.setOpaque(true);
      underbarAnswerboxLabel.setHorizontalAlignment(JLabel.CENTER);
      underbarAnswerboxLabel.setBackground(Color.WHITE);
      underbarScoreboxLabel.setBounds(scoreBox_x, scoreBox_y, scoreBox_W, scoreBox_H);
      underbarScoreboxLabel.setOpaque(true);
      underbarScoreboxLabel.setHorizontalAlignment(JLabel.CENTER);
      underbarScoreboxLabel.setBackground(Color.PINK);

      int clockboxBufferSize = 15;
      int answrboxBufferSize = clockboxBufferSize * 2;
//      int clockBoxTextLength = 40;   // 미사용변수; 향후 시계 스레드 추가시 참조할 것
      int answrBoxtTextLength = 0; // 0 = 40 - 40;
      int clockText_W = 85;
      int clockText_H = clockBox_H - 0;
      int clockThread_W = 85;
      int clockThread_H = clockBox_H - 0;
      int answrTextfield_W = answrBox_W - (answrBoxtTextLength + answrboxBufferSize * 2);
      int answrTextfield_H = answrBox_H - 0;
      int clockText_x = clockBox_x + clockboxBufferSize / 2;
      int clockText_y = clockBox_y;
      int clockThread_x = clockText_x + clockText_W + clockboxBufferSize;
      int clockThread_y = clockBox_y;
      int answrTextfield_x = answrBox_x + answrBoxtTextLength + answrboxBufferSize;
      int answrTextfield_y = answrBox_y;

      clockboxTextLabel.setBounds(clockText_x, clockText_y, clockThread_W, clockThread_H);
      clockboxTextLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      clockboxTextLabel.setOpaque(true);
      clockboxTextLabel.setHorizontalAlignment(JLabel.LEFT);
      clockboxTextLabel.setBackground(Color.ORANGE);
      clockboxThreadLabel.setBounds(clockThread_x, clockThread_y, clockText_W, clockText_H);
      clockboxThreadLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      clockboxThreadLabel.setOpaque(true);
      clockboxThreadLabel.setHorizontalAlignment(JLabel.LEFT);
      clockboxThreadLabel.setBackground(Color.GREEN);
      answerboxTextField.setBounds(answrTextfield_x, answrTextfield_y, answrTextfield_W, answrTextfield_H);
      answerboxTextField.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      answerboxTextField.setOpaque(false);// answerboxTextField.setOpaque(true);
      answerboxTextField.setBackground(Color.MAGENTA);// answerboxTextField.setBackground(Color.ORANGE);

      add(clockboxTextLabel);
      add(clockboxThreadLabel);
      add(answerboxTextField);
      add(underbarClockboxLabel);
      add(underbarAnswerboxLabel);
      add(underbarScoreboxLabel);
      add(gameUnderbarLabel);
      add(gameDeathYLabel);

//----------  ▲ 고정형 그래픽 요소 추가 완료 ---------- ---------- ---------- ---------- ---------- ---------- 
//---------- ----- --------------- ---------- ---------- ---------- ---------- ---------- ---------- ----------

      // ▼ 시계 스레드 초기화 및 시작
      ClockThread clockThread = new ClockThread();
      clockThread.start();
      // ▼ answerboxTextField에 KeyListener 추가
      answerboxTextField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               checkAnswer(); // 사용자가 엔터 키를 입력하면 정답 체크 메소드 호출
               answerboxTextField.setText(""); // 입력 필드 초기화
            }
         }
      });

      // ▼ quizLabelMakerJava 클래스의 인스턴스 생성, createThreads 메서드 호출 통해 스레드 생성.
      quizLabelMakerJava quizLabelMakerJavaInstance = new quizLabelMakerJava();
      quizLabelMakerJavaInstance.createThreads();

////        ----- ▼ 테스트 코드 영역

////        ----- ▲ 테스트 코드 영역
   }
   // ▲ NewGamePanelJava 패널 '생성자' 끝

   int quizLabelAppear_y = -25; // 시작점 높이 지정

   // ▣ NewGamePanelJava 패널 '생성자' 외부
   // ▼ 단어라벨 생성 위한 [RandomLabelJava] 클래스 생성
   class quizLabelMakerJava {
      private int quizLabel_W, quizLabel_H, initial_y; // ????? : private 써야해?
      int quizLabelVerticalGap = 25 * 2; // 25 = qLa bel_H; > LabelThread 클래스에서 사용하는 필드 값

      int[] randomX = new int[wordSizeJava]; // 무작위 X좌표 저장용 정수배열 생성 (크기 : 단어 개수)
      LabelThread javaLabel_th[] = new LabelThread[wordSizeJava]; // 스레드 이름 후보 : labelThreadJava
      Random randomInsatance = new Random();

//       // ▼ [RandomLabelJava] 생성자 생성
//       quizLabelMakerJava() {
//        }

      // ▼ 스레드 생성을 별도의 '메서드'로 분리하여 수행 (이전 : RandomLabelJava 클래스의 생성자에서 스레드 생성)
      public void createThreads() {
         quizLabel_H = 25;

         for (int i = 0; i < wordSizeJava; i++) {
            String javaWord = wordListJavaShuffled.get(i); // ArrayList 'wordListJavaShuffled'에서 인덱스별 단어 갖고와서
                                                // 저장하기.
            int javaLabelIndex = i;

            int javaWordLength = javaWord.length();
            if (javaWordLength >= 15)
               quizLabel_W = 150;// 라벨 사이즈 지정
            else if (javaWordLength >= 10)
               quizLabel_W = 120;
            else if (javaWordLength >= 5)
               quizLabel_W = 100;
            else
               quizLabel_W = 50;

            randomX[i] = randomInsatance.nextInt(0 + 10, g_W - quizLabel_W - 10); // 랜덤 x좌표 발생 범위 : 단어라벨 여백 제외한
                                                                  // 화면 가로영역
            initial_y = quizLabelAppear_y - quizLabelVerticalGap * i;

            javaLabel_th[i] = new LabelThread(randomX[i], initial_y, quizLabel_W, quizLabel_H, javaWord,
                  javaLabelIndex); // 라벨 x좌표, y좌표, 일련번호 매개변수에 입력
            javaLabel_th[i].start();

         }
      }
   }
   // ▲ 단어라벨 생성 위한 [RandomLabelJava] 클래스 끝
   // ▣ NewGamePanelJava 패널 '클래스' 내부

   // ▼ NewGamePanelJava 패널 '클래스' 내부
   // ▼▼ ______용 [LabelThread]클래스, []클래스 在
   class LabelThread extends Thread {

      private int qLabel_x, qLabel_y, qLabel_W, qLabel_H, qLabelIndex, qLabelSortingID;
      private String qWord;

      int descendingAmount = 3; // 하강 y값의 크기
      int descendingInterval = 1000 / 20; // sleepTime - ms(밀리초)

      LabelThread(int P_qLabelRandomX, int P_qLabelInitialY, int P_qLabel_W, int P_qLabel_H, String P_qWord,
            int P_qLabelIndex) {
         qLabel_x = P_qLabelRandomX;
         qLabel_y = P_qLabelInitialY;
         qLabel_W = P_qLabel_W;
         qLabel_H = P_qLabel_H;
         qWord = P_qWord;
         qLabelIndex = P_qLabelIndex;
         qLabelSortingID = P_qLabelIndex + 1; // 퀴즈라벨 일련번호

         quizLabelJava[qLabelIndex] = new JLabel(qWord);

         quizLabelJava[qLabelIndex].setBounds(qLabel_x, qLabel_y, qLabel_W, qLabel_H);
         quizLabelJava[qLabelIndex].setFont(new Font("맑은 고딕", Font.BOLD, 15));
         quizLabelJava[qLabelIndex].setOpaque(true);
         quizLabelJava[qLabelIndex].setHorizontalAlignment(JLabel.CENTER);
         quizLabelJava[qLabelIndex].setBackground(Color.GREEN);

         add(quizLabelJava[qLabelIndex]); // 생성된 라벨을 패널에 추가하는 부분
//         repaint();

         System.out.println(qLabelSortingID + " label has created logically");
      }

      @Override
      public void run() {

         while (true) {
            int variable_y = qLabel_y + descendingAmount;
            qLabel_y = variable_y; // y 좌표값 업데이트

            quizLabelJava[qLabelIndex].setLocation(qLabel_x, qLabel_y);

            if (qLabel_y >= death_y - qLabel_H / 2) {
               System.out.println(qLabelIndex + " is Gone.");
               remove(quizLabelJava[qLabelIndex]);
               break;
            }

            try {
               sleep(descendingInterval);
            } catch (InterruptedException e) {
            }
         }
      }
   }
   // ▲ 단어라벨 생성용 [LabelThread]클래스 끝
   // ▣ NewGamePanelJava 패널 '클래스' 내부

   private void checkAnswer() {
      String userAnswer = answerboxTextField.getText();
      for (int i = 0; i < wordSizeJava; i++) {
         if (quizLabelJava[i].isVisible() && userAnswer.equals(wordListJavaShuffled.get(i))) {
            System.out.println(i + " -Correct!"); // 여기에 원하는 동작을 추가할 수 있습니다.
            remove(quizLabelJava[i]); // 정답을 맞춘 라벨은 화면에서 제거
            repaint();
            answerboxTextField.setText(""); // 입력 필드 초기화
            break;
         }
      }
   }

   //// ▼ 시계 쓰레드 담당 부분
   class ClockThread extends Thread {
      @Override
      public void run() {
         int elapsedTime = 0; // 경과 시간(초)

         while (true) {
            try {
               sleep(1000); // 1초마다 업데이트
               elapsedTime++;
               updateClock(elapsedTime); // 시계 라벨 업데이트 메소드 호출
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }

   // 추가: 시계 라벨 업데이트 메소드
   private void updateClock(int elapsedTime) {
      int minutes = elapsedTime / 60;
      int seconds = elapsedTime % 60;
      String timeString = String.format("%02d:%02d", minutes, seconds);

      clockboxThreadLabel.setText(timeString);
   }

//   public static void main(String[] args) {
//      new GamePanelJava(); // 객체 생성 (생성자 정의만 하면 안됩니다. 생성을 해야죠.)
//
//   }

}