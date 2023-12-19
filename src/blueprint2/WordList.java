package blueprint2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WordList {
	
	// word_list �ʵ� �߰�
    private static ArrayList<String> word_list = new ArrayList<>();
	
	WordList() {
	    // ������ ���� �ܾ �о�ɴϴ�.
	    try (BufferedReader br = new BufferedReader(new FileReader("wordlist_JAVA.txt"))) {
	      String sentence;
	      while ((sentence = br.readLine()) != null) {
				word_list.add(sentence);
	      }
	    } catch (IOException e) {
	      System.err.println(e);
	    }
	    
	    // ArrayList word_list�� ������ �ܾ �����ϴ�.
	    Collections.shuffle(word_list);

//	    // �ܾ ����մϴ�.
//	    for (String word : word_list) {
//	      System.out.println(word);
//	    }
//	    for (int i = 0; i < word_list.size(); i++) {
//	    	  System.out.println(word_list.get(i));
//	    }
	  }
	
	// �޼ҵ� ���� ���� ---------- ---------- ---------- ---------- ---------- ---------- ---------- 
    // word_list �ʵ��� getter �޼ҵ� �߰�
    public static ArrayList<String> getWordList() {
        return word_list;
    }
	
	
	
	
  public static void main(String[] args) {
	  new WordList();
  }
	
}
