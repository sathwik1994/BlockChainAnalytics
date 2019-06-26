import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockChain2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String csvFile = "transactions (10172018).csv";
		String csvFile1 = "blocks (10172018).csv";
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        Map<Integer, String> m = new HashMap<Integer, String>();
        Map< String,Integer> m2 = new HashMap< String,Integer>();
        Map< Integer,String> m3 = new HashMap< Integer,String>();

        Map<String, String> m1 = new HashMap<String, String>();
        List<String> al= new ArrayList<String>();
        System.out.println("2. List up all the blocks by their # transactions in an increasing order");
        System.out.println("");
        int p=0;
           try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	String[] transactions = line.split(cvsSplitBy);
                m.put(p, transactions[1]);
                m2.put( transactions[7],p);
               
                al.add(transactions[7]);
                p++;
  
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
        
        
        
        try {

            br = new BufferedReader(new FileReader(csvFile1));
            while ((line = br.readLine()) != null) {

                // use comma as separator
            	String[] blocks = line.split(cvsSplitBy);
                
                m1.put(blocks[1], line);

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
        
        for(int i=0; i<arr.length-1; i++) {
        	if(arr[i]>arr[i+1]) {
       		m3.put( arr[i],m.get(i));
        	}
        }
        Collection<Integer> values = m3.keySet();
		
      ArrayList<Integer> al2 = new ArrayList<Integer>(values);

        int[] arr1 = new int[al2.size()];

        for(int i = 0; i < al2.size(); i++) {
            if (al2.get(i) != null) {
                arr1[i] = (al2.get(i));
            }
        }
        
        BlockChain bc1= new BlockChain();
        bc1.sort(arr1, 0, arr1.length-1);
      System.out.println(m1.get("block number"));
        for(int i=0; i<arr1.length; i++) {
        
        	
        	System.out.println(m1.get(m3.get((arr1[i]))));
        }
        
        System.out.println();
       
        long end = System.currentTimeMillis();
        long x= end-start;
        System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
        System.out.println("Execution time is: (in milliseconds):"+x);

	}

}
