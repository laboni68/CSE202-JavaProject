package ServerPackage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by DELL on 12/20/2015.
 */

public class server {

    public static void main(String[] arg) {

        CircuitLogicServer circuitLogicServer;
        int i=1;
        try {
            ServerSocket socketConnection = new ServerSocket(11111);
            while (true) {

                    System.out.println("Server Waiting for DLD connection fron Client...."+i++);

                    Socket pipe = socketConnection.accept();

                    ObjectInputStream serverInputStream = new
                            ObjectInputStream(pipe.getInputStream());

                    ObjectOutputStream serverOutputStream = new
                            ObjectOutputStream(pipe.getOutputStream());

                circuitLogicServer = (CircuitLogicServer) serverInputStream.readObject();
                    serverOutputStream.writeObject(circuitLogicServer);

                    //serverInputStream.close();
                    // serverOutputStream.close();
                }

        }  catch(Exception e) {System.out.println("server: "+e);
        }
    }

}
