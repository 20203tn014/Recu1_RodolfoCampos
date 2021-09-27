package mx.edu.utez.client;

import mx.edu.utez.server.Handler;
import mx.edu.utez.server.User;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class JavaClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1400"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        System.out.println(read(client));
    }

    public static String read(XmlRpcClient client) throws XmlRpcException{
        Scanner sc = new Scanner(System.in);
        String res = "";

        System.out.println("Bienvenido");
        System.out.println("Menú\n1.- Registrar Usuario\n2.- Ver todos\n3.- Actualizar\n4.- Eliminar");
        int opc = sc.nextInt();
        switch (opc){
            case 1:
                // Registrar
                System.out.println("Ingrese su nombre");
                String name = sc.next();
                System.out.println("Ingrese su apellido");
                String lastname = sc.next();
                System.out.println("Ingrese su correo");
                String email = sc.next();
                System.out.println("Ingrese su contraseña");
                String password = sc.next();

                Object[] params1 = { name, lastname, email, password };
                boolean result = (Boolean) client.execute("Handler.createUser" , params1);
                res = result ? "Se ha registrado correctamente" : "No se ha registrado correctamente";
                return res;
            case 2:
                // Ver todos
                System.out.println("Ver todos");
                for (User user : new Handler().findAll()){
                    System.out.println("Id: "+user.getId());
                    System.out.println("Nombre: "+user.getName());
                    System.out.println("Apellido: "+user.getLastname());
                    System.out.println("Email: "+user.getEmail());
                    System.out.println("Contraseña: "+user.getPassword());
                    System.out.println("Fecha de Registro: "+user.getDate_registered());
                    System.out.println("Status: "+user.getStatus());
                    System.out.println("***************************");
                }
                res = "Se ha listado correctamente";
                break;
            case 3:
                // Actualizar
                System.out.println("Ingrese su nombre");
                String name2 = sc.next();
                System.out.println("Ingrese su apellido");
                String lastname2 = sc.next();
                System.out.println("Ingrese su correo");
                String email2 = sc.next();
                System.out.println("Ingrese su contraseña");
                String password2 = sc.next();
                System.out.println("Ingrese el ID");
                int id = sc.nextInt();

                Object[] params2 = { id, name2, lastname2, email2, password2 };
                boolean result2 = (Boolean) client.execute("Handler.updateUser" , params2);
                res = result2 ? "Se ha actualizado correctamente" : "No se ha actualizado correctamente";
                return res;
            case 4:
                // Eliminar
                System.out.println("Ingrese el ID");
                int id2 = sc.nextInt();

                Object[] params3 = { id2 };
                boolean result3 = (Boolean) client.execute("Handler.deleteUser" , params3);
                res = result3 ? "Se ha eliminado correctamente" : "No se ha eliminado correctamente";
                return res;
            default:
                System.out.println("Ha salido del sistema");
                break;
        }

        return res;
    }
}