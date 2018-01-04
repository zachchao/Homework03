package edu.miracosta.cs113;

/**
 *LinkedList.java Creates a custom linked list class
 *
 *Class Invariant : None
 *
 *@author   Zachary Chao <zach.chao@yahoo.com> (A lot taken from Nery Chapeton-Lamas)
 *@version  1.0
 *   
 */
public class SingleLinkedList <E>{
	private Node <E> head = null;
	private int size = 0;
	
	/**
	 * Gets the data from the node given the index
	 * @param index the index of the node to get
	 * @return the data of the node
	 */
	public E get(int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (getNode(index) == null){
			return null;
		}
		return getNode(index).data;
	}
	
	/**
	 * Public setter for the linked list
	 * @param index The index to set the new data
	 * @param newData The new data to set into the node
	 * @return The data fo the node that was deleted
	 */
	public E set(int index, E newData){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		E oldData = node.data;
		node.data = newData;
		return oldData;
	}
	
	/**
	 * Gets the size
	 * @return size
	 */
	public int size(){
		return size;
	}
	
	/**
	 * Add an item at the end of the list
	 * @param item The data to add to the list
	 * @return True always because it overrides List interface
	 */
	public boolean add(E item){
		add(size, item);
		return true;
	}
	
	/**
	 * Allows the user to add a new data to the linked list
	 * @param index The index of where to add the new data
	 * @param item The new data to be added
	 * @return None
	 */
	public void add(int index, E item){
		if(index == 0){
			head = new Node<E>(item, head);
			size ++;
		}else if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}else{
			Node<E> node = getNode(index - 1);
			node.link = new Node<E>(item, node.link);
			size ++;
		}
	}
	
	/**
	 * Allows removal from the list given an index
	 * @param index The index of the node to remove
	 * @return returns The deleted node's data
	 */
	public E remove(int index) {
		if (index < 0 || index > size || size == 0){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		//If removing the head
		}else if (index == 0){
			Node<E> oldHead = head;
			head = oldHead.link;
			return oldHead.data;
		}else{
			Node<E> current = getNode(index);
			//If removing the last node just drop the link
			if (getNode(index+1) == null){
				getNode(index-1).link = null;
				return current.data;
			}else{
				getNode(index-1).link = current.link;
				return current.data;
			}
		}
	}
	
	/**
	 * Returns index of a given target, returns -1 if
	 * target is not found
	 * @param target The target to find
	 * @return Index of the target
	 */
	public int indexOf(E target) {
		Node<E> node = head;
		int index = 0;
		while (node != null) {
			if (node.data.equals(target)){
				return index;
			}
			node = node.link;
			index++;
		}
		//Reached end of list without finding anything
		return -1;
	}

	
	/**
	 * toString method for turning the list into a string
	 * @return a string representing the linkedList
	 */
	@Override
	public String toString(){
		Node<E> node = head;
		String result = "";
		while(node != null){
			result += node.data;
			if(node.link != null){
				result += " => ";
			}
			node = node.link;
		}
		return result;
	}
	
	/**
	 * toString method for custom delimiter
	 * @return a string representing the linkedList with a delimiter
	 */
	public String toString(String delim){
		Node<E> node = head;
		String result = "";
		while(node != null){
			result += node.data;
			if(node.link != null){
				result += delim;
			}
			node = node.link;
		}
		return result;
	}
	
	/**
	 * Gets the node given an index
	 * @param index The index of the node to retrieve
	 * @return The node at the given index
	 */
	private Node<E> getNode(int index){
		Node<E> node = head;
		int i = 0;
		while(i < index && node != null){
			node = node.link;
			i++;
		}
		return node;
	}
	
	/**
	 *Private inner Node class for holding data and a link to a new node
	 *Class Invariant : None
	 *@author   Zachary Chao <zach.chao@yahoo.com>
	 *@version  1.0
	 */
	private class Node <E>{
		private Node <E> link;
		private E data;
		
		/** 
		 * Creates a new node with a null text field aka tail node
		 * @param data The data stored
		 * @return None
		 */
		private Node(E data){
			this.data = data;
			this.link = null;
		}
		
		/**
		 * Creates a new node that references another node
		 * @param data The data stored
		 * @param link The node referenced by the new node
		 * @return None
		 */
		private Node(E data, Node <E> link){
			this.data = data;
			this.link = link;
		}
	}
}
