package blueprint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordListDecoupling {
	/*
	 * 주의: 공유변수이므로 멀티쓰레딩 적용시 주의
	 * 싱글톤 패턴 적용 
	 */
	private WordListEnum wordListEnum = WordListEnum.JAVA;
	private final Map<WordListEnum, List<String>> wordMap = new HashMap<>();
	private final static WordListDecoupling wordListManager = new WordListDecoupling();

	private WordListDecoupling() {
		init();
	}
	
	private void init() {
		for(WordListEnum wordListEnum: WordListEnum.values()) {
			try (BufferedReader br = new BufferedReader(new FileReader(wordListEnum.getFilename()))) {
				String sentence;
				List<String> sentences = new ArrayList<>();
				while ((sentence = br.readLine()) != null) {
					sentences.add(sentence);
				}
				Collections.shuffle(sentences);
				wordMap.put(wordListEnum, sentences);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	public static WordListDecoupling getInstance(){
		return wordListManager;
	}
	/**
	 * 해당 매서드로 어떤 언어 리스트를 사용할지 정할 수 있습니다. 
	 * @param wordListEnum 선택할 단어 리스트 
	 */
	public void selectWordList(WordListEnum wordListEnum) {
		this.wordListEnum = wordListEnum;
	}
	
	/**
	 * selectWordList 로 선택한 언어 리스트를 반환합니다.
	 * 주의: selectWordList 를 호출하지 않으면 예상하지 못한 결과가 나올 수 있습니다
	 * @return 선택된 단어 리스트 
	 */
	public List<String> getWordList() {
		return wordMap.get(wordListEnum);
	}


	public static void main(String[] args) {
		new WordListDecoupling();
	}

}