/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author chamidi
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RMIFacade extends Remote{
    public String login(String email, String password) throws RemoteException;
    public String signup(String fname, String lname, String email, String password, String c_pass) throws RemoteException;
    
}
