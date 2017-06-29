import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter; 

public class MethodDemoGlobal {

	public static void main(String[] args) {
		String closeName=" ";
		int Maxdistance=-10000;
		//Blotry bl=new Blotry();
		try {
				BufferedReader persian = new BufferedReader(new FileReader("src/train.txt"));		
				PrintWriter outputstream = new PrintWriter(new FileOutputStream("src/resultGlobal.txt"));	
				String line = persian.readLine();
				GlobalEditDistance g1 = new GlobalEditDistance();
				//ImproveGlo g1 = new ImproveGlo();
				
				while (line != null) {
					String[] words = line.split("	");
					String wrong = words[0];
					String wrongl = wrong.toLowerCase();
					BufferedReader engName = new BufferedReader(new FileReader("src/names.txt"));
					String name = engName.readLine();
					Maxdistance = -1000;
					//closeName = null;
					int r=0;
					while (name != null) {	
						g1.getStrings(wrongl,name);

						if (Maxdistance < g1.distance()) {
							closeName = name;
							Maxdistance = g1.distance();
						}
						name = engName.readLine();
					}
					engName.close();
					engName = new BufferedReader(new FileReader("src/names.txt"));
					name = engName.readLine();
					while(name!=null) {
						g1.getStrings(wrongl,name);
                        if (Maxdistance==g1.distance()) {
                        	r=r+1;
                        	//System.out.println(r);
                        	if (!closeName.equals(name)) {
                            closeName = closeName +"\t" +name; 
                        	}
                            //System.out.println(closeName);
                        }
                        name = engName.readLine();
					}
					outputstream.println(wrong + "\t" + closeName);
					line = persian.readLine();
					engName.close();
				}
				persian.close();
				
				outputstream.close();
		}
		  
		catch(FileNotFoundException e)
	        {
	           System.out.println("Problem opening files.");
	        }
		 
	    catch(IOException e)
	        {
	           System.out.println("Error reading from original.txt.");
		      }
		//Evaluation eva = new Evaluation(File("src/"))
		System.out.println("Done!");
	}
}

