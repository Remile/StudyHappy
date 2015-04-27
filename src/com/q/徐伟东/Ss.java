package com.q.ÐìÎ°¶«;

import java.awt.SystemColor;

public class Ss {
	class Node{
		private Node next;
		public String data;
		public Node(String data){
			this.data=data;
		}
		public String getData(){
			return data;
		}
		
		public  Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	class List{
		private Node head;
		private int length=0;
	   public  boolean isEmpty(){
	        if(head!=null)
	        	return false;
	        else
	        	return true;
	   }
	   public void add(String data) {
		   Node node=new Node(data);
		    if(isEmpty()){
		    	head=node;
		    }else{
//		    	Node nod=node;
		    	Node nod = head;
		    	while(nod.getNext()!=null){
		    		nod=nod.getNext();
		    	}
		    	nod.setNext(node);
		    	length++;
		    }
		   
	   }
	   public void display(){
		Node node=head;
		while(node!=null){
			System.out.println(node.getData());
			node=node.getNext();
		}
 	   }   
	}
	public static void main(String[] args) {
		Ss i=new Ss();
		List a=i.new List();
		a.add("1");
		a.add("2");
		a.add("3");
		a.display();
	}

}

