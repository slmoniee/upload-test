package blueprint3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WordList_Decoupling {

   // wordlistJava 필드 추가
   private static ArrayList<String> wordlistJava = new ArrayList<>();
   private static ArrayList<String> wordlistPython = new ArrayList<>();

   WordList_Decoupling() {

//      getWordListJava();
//      getWordListPython();
//
//      // 단어를 출력합니다.
//      for (String word : wordlistJava) {
//         System.out.println(word);
//      }
//      for (int i = 0; i < wordlistJava.size(); i++) {
//         System.out.println(wordlistJava.get(i));
//      }
   }

   // 메소드 생성 영역 ---------- ---------- ---------- ---------- ---------- ----------

   // wordlistJava 필드의 getter 메소드 추가
   public static ArrayList<String> getWordListJava() {
      // 파일을 열고 단어를 읽어옵니다.
      try (BufferedReader br = new BufferedReader(new FileReader("wordlist_JAVA.txt"))) {
         String sentence;
         while ((sentence = br.readLine()) != null) {
            wordlistJava.add(sentence);
         }
      } catch (IOException e) {
         System.err.println(e);
      }

      // ArrayList wordlistJava에 저장한 단어를 섞습니다.
      Collections.shuffle(wordlistJava);
      return wordlistJava;
   }
//   public static ArrayList<String> getWordList() {
//        return wordlistJava;
//    }
   
   // wordlistJava 필드의 getter 메소드 추가
   public static ArrayList<String> getWordListPython() {
      // 파일을 열고 단어를 읽어옵니다.
      try (BufferedReader br = new BufferedReader(new FileReader("wordlist_Python.txt"))) {
         String sentence;
         while ((sentence = br.readLine()) != null) {
            wordlistPython.add(sentence);
         }
      } catch (IOException e) {
         System.err.println(e);
      }

      // ArrayList wordlistPython에 저장한 단어를 섞습니다.
      Collections.shuffle(wordlistPython);
      return wordlistPython;
   }
   
   
   
   
  public static void main(String[] args) {
     new WordList_Decoupling();
  }
   
}