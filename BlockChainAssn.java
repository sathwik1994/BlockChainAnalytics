import java.util.*; 
import java.io.*;


public class BlockChainAssn
{
	private static String block_File_Name = "blocks (10172018).csv";
	private static String transaction_File_Name = "transactions (10172018).csv";

	public static void fourthQstn() throws Exception
	{
		Block_Analytics dataanalytics = new Blockchain_Load(block_File_Name, transaction_File_Name).blockTransactionsLoad();

		long BeginTime= System.currentTimeMillis();
		dataanalytics.gas_price_sort();
		long LastTime= System.currentTimeMillis();
		System.out.println("4.List up all the transactions per block in an increasing order of gas fees");
		dataanalytics.transactionList_print();
		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");

		System.out.println("Execution time is: (in milliseconds): " + (LastTime-BeginTime));
		System.out.println("");
		System.out.println("");

	}

	public static void fifthQstn() throws Exception
	{
		AnalyticsOnTransaction dataanalytics = new Blockchain_Load(block_File_Name, transaction_File_Name).transactionsLoad();

		long BeginTime= System.currentTimeMillis();
		dataanalytics.blockNumber_sort();
		long LastTime= System.currentTimeMillis();
		System.out.println("5. List up all the transactions in groups per contract address in an increasing order of the block#");
		dataanalytics.list_print();
		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");

		System.out.println("Execution time is: (in milliseconds): " + (LastTime-BeginTime));
		System.out.println("");
		System.out.println("");
	}

	public static void sixthQstn(String blockNumber_search) throws Exception
	{
		Block_Analytics dataanalytics = new Blockchain_Load(block_File_Name, transaction_File_Name).blockTransactionsLoad();

		System.out.println("6. Search for a particular block# and then display its transactions list");
		long BeginTime= System.currentTimeMillis();
		dataanalytics.blockNumber_search(blockNumber_search);
		long LastTime= System.currentTimeMillis();
		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
	
		System.out.println("Execution time is: (in milliseconds): " + (LastTime-BeginTime));
		System.out.println("");
		System.out.println("");

	}

	public static void seventhQstn(String transactionHash_search) throws Exception
	{
		Block_Analytics dataanalytics = new Blockchain_Load(block_File_Name, transaction_File_Name).blockTransactionsLoad();
		System.out.println("7.Search for a particular Transaction hash code (0x3cf82e4ecd6f7dee909b9a866e2957492893bfef572b68346932df7a33e355ec)for an index within a block # and display its Block# and gas fee:");
		long BeginTime= System.currentTimeMillis();
		dataanalytics.transactionHash_search(transactionHash_search);
		long LastTime= System.currentTimeMillis();
		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
	
		System.out.println("Execution time is : (in milliseconds): " + (LastTime-BeginTime));
		System.out.println("");
		System.out.println("");

	}

	public static void eigthQstn(String transactionSearch_From) throws Exception
	{
		Block_Analytics dataanalytics = new Blockchain_Load(block_File_Name, transaction_File_Name).blockTransactionsLoad();
		System.out.println("8.Identify and list up all transactions originated from a particular public key(node) (0x62b0a4af48be6e4ef7d818b21fbdff5254a2a07e) and its total transaction fee:");
		long BeginTime= System.currentTimeMillis();
		dataanalytics.totalTransaction_Fees_from(transactionSearch_From);
		long LastTime= System.currentTimeMillis();
		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
		
		System.out.println("Execution Time is: (in milliseconds): " + (LastTime-BeginTime));
		System.out.println("");
		System.out.println("");
	}

	public static void ninthQstn(String transactionSearch_To) throws Exception
	{
		Block_Analytics dataanalytics = new Blockchain_Load(block_File_Name, transaction_File_Name).blockTransactionsLoad();
		System.out.println("9.Identify and list up all transactions destined to a particular public key(node) (0xa4d6ff84f3fc783f3f7f71177958cff19dd7ffc4): and its transaction fee:");
		long BeginTime= System.currentTimeMillis();
		dataanalytics.transaction_Totalfees_To(transactionSearch_To);
		long LastTime= System.currentTimeMillis();
		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
		
		System.out.println("Execution time is: (in milliseconds): " + (LastTime-BeginTime));
		System.out.println("");
		System.out.println("");
	}

