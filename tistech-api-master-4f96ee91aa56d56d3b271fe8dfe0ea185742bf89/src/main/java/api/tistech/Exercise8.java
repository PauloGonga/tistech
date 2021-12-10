package api.tistech;

/*
 * @author Paulo Jacinto Morais Gonga
 * @Version 1
 * @Date 10/12/2021
 */

public class Exercise8 {
    
    private int a;
    private int b;
    private int c;
   
    public Exercise8(){
    }
       
    //Define the vector length
    public int  calulateTotalOfNumbers (int num){
                int totalOfNumbers=0;
                int restOfDivision=0;
                int division = 0;
                
                while(num > 0)
                {
                      restOfDivision=num%10;
                      division=(num/10);
                      totalOfNumbers++;
                      num=division;
                }
                return totalOfNumbers;
    }
    
    //Charge numbers in to a vector
    public int [] chargeElementsInVector (int num)
    {
                int restOfDivision=0;
                int division = 0;
                int totalOfNumbers=calulateTotalOfNumbers(num);
                int [] vector;
                vector = new int[totalOfNumbers];
               
                while(num>0){
                      restOfDivision=(num%10);
                      division=(num/10);
                      num=division;
                      totalOfNumbers=totalOfNumbers-1;
                      vector [totalOfNumbers]=restOfDivision;
                }
              return vector;
    }
    
    //Add numbers A and B to C number
    public int addNumbersToC (int numberA, int numberB){
      
           int[] vectorA  ;
           int[] vectorB ;
           int mainLength=0;
           String c="";
         
           vectorA  = new int[calulateTotalOfNumbers(numberA)];
           vectorB  = new int[calulateTotalOfNumbers(numberB)];
           vectorA = chargeElementsInVector (numberA);
           vectorB = chargeElementsInVector (numberB);
         
           
           //The initial length to concat the numbers
           mainLength=vectorA.length;
           if(vectorA.length<vectorB.length)
                mainLength=vectorB.length;
           for(int i=0;i<mainLength;i++)
           {    
               if(vectorA.length>i)
                  c+=vectorA[i];
               if(vectorB.length>i)
                   c+=vectorB[i];
           }
           if(Integer.parseInt(c)>1000000)          
               return -1;
           return 1;
    }
    
  

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    } 
    
}
