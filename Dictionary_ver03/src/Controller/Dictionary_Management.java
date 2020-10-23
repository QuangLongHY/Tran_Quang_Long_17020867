package Controller;
import java.util.ArrayList;
import java.util.List;
import GetData.Getdata;
import Model.Word;

public class Dictionary_Management {
	
	Getdata getrepo = new Getdata();
	
	List<Word> Dictionary = getrepo.getModel(); 
	
	public String[] getWordAnswer() {		
		String[] wordAnswer = new String[Dictionary.size()]; 
		for (int i = 0; i<Dictionary.size(); i++) {
			wordAnswer[i] = Dictionary.get(i).getWord();
		}
		return wordAnswer;
	}
	
	public List<String> getWord(){
		List<String> result = new ArrayList<String>();
		for (Word w: Dictionary) {
			result.add(w.getWord());
		}
		return result;
	}
	
	public String search(String word) {
		String result = null;
		for (Word w:Dictionary) {
    		if (w.getWord().equals(word) == true) {
    			result = w.getMean();
    			break;
    		}
		}
		return result;	
	}
	public void AddWord(Word word) {
		getrepo.AddWord(word.getWord(), word.getMean());
		
	}
	public void DelWord(String word) {
		getrepo.DeleteWord(word);
	}
	public void EditWord(String Lword, String Nword) {
		getrepo.EditWord(Lword, Nword);
	}
	
}