	public static void tenthQstn(String contractID_search) throws Exception
	{
		AnalyticsOnTransaction dataanalytics = new Blockchain_Load(block_File_Name, transaction_File_Name).transactionsLoad();
		System.out.println("10.Identify the transaction ID in a particular node (Contract ID) (0x11b2add67c41dbc1f6971c40bdce225f6b7bbdd7) with the Smallest and largest value of tokens:");
		long BeginTime= System.currentTimeMillis();
		dataanalytics.min_maxToken_List(contractID_search);
		long LastTime= System.currentTimeMillis();
		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");

	
		System.out.println("Execution time is (in milliseconds): " + (LastTime-BeginTime));
		System.out.println("");
		System.out.println("");
	}

	public static void eleventhQstn() throws Exception
	{
		String start_BFS = "0x2e745a4cfdcac610e03d57248e683c655fb56640";
		System.out.println("11.Build a graph from the list of from's and to's of Transactions and traverse in DFS and BFS:");
		long BeginTime= System.currentTimeMillis();
		GraphTransaction graph = new Blockchain_Load(block_File_Name, transaction_File_Name).transactionGraph_Load();
		graph.graph_print();
		long LastTime= System.currentTimeMillis();

		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
		
		System.out.println("Time to build agraph is :(in milliseconds): " + (LastTime-BeginTime));
		System.out.println("");
		System.out.println("");

		System.out.println("BFS on generated graph and "+ start_BFS+" as the beginning node:");
		System.out.println("The shortest path from "+ start_BFS+" to other nodes in BFS:");
		BeginTime= System.currentTimeMillis();
		graph.bfs_print(start_BFS);
		LastTime= System.currentTimeMillis();
		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
		
		System.out.println("Execution time of BFS on the entire data (in milliseconds): " + (LastTime-BeginTime));
		System.out.println("");
		System.out.println("");


		System.out.println("DFS on the generated graph:");
		System.out.println("Node Id's in DFS");
		BeginTime= System.currentTimeMillis();
		graph.dfs_print(start_BFS);
		LastTime= System.currentTimeMillis();
		System.out.println("");
		System.out.println("\n");
		System.out.println("\n");
        System.out.println("Execution time of DFS on the entire data (in milliseconds): " + (LastTime-BeginTime));
        System.out.println("");
        System.out.println("");

	}

	public static void main(String args[]) throws Exception
	{
		
		  fourthQstn();
		  fifthQstn();
		  sixthQstn("3110817");
		  seventhQstn("0x3cf82e4ecd6f7dee909b9a866e2957492893bfef572b68346932df7a33e355ec");
		  eigthQstn("0x62b0a4af48be6e4ef7d818b21fbdff5254a2a07e");
		  ninthQstn("0xa4d6ff84f3fc783f3f7f71177958cff19dd7ffc4");
		  tenthQstn("0x11b2add67c41dbc1f6971c40bdce225f6b7bbdd7");
		  eleventhQstn();
		
	}

}



class Block_Analytics extends BlockChainAssn
{
	private LinkedList<NodeFile> block_chain;
	private Map<String, NodeFile> look_up;

	public Block_Analytics() 
	{
		block_chain = new LinkedList<NodeFile>();
		look_up = new HashMap<String, NodeFile>();
	}

	public NodeFile blockNumber_search(String block_number)
	{
		TransactionFile.header_print();		
		NodeFile node = null;

		if(look_up.containsKey(block_number)) {
                        node = look_up.get(block_number);
			ArrayList<TransactionFile> transactions_related = node.transactions_get();
			for (TransactionFile trans : transactions_related) {
				System.out.println(trans.toString());
			}
			return node;
                }

		return null;
	}
	
