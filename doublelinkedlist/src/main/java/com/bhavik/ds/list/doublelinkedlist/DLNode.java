package com.bhavik.ds.list.doublelinkedlist;

/**
 * The Class DLNode.
 *
 * @author Bhavik Aniruddh Ambani
 * @version 1.0.0.1
 * @param <T>
 *            the generic type for which we want to create node
 */
public class DLNode<T> {

	/**
	 * The data which will hold the mail element of the node containing data
	 * part such as any POJO etc..
	 */
	private T data;

	/** The next node of the linked list. */
	private DLNode<T> next;

	/** The prev node of the linked list. */
	private DLNode<T> prev;

	/**
	 * Instantiates a new DL node with all null elements i.e. blank node.
	 */
	DLNode() {
		next = null;
		prev = null;
		data = null;
	}

	/**
	 * Instantiates a new DL node.
	 *
	 * @param data
	 *            the data object of the list
	 */
	DLNode(T data) {
		this(data, null, null);
	}

	/**
	 * Instantiates a new DL node.
	 *
	 * @param data
	 *            the data object of the list
	 * @param next
	 *            the next object of the list
	 * @param prev
	 *            the prev object of the list
	 */
	DLNode(T data, DLNode<T> next, DLNode<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data part of the node
	 */
	T getData() {
		return data;
	}

	/**
	 * Sets the next node.
	 *
	 * @param next
	 *            the new next node
	 */
	public void setNextNode(DLNode<T> next) {
		this.next = next;
	}

	/**
	 * Gets the prev node.
	 *
	 * @return the prev node
	 */
	public DLNode<T> getPrevNode() {
		return prev;
	}

	/**
	 * Sets the prev node.
	 *
	 * @param prev
	 *            the new prev node
	 */
	public void setPrevNode(DLNode<T> prev) {
		this.prev = prev;
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Gets the next node.
	 *
	 * @return the next node
	 */
	public DLNode<T> getNextNode() {
		return next;
	}

}
