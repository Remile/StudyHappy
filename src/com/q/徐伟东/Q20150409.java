package com.q.徐伟东;

public class Q20150409 {
	class Node {
		private Node next;
		public String data;
		
		public Node(String data) {
			this.data = data;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public Node getNext() {
			return next;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
	}
	class List {
		private Node head;
		public int length = 0;
		
		public boolean isEmpty() {
			if(head == null) {
				return true;
			}
			return false;
		}
		public void add(String data) {
			// 要添加的节点
			Node node = new Node(data);
			if(isEmpty()) {
				head = node;
			}else {
				// 我想要他指向链表的最后一节点
				Node nod = head;
				while(nod.getNext() != null) {
					nod = nod.getNext();
				}
				nod.setNext(node);
			}
			length ++;
		}
		public void display() {
			Node node = head;
			while(node != null) {
				System.out.println(node.getData());
				node = node.getNext();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Q20150409 q = new Q20150409();
		List list = q.new List();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.display();
	}
	
	
}
