/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.service;

/**
 *
 */
public interface IBeanService
{
   <T> T getBean(Class<T> type);   
}
