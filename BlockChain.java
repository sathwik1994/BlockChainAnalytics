import java.io.BufferedReader;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockChain {
	  void merge(int arr[], int l, int m, int r) 
	    { 
	         
	        int arr1cont = m - l + 1; 
	        int arr2cont = r - m; 
	        int arr1[] = new int [arr1cont]; 
	        int arr2[] = new int [arr2cont]; 
	  
	        for (int i=0; i<arr1cont; ++i) 
	            arr1[i] = arr[l + i]; 
	        for (int j=0; j<arr2cont; ++j) 
	            arr2[j] = arr[m + 1+ j]; 
	  
	        int i = 0, j = 0; 
	        int k = l; 
	  
	        while (i < arr1cont && j < arr2cont) 
	        { 
	            if (arr1[i] <= arr2[j]) 
	            { 
	                arr[k] = arr1[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arr[k] = arr2[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        while (i < arr1cont) 
	        { 
	            arr[k] = arr1[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        while (j < arr2cont) 
	        { 
	            arr[k] = arr2[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	  
	    void sort(int arr[], int l, int r) 
	    { 
	        if (l < r) 
	        { 
	            int m = (l+r)/2; 
	  
	            sort(arr, l, m); 
	            sort(arr , m+1, r); 
	            merge(arr, l, m, r); 
	        } 
	    }
  
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String csvFile = "blocks (10172018).csv";
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Map<String, String> m = new HashMap<String, String>();
        List<String> al= new ArrayList<String>();
        System.out.println("1. List up all the blocks by their gas used in an increasing order:");
        System.out.println("");
        
      

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	String[] blocks = line.split(cvsSplitBy);

                m.put(blocks[7], line);
                
                al.add(blocks[7]);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        al.remove(0);
        String[] strings = al.toArray(new String[al.size()]);
    
        int[] arr= new int[strings.length];
        
        for(int i=0; i<strings.length; i++) {
        	arr[i]= Integer.parseInt(strings[i]);
        }
        BlockChain bc= new BlockChain();
        bc.sort(arr, 0, arr.length-1);
        System.out.println(m.get("gas used"));
       
        for(int i=0; i<arr.length; i++) {
        	System.out.println(m.get(Integer.toString(arr[i])));
        }
        long end = System.currentTimeMillis();
        System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
        System.out.print("Execution time is (in milliseconds): " + (end - start) + " milliseconds");
	}
}