        public NodeFile transactionHash_search(String transaction_hash)
	{
		System.out.println("(Searching for: " + transaction_hash);
		System.out.println("Blockno\tindex\tTXN Fee(ETH)\tTx hash");
		for(NodeFile node : block_chain) {
			ArrayList<TransactionFile> transactions_related = node.transactions_get();

			for (TransactionFile trans : transactions_related) {
				if(trans.txn_hash().equals(transaction_hash)) {
					System.out.println(node.block_number()+"\t"+trans.index()+"\t"+node.gas_used()+"\t"+transaction_hash);
					return node;
				}
			}
		}
		return null;
	}

        public double totalTransaction_Fees_from(String transaction_from)
        {
                System.out.println("(Searching transactions from: " + transaction_from);
		TransactionFile.header_print();
		double fees_total = 0.0;
                for(NodeFile node : block_chain) {
                        ArrayList<TransactionFile> transactions_related = node.transactions_get();

                        for (TransactionFile trans : transactions_related) {
                                if(trans.from().equals(transaction_from)) {
                                        System.out.println(trans.toString());
					fees_total+= Double.parseDouble(node.gas_used());
                                }
                        }
                }

		System.out.println("Total Transaction Fee (ETH): " + fees_total);

                return fees_total;
        }

        public double transaction_Totalfees_To(String transaction_to)
        {
                System.out.println("(Searching transactions to: " + transaction_to);
                TransactionFile.header_print();
                double fees_total= 0.0;
                for(NodeFile node : block_chain) {
                        ArrayList<TransactionFile> transactions_related = node.transactions_get();

                        for (TransactionFile trans : transactions_related) {
                                if(trans.to().equals(transaction_to)) {
                                        System.out.println(trans.toString());
                                        fees_total+= Double.parseDouble(node.gas_used());
                                }
                        }
                }

                System.out.println("Total Transaction Fee (ETH): " + fees_total);

                return fees_total;
        }




	public void block_add(String block_hash, String block_number, int length, String time_stamp, String total_difficulty, String miner, String gas_limit, String gas_used)
	{
		BlockFile block = new BlockFile(block_hash, block_number, length, time_stamp, total_difficulty, miner, gas_limit, gas_used);
		NodeFile node = null;
		if(look_up.containsKey(block_number)) {
			node = look_up.get(block_number);	
			node.block_replace(block);
		} else {
			node = new NodeFile(block);
			block_chain.add(node);
		}
		look_up.put(block_number, node);
	}

	public void transaction_add(String block_hash, String block_number, String from, String to, String contract_id, String gas_price, String txn_hash, String index, String value)	 throws Exception {
		NodeFile node = null;
		if(look_up.containsKey(block_number)) {
                        node = look_up.get(block_number);
                        node.transaction_add(block_hash, block_number, from, to, contract_id, gas_price, txn_hash, index, value);
                }
	}

	public void gasSort()
	{
		Collections.sort(block_chain, new Comparator<NodeFile>() {
				@Override
				public int compare(NodeFile n1, NodeFile n2) {
				return n1.gas_used_compare(n2);
				}
				});

	}

        public void gas_price_sort()
        {
		for (NodeFile block : block_chain) {
			block.gas_price_sort();
		}

        }


	public void TransactionCountSort()
	{

                Collections.sort(block_chain, new Comparator<NodeFile>() {
                                @Override
                                public int compare(NodeFile n1, NodeFile n2) {
                                return n1.transactions_get().size() - n2.transactions_get().size();
                                }
                                });
	}


	public void list_print() 
	{
		BlockFile.header_print();
		for (NodeFile temp : block_chain) {
			System.out.println(temp.block_get().toString());
		}
	}

	public void transactionList_print() 
	{
		TransactionFile.header_print();
		for (NodeFile temp : block_chain) {
			ArrayList<TransactionFile> transactions_related = temp.transactions_get();
			for (TransactionFile trans : transactions_related) {
				System.out.println(trans);
			}
		}
	}

}


