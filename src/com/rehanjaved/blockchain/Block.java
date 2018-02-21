package com.rehanjaved.blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rehanjaved.blockchain.transaction.Transaction;
import com.rehanjaved.helper.Utils;

/**
 * Represents a Block.
 * 
 * @author Rehan Javed
 * @version 1.0
 */
public class Block {

	// Attributes
	private int index;
	private String hash;
	private String previousHash;
	private Date timeStamp;
	private String data;
	private int countOfMiningTransaction;
	private List<Transaction> transactions;
	
	/**
	 * Constructor.
	 * 
	 * @param index
	 * @param previousHash
	 * @param timeStamp
	 * @param data
	 */
	public Block(int index, String previousHash, Date timeStamp, String data) {
		
		this.index = index;
		this.previousHash = previousHash;
		this.timeStamp = timeStamp;
		this.data = data;
		transactions = new ArrayList<Transaction>();
		this.countOfMiningTransaction = 0;
		
		// Generated hash for block.
		this.hash = Utils.generateHash(getBlockString());
		
	}
	
	/**
	 * Constructor.
	 * 
	 * @param index
	 * @param previousHash
	 * @param data
	 */
	public Block(int index, String previousHash, String data){
		
		this(index, previousHash, (new Date()), data);
		
	}
	
	/**
	 * Constructor.
	 * 
	 * @param index
	 * @param previousHash
	 */
	public Block(int index, String previousHash){
		
		this(index, previousHash, "");
		
	}
	
	/**
	 * @return index
	 */
	public int getIndex() {
		
		return index;
		
	}

	/**
	 * @return hash
	 */
	public String getHash() {
		
		return hash;
	
	}

	/**
	 * @return previousHash
	 */
	public String getPreviousHash() {
	
		return previousHash;
	
	}

	/**
	 * @return timeStamp
	 */
	public Date getTimeStamp() {
		
		return timeStamp;
	
	}

	/**
	 * @return data
	 */
	public String getData() {
	
		return data;
	
	}

	/**
	 * @return countOfMiningTransaction
	 */
	public int getCountOfMiningTransaction() {
	
		return countOfMiningTransaction;
	
	}

	/**
	 * @return transactions
	 */
	public List<Transaction> getTransactions() {
	
		return transactions;
	
	}
	
	/**
	 * @return block string
	 */
	public String getBlockString(){
		
		return this.index + this.previousHash + 
				this.timeStamp + this.data + 
				this.countOfMiningTransaction;
		
	}
	
	/**
	 * @return data of the complete block.
	 */
	public String toString(){
		
		return "";
		
	}
	
}
