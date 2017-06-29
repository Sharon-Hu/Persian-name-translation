import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Evarecall {
	//public BufferedReader result;
	//public BufferedReader correctSet;
	private File result;
	private File correctSet;
	double acc, rec, pre;
	int count,linecount=1;
	int recount=0,poncount=0;
	
	public Evarecall(File result, File correctSet) {
		this.result = result;
		this.correctSet = correctSet;
		calculate();
		
	}
	
	public void calculate() {
		try {
			BufferedReader re = new BufferedReader(new FileReader(result));
			//BufferedReader co = new BufferedReader(new FileReader(correctSet));
			String line1 = re.readLine();
			String[] words1;
			String[] words2;
			PrintWriter output = new PrintWriter(new FileOutputStream("src/correctName2.txt"));
			count = 0;
			linecount=0;
			while (line1!=null) {
				line1 = line1.toLowerCase();
				words1 = line1.split("\t");
				BufferedReader co = new BufferedReader(new FileReader(correctSet));
				String line2 = co.readLine();
				while (line2!=null){
					line2=line2.toLowerCase();
					//System.out.println(line2);
					words2 = line2.split("\t");
					if (words1[0].equals(words2[0])){
						//System.out.println(words1.length);
						for (int i=0; i<words1.length-1;i++) {
							if (words1[i+1].equals(words2[1])) {
								recount = recount+1;
								output.println(words1[0] + "\t" + words1[i+1]);
								//System.out.println(recount);
								if (i==0) {
									count = count+1;
								}
							}
							poncount = poncount +1;
						}
					}
					line2 = co.readLine();
				}
				co.close();
				line1 = re.readLine();
				linecount=linecount+1;
			}
			re.close();
			output.close();
			
		}
		catch(FileNotFoundException e)
        {
           System.out.println("Problem opening files.");
        }
	 
    catch(IOException e)
        {
           System.out.println("Error reading from original.txt.");
	      }

	}
	
	public double accuracy() {
		//calculate();
		System.out.println("accuracy: " + count + " over " + linecount);
		acc = (double)count/linecount;
		System.out.printf("Accuracy = %.2f", acc);
		System.out.println();
		return acc;
	}
	
	public double recall() {
		//calculate();
		System.out.println("recall: "+ recount + " over " + linecount);
		rec = (double)recount/linecount;
		System.out.printf("Recall = %.2f", rec);
		System.out.println();
		return rec;
	}
	
	public double precison() {
		System.out.println("precision: "+ recount + " over " + poncount);
		pre = (double)recount/poncount;
		System.out.printf("Precison = %.2f ", pre);
		System.out.println();
		return pre;
	}

}
