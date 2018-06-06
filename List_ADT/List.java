/* * *
  This module was implemented by following an interface provided
  by Patrick Tantalo in CMPS 101 at UC Santa Cruz.
* * */

class List{

	// Node class used for the list elements
	private class Node{
		int data;
		Node prev;
		Node next;
		// Constructor
		Node(int data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		public String toString(){
			return String.valueOf(data);
		}
	}

	/* Doubly linked list variables, pointers to the first and last 
	   element of the list and a cursor element that can point to any
	   element in the list. Index provides the position of where the
	   current element points.
	*/
	Node first;
	Node last;
	Node current;
	int length;
	int index;

	// Constructor
	List(){
		this.first = null;
		this.last = null;
		this.current = null;
		this.index = -1;
		this.length = 0;
	}

	/* * Accessor Functions * */
	int length(){
		return this.length;
	}


	int index(){
		if(this.current != null){
			return index;
		}
		return -1;
	}

	int first(){
		if(this.length > 0 ){
			return first.data;
		}
		return -1;
	}

	int last(){
		if(this.length > 0 ){
			return last.data;
		}
		return -1;
	}

	int get(){
		if(this.length() > 0 && this.index() >= 0){
			return current.data;
		}
		return -1;
	}

	// Overrides super class Object's equals method.
	boolean equals(List L){
		if(this.length() != L.length()){
			return false;
		}
		if(this.length() == 0 && L.length() == 0){
			return true;
		}

		Node this_tmp = this.first;
		Node that_tmp = L.first;
		while(this_tmp != null){
			if(this_tmp.data != that_tmp.data){
				return false;
			}
			this_tmp = this_tmp.next;
			that_tmp = that_tmp.next;
		}
		return true;
	}

	/* * Manipulation procedures * */

	// Removes all elements in the list
	void clear(){
		while(this.first!=null){
			deleteFirst();
		}
	}

	// Moves the cursor to the first element in the list.
	void moveFirst(){
		if(this.length() > 0){
			this.current = first;
			this.index = 0;
		}
	}

	//  Moves the cursor to the last element in the list.
	void moveLast(){
		if(this.length() > 0){
			this.current = last;
			this.index = this.length - 1;
		}
	}

	// Moves the current pointer to the previous element
	void movePrev(){
		if(this.current != null && this.current != this.first){
			this.current = this.current.prev;
			this.index--;
		}else if(this.current != null && this.current == first){
			this.current = null;
			index = -1;
		}
	}

	// Moves the current pointer to the following element
	void moveNext(){
		if(this.current != null && this.current != this.last){
			this.current = this.current.next;
			this.index++;
		}else if(this.current != null && this.current == this.last){
			this.current = null;
			index = -1;
		}
	}


	void prepend(int data){
		if(this.length() == 0){
			Node node = new Node(data);
			this.first = node;
			this.last = node;
			this.length++;
		}else{
			Node node = new Node(data);
			this.first.prev = node;
			node.next = this.first;
			node.prev= null;
			this.first = node;
			this.length++;
			if(this.current != null){
				index++;
			}
		}
	}

	void append(int data){
		if(this.length() == 0){
			Node node = new Node(data);
			this.first = node;
			this.last = node;
			this.length++;
		}else{
			Node node = new Node(data);
			node.prev = this.last;
			node.next = null;
			this.last.next = node;;
			this.last = node;
			this.length++;
		}
	}

	// Pre: length > 0 and index be defined.
	// Post: 
	void insertBefore(int data){
		if(!(this.length() > 0 && this.index() >= 0)){
			throw new RuntimeException("Empty list or invalid index.");
		}
		// Case 1: In front of the list
		if(this.current == this.first){
			this.prepend(data);
		}else{
			Node tmp = new Node(data);
			tmp.next = this.current;
			tmp.prev = this.current.prev;
			this.current.prev.next = tmp;
			this.current.prev = tmp;
			this.index++;
			this.length++;
		}
	}

	void insertAfter(int data){
		if(!(this.length() > 0 && this.index() >= 0)){
			throw new RuntimeException("Empty list or invalid index.");
		}
		if(this.current == this.last){
			this.append(data);
		}else{
			Node tmp = new Node(data);
			tmp.next = this.current.next; 
			tmp.prev = this.current;
			this.current.next.prev = tmp;
			this.current.next = tmp;
			this.length++;
		}
	}

	void deleteFirst(){
		if(!(this.length() > 0)){
			throw new RuntimeException("List does not containg any elements.");
		}
		if(this.current == this.first){
			this.current = null;
		}
		Node tmp = this.first;
		if(this.length() == 1){
			this.first = null;
			this.last = null;
			tmp = null;
			this.length--;
		}else{
			this.first = this.first.next;
			this.first.prev = null;
			tmp.next = null;
			tmp.prev = null; // already should have been null because first elem
			tmp = null;
			this.length--;
		}
	}

	void deleteLast(){
		if(!(this.length() > 0)){
			throw new RuntimeException("List does not containg any elements.");
		}
		if(this.current == this.last){
			this.current = null;
		}
		Node tmp = this.last;
		if(this.length() == 1){
			this.last = null;
			this.first = null;
			tmp = null;
			this.length--;
		}else{
			this.last = this.last.prev;
			this.last.next = null;
			tmp.prev = null;
			tmp.next = null; // already should have been null because last elem
			tmp = null;
			this.length--;
		}
	}

	void delete(){
		if(!(this.length() > 0 && this.index() >= 0)){
			throw new RuntimeException("Empty list or invalid index.");
		}
		if(this.length() == 1){
			this.first = null;
			this.last = null;
			this.current.next = null; // was already null
			this.current.prev = null; // was already null
			this.current = null;
			this.length--;
		}else if(this.current == this.first){
			this.deleteFirst();
		}else if(this.current == this.last){
			this.deleteLast();
		}else{
			Node tmp = this.current;
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
			tmp.prev = null;
			tmp.next = null;
			tmp = null;
			this.current = null;
			this.length--;
		}

	}

	// Overrides Object's toString method
	public String toString(){
		StringBuilder str = new StringBuilder();
		if(this.length() == 0){
			return "";
		}
		Node tmp = null;
		tmp = this.first;
		for(int i = 0; i < this.length; i++){
			str.append(tmp.data);
			if(tmp != this.last){
				str.append(" ");
			}
			tmp = tmp.next;
		}
		return str.toString();
	}

	// Returns an indentical list of values as the original
	List copy(){
		List list = new List();
		Node tmp = this.current;
		for(this.moveFirst(); this.index() >= 0; this.moveNext()){
			int data = this.get();
			list.append(data);
		}
		this.current = tmp;
		return list;
	}

	// Returns a concatenation of the two lists leaving the orginals unchanged
	List concat(List L){
		List mylist = new List();
		Node tmp = this.first;
		while(tmp != null){
			mylist.append(tmp.data);
			tmp = tmp.next;
		}
		tmp = L.first;
		while(tmp != null){
			mylist.append(tmp.data);
			tmp = tmp.next;
		}
		return mylist;
	}

	

}