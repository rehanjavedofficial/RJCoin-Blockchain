package com.rehanjaved.blockchain;

import java.util.ArrayList;

import com.rehanjaved.helper.Utils;

/**
 * Represents a Blockchain.
 * 
 * @author Rehan Javed
 * @version 1.0
 */
public class BlockChain {

	// Attributes
	private ArrayList<Block> blockChain;
	
	/**
	 * Constructor.
	 */
	public BlockChain(){
		
		blockChain = new ArrayList<Block>();
		blockChain.add(new Block(0, null, "Genesis Block"));
		
	}
	
	/**
	 * To check the main genesis block
	 * validity.
	 * 
	 * @return true if valid.
	 */
	private boolean isGenesisBlockValid(){
		
		Block genesisBlock = blockChain.get(0);
		
		if(genesisBlock.getIndex() != 0)
			return false;
		
		if(genesisBlock.getPreviousHash() != null)
			return false;
		
		if(!genesisBlock.getHash().equals(
				Utils.generateHash(genesisBlock.getBlockString())))
			return false;
		
		return true;
		
	}
	
	/**
	 * To check is current block valid or not.
	 * 
	 * @param currentBlock
	 * @param previousBlock
	 * @return true if valid.
	 */
	private boolean currentBlockValidity(Block currentBlock, Block previousBlock){
		
		if(currentBlock == null || previousBlock == null)
			return false;
		
		if(currentBlock.getIndex() != previousBlock.getIndex()+1)
			return false;
		
		if(!(currentBlock.getHash().
				equals(Utils.generateHash(currentBlock.getBlockString())) && 
				previousBlock.getHash().equals(
				Utils.generateHash(previousBlock.getBlockString()))))
			return false;
		
		if(!currentBlock.getPreviousHash().equals(previousBlock.getHash()))
			return false;
		
		return true;
		
	}
	
	/**
	 * To check is block chain valid or not.
	 * 
	 * @return true if valid.
	 */
	public boolean isBlockChainValid(){
		
		if(!isGenesisBlockValid())
			return false;
		
		Block current, previous;
		
		for(int i = 1; i <= blockChain.size(); i++){
			
			current = blockChain.get(i);
			previous = blockChain.get(i-1);
			
			if(!currentBlockValidity(current, previous))
				return false;
			
		}
		
		return true;
		
	}
	
}