class Blockchain_Load extends BlockChainAssn
{
	private String block_File_Name;
	private String transaction_File_Name;

	Blockchain_Load(String block_File_Name, String transaction_File_Name)
	{
		this.block_File_Name = block_File_Name;
		this.transaction_File_Name = transaction_File_Name;
	}

	
	@SuppressWarnings("resource")
	public Block_Analytics blockTransactionsLoad() throws Exception
	{
		Block_Analytics dataanalytics = new Block_Analytics();
		String[] nextRow;
		String line;
		BufferedReader br;
		br = new BufferedReader(new FileReader(block_File_Name));
		line = br.readLine();
		while ((line = br.readLine()) !=null) {
			nextRow = line.split(",");
			if(nextRow.length >= 8) {
				dataanalytics.block_add(nextRow[0], nextRow[1], Integer.parseInt(nextRow[2]), nextRow[3], nextRow[4], nextRow[5], nextRow[6], nextRow[7]);
			}
		}

		br = new BufferedReader(new FileReader(transaction_File_Name));
		line = br.readLine();
		while ((line = br.readLine()) !=null) {
			nextRow = line.split(",");
			if(nextRow.length >= 9){
				dataanalytics.transaction_add(nextRow[0], nextRow[1], nextRow[2], nextRow[3], nextRow[4], nextRow[5], nextRow[6], nextRow[7], nextRow[8]);
			}
		}

		return dataanalytics;
	}

	@SuppressWarnings("resource")
	public AnalyticsOnTransaction transactionsLoad() throws Exception
	{
		AnalyticsOnTransaction dataanalytics = new AnalyticsOnTransaction();
		String[] nextRow;
		String line;
		BufferedReader br;

		br = new BufferedReader(new FileReader(transaction_File_Name));
		line = br.readLine();
		while ((line = br.readLine()) !=null) {
			nextRow = line.split(",");
			if(nextRow.length >= 9){
				dataanalytics.transaction_add(nextRow[0], nextRow[1], nextRow[2], nextRow[3], nextRow[4], nextRow[5], nextRow[6], nextRow[7], nextRow[8]);
			}
		}

		return dataanalytics;
	}

	@SuppressWarnings("resource")
	public GraphTransaction transactionGraph_Load() throws Exception
        {
                GraphTransaction graph = new GraphTransaction();
                String[] nextRow;
                String line;
                BufferedReader br;

                br = new BufferedReader(new FileReader(transaction_File_Name));
                line = br.readLine();
                while ((line = br.readLine()) !=null) {
                        nextRow = line.split(",");
                        if(nextRow.length >= 9){
				graph.edge_add(nextRow[2], nextRow[3]);
                        }
                }

                return graph;
        }

}


class AnalyticsOnTransaction extends BlockChainAssn
{
	private LinkedList<TransactionFile> transactions_All;

	public AnalyticsOnTransaction() 
	{
		transactions_All = new LinkedList<TransactionFile>();
	}

	public void transaction_add(String block_hash, String block_number, String from, String to, String contract_id, String gas_price, String txn_hash, String index, String value) {
                        TransactionFile trans = new TransactionFile(block_hash, block_number, from, to, contract_id, gas_price, txn_hash, index, value);
                        transactions_All.add(trans);
	}

	public void priceSort()
	{
		Collections.sort(transactions_All, new Comparator<TransactionFile>() {
				@Override
				public int compare(TransactionFile trans1, TransactionFile trans2) {
				return trans1.gas_price_compare(trans2.gas_price());
				}
				});

	}

        public void blockNumber_sort()
        {
                Collections.sort(transactions_All, new Comparator<TransactionFile>() {
                                @Override
                                public int compare(TransactionFile trans1, TransactionFile trans2) {
                                return trans1.block_number_compare(trans2.block_number());
                                }
                                });

        }

