import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IOtest {

	
	
	public static void main(String[] args) {
		try{
			ArrayList<Double> arrayList = new ArrayList<>();;
			File f = new File("C:\\java_lab\\IOtest\\abcd.txt");
			FileReader fin = new FileReader(f);
			double c=0;
			
			while((c=fin.read())!=-1) {
				//arrayList.add((double)c);
				System.out.println(c);
			}
	
	    }
	    catch(IOException e){System.out.println(e.getMessage());}	
	}
}