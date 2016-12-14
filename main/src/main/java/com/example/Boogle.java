package com.example;

public class Boogle {

    public static void main(String[] args) {
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO", "GUZ", "ZEE", "IZQ"};
        char boggle[][]   = {{'G','I','Z'},
                             {'U','E','K'},
                             {'Q','S','E'}};
        //System.out.println((0 /10)+ " "+ (0%10));
        for(int i = 0; i<dictionary.length; i++){
            String word = dictionary[i];
            System.out.println(word+" "+ new Boogle().findWord(boggle, word));
        }
    }

    public boolean findWord(char boogle[][], String word){
        boolean flag = false;
        int columns = boogle.length;
        int rows = boogle[0].length;
        boolean [][]checked = getCheckedArray(columns,rows, false);
        char [] cWord = word.toCharArray();
        int cord = 0;
        for(int i = 0; i < cWord.length; i++){
            if(i == 0){
                cord = getFirstCoordinates(boogle, cWord[i], checked);
                if(cord == -1){
                    return false;
                }
            }else{
                cord = getNextCoordinates(cord, cWord[i], boogle, checked);
                if(cord == -1){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean[][] getCheckedArray(int columns, int rows, boolean flag){
        boolean [][] checked = new boolean[columns][rows];
        for(int i = 0; i< checked.length; i++){
            for(int j = 0; j< checked[i].length; j++){
                checked[i][j] = flag;
            }
        }
        return checked;
    }

    private int getFirstCoordinates(char boogle[][], char c, boolean checked[][]){
        //int cord = 0;
        for(int i = 0; i<boogle.length; i++){
            for(int j=0; j<boogle[i].length; j++){
                if(c == boogle[i][j]){
                    checked[i][j] = true;
                    return (i * 10) + j;
                }
            }
        }
        return -1;
    }

    private int getNextCoordinates(int cord, char c, char boogle[][], boolean checked[][]){
        int col = cord / 10;
        int row = cord % 10;
        int aCol = col -1;
        int pCol = col +1;
        int aRow = row -1;
        int pRow = row +1;
        int maxCol = boogle.length;
        int maxRow = boogle[0].length;
        if((aCol >= 0 && aCol < maxCol) && (aRow >= 0 && aRow < maxRow)){
            if(!checked[aCol][aRow] && c == boogle[aCol][aRow]){
                checked[aCol][aRow] = true;
                return (aCol * 10) + aRow;
            }
        }
        if((aCol >= 0 && aCol < maxCol) && (row >= 0 && row < maxRow)){
            if(!checked[aCol][row] && c == boogle[aCol][row]){
                checked[aCol][row] = true;
                return (aCol * 10) + row;
            }
        }
        if((aCol >= 0 && aCol < maxCol) && (pRow >= 0 && pRow < maxRow)){
            if(!checked[aCol][pRow] && c == boogle[aCol][pRow]){
                checked[aCol][pRow] = true;
                return (aCol * 10) + pRow;
            }
        }
        if((col >= 0 && col < maxCol) && (aRow >= 0 && aRow < maxRow)){
            if(!checked[col][aRow] && c == boogle[col][aRow]){
                checked[col][aRow] = true;
                return (col * 10) + aRow;
            }
        }
        if((col >= 0 && col < maxCol) && (pRow >= 0 && pRow < maxRow)){
            if(!checked[col][pRow] && c == boogle[col][pRow]){
                checked[col][pRow] = true;
                return (col * 10) + pRow;
            }
        }
        if((pCol >= 0 && pCol < maxCol) && (aRow >= 0 && aRow < maxRow)){
            if(!checked[pCol][aRow] && c == boogle[pCol][aRow]){
                checked[pCol][aRow] = true;
                return (pCol * 10) + aRow;
            }
        }
        if((pCol >= 0 && pCol < maxCol) && (row >= 0 && row < maxRow)){
            if(!checked[pCol][row] && c == boogle[pCol][row]){
                checked[pCol][row] = true;
                return (pCol * 10) + row;
            }
        }
        if((pCol >= 0 && pCol < maxCol) && (pRow >= 0 && pRow < maxRow)){
            if(!checked[pCol][pRow] && c == boogle[pCol][pRow]){
                checked[pCol][pRow] = true;
                return (pCol * 10) + pRow;
            }
        }
        return -1;
    }


}
