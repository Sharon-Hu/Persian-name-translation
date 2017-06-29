import java.io.File;

public class GlobalEditDistance {
	
	int l1,l2; // l1 is in x direction, l2 is in y direction
	String w1, w2; // w1 is Persian name, w2 is English name
	int[][] disMat;
	
	
	int i=-1,d=-1,r=-1,m=1; //[m,i,d,r]
	
	public GlobalEditDistance() {
		
	}

	public void getStrings(String word1, String word2) {
		w1 = word1;
		w2 = word2;
		l1 = w1.length();
		l2 = w2.length();
		disMat = new int[l2+1][l1+1];
	}
	
	public int distance() {
		for (int k=0; k<=l1; k++) {
			disMat[0][k] = k*d;
		} // x direction for deletion
		for (int j=0; j<=l2; j++) {
			disMat[j][0] = j*i;
		} // y direction for insertion
		
		for (int j=1; j<=l2 ; j++) {
			for (int k=1; k<=l1; k++) {
				disMat[j][k] = max(disMat[j][k-1]+d, disMat[j-1][k]+i,
						disMat[j-1][k-1] + equal(w1.charAt(k-1),w2.charAt(j-1)));
			}
		}
		return disMat[l2][l1];
	}
		
	
	private int max(int a,int b,int c) {
		int max = Math.max(a, b);
		max = Math.max(max, c);
		return max;
	}
	
	private int equal(char A, char B) {
		if (A==B)
			return m;
		else
			return r;
		
		//return (int)Blosum62.getDistance(A,B);
	}

}


