import java.io.*;

public class CalMat {

	private char[] chaList = {'a','b','c','d','e','f','g','h','i','j',
			'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','\''};
	private int[][] count = new int[27][26];
	
	public CalMat() {
		for (int i=0; i<27 ; i++) {
			for (int j=0; j<26; j++) {
				count[i][j] = 0;
			}
		}
	}
	public void calculate() {
		try {
			BufferedReader tra = new BufferedReader(new FileReader("src/train.txt"));
			PrintWriter output = new PrintWriter(new FileOutputStream("src/Rscore.txt"));
			String line = tra.readLine();
			String[] words = new String[2];
			char[][] seq;
			int len=0;
			String lo,sh;
			int r,c;
			int o,p;
			while (line!=null) {
				words = line.split("\t");
				words[0]=words[0].toLowerCase();
				LocalEdiDis freq = new LocalEdiDis(words[0],words[1]);
				seq = freq.matchSeq();
				for (int i=0; i<seq.length;i++) {
					if (seq[i][0]=='\'') {
					   p=seq[i][1]-97;
					   count[26][p] = count[26][p]+1;
					}
					else {
						o = seq[i][0]-97;
						p = seq[i][1]-97;
						System.out.println(seq[i][1]);
						count[o][p] = count[o][p] +1;
					}	
				}
				line = tra.readLine();
			}
			output.print("s|");
			for (int i=0; i<26; i++) {
				output.print(chaList[i]);
				output.print("|");
			}
			output.println();
			for (int i=0; i<27; i++) {
				output.print(chaList[i]+"|");
				for (int j=0; j<26; j++) {
					output.print(count[i][j] + "|");
				}
				output.println();
			}
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
	

}