	public LinkedList<TransactionFile> contract_filter(String contract_id)
	{
		LinkedList<TransactionFile> transactions_filter = new LinkedList<TransactionFile>();
		for (TransactionFile trans : transactions_All) {
			if(trans.contract_id().equals(contract_id)) {
				transactions_filter.add(trans);
			}
		}

		return transactions_filter;
	}

	public void min_maxToken_List(String contract_id)
	{
		LinkedList<TransactionFile> transactions_filter= contract_filter(contract_id);
		System.out.println("(Searching for transactions of node with the Contract ID: "+contract_id+")");
		System.out.println("Transaction hash with the least number of tokens\tTransaction hash with the highest number of tokens");
		String minTransact = null, maxTransact = null;
		double minimumValue = 0.0, maximumValue = 0.0;

		for(TransactionFile trans : transactions_filter) {
			if(minTransact== null) {
				minTransact= trans.txn_hash();
				maxTransact= trans.txn_hash();
				minimumValue = Double.parseDouble(trans.value());
				maximumValue = Double.parseDouble(trans.value());
			}

			if(Double.parseDouble(trans.value()) < minimumValue) {
				minimumValue = Double.parseDouble(trans.value());
				minTransact= trans.txn_hash();
			}

			if(Double.parseDouble(trans.value()) > maximumValue) {
				maximumValue = Double.parseDouble(trans.value());
				maxTransact= trans.txn_hash();
			}

		}	

		if(minTransact != null) {
			System.out.println(minTransact + "\t" + maxTransact);
		}
	}

	public void list_print() {
		TransactionFile.header_print();
		for (TransactionFile trans : transactions_All) {
			System.out.println(trans);
		}
	}

}

class GraphTransaction extends BlockChainAssn
{
	private HashMap<String, NodeOfTransaction> graphHashMap;
	private HashMap<String, String> visitedHashMap;

	public GraphTransaction()
	{
		graphHashMap = new HashMap<String, NodeOfTransaction>();
	}

	public void edge_add(String from, String to)
	{
		NodeOfTransaction node = null;
		NodeOfTransaction new_node = new NodeOfTransaction(to);

		if(graphHashMap.containsKey(from)) {
			node = graphHashMap.get(from);
			node.neighbour_add(new_node);
		} else {
			node = new NodeOfTransaction(from);	
			node.neighbour_add(new_node);
			graphHashMap.put(from, node);
			
		}
	}	
	
	public void graph_print()
	{
		System.out.println("Displaying Graph:");	
		System.out.println("Counter.\tNode Public Key\t-->\tconnected node (weight), connected node , ...");
		int index = 0;
		for (Map.Entry<String, NodeOfTransaction> entry : graphHashMap.entrySet()) {
			index++;
			
			System.out.println(index + "\t" + entry.getKey() + "\t-->\t" + entry.getValue());
		}
	}

	public void bfs_print(String begin_node)
	{
		HashMap<String, String> visitedHashMap = new HashMap<String, String>();
		HashMap<String, Integer> lengthOfPath = new HashMap<String, Integer>();

		System.out.println("NodeId - Shortest path(number of edges)");
		int next_incr = 0, current_depth = 0;
		if(graphHashMap.containsKey(begin_node)) {
                        NodeOfTransaction beginNode = graphHashMap.get(begin_node);
			ArrayList<NodeOfTransaction> queue = beginNode.getAdjacency_list();
			
			int path_length = 0;
			lengthOfPath.put(begin_node, path_length);

			path_length++;
			for(NodeOfTransaction new_node : beginNode.getAdjacency_list()) {
				lengthOfPath.put(new_node.nodeName_get(), path_length);
			}

			next_incr += queue.size();
                                        System.out.print(beginNode.nodeName_get() + " - ");
                                        System.out.println(lengthOfPath.get(beginNode.nodeName_get()));

			while(!queue.isEmpty()) {
				NodeOfTransaction node = queue.get(0); 
				current_depth ++;

				if(current_depth > next_incr) {
					next_incr += queue.size();
					path_length++;
				}

				if(!visitedHashMap.containsKey(node.nodeName_get())){
					for(NodeOfTransaction new_node : node.getAdjacency_list()) {
						if(!visitedHashMap.containsKey(new_node.nodeName_get())){
							queue.add(new_node);
							lengthOfPath.put(new_node.nodeName_get(), path_length);
						}
					}
					System.out.print(node.nodeName_get() + " - ");
					System.out.println(lengthOfPath.get(node.nodeName_get()));

					visitedHashMap.put(node.nodeName_get(), node.nodeName_get());
				}
				queue.remove(0);
			}
                }
	}

