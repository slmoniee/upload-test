package blueprint;

public enum WordListEnum{
	JAVA("wordlist_JAVA.txt"), PYTHON("wordlist_Python.txt");
	String filename;
	WordListEnum(String filename){
		this.filename = filename;
	}
	public String getFilename() {
		return this.filename;
	}
}