package server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import interfaces.InterfacePartRepository;

public class Server {
    private static Registry registry;

    public Server (String name, String strPort) {
        System.out.println("Iniciando servidor "+ name +"...");
        try {
            int port = Integer.parseInt(strPort);
            LocateRegistry.createRegistry(port);
            InterfacePartRepository obj = new PartRepository(name);
            registry = LocateRegistry.getRegistry(port);
            registry.bind(name, obj);
            //Naming.rebind("//localhost:"+ port +"/"+ name, obj);
            System.out.println("Servidor iniciado e rodando!");
        } catch (Exception e) {
            System.out.print("Erro: "+ e);
        }
    }
    public static void main(String[] args) {
        new Server(args[0], args[1]);
    }
}

