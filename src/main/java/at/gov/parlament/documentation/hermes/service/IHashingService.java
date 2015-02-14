/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.service;

import at.gov.parlament.documentation.hermes.exceptions.HashingServiceException;



/**
 *
 */
public interface IHashingService
{
	String hashPassword(String password) throws HashingServiceException;
}
