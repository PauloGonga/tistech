package api.tistech;

/*
 * @author Paulo Jacinto Morais Gonga
 * @Version 1
 * @Date 10/12/2021
 */
public class Exercise9  {
    
    private String [][] biArray ; 
    private String word;
    private int MAXROW;
    private int MAXCOL;
    
    public Exercise9(){ 
    }

    public Exercise9(String[][] biArray, String word, int MAXROW, int MAXCOL) {
        
        this.biArray = new String [MAXROW][MAXCOL];
        this.biArray = copyMatrix(biArray,MAXROW,MAXROW) ;
        this.word = word;
        this.MAXROW = MAXROW;
        this.MAXCOL = MAXCOL;
    }
    
    //Charge and split word in to a vector
    public String [] chargeWordInVector (String word){ 
                     String [] wordSeparated;
                     wordSeparated = new String[word.length()];
                     String [] part=word.split("");
                     for(int i=0; i<word.length(); i++)
                         wordSeparated[i] = part[i]; 
                    return wordSeparated;
    }
    
    //Recieve a matrix and transform as uppercase
    public String [][] copyMatrix(String orginal[ ][ ],int MAXROW, int MAXCOL) {   
                    int lin, col;   
                    String copy[][] = new String[MAXROW][MAXCOL];
                    for (lin= 0; lin < MAXROW; lin++)     
                         for (col= 0; col < MAXCOL; col++)             
                             copy[lin][col] = orginal[lin][col].toUpperCase(); 
                   
                    return  copy;
   }
    
    public boolean diagonalBottomToTopSeacher(String [][] biArraya, int lin,  String [] palavraABuscar){
      
                    String [] wordToSearch=chargeWordInVector(getWord().toUpperCase());
                    for ( lin = biArraya.length-1 ; lin > 0 ; lin--) 
                    {
                          int colAux=0;
                          if(biArraya[lin][lin].equals(wordToSearch[colAux])){
                             if(lin>=(wordToSearch.length-1))
                                   return true;
                             colAux++;
                          }  
                    } 
                 return false;
    }
    
    public boolean diagonalTopToBottomSeacher(String [][] biArraya, int lin,  String [] palavraABuscar){
       
                    String [] wordToSearch=chargeWordInVector(getWord().toUpperCase());
                    for ( lin = 0; lin < biArraya.length ; lin++) 
                    {
                        if(biArraya[lin][lin].equals(wordToSearch[lin])){
                           if(lin>=(wordToSearch.length-1))
                                 return true;
                        }
                    } 
               return false;
    }
   
    public boolean jogoLocalizaPalavras (){
                    String [] wordToSearch=chargeWordInVector(getWord().toUpperCase());
                    int lin=0;
                    int col=0;
              
                    int colAux=0;
                    
                    String [][] biArraya = new String [getMAXROW()][getMAXCOL()];
             
                    biArraya=getBiArray();
                    if(horizontalSeacher(biArraya,getMAXROW(), getMAXCOL(), lin, col, wordToSearch,  colAux))    
                        return true;
                      else if(verticalSeacher(getBiArray(), lin, col, wordToSearch,  colAux)) 
                          return true;
                      else if (diagonalTopToBottomSeacher(getBiArray(), lin, wordToSearch)) 
                          return true;
                     else if (diagonalBottomToTopSeacher(getBiArray(), lin, wordToSearch)) 
                          return true;
                    
                   return false;
    }
    
    public boolean horizontalSeacher(String [][] biArraya, int MAXROW, int MAXCOL, int lin,int col,  String [] palavraABuscar, int colAux){
         
                   String [] wordToSearch=chargeWordInVector(getWord().toUpperCase());
                  
                   for(lin=0; lin < getMAXROW(); lin++){  
                       for(col= 0; col < getMAXCOL(); col++)   {
                           if(biArraya[lin][col].equals(wordToSearch[colAux])){
                               colAux=colAux+1;
                               if(colAux>=(wordToSearch.length))
                                  return true;
                           }
                             else{
                                     colAux=0;
                            }
                        }
                    }
           return false;
    }
    
     public boolean verticalSeacher(String [][] biArraya, int lin,int col,  String [] palavraABuscar, int colAux){
         
                      
                     String [] wordToSearch=chargeWordInVector(getWord().toUpperCase());
                     if(wordToSearch.length<=biArraya.length)
                     {
                        colAux=0;
                        for(lin=0; lin<biArraya.length; lin++){
                            for( col =0; col<biArraya[lin].length;col++){
                                if(biArraya[lin][col].equals( wordToSearch[0])){
                                   colAux=colAux+1;
                                   for(int linAux=lin+1; linAux<biArraya.length; linAux++){
                                        if(col < biArraya[linAux].length)
                                        {
                                            if(biArraya[linAux][col].equals( wordToSearch[colAux]))
                                               colAux=colAux+1;
                                               if(colAux==wordToSearch.length)
                                                  return true;
                                        }
                                        else
                                        {
                                            colAux=0;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return false;
     }
     
    public String[][] getBiArray() {
        return biArray;
    }

    public void setBiArray(String[][] biArray) {
        this.biArray = biArray;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getMAXROW() {
        return MAXROW;
    }

    public void setMAXROW(int MAXROW) {
        this.MAXROW = MAXROW;
    }

    public int getMAXCOL() {
        return MAXCOL;
    }

    public void setMAXCOL(int MAXCOL) {
        this.MAXCOL = MAXCOL;
    }
}