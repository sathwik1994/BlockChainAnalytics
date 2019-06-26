import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BlockChain3 {
	
	void merge(double arr[], int l, int m, int r) 
    { 
         
        int arr1cont = m - l + 1; 
        int arr2cont = r - m; 
        double arr1[] = new double [arr1cont]; 
        double arr2[] = new double [arr2cont]; 
  
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
  
    void sort(double arr[], int l, int r) 
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
		String csvFile = "transactions (10172018).csv";
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
       
        Map<String, List<String>> m = new HashMap<String, List<String>>();
     
        ArrayList<String> list;
        System.out.println("3. List up all the transactions by their transaction fee in an increasing order");
        System.out.println("");
      

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	String[] transactions = line.split(cvsSplitBy);
            	if(m.containsKey(transactions[5])) {
            		m.get(transactions[5]).add(line);
            	}else {
            		list = new ArrayList<String>();
            	    list.add(line);
            		m.put(transactions[5], list);
            	}

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

        System.out.println(m.get("gas price"));
        Set<String> li= m.keySet();
        li.remove("gas price");
        String arr[] = new String[li.size()];
        int i = 0; 
        for(String s:li) {
        	arr[i++] = s;
        }
        double[] arr1= new double[arr.length];
        for(int j=0; j<arr.length; j++) {
        	arr1[j]= Double.parseDouble(arr[j]);
        	
        }
        BlockChain3 bc3= new BlockChain3();
        bc3.sort(arr1, 0, arr.length-1);
       
        List<String> list1;
        
        for(int j=0; j<arr1.length;j++) {
        	
        	long l = (long) arr1[j];
        	//System.out.println(l);
        	list1 = new ArrayList<String>();
        	if(l==100000000000L) {
        		list1 = m.get("1.00E+11");
        		
        	}
        	else if(l==200000000000L) {
        		list1 = m.get("2.00E+11");
        	}
        	else {
        		list1 = m.get(String.valueOf(l));
        	}
        	
        	
        	for(int k = 0; k< list1.size() ; k++) {
        		
        		System.out.println(list1.get(k));
        	}
        	
        	
        }
        long end = System.currentTimeMillis();
        long x= end-start;
        System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
        System.out.println("Execution time is: (in milliseconds):"+x);
	}

}
