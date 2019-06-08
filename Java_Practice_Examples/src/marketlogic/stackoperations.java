package marketlogic;

import java.util.Scanner;

public class stackoperations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int operations_size = 0;
        operations_size = Integer.parseInt(in.nextLine().trim());

        String[] operations = new String[operations_size];
        for(int i = 0; i < operations_size; i++) {
            String operations_item;
            try {
                operations_item = in.nextLine();
            } catch (Exception e) {
                operations_item = null;
            }
            operations[i] = operations_item;
        }

        superStack(operations);
        
    }
	static int topIndex = -1;
	static void superStack(String[] operations) {
		String arr[] = new String[operations.length];
		for(int i=0; i<operations.length;i++){
			String operation = operations[i];
			String operationElements[] = operation.split(" ");
			performOperation(arr, operationElements);
		}
    }
	
	public static void performOperation(String[] arr, String[] operationArray){
		if(operationArray[0].equals("push")){
			topIndex = topIndex+1;
			arr[topIndex] = operationArray[1];
			System.out.println(arr[topIndex]);
		}
		if(operationArray[0].equals("pop")){
			if(topIndex==-1){
				System.out.println("EMPTY");
			}
			else if(topIndex==0){
				topIndex = topIndex-1;
				System.out.println("EMPTY");
			}
			else if(topIndex>0){
				topIndex = topIndex-1;
				System.out.println(arr[topIndex]);
				
			}
		}
		if(operationArray[0].equals("inc")){
			int numberOfBottomElements = Integer.parseInt(operationArray[1]);
			if(Math.abs(topIndex - numberOfBottomElements)>=0){
				int k=0;
				while(numberOfBottomElements>0){
					int value = (Integer.parseInt(arr[k])+ Integer.parseInt(operationArray[2]));
					arr[k] = String.valueOf(value);
					k++;
					numberOfBottomElements--;
				}
			}
			System.out.println(arr[topIndex]);
		}
	}
}
