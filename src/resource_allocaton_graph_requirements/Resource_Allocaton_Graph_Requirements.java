package resource_allocaton_graph_requirements;

import java.util.LinkedList;

public class Resource_Allocaton_Graph_Requirements {
	

	int process_Number;
	int edge_Number;
	
	String[] storage_String;// = new String[edge_Number];
//	String[] storage_Separated = new String[edge_Number];
	String[] output = new String[process_Number];
	

	
	public Resource_Allocaton_Graph_Requirements( int a, int b, String[] c)
	{
		process_Number = a;
		edge_Number = b;
		storage_String = c;
		
		
	}
	
	


	
	
	LinkedList<String> list_ContainerForHoldingInstance = new LinkedList<String>();
	LinkedList<String> list_ContainerForWaitingInstance = new LinkedList<String>();

	
	
	
	int[] Process_Number_Counting()
	{
		
		int[] process_Counting = new int[process_Number];
		
		
		System.out.println(process_Number);
		

		
		//Counting the number of a process that presents in the input storage
		for(int i = 0; i < process_Number; i++ )
		{
			
			process_Counting[i] = 0;
			
//			String[] tmp_Storage_Separated = storage_String[i].split(">");
			
			String temp = "P"+ (i+1);
			
			String process_Name = temp;
			
//			if( tmp_Storage_Separated[0] == (temp) )
//			{
//				process_Name = tmp_Storage_Separated[0];
//			}
//			
//			else if( tmp_Storage_Separated[1] == temp )
//			{
//				process_Name = tmp_Storage_Separated[1];
//			}

		
		
			//System.out.println("PRo. Name: " + temp + "process_Name: " + process_Name);
			
			for( int k = 0; k < edge_Number; k++ )
			{
				if( storage_String[k].contains(process_Name) )
				{
					System.out.println("PRo.FFF Name: " + process_Name+":"+process_Counting[i]);
					process_Counting[i] = process_Counting[i] + 1;
					
				}	
				
				else
				{
					process_Counting[i] = process_Counting[i] + 0;
				}
				
			} //End of inner for( int k = 0; k < edge_Number; k++ );
			
			System.out.println("Process Counting:"+(i+1)+ " :"  + process_Counting[i]);

		} //End of outer for(int j = 0; j < process_Number; j++ );
	
		return process_Counting;
	
	} //void Process_Number_Counting();
	//------------------------------------
	
	
	
	
	
	
	public void Output_Calculation()
	{
		//int[] process_Counting = Process_Number_Counting();
		
		@SuppressWarnings("unchecked")
		LinkedList<String> list_Output_Container[] = new LinkedList[process_Number];
		
		for( int i = 0; i < process_Number; i++ )
		{
			
			list_Output_Container[i] = new LinkedList<String>();
		}
		
		
//		System.out.println("Inside Output Calc.");
		
		LinkedList<String> list_Storage_String = new LinkedList<String>();
		for(int i = 0; i < edge_Number; i++ )
		{
			list_Storage_String.addLast( storage_String[i] );
		}
		
		
		
		for( int i = 0; i < process_Number; i++ )
		{
			String process_Name = "P" + (i+1);
//			String[] tmp_Storage_Separated = list_Storage_String.getFirst().split(">");
//			
//			
//			
//			list_Storage_String.removeFirst();
//			
//			if( tmp_Storage_Separated[0].contains("P") )
//			{
//				process_Name = tmp_Storage_Separated[0];
//			}
//			
//			else if( tmp_Storage_Separated[0].contains("R") )
//			{
//				process_Name = tmp_Storage_Separated[1];
//			}
			
			
//			System.out.println("process_Number_Show: " + process_Name);
			
			
			for( int j = 0; j < edge_Number; j++ )
			{
				
				
				
				if( storage_String[j].contains(process_Name) )
				{
					String temp1 = storage_String[j];
					String[] temp2 = temp1.split(">");
					
					
					
					if( temp2[1].equalsIgnoreCase(process_Name) )
					{
						
						list_ContainerForHoldingInstance.addLast( temp2[0] );
						
		
						
//						String tmp = "Process "+ temp2[1] + " is holding an instance of resource type " + temp2[0];
//						System.out.println(tmp + " :i: "+i);

//						list_Output_Container[i].addFirst(tmp);
					}
					
					else if( temp2[0].equalsIgnoreCase(process_Name) )
					{
						
						list_ContainerForWaitingInstance.addLast( temp2[1] );
						
						
//						System.out.println("Temp2: " + temp2.length);
//						System.out.println("Temp2[0]: " + temp2[0]);
//						System.out.println("Temp2[1]: " + temp2[1]);
						
//						String tmp = "Process "+ temp2[0] + " is waiting for an instance of type " + temp2[1];
//						list_Output_Container[i].addLast(tmp);
					}
					
//					else
//					{
//						System.out.println("Error occured !! Error Code 401");
//					}
					
					
					
					
				} //End of if( storage_String[j].contains(process_Name) ) Scope;
				
			} //End of for( int j = 0; j < edge_Number; j++ );
			
			Print_Output(process_Name);

			
		} //End of for( int i = 0; i < process_Number; i++ ) Scope;
		
		
		
		
	} //End of void Output_Calculation() Scope;
	
	
	
	
	
	
	
	
	
	
	//Printing the generated outputs
	void Print_Output(String p_Name)
	{
		int flag = 0;
		
		System.out.println();
		
//		System.out.println("Inside print");
//		System.out.println("List Hold: "+list_ContainerForHoldingInstance.size() );
//		System.out.println("List Hold: "+list_ContainerForWaitingInstance.size() );
		
		while( list_ContainerForHoldingInstance.size() != 0 )
		{
			if( list_ContainerForHoldingInstance.size() == 1 )
			{
				String tmp = "Process "+ p_Name + " is holding an instance of resource type " + list_ContainerForHoldingInstance.getFirst();
				
				System.out.println( tmp );
				
				list_ContainerForHoldingInstance.removeFirst();
				
				flag = 999;
			}
			
			else if( list_ContainerForHoldingInstance.size() > 1 )
			{
				String tmp = "Process "+ p_Name + " is holding an instance of resource type " + list_ContainerForHoldingInstance.getFirst();
				
				
				list_ContainerForHoldingInstance.removeFirst();
				
				for( int j = 0; j < list_ContainerForHoldingInstance.size(); j++ )
				{
					tmp = tmp + " and ";
					tmp = tmp + list_ContainerForHoldingInstance.get(j);
					
				}
				
				tmp = tmp + " ";
				
				if( list_ContainerForWaitingInstance.size() != 0 )
				{
					tmp = tmp + "and ";
				}
				
				System.out.println( tmp );
				flag = 999;
				
				if( list_ContainerForHoldingInstance.size() != 0 )
				{
					for( int j = 0; j < list_ContainerForHoldingInstance.size(); j++ )
					{
						list_ContainerForHoldingInstance.removeFirst();
					}
				}
				
				else
					break;
				
		
				
			} //End of else if( list_ContainerForHoldingInstance.size() > 1 );
		} //End of while( list_ContainerForHoldingInstance.size() != 0 ) scope;
		
		
		
		
		while( list_ContainerForWaitingInstance.size() != 0 )
		{
			if( list_ContainerForWaitingInstance.size() == 1 && flag == 0)
			{
				String tmp = "Process "+ p_Name + " is waiting for an instance of resource type " + list_ContainerForWaitingInstance.getFirst();
				list_ContainerForWaitingInstance.removeFirst();
				
				System.out.println(tmp);
			}
			
			else if( list_ContainerForWaitingInstance.size() == 1 && flag == 999 )
			{
				String tmp = " and is waiting for an instance of resource type " + list_ContainerForWaitingInstance.getFirst();
				list_ContainerForWaitingInstance.removeFirst();
				
				System.out.println(tmp);
			}
			
			else if( list_ContainerForWaitingInstance.size() > 1 && flag == 0 )
			{
				String tmp = "Process "+ p_Name + " is waiting for an instance of type " + list_ContainerForWaitingInstance.getFirst();
				list_ContainerForWaitingInstance.removeFirst();
				
				for( int j = 0; j < list_ContainerForWaitingInstance.size(); j++ )
				{
					tmp = tmp + " and ";
					tmp = tmp + list_ContainerForWaitingInstance.get(j);
				}
				
				tmp = tmp + " ";
				
				
				System.out.println( tmp );
				
				if( list_ContainerForWaitingInstance.size() != 0 )
				{
					for( int j = 0; j < list_ContainerForWaitingInstance.size(); j++ )
					{
						list_ContainerForWaitingInstance.removeFirst();
					}
				}
				
				else
					break;
				
				
				
			} //End of else if( list_ContainerForWaitingInstance.size() > 1 );
			
			
			else if( list_ContainerForWaitingInstance.size() > 1 && flag == 999 )
			{
				String tmp = " and is waiting for an instance of type " + list_ContainerForWaitingInstance.getFirst();
				list_ContainerForWaitingInstance.removeFirst();
				
				for( int j = 0; j < list_ContainerForWaitingInstance.size(); j++ )
				{
					tmp = tmp + " and ";
					tmp = tmp + list_ContainerForWaitingInstance.get(j);
				}
				
				tmp = tmp + " ";
				
				
				System.out.println( tmp );
				
				if( list_ContainerForWaitingInstance.size() != 0 )
					{
						for( int j = 0; j < list_ContainerForWaitingInstance.size(); j++ )
						{
							list_ContainerForWaitingInstance.removeFirst();
						}
					}
					
				else
					break;
				
				
				
				
				
			} //End of else if( list_ContainerForWaitingInstance.size() > 1 );
			
		} //End of while( list_ContainerForWaitingInstance.size() != 0 );
		
		
	} //End of void Print_Output() Scope;
	

} //End of class Resource_Allocaton_Graph_Requirements Scope;
