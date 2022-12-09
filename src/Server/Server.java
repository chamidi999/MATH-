/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.TreeMap;

public class Server extends UnicastRemoteObject implements RMIFacade {

    private TreeMap clients = new TreeMap<String, String>();

    public Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Server obj = new Server();

            reg.rebind("rmi://localhost/service", obj);

            System.out.println("Server is Running...");
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String login(String email, String password) throws RemoteException {
        String response = "";
        try {
            ResultSet rs = DB_connection.search("SELECT * FROM registration WHERE email='" + email + "'");

            if (!rs.next()) {
                response = "Incorrect email";
            } else {
                if (rs.getString("password").equals(password)) {
                    response = "Login Succesfull.";
                } else {
                    response = "Incorrect password";
                }
            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return response;
        }
    }
 
    
    @Override
    public String signup(String lname, String fname, String email, String password, String c_pass) throws RemoteException {
        String response_signup = "";
        if (password.equals(c_pass)) {
            try {
                //clients.put(username, password);
                DB_connection.iud("INSERT INTO registration (fname,lname,email,password,confirm) values ('" + fname + "','" + lname + "','" + email + "','" + password + "','" + c_pass + "')");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            response_signup = "SignUp Succesfull.";
        } else {
            response_signup = "Enter the password Correctly.";
        }
        return response_signup;
    }


}

