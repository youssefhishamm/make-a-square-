
package makeasquare;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MasterThread   implements Runnable {
    static int[] inputPieces;
    static int keyThreadLJT=0;
    static int keyThreadSZI=0;
    public Thread t1,t2,t3,t4;
    public static int[] key0fSolve;

    public  MasterThread(int[] inputPieces){
        this.inputPieces =inputPieces;        
    }
    
    
    
    
    @Override
    public void run() {                     
        try {
            HashMap<Integer,ArrayList<int[][]>> pieces1 = new HashMap<Integer,ArrayList<int[][]>>();
            HashMap<Integer,ArrayList<int[][]>> pieces2 = new HashMap<Integer,ArrayList<int[][]>>();
            HashMap<Integer,ArrayList<int[][]>> pieces3 = new HashMap<Integer,ArrayList<int[][]>>();
            HashMap<Integer,ArrayList<int[][]>> pieces4 = new HashMap<Integer,ArrayList<int[][]>>();

            int[] usablePieces1 = null;
            usablePieces1 = board1setup(pieces1,inputPieces);
            int[] usablePieces2 = null;
            usablePieces2 = board1setup(pieces2,inputPieces);
            int[] usablePieces3 = null;
            usablePieces3 = board1setup(pieces3,inputPieces);
            int[] usablePieces4 = null;
            usablePieces4 = board1setup(pieces4,inputPieces);
            
            key0fSolve = usablePieces1;
            
            multiThreading m1 = new multiThreading(pieces1 ,usablePieces1);
            multiThreading m2 = new multiThreading(pieces2 ,usablePieces2);
            multiThreading m3 = new multiThreading(pieces3 ,usablePieces3);
            multiThreading m4 = new multiThreading(pieces4 ,usablePieces4);
                     
                        
            t1 = new Thread(m1);
            t2 = new Thread(m2);
            t3 = new Thread(m3);
            t4 = new Thread(m4);
            
            System.out.println("Start");
            t1.start();
            t2.start();
            t3.start();
            t4.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.println("finish");

                        
            if (!m1.solutionsThread.isEmpty()) {
                PrintSolutionsThreads pr1 = new PrintSolutionsThreads(m1.solutionsThread.get(0),1);
                Thread p1 = new Thread(pr1);
                p1.start();
            }
            if (!m2.solutionsThread.isEmpty()) {
                PrintSolutionsThreads pr1 = new PrintSolutionsThreads(m2.solutionsThread.get(0),2);
                Thread p1 = new Thread(pr1);
                p1.start();
            }
            if (!m3.solutionsThread.isEmpty()) {
                PrintSolutionsThreads pr1 = new PrintSolutionsThreads(m3.solutionsThread.get(0),3);
                Thread p1 = new Thread(pr1);
                p1.start();
            }
            if (!m4.solutionsThread.isEmpty()) {
                PrintSolutionsThreads pr1 = new PrintSolutionsThreads(m4.solutionsThread.get(0),4);
                Thread p1 = new Thread(pr1);
                p1.start();
            }else {
                PrintSolutionsThreads pr1 = new PrintSolutionsThreads();
                Thread p1 = new Thread(pr1);
                p1.start();}
            
        } catch (InterruptedException ex) {
            Logger.getLogger(MasterThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int[] board1setup(HashMap<Integer,ArrayList<int[][]>> pieces,int[] inputPieces) {

                System.out.println("wowo");
		//---------------------PIECE Z---------------------//
		
		int[][] pieceZa = {{5,5,0,0,0},
                                   {0,5,5,0,0},
				   {0,0,0,0,0},
				   {0,0,0,0,0}};
                
                int[][] pieceZb = {{0,5,0,0,0},
                                   {5,5,0,0,0},
				   {5,0,0,0,0},
				   {0,0,0,0,0}};
		
		
		ArrayList<int[][]> pieceZ = new ArrayList<int[][]>();
		
		pieceZ.add(pieceZa);
                pieceZ.add(pieceZb);
                

		

		//---------------------PIECE I---------------------//
		
		int[][] pieceIa = {{6,0,0,0,0},
				    {6,0,0,0,0},
				    {6,0,0,0,0},
				    {6,0,0,0,0}};
                int[][] pieceIb = {{6,6,6,6,0},
				    {0,0,0,0,0},
				    {0,0,0,0,0},
				    {0,0,0,0,0}};

		ArrayList<int[][]> pieceI = new ArrayList<int[][]>();
		
		pieceI.add(pieceIa);
		pieceI.add(pieceIb);

		
		//---------------------PIECE J---------------------//
		
		int[][] pieceJa = {{2,0,0,0,0},
                                    {2,2,2,0,0},
                                    {0,0,0,0,0},
                                    {0,0,0,0,0}};
                
                int[][] pieceJb = {{0,2,0,0,0},
                                    {0,2,0,0,0},
                                    {2,2,0,0,0},
                                    {0,0,0,0,0}};
                
                int[][] pieceJc = {{2,2,0,0,0},
                                    {2,0,0,0,0},
                                    {2,0,0,0,0},
                                    {0,0,0,0,0}};
                
                int[][] pieceJd = {{2,2,2,0,0},
                                    {0,0,2,0,0},
                                    {0,0,0,0,0},
                                    {0,0,0,0,0}};

		
		ArrayList<int[][]> pieceJ = new ArrayList<int[][]>();
		
		pieceJ.add(pieceJa);
		pieceJ.add(pieceJb);
		pieceJ.add(pieceJc);
		pieceJ.add(pieceJd);


//                ---------------------PIECE L---------------------//
		
		int[][] pieceLa = {{1,0,0,0,0},
				           {1,0,0,0,0},
				           {1,1,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0}};
                
                int[][] pieceLb = {{1,1,1,0,0},
				           {1,0,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0}};
                
                int[][] pieceLc = {{0,0,1,0,0},
				           {1,1,1,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0}};
                
                int[][] pieceLd = {{1,1,0,0,0},
				           {0,1,0,0,0},
				           {0,1,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0}};


		
		ArrayList<int[][]> pieceL = new ArrayList<int[][]>();
		
		pieceL.add(pieceLa);
                pieceL.add(pieceLb);
		pieceL.add(pieceLc);
		pieceL.add(pieceLd);

                
//		//---------------------PIECE O---------------------//
		
		int[][] pieceOa = {{7,7,0,0,0},
                                   {7,7,0,0,0},
				   {0,0,0,0,0},
				   {0,0,0,0,0},
				   {0,0,0,0,0}};
		
		
		ArrayList<int[][]> pieceO = new ArrayList<int[][]>();
		
		pieceO.add(pieceOa);
		

//		//---------------------PIECE S---------------------//
		
		int[][] pieceSa = {{0,4,4,0,0},
				    {4,4,0,0,0},
				    {0,0,0,0,0},
				    {0,0,0,0,0}};
                
                int[][] pieceSb = {{4,0,0,0,0},
				    {4,4,0,0,0},
				    {0,4,0,0,0},
				    {0,0,0,0,0}};

		ArrayList<int[][]> pieceS = new ArrayList<int[][]>();
		
		pieceS.add(pieceSa);
		pieceS.add(pieceSb);

		
//		//---------------------PIECE T---------------------//
		
		int[][] pieceTa = {{3,3,3,0,0},
				           {0,3,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0}};
                
                int[][] pieceTb = {{0,3,0,0,0},
				           {3,3,3,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0}};
                
                int[][] pieceTc = {{0,3,0,0,0},
				           {3,3,0,0,0},
				           {0,3,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0}};
                
                int[][] pieceTd = {{3,0,0,0,0},
				           {3,3,0,0,0},
				           {3,0,0,0,0},
				           {0,0,0,0,0},
				           {0,0,0,0,0}};

		
		ArrayList<int[][]> pieceT = new ArrayList<int[][]>();
		
		pieceT.add(pieceTa);
		pieceT.add(pieceTb);
		pieceT.add(pieceTc);
		pieceT.add(pieceTd);
                // --------------------------------------------------- //


                
                            // copy array inputPieces //
                int[] copy_inputPieces = new int[inputPieces.length];
                for(int i =0 ; i < inputPieces.length ;i++){
                    copy_inputPieces[i] = inputPieces[i];
                }
                            //  ----------------- //
                            
                            
                            
                            
                  int findnumThread=0;
                  
                for (int i = 0 , key  ; i < copy_inputPieces.length ;i++){
                    if (copy_inputPieces[i] != 0 &&findnumThread==0){
                     findnumThread++;
                     ArrayList<int[][]> piecethread = new ArrayList<int[][]>();
                        System.out.println(keyThreadSZI);
                        System.out.println(keyThreadLJT);
                     if(copy_inputPieces[i] == 1){
                            key=i+1;
                            switch(key) {
                                case 5:
                                    piecethread.add(pieceZ.get(keyThreadSZI));
                                    pieces.put(key,piecethread);
                                    break;
                                case 6:
                                    piecethread.add(pieceI.get(keyThreadSZI));
                                    pieces.put(key,piecethread);
                                    break;
                                case 2:
                                    piecethread.add(pieceJ.get(keyThreadLJT));
                                    pieces.put(key,piecethread);
                                    break;
                                case 1:
                                    piecethread.add(pieceL.get(keyThreadLJT));
                                    pieces.put(key,piecethread);
                                    break;
                                case 7:
                                    pieces.put(key, pieceO);
                                    break;
                                case 4:
                                    piecethread.add(pieceS.get(keyThreadSZI));
                                    pieces.put(key,piecethread);
                                    break;
                                case 3:
                                    piecethread.add(pieceT.get(keyThreadLJT));
                                    pieces.put(key,piecethread);
                                    break;    
                            }  
                    } 
                        else if (copy_inputPieces[i] != 0){
                            key=i+1;
                            switch(key) {
                                case 5:
                                    piecethread.add(pieceZ.get(keyThreadSZI));
                                    pieces.put(5*(copy_inputPieces[i]+6),setupcopy(piecethread,(copy_inputPieces[i]+6)));
                                    break;
                                case 6:
                                     piecethread.add(pieceI.get(keyThreadSZI));
                                    pieces.put(6*(copy_inputPieces[i]+6),setupcopy(piecethread,(copy_inputPieces[i]+6)));
                                    break;
                                case 2:
                                    piecethread.add(pieceJ.get(keyThreadLJT));
                                    pieces.put(2*(copy_inputPieces[i]+6),setupcopy(piecethread,(copy_inputPieces[i]+6)));
                                    break;
                                case 1:
                                    piecethread.add(pieceL.get(keyThreadLJT));
                                    pieces.put(1*(copy_inputPieces[i]+6),setupcopy(piecethread,(copy_inputPieces[i]+6)));
                                    break;
                                case 7:
                                    pieces.put(7*(copy_inputPieces[i]+6),setupcopy(pieceO,(copy_inputPieces[i]+6)));
                                    break;
                                case 4:
                                     piecethread.add(pieceS.get(keyThreadSZI));
                                    pieces.put(4*(copy_inputPieces[i]+6),setupcopy(piecethread,(copy_inputPieces[i]+6)));
                                    break;
                                case 3:
                                    piecethread.add(pieceT.get(keyThreadLJT));
                                    pieces.put(3*(copy_inputPieces[i]+6),setupcopy(piecethread,(copy_inputPieces[i]+6)));
                                    break;    
                            }
                        copy_inputPieces[i]--; 
                        i--;                            
                        }
                    } else{
                        if(copy_inputPieces[i] == 1){
                            key=i+1;
                            switch(key) {
                                case 5:                                   
                                    pieces.put(key,pieceZ);
                                    break;
                                case 6:
                                    pieces.put(key, pieceI);
                                    break;
                                case 2:
                                    pieces.put(key, pieceJ);
                                    break;
                                case 1:
                                    pieces.put(key, pieceL);
                                    break;
                                case 7:
                                    pieces.put(key, pieceO);
                                    break;
                                case 4:
                                    pieces.put(key, pieceS);
                                    break;
                                case 3:
                                    pieces.put(key, pieceT);
                                    break;    
                            }  
                    } 
                        else if (copy_inputPieces[i] != 0){
                            key=i+1;
                            switch(key) {
                                case 5:     
                                    pieces.put(5*(copy_inputPieces[i]+6),setupcopy(pieceZ,(copy_inputPieces[i]+6)));
                                    break;
                                case 6:
                                    pieces.put(6*(copy_inputPieces[i]+6),setupcopy(pieceI,(copy_inputPieces[i]+6)));
                                    break;
                                case 2:
                                    pieces.put(2*(copy_inputPieces[i]+6),setupcopy(pieceJ,(copy_inputPieces[i]+6)));
                                    break;
                                case 1:
                                    pieces.put(1*(copy_inputPieces[i]+6),setupcopy(pieceL,(copy_inputPieces[i]+6)));
                                    break;
                                case 7:
                                    pieces.put(7*(copy_inputPieces[i]+6),setupcopy(pieceO,(copy_inputPieces[i]+6)));
                                    break;
                                case 4:
                                    pieces.put(4*(copy_inputPieces[i]+6),setupcopy(pieceS,(copy_inputPieces[i]+6)));
                                    break;
                                case 3:
                                    pieces.put(3*(copy_inputPieces[i]+6),setupcopy(pieceT,(copy_inputPieces[i]+6)));
                                    break;    
                            }
                        copy_inputPieces[i]--; 
                        i--;                            
                        }
                    }
                }
                
                // copy array inputPieces //
                int[] copy2_inputPieces = new int[inputPieces.length];
                for(int i =0 ; i < inputPieces.length ;i++){
                    copy2_inputPieces[i] = inputPieces[i];
                }
                            //  ----------------- //
                Set<Integer> set0fKey = pieces.keySet();
                Object [] array0fKey  = set0fKey.toArray();
                            
		int[] pieceKeyList = new int[pieces.size()];
                for (int k =0 ; k < array0fKey.length ;k++){
                     pieceKeyList[k] = (int) array0fKey[k];               
                }
                
                if(keyThreadLJT<3){
                    keyThreadLJT++;
                }
                if(keyThreadSZI<1){
                    keyThreadSZI++;
                }
		return pieceKeyList;
	}
    public static ArrayList<int[][]> setupcopy (ArrayList<int[][]> piece , int i) {
            ArrayList<int[][]> piecescopy = new ArrayList<int[][]>();
            
            for(int[][] piececopy : piece) {
                int [][] newpiece = new int [piececopy.length][piececopy[0].length];
                for (int x = 0 ; x < piececopy.length ;x++){
                    for (int y = 0 ; y < piececopy[0].length ;y++){
                        newpiece[x][y] = piececopy [x][y] * i;                    
                    }
                }
                piecescopy.add(newpiece);
            }
            return piecescopy;
        }




   
    // Only --- To Print Array
    public static void print2DArray(int[][] myArray) {
		int yLength = myArray.length;
		int xLength = myArray[0].length;
		for(int top = 0; top < xLength*3+2; top++) {
			System.out.print("-");
		}
		System.out.println();
		for(int row = 0; row < yLength; row++) {
			System.out.print("|"); 
			for(int col = 0; col < xLength; col++) {
				if(myArray[row][col] < 10) {
					System.out.print(" "+myArray[row][col]+" ");
				}
				else System.out.print(" "+myArray[row][col]);
			}
			System.out.println("|");
		}
		for(int top = 0; top < xLength*3+2; top++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
