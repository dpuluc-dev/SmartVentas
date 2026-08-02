
package Red;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class CreateConnection {
    
    private String hostname; 
    private String port;  
    private String database;
    private String username; 
    private String password; 
    
    public CreateConnection(){
    
    Properties config = new Properties(); 
    
    try(InputStream In = getClass()
            .getClassLoader()
            .getResourceAsStream("Red/db_properties.properties")){
    
        if(In==null){
            System.out.println("Archivos de red no encontrados!");
            return;
        } 
        
        config.load(In); 
        
        hostname = config.getProperty("hostname");
        port = config.getProperty("port");
        database = config.getProperty("database");
        username = config.getProperty("username");
        password = config.getProperty("password"); 
        
        System.out.println("Archivos de red cargando...");
        
        
    }catch(Exception e){
     e.printStackTrace();
        }

    }  
    
    public Connection getConnection(){
    
    Connection conn = null;
    
    try{
    
    String url = "jdbc:postgresql://"+hostname+":"+port+"/"+database+"?sslmode=require";
    conn = DriverManager.getConnection(url,username,password);
    System.out.println("Conectado a la red exitosamente!");
    
    }catch(Exception e){
    
        e.printStackTrace(); 
        
    }
    
   return conn; 
    
    }
    
    
}
