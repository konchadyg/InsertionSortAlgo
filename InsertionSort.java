//Author Name: Konchady Gaurav Shenoy
//NETID: kxs168430
//Programming assignment 1: Write a program that computes the number of inversions in a random permutation and runs the insertion sort on the same permutation. Compute t_i, be the number of shifts when ith element is inserted. Compare t, the sum of all t_i, and the number of inversions. Find a meaning of t_i in terms of inversions. 
//This assignment is just for practicing, not for grading.

//package insertionsort;

import java.util.Random;

/**
 *
 * @author konchady
 */
public class InsertionSort {

    final static int CAPVAL = 20;
    // Input: S[0..n−1] is the array of n numbers. // Output: sorted array S. 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random r = new Random();
        
        int[] s;
        //s= new int[]{5,8,6,1,4,22,7,5,93,1,44,7};
        
        int n = r.nextInt(Integer.MAX_VALUE)%CAPVAL;
        
        do{
        n = (n>0)?(n):(-n);
        if (n>0)break;
        }while(true);
        
        s = new int[n];
        
        for (int i=0;i<n;i++)
        {
            int newval = r.nextInt(Integer.MAX_VALUE)%CAPVAL;
            s[i] = newval>=0?newval:(-newval);
        }
        
        
        
        printArray(s);
        
        int inversions = getNumberOfInversions(s);
        int swaps=0; //Total swaps
        
        System.out.println("\n====================\n\n");
        
        for (int i=1;i<s.length;i++)
        //for (int i=s.length-1;i>=0;i--)
        {
            int x = s[i];
            int localiswap=0; //Each i swap
            //int j = i+1;
            //int k=0;
            for (int j=i-1 ; j>=0&&s[j]>s[j+1] ; j--)
            {
                int temp = s[j];
                s[j] = s[j+1];
                s[j+1] = temp;
                
                localiswap++;
                swaps++;
                
                        
            }
            
            System.out.println("Local swaps for "+i+": "+localiswap);
            //s[i] = x;
            
            printArray(s);
            
            
        }
        
        
       System.out.println("Total number of Swaps: "+swaps+" and total Inversions: "+inversions); 
    }
    
    //Print Array Contents
    public static void printArray(int[] d)
    {
        System.out.print("[ ");
        for(int i=0;i<d.length;i++)
        {
            System.out.print(d[i]);
            
            if(i+1 < d.length)
            {
                System.out.print(", ");
            }
        }
        
        System.out.println(" ]");
    }
    
    //Get Number of Inversions along with helpful messages
    public static int getNumberOfInversions(int[] d)
    {
        int inversions=0;
        
        for (int i=0;i<d.length;i++)
        {
            for (int j=i+1;j<d.length;j++)
            {
                if (d[i]>d[j])
                {
                    System.out.println("Inversion = ("+d[i]+","+d[j]+")");
                    inversions++;
                }
            }
        }
        
        System.out.println("Total Inversions found: "+inversions);
        
        return inversions;
        
    }
    
}
