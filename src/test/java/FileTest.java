import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type File test.
 */
public class FileTest {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException{

        while (true){
            menu();
        }
    }
    /**
     * Menu.
     *
     * @throws IOException the io exception
     */
    public static void menu() throws IOException {
        IOReader ior = new IOReader();

        boolean isOn = true;
        int option = 0;
        boolean isValidated = false;
        System.out.println("1/ Create File");
        System.out.println("2/ Write File");
        System.out.println("3/ Read File");
        System.out.println("4/Exit");
        System.out.println();
        System.out.println("Enter an Option:");
        try{
            isValidated = ior.validateOption();
            if(isValidated != true) {
                System.out.println("Please Enter an Option Again.");
            }
            else{
                if(option>4){
                    System.out.println("Please Enter an Option Again.");
                }
                else{
                    option = Integer.parseInt(ior.getString());
                }
            }
        }
        catch(NullPointerException e){
            System.out.println(e);
        }
        finally{

            switch(option){
                case 1 -> { options(1);}
                case 2 -> {options(2);}
                case 3 -> {options(3);}
                case 4 ->{System.exit(0);}
            }
        }

    }

    /**
     * Options.
     *
     * @param i the
     * @throws IOException the io exception
     */
    public static void options(int i) throws IOException {
        if(i == 1){
            System.out.println("Please Enter A File Name");
            IOReader ior = new IOReader();
            ior.setString();
            String f = ior.getString();
            createFile(f);
        }
        if(i==2){
            System.out.println("Please Enter A File Name");
            IOReader ior = new IOReader();
            ior.setString();
            String f = ior.getString();
            System.out.println("Please enter input for file");
            ior.setString();
            String input = ior.getString();
            writeFile(f,input);
        }
        if(i==3){
            System.out.println("Please Enter A File Name");
            IOReader ior = new IOReader();
            ior.setString();
            String f = ior.getString();
            readFile(f);

        }

    }

    /**
     * Create file.
     *
     * @param FileName the file name
     */
    public static void createFile(String FileName){
        IOReader ior = new IOReader();

        Path p = Path.of(FileName);
        if(!Files.exists(p) ){
            try(FileWriter fw = new FileWriter(FileName);){
                System.out.println(FileName+" created");
                System.out.println("");

            }catch(IOException e){System.out.println(e);}
        }
        else{
            System.out.println("Sorry file already exists");
            System.out.println("");
            }


    }

    /**
     * Write file.
     *
     * @param FileName the file name
     * @param source   the source
     */
    public static void writeFile(String FileName,String source){
        Path p = Path.of(FileName);
        if(Files.exists(p) && Files.isWritable(p)){
            try(FileWriter fw = new FileWriter(FileName);){

                fw.write(source);
                System.out.println("Write to "+FileName+" successful");
                System.out.println("");

            }catch(IOException e){System.out.println(e);}
        } else {
            System.out.println("Sorry this file does not exist.");
            System.out.println("");

        }
    }

    /**
     * Read file.
     *
     * @param FileName the file name
     * @throws IOException the io exception
     */
    public static void readFile(String FileName) throws IOException {
        Path p = Path.of(FileName);
        if(Files.exists(p) && Files.isReadable(p)){
           System.out.println(Files.readString(p));
            System.out.println("");
        } else {
            System.out.println("Sorry this file does not exist");
            System.out.println("");
        }

    }
    public static void parseFile(String FileName) throws IOException {
        Path p = Path.of(FileName);
        if(Files.exists(p) && Files.isReadable(p)){
            System.out.println(Files.readString(p));
            System.out.println("");
        } else {
            System.out.println("Sorry this file does not exist");
            System.out.println("");
        }
        

    }
}
