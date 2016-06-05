package com.bhavik.ds.list.doublelinkedlist;

/**
 * The Class DoublyLinkedList.
 *
 * @param <T>
 *            the generic type
 * @author Bhavik Aniruddh Ambani
 * @version 1.0.0.1
 */
public class DoublyLinkedList<T> {

	/** The head node of the list. */
	private DLNode<T> head;

	/** The tail node of the list. */
	private DLNode<T> tail;

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	// Returns the no. of nodes in Doubly linked list
	public int getSize() {
		int count = 0;
		if (head == null)
			return count;
		else {
			DLNode<T> temp = head;
			do {
				temp = temp.getNextNode();
				count++;
			} while (temp != tail);
		}
		return count;
	}

	/**
	 * Traverse f.
	 */
	// Traverse from head
	public void traverseForward() {
		DLNode<T> temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNextNode();
		}
	}

	/**
	 * Traverse b.
	 */
	// Traverse from tail
	public void traverseBackward() {
		DLNode<T> temp = tail;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getPrevNode();
		}
	}

	/**
	 * Insert at beg.
	 *
	 * @param data
	 *            the data
	 */
	/* methods related to insertion in doubly linked list starts. */
	public void insertAtBegining(T data) {
		DLNode<T> newnode = new DLNode<T>(data);
		if (head == null) {
			head = newnode;
			tail = newnode;
			newnode.setNextNode(null);
			newnode.setPrevNode(null);
		} else {
			newnode.setNextNode(head);
			head.setPrevNode(newnode);
			head = newnode;
		}
	}

	public int getNodeCountBetween(T node1, T node2) {
		DLNode<T> node = head;
		boolean rootFound = false;
		int nodeCount = 0;
		while (node != null) {
			if (node.getData().equals(node1)) {
				rootFound = true;
			} else if (rootFound) {
				nodeCount++;
			}
			if (rootFound && node.getData().equals(node2)) {
				break;
			}
			node = node.getNextNode();
		}
		return nodeCount;
	}

	/**
	 * Insert at end.
	 *
	 * @param data
	 *            the data
	 */
	public void insertAtEnd(T data) {
		DLNode<T> newnode = new DLNode<T>(data);
		if (tail == null) {
			head = newnode;
			tail = newnode;
			newnode.setNextNode(null);
			newnode.setPrevNode(null);
		} else {
			newnode.setPrevNode(tail);
			tail.setNextNode(newnode);
			tail = newnode;
		}
	}

	/**
	 * Insert at position.
	 *
	 * @param data
	 *            the data
	 * @param position
	 *            the position
	 */
	public void insertAtPosition(T data, int position) {
		if (position < 0 || position == 0) {
			insertAtBegining(data);
		} else if (position > getSize() || position == getSize()) {
			insertAtEnd(data);
		} else {

			DLNode<T> temp = head;
			DLNode<T> newnode = new DLNode<T>(data);
			for (int i = 0; i < position - 1; i++) {
				temp = temp.getNextNode();
			}

			newnode.setNextNode(temp.getNextNode());
			temp.getNextNode().setPrevNode(newnode);
			temp.setNextNode(newnode);
			newnode.setPrevNode(temp);
		}
	}
	/* methods related to insertion in doubly linked list ends. */

	/* methods related to deletion in doubly linked list starts. */
	/**
	 * Removes the.
	 *
	 * @param node
	 *            the node
	 */
	// Removal based on a given node for internal use only
	@SuppressWarnings("unused")
	private void remove(DLNode<T> node) {
		if (node.getPrevNode() == null)
			head = node.getNextNode();
		else if (node.getNextNode() == null)
			tail = node.getPrevNode();
		else {
			DLNode<T> temp = node.getPrevNode();
			temp.setNextNode(node.getNextNode());

			node.getNextNode().setPrevNode(temp);
		}
		node = null;
	}

	/**
	 * Removes the.
	 *
	 * @param position
	 *            the position
	 * @return the t
	 */
	// Removal based on a given position
	public T remove(int position) {
		T data = null;
		if (position == 1) {
			data = head.getData();
			head = head.getNextNode();
		} else if (position == getSize()) {
			data = tail.getData();
			tail = tail.getPrevNode();
			tail.setNextNode(null);
		} else {
			DLNode<T> temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.getNextNode();
			}
			DLNode<T> node = temp.getNextNode();
			node.setPrevNode(temp.getPrevNode());
			temp.getPrevNode().setNextNode(node);
			temp = null;
		}
		return data;// Deleted node's data
	}
	/* methods related to deletion in doubly linked list ends. */

}
