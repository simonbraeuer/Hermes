/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import at.gov.parlament.documentation.hermes.exceptions.HashingServiceException;
import at.gov.parlament.documentation.hermes.exceptions.HashingServiceExceptionCode;


/**
 *
 */
public class HashingService implements IHashingService
{

	public String hashPassword(String password) throws HashingServiceException
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-512");

			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			
			BigInteger bigInt = new BigInteger(1, digest);
            String output = bigInt.toString(16);
			
			return output;
		} 
		catch (NoSuchAlgorithmException ex)
		{
			throw new HashingServiceException(HashingServiceExceptionCode.HASHING_EXCEPTION);
		} 
		catch (UnsupportedEncodingException ex)
		{
			throw new HashingServiceException(HashingServiceExceptionCode.HASHING_EXCEPTION);
		}
	}
	
}
