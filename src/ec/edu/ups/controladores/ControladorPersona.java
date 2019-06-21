/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.modelo.Persona;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author tians
 */
public class ControladorPersona {
    
    public void crearPersona(Persona persona) {
        String ruta = "personas.ups";
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            archivo.seek(archivo.length());
            System.out.println(archivo.length());
            archivo.writeUTF(persona.getNombre());
            archivo.writeUTF(persona.getApellido());
            archivo.writeUTF(persona.getCedula());
            archivo.writeInt(persona.getEdad());
            archivo.writeUTF(persona.getFechaNacimiento());
            archivo.writeUTF(persona.getCelular());
            archivo.writeDouble(persona.getSalario());
            archivo.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo");
        } catch (IOException ex){
            System.out.println("Error de escritura");
        }
    }
    
    public Persona buscarPersona(int posicion){
        Persona persona=new Persona();
        String ruta = "personas.ups";
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            posicion=posicion*152;
            archivo.seek(posicion);
            persona.setNombre(archivo.readUTF());
            archivo.seek(posicion+52);
            persona.setApellido(archivo.readUTF());
            archivo.seek(posicion+104);
            persona.setCedula(archivo.readUTF());
            archivo.seek(posicion+116);
            persona.setEdad(archivo.readInt());
            archivo.seek(posicion+120);
            persona.setFechaNacimiento(archivo.readUTF());
            archivo.seek(posicion+132);
            persona.setCelular(archivo.readUTF());
            archivo.seek(posicion+144);
            persona.setSalario(archivo.readDouble());
            archivo.close();
            return persona;
        } catch (FileNotFoundException  ex){
            System.out.println("No existe el archivo");
        } catch (IOException ex){
            System.out.println("Error de archivo");
        }
        return null;
    }
    
    public void eliminarPersona(int posicion){
        String ruta = "personas.ups";
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            posicion=posicion*152;
        } catch (FileNotFoundException ex){
            System.out.println("No existe el archivo");
        } catch (IOException ex){
            System.out.println("Error de archivo");
        }
    }
    
    public long getSize(){
        String ruta = "personas.ups";
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            return archivo.length();
        } catch (FileNotFoundException ex){
            System.out.println("No existe el archivo");
        } catch (IOException ex){
            System.out.println("Error de archivo");
        }
        return -1;
    }
    
}
