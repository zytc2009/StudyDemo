package com.example.studyproject.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static String TAG = "Solution";

    public Solution(){
        System.out.println("test Solution construct ..");
    }

    static {
        System.out.println("test Solution static ..");
    }

    class NotStaticClass{
        String TAG = "NotStaticClass";
        public NotStaticClass(){
            System.out.println("test NotStaticClass  construct..");
        }
    }

    static class StaticClass{
        private static String aaa = "aaa";
        private static StaticClass TAG = new StaticClass();
        static {
            System.out.println("test StaticClass static TAG = " + TAG);
        }
        public StaticClass(){
            System.out.println("test StaticClass  construct TAG = " +TAG);
        }


    }

    public static void main(String[] args) {
        //[[1,2],[2,1],[1,0],[0,0],[0,1],[2,0],[1,1]]
//        int[][] moves = new int[][]{{1,2},{2,1},{1,0},{0,0},{0,1},{2,0},{1,1}};
//        String result = tictactoe(moves);
//        System.out.println("result = " + result);
        String staticClass = StaticClass.aaa;


    }



    public static String tictactoe(int[][] moves) {

        Integer[][] winsArray = new Integer[8][3];
        winsArray[0] = new Integer[]{0, 1, 2};
        winsArray[1] = new Integer[]{3, 4, 5};
        winsArray[2] = new Integer[]{6, 7, 8};
        winsArray[3] = new Integer[]{0, 3, 6};
        winsArray[4] = new Integer[]{1, 4, 7};
        winsArray[5] = new Integer[]{2, 5, 8};
        winsArray[6] = new Integer[]{0, 4, 8};
        winsArray[7] = new Integer[]{2, 4, 6};
    
        List<Integer> A = new ArrayList();
        List<Integer> B = new ArrayList();
        
        for(int i = 0 ; i < moves.length ; i++){
            int pos = moves[i][0] * 3 + moves[i][1];
            if( i % 2 == 0){ //A
                A.add(pos);
                Integer[] arraycopy = new Integer[A.size()];
                for(int m = 0 ; m < A.size() ; m++){
                    Integer a = A.get(m);
                    arraycopy[m] = a;
                }
                if(isWin(winsArray,arraycopy)){
                    return "A";
                }
            }else {//B
            
                B.add(pos);

                Integer[] arraycopyB = new Integer[B.size()];
                for(int n = 0 ; n < B.size() ; n++){
                    Integer b = B.get(n);
                    arraycopyB[n] = b;
                }

                if(isWin(winsArray,arraycopyB)){
                    return "B";
                }
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";

    }

    private static boolean isWin(Integer[][] winsArray,Integer[] ab){
        
        for(int i = 0 ; i < winsArray.length ; i++){
             if(isSame(Arrays.asList(winsArray[i]),Arrays.asList(ab))){
                 return true;
             }
        }

        return false;

        
    }


    private static boolean isSame(List<Integer> ary1,List<Integer> ary2){
        int count = 0;
        for (Integer value : ary2){
            if (ary1.contains(value)){
                count ++;
                if (count == 3){
                    return true;
                }
            }
        }

        return false;
    }

}