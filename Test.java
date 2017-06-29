import java.io.*;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Calculate repalcement matrix
		//CalMat cl = new CalMat();
		//cl.calculate();
		
		System.out.println("Global Edit distance with same r parameter");
		//Evaluate performance of global edit distance
		Evarecall ts = new Evarecall(new File("src/resultGlobal.txt"),new File("src/train.txt"));
		ts.accuracy();
		ts.recall();
		ts.precison();
		
		System.out.println("Improve method");
		//Evaluate performance of improved global edit distance
		Evarecall ts2 = new Evarecall(new File("src/resultImproveGlo.txt"),new File("src/train.txt"));
		ts2.accuracy();
		ts2.recall();
		ts2.precison();

	}

}
