package resource_allocaton_graph;

import java.util.LinkedList;
import java.util.Scanner;

import resource_allocaton_graph_requirements.Resource_Allocaton_Graph_Requirements;

public class Resource_Allocaton_Graph {
	
	
	public static void main(String[] args) throws Exception
	{
		int process_Number;
		int resource_Number;
		int edge_Number; 		//Number of edge Numbers
		String[] storage;
		String[] str_Storage; 	//To merge all input string into one String variable;
		
		
		LinkedList<String> list_Edge_Storage = new LinkedList<String>();
		
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Ener process number: ");
		process_Number = input.nextInt();
		
		//System.out.println();
		
		System.out.print("Ener resource number: ");
		resource_Number = input.nextInt();
		
		System.out.print("Ener edge number: ");
		edge_Number = input.nextInt();
		
		System.out.println();
		
		
		
		int[] process_Counting = new int[process_Number];
		String[] storage_String = new String[edge_Number];
//		String[] storage_Separated = new String[edge_Number];
		String[] output = new String[process_Number];
		
		
		//This will take input from user, that is: Process & Resource no.
		System.out.println("Enter process/resource number>process/resource number\n");
		for(int i = 0; i < edge_Number; i++ )
		{
			//System.out.print();
			System.out.print( (i+1) + ": ");
			storage_String[i] = input.next();
			
			list_Edge_Storage.addLast( storage_String[i] );	
		}
		
		if( edge_Number > 10 )
		{
			System.out.println("\nCaution: " +edge_Number );
			System.out.println("Edge Number is not allowed more than 10.");
			System.out.println("System is exiting...");
			System.exit(1);
		}
		
		else if( process_Number > 10 )
		{
			System.out.println("\nCaution: " +process_Number );
			System.out.println("Process Number is not allowed more than 10.");
			System.out.println("System is exiting...");
			System.exit(1);
		}
		
		for(int i = 0; i < edge_Number; i++ )
		{
			if( storage_String[i].length() != 5 )
			{
				System.out.println("\nCaution: " +storage_String[i] );
				System.out.println("OOPS !! You entered wrong input. Input must be of length 5. (i.e: P1>R1)");
				System.out.println("System is exiting...");
				System.exit(1);
			}
			
		}
		
		
		Resource_Allocaton_Graph_Requirements object_RAG = new Resource_Allocaton_Graph_Requirements(process_Number, edge_Number,storage_String);
		
//		System.out.println("List_Storage: " + list_Edge_Storage.get(0));
//		System.out.println("List_Storage: " + list_Edge_Storage.get(1));
//		System.out.println("List_Storage: " + list_Edge_Storage.get(0).contains("P1") );
//		System.out.println();
		
		
		object_RAG.Output_Calculation();
//		object_RAG.Print_Output();
		
		
		
//		//--------------------------------------------------------------------
//		//Calculating the output for each process for every specified resources
//		for(int i = 0; i < edge_Number; i++ )
//		{
//			String process_Name = "";
//			String[] tmp_Storage_Separated = storage_String[i].split(">");
//			
//			if( tmp_Storage_Separated[0].contains("P") )
//			{
//				process_Name = tmp_Storage_Separated[0];
////				process_Name = process_Name + (i+1);
//			}
//			
//			else if( tmp_Storage_Separated[0].contains("R") )
//			{
//				process_Name = tmp_Storage_Separated[1];
////				process_Name = process_Name + (i+1);
//			}
//			
//			
//			
//			//Saving the output for each process to an array of String.Next, just print it.
////			for(int j = 0; j < list_Edge_Storage.size(); j++ )
//			
//				
//				System.out.println("List_Storage2: " + list_Edge_Storage.get(i).contains(process_Name) );
//				System.out.println("F: " + process_Name);
//				System.out.println();
//				
//				
//				//Checking how many time a process occurs in input Strings.
//				if( list_Edge_Storage.get(i).contains(process_Name) )
//				{
//					String temp = list_Edge_Storage.get(i);
////					char[] char_Array = temp.toCharArray();
//					String[] tmp_Storage_Separated2 = temp.split(">");
//					
//					System.out.println("Fuck");
//					
//					
//					if( tmp_Storage_Separated2[0] == process_Name )
//					{
//						output[i] = output[i] + "Process ";
//						output[i] = output[i] + tmp_Storage_Separated2[0];
//						output[i] = output[i] + " is waiting for an instance of resource type of ";
//						output[i] = output[i] + tmp_Storage_Separated2[1];
//					}
//					
//					else if(tmp_Storage_Separated2[1] == process_Name )
//					{
//						output[i] = output[i] + "Process ";
//						output[i] = output[i] + tmp_Storage_Separated2[1];
//						output[i] = output[i] + " is holding an instance of resource type of ";
//						output[i] = output[i] + tmp_Storage_Separated2[0];
//						
//					}
//					
//					System.out.println("2-Process_Name: " + process_Name);
//					
//					
//				} //End of If Condition scope;
//				
//				
//				else
//				{
//					System.out.println("ELSE -> Process_Name: " + process_Name);
//					System.out.println("\nOOPS !!  Something went wrong.\nError code: 404");
//					break;
//				}
//					
//				
//				
////			} //Inner for(int j = 0; j < list_Edge_Storage.size(); j++ );
//			
//			
//		} //End of Outer for(int i = 0; i < edge_Number; i++ );
//		
	
		
		
//----------------------------------------		
	} //Main() Method;
	
} //public class Resource_Allocaton_Graph;
