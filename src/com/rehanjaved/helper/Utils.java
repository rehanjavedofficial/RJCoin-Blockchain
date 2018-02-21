package com.rehanjaved.helper;

import java.security.MessageDigest;

/**
 * Represents a Utils.
 * 
 * @author Rehan Javed
 * @version 1.0
 */
public class Utils {

	/**
	 * Generating Hash of the block data.
	 * 
	 * @param blockData
	 * @return hash
	 */
	public static String generateHash(String blockData){
		
		MessageDigest messageDigest = null;
		
		try{
			
			messageDigest = MessageDigest.getInstance("SHA-256");
			
		}catch(Exception e){
			
			System.out.println("#### Error ####: Message Digest: "+e.toString());
			return null;
		
		}
		
		byte[] bytesData = messageDigest.digest(blockData.getBytes());
		String hash = "";
		String hexData = "";
		
		for(byte eachByte: bytesData){
			
			hexData = Integer.toHexString(0xff & eachByte);
			
			if(hexData.length() == 1){
				hash += "0";
			}
			hash += hexData;
			
		}
		
		return hash;
		
	}
	
}