	private void dfs_Util_print(NodeOfTransaction node)
	{
		if(!visitedHashMap.containsKey(node.nodeName_get())){
			visitedHashMap.put(node.nodeName_get(), node.nodeName_get());
			for(NodeOfTransaction new_node : node.getAdjacency_list()) {
				if(!visitedHashMap.containsKey(new_node.nodeName_get())){
					dfs_Util_print(new_node);
				}
			}
			System.out.println(node.nodeName_get());
		}
	}

	public void dfs_print(String begin_node)
	{
		visitedHashMap = new HashMap<String, String>();

		if(graphHashMap.containsKey(begin_node)) {
			System.out.println("Node");
			NodeOfTransaction beginNode = graphHashMap.get(begin_node);			
			dfs_Util_print(beginNode);
		}
	}
}

class NodeOfTransaction
{
	private String to;
	private ArrayList<NodeOfTransaction> adjacency_list; 

	public NodeOfTransaction(String to) 
	{
		this.to = to;
		adjacency_list = new ArrayList<NodeOfTransaction>();
	}

	public void neighbour_add(NodeOfTransaction node)
	{
		adjacency_list.add(node);
	}

	public ArrayList<NodeOfTransaction> getAdjacency_list()
	{
		return adjacency_list;
	}

	public String nodeName_get()
	{
		return to;
	}

	@Override
	public String toString()
	{
		String retVal = "" + to;
		for(NodeOfTransaction node : adjacency_list) {
			retVal += ", "+node.nodeName_get();	
		}
		return retVal;
	}
}

class NodeFile 
{
	private String block_hash;
	private BlockFile block;
	private ArrayList<TransactionFile> transactions; 

	public NodeFile(String block_hash, String block_number, int length, String time_stamp, String total_difficulty, String miner, String gas_limit, String gas_used) 
	{
		this.block = new BlockFile(block_hash, block_number, length, time_stamp, total_difficulty, miner, gas_limit, gas_used);
		this.block_hash = block_hash;
		transactions = new ArrayList<TransactionFile>();
	}

	public NodeFile(BlockFile block) 
	{
		this.block = block;
		this.block_hash = block.block_id();
		transactions = new ArrayList<TransactionFile>();
	}

	public boolean transaction_add(String block_hash, String block_number, String from, String to, String contract_id, String gas_price, String txn_hash, String index, String value) 
	{
		
		TransactionFile trans = new TransactionFile(block_hash, block_number, from, to, contract_id, gas_price, txn_hash, index, value);
		transactions.add(trans);
		return true;
	}

	public boolean transaction_add(TransactionFile trans)
	{
		if( !this.block_hash.equals(trans.block_id()) ) {
			return false;
		}

		transactions.add(trans);
		return true;


	}

	public void block_replace(BlockFile block) {
		this.block = block;
		this.block_hash = block.block_id();
	}

	public String block_id() 
	{
		return block_hash;
	}

	public String block_number()
	{
		return block.block_number();
	}

	public String gas_used()
	{
		return block.gas_used();
	}



	public int gas_limit_compare(String gas_limit) 
	{
		return this.block.gas_limit_compare(gas_limit);
	}

	public int gas_limit_compare(NodeFile node2)
	{
		return this.gas_limit_compare(node2.block.gas_limit_get());
	}

        public int gas_used_compare(String gas_used)
        {
                return this.block.gas_used_compare(gas_used);
        }

        public int gas_used_compare(NodeFile node2)
        {
                return this.gas_used_compare(node2.block.gas_used_get());
        }


