import java.util.Random;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException,InputMismatchException{

        Lista Enemigos=new Lista();
        File file = new File("Docs\\nombres.txt");
        File file2 = new File("Docs\\output.txt");
   
        int u=0;
        Scanner sc = new Scanner(file);
        Scanner sc1=new Scanner(file2);
        
        if(!sc1.hasNext()){
            try{      
            Scanner numero=new Scanner(System.in);
            System.out.println("Ingrese el NUMERO de datos que quiere que se generen");
            u=numero.nextInt();
            }catch(InputMismatchException ex){
                System.out.println("Tipo de dato érroneo");
            }
            String[] arreglo = new String[6615];
            FileWriter output = new FileWriter("Docs\\output.txt");
            BufferedWriter buffer = new BufferedWriter(output);
            buffer.write(u+"\n");
             for(int i = 0; i < 6615; i++){
            arreglo[i] = sc.next();
            }
            for(int i = 0; i < u; i++){
                Random r = new Random();
                int valor1 = r.nextInt(6615);
                int valor2 = r.nextInt(6615);
                int vida = r.nextInt(10000);
                int ataque = r.nextInt(100);
                int defensa = r.nextInt(100);
                String name = arreglo[valor1];
                String lname = arreglo[valor2];
                Enemigo enemigo = new Enemigo(name + " " + lname, vida, ataque, defensa);
                try{
                    buffer.write(name + " " + lname + "\n" + vida + "\n" + ataque + "\n" + defensa + "\n");
                }
                catch (Exception ex){

                }
             }
            buffer.close();
        }else{
        
            
            //Llenar lista con datos del archivo de texto
            try{
                int c=0;
                Scanner s=new Scanner(file2);
                
                String nombre="";
                int vida=0;
                int ataque=0;
                int defensa=0;
                c =s.nextInt();
                

            for(int i=0;i<c;i++){
                s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                nombre=s.nextLine();
                vida=s.nextInt();
                ataque=s.nextInt();
                defensa=s.nextInt();
                Enemigo e=new Enemigo(nombre,vida,ataque,defensa);
                Enemigos.pushBack(e);   
            }

            s.close();

            //Hacer pruebas de agregar/borrar
            //Enemigo f=new Enemigo("Jugo de Naranja",200,400,7);
            //Enemigos.removeAtK(Enemigos.getN((Enemigos.getSize()/2)));
            //Enemigos.getEnemigoXNombre("");
            
            //////////////////////////////////
             
            
            //EScritura de salida (guardar datos añadidos en la sección de pruebas) en el archivo de texto
            PrintStream flujoSalida=new PrintStream(file2);
            flujoSalida.println(Enemigos.getSize());
            for(int i=0;i<Enemigos.getSize();i++){
                Nodo n=new Nodo();
                n=Enemigos.getN(i);
                flujoSalida.print(n.getDato().getNombre()+"\n"+n.getDato().getVida()+"\n"+n.getDato().getAtaque()+"\n"+n.getDato().getDefensa()+"\n");
            }
            flujoSalida.flush();
            flujoSalida.close();
            
            }catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }  catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }    
               
    }
}
