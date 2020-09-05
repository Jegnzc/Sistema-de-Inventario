/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;

/**
 *
 * @author JorgeG
 */
public class Backups {
    public boolean tbRestore(String dbName,String dbUserName, String dbPassword, String source) {
        
        
        
  String[] restoreCmd = new String[]{"mysql", dbName, "--user=" + dbUserName,"--password=" + dbPassword, "-e", " source " + source};
 
        Process runtimeProcess;
    
        try
        {
            runtimeProcess = Runtime.getRuntime().exec(restoreCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Restauración completada");
                return true;
            } else {
                System.out.println("Could not restore the backup!");
                return false;
            }
        } catch (IOException | InterruptedException ex)
        {
        }
return false;
}
    
    public boolean tbBackup(String dbName,String dbUserName, String dbPassword, String path) {
        
        
        
    String executeCmd = "mysqldump -u " + dbUserName + " -p" + dbPassword + " --add-drop-database -B " + dbName + " -r " + path;
    Process runtimeProcess;
    
        try
        {
            System.out.println(executeCmd);//this out put works in mysql shell
            runtimeProcess = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", executeCmd });

            int processComplete = runtimeProcess.waitFor();

                if (processComplete == 0)
                {
                    System.out.println("Backup created successfully");
                    return true;
                }
                else
                {
                    System.out.println("Could not create the backup");
                }
        } catch (IOException | InterruptedException ex)
        {
        }
return false;
}

public static void main(String[] args){

        Backups bb = new Backups();
        //bb.tbRestore("tienda_backup","root","admin","C:/Users/JorgeG/Documents/NetBeansProjects/prueba.sql");
        
        bb.tbBackup("tienda","root","admin","C:/Users/JorgeG/Documents/NetBeansProjects/prueba.sql");
        
}
}
