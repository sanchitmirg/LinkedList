package linkedList1;

public class LinkedList {
	
	//Linked list first element that is referenced
	Node head;
	
	//inner class which is a node
	public static class Node{
		
		int data;
		Node next;
		
		Node(int d){
			data = d;
		}
	}
	
	//to print the data in the Linked List
	public void printList(){
		
		Node n = head;
		
		while (n!=null){
			System.out.print(n.data);
			n = n.next;
		}
	}
	
	//insert a node to the starting of the LinkedList
	public void push(int new_data){
		
		Node new_node = new Node(new_data);
		new_node.next = head;
		//now head will be the new node.
		head = new_node;
	}
	
	//inserting a node after the mentioned node.
	public void inserAfter(Node prev_node, int new_data){
		
		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}
	
	public void append(int new_data){
		
		Node new_node = new Node(new_data);
		
		if(head == null){
			head = new Node(new_data);
			return;
		}
		
		//making the new node next value as null because
		//last node does not have next
		new_node.next = null;
		
		//applying a loop to search for the last node
		Node last = head;
		while(last.next!=null){
			last = last.next;
		}
		
		//changing the next value of the last node to new_node;
		last.next = new_node;
	}
	
	public void deleteNode(int key){
		
		//taking a head node in a temp variable, 
		//declaring a prev node to store the node before the key node
		Node temp = head, prev = null;
		
		//searching the node first node with the key value
		while(temp.data != key){
			
			prev = temp;
			temp = temp.next;
		}
		
		//assigning the prev node next with the node to be deleted next.
		prev.next = temp.next;
		
	}
	
	//method to get the nodes in the LinkedList
	public int getCount(){
		
		int count = 0;
		Node temp = head;
		
		while(temp != null){
			temp = temp.next;
			count++;
		}
		
		return count;
	}
	
	public int getCountRec(Node node){
		
		return 1 + getCountRec(node.next);
	}
	
	public void swapNodes(int x, int y){
		
		Node prevX = null, currX = head;		
		while (currX != null && currX.data != x){
			prevX = currX;
			currX = currX.next;
		}
		
		Node prevY = null, currY = head;
		while (currY != null && currY.data != y){
			prevY = currY;
			currY = currY.next;
		}
		
		prevX.next = currY;
		prevY.next = currX;
		
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
		
	}
	
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		
		//initializing the nodes with data
		ll.head = new Node(8);
		Node second = new Node(3);
		Node third = new Node(6);
		
		//assigning the reference of the next node to the previous node.
		ll.head.next = second;
		second.next = third;
		
		// pushing a node to the start of the LinkedList
		ll.push(7);
		ll.push(1);
		ll.push(3);
		ll.push(2);
		
		ll.printList();
		
		//System.out.println("The total number of nodes in the LinkedList are:"+ll.getCount());
		
		ll.swapNodes(1, 8);
		
		System.out.println("");
		
		ll.printList();

	}

}
