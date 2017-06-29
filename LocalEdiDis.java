
public class LocalEdiDis {
	String f,t;
	int lf,lt;
	int[][] mat;
	int d=-1,i=-1,r=-1,m=1;
     public LocalEdiDis(String f, String t) {
    	 this.f = f;
    	 this.t = t;
    	 lf = f.length();
    	 lt = t.length();
     }
     
     public void distance() {
    	 int lf = f.length();
    	 int lt = t.length();
    	 mat = new int[lt+1][lf+1];
    	 for (int j=0; j <=lt ; j++)
    		 mat[j][0] = 0;
    	 for (int k=0; k<=lf; k++) 
    		 mat[0][k] = 0;
    	 
    	 for (int j=1; j<=lt; j++) {
    		 for (int k=1; k<=lf; k++) {
    			 mat[j][k] = max(0,mat[j][k-1]+d, mat[j-1][k]+i,
 						mat[j-1][k-1] + equal(f.charAt(k-1),t.charAt(j-1)));
    		 }
    	 }
    	 
    	// for 
    	 
     }
     
     public char[][] matchSeq(){
    	 distance();
    	 int maxi=-99999;
    	 int mr=0,mc=0;
    	 for (int i=0; i<=lt;i++) {
    		 for (int j=0; j<=lf;j++) {
    			 if (mat[i][j] > maxi) {
    				 maxi = mat[i][j];
    				 mr = i;
    				 mc = j;
    			 }
    		 }
    	 }
    	 System.out.println(mc+" "+mr);
    	 String direc = findDirection(mr,mc);
    	 //System.out.println(direc);
    	 if (direc.length()!=1) {
    	 int[][] seqNum = new int[direc.length()-1][2];
    	 seqNum[0][0] = mr; seqNum[0][1]=mc;
    	 int rlength=0;
    	 for (int i=1; i<direc.length()-1;i++) {
    		 if (direc.charAt(i+1)=='i') {
    			 mr = mr-1;
    			 seqNum[i][0] = mr;
    			 seqNum[i][1] = mc;
    		 }
    		 else if (direc.charAt(i+1)=='d') {
    			 mc = mc-1;
    			 seqNum[i][0] = mr;
    			 seqNum[i][1] = mc;
    		 }
    		 else if (direc.charAt(i+1)=='r') {
    			 mc = mc-1;
    			 mr = mr-1;
    			 seqNum[i][0] = mr;
    			 seqNum[i][1] = mc;
    			 rlength = rlength+1;
    		 }
    		 else {
    			 mc = mc-1;
    			 mr = mr-1;
    			 seqNum[i][0] = mr;
    			 seqNum[i][1] = mc;
    		 }
   
    	 }
    	 //int[][] rseq = new int[rlength][2];
    	 //int dx=0;
    	 /*for (int i=0; i<direc.length()-2;i++) {
    		 if (direc.charAt(i+1)=='r') {
    			 rseq[dx][0] = seqNum[i][0];
    			 rseq[dx][1] = seqNum[i][1];
    			 dx = dx+1;
    		 }
    	 }*/
    	 char[][] bestM = new char[seqNum.length][2];
    	// System.out.println(direc.length());
    	// int index=direc.length()-1;
    	 for (int i=0; i<seqNum.length; i++) {
    		 //index = index-1;
    		 //System.

    		 bestM[i][1] = t.charAt(seqNum[i][0]-1);
    		 bestM[i][0] = f.charAt(seqNum[i][1]-1);
    		 
    		 //System.out.println(index);
    		 //System.out.print(bestM[i][0] + " " + bestM[i][1]);
    		 //System.out.println();
    	}
    	return bestM; 
    	 }
    	 else {
    		 char[][] be = {{'a','a'},{'a','a'}}; 
    		 return be;
    	 }
    	 
     }
     
     private String findDirection(int r,int c) {
    	String direc = "s";
    	while ((r!=0 && c!=0) && mat[r][c]!=0) {
    		if (mat[r][c]==mat[r-1][c]+i) {
    			direc = direc +"i";
    			r = r-1;
    		}
    		else if (mat[r][c]==mat[r][c-1]+d) {
    			direc = direc +"d";
    			c = c-1;
    		}
    		else if (mat[r][c]==mat[r-1][c-1]+r) {
    			direc = direc +"r";
    			r=r-1;c=c-1;
    		}
    		else {
    			direc = direc + "m";
    			r=r-1;c=c-1;
    		}
    		
    	}
    	//System.out.println(direc);
    	return direc;
     }
     
     private int max(int a,int b,int c,int d) {
 		int max = Math.max(a, b);
 		max = Math.max(max, c);
 		max = Math.max(max, d);
 		return max;
 	}
     
     private int equal(char A, char B) {
 		if (A==B)
 			return m;
 		else
 			return r;
 		
 	}
}
