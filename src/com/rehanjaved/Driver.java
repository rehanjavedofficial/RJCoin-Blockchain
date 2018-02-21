package com.rehanjaved;

import com.rehanjaved.blockchain.Block;

/**
 * Represents a Main class.
 * 
 * @author Rehan Javed
 * @version 1.0
 */
public class Driver {

	/**
	 * Main method to run the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Genesis Block.
		Block genesisBlock = new Block(0, null, "first block.");
		System.out.println("Block Hash: "+genesisBlock.getHash());
		
	}

}