	public void gas_price_sort()
	{
		Collections.sort(transactions, new Comparator<TransactionFile>() {
				@Override
				public int compare(TransactionFile trans1, TransactionFile trans2) {
				return trans1.gas_price_compare(trans2.gas_price());
				}
				});
	}

	public BlockFile block_get()
	{
		return this.block;
	}

	public ArrayList<TransactionFile> transactions_get()
	{
		return this.transactions;
	}
}


class BlockFile
{
	private String block_hash;
	private String block_number;
	private int length;
	private String time_stamp; 
	private String total_difficulty;
	private String miner;
	private String gas_limit;
	private String gas_used;

	public BlockFile(String block_hash, String block_number, int length, String time_stamp, String total_difficulty, String miner, String gas_limit, String gas_used) 
	{
		this.block_hash = block_hash;
		this.block_number = block_number;
		this.length = length;
		this.time_stamp = time_stamp;
		this.total_difficulty = total_difficulty;
		this.miner = miner;
		this.gas_limit = gas_limit;
		this.gas_used = gas_used;
	}

	public String block_id() 
	{
		return block_hash;
	} 

        public String block_number()
        {
                return block_number;
        }

        public String gas_used()
        {
                return gas_used;
        }


	public int gas_limit_compare(String gas_limit) 
	{
		return Double.compare(Double.parseDouble(this.gas_limit), Double.parseDouble(gas_limit));
	}

	public String gas_limit_get()
	{
		return this.gas_limit;
	}

        public int gas_used_compare(String gas_used)
        {
		return Double.compare(Double.parseDouble(this.gas_used), Double.parseDouble(gas_used));
        }

        public String gas_used_get()
        {
                return this.gas_used;
        }


	public static void header_print()
	{
		System.out.println("block_hash\tblock_number\tlength\ttime_stamp\ttotal_difficulty\tminer\tgas_limit\tgas_used");
	}

	@Override
		public String toString() {
			return block_hash + "\t" + block_number + "\t" + length + "\t" + time_stamp + "\t" + total_difficulty + "\t" + miner + "\t" + gas_limit + "\t" + gas_used;
		}

}


class TransactionFile
{
	private String block_hash;
	private String block_number;
	private String from;
	private String to; 
	private String contract_id;
	private String gas_price;
	private String txn_hash;
	private String index;
	private String value;

	public TransactionFile(String block_hash, String block_number, String from, String to, String contract_id, String gas_price, String txn_hash, String index, String value) 
	{
		this.block_hash = block_hash;
		this.block_number = block_number;
		this.from = from;
		this.to = to;
		this.contract_id = contract_id;
		this.gas_price = gas_price;
		this.txn_hash = txn_hash;
		this.index = index;
		this.value = value;
	}

	public String txn_hash()
	{
		return txn_hash;
	}

	public String contract_id()
	{
		return contract_id;
	}

        public String value()
        {
                return value;
        }


	public String index()
	{
		return index;
	}

        public String from()
        {
                return from;
        }

        public String to()
        {
                return to;
        }

	public String block_id() 
	{
		return block_hash;
	} 

	public int gas_price_compare(String gas_price) 
	{
		return Double.compare(Double.parseDouble(this.gas_price), Double.parseDouble(gas_price));
	}

	public int block_number_compare(String block_number)
	{
		return Double.compare(Double.parseDouble(this.block_number), Double.parseDouble(block_number));
	}

	public String block_number()
	{
		return this.block_number;
	}


	public String gas_price()
	{
		return this.gas_price;
	}


	public static void header_print()
	{
		System.out.println("block_hash\tblock_number\tfrom\tto\tcontract_id\tgas_price\ttxn_hash\tindex\token");
	}

	@Override
		public String toString() {
			return block_hash + "\t" + block_number + "\t" + from + "\t" + to + "\t" + contract_id + "\t" + gas_price + "\t" + txn_hash + "\t" + index + "\t" + value;
		}

}
