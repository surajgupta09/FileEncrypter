import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class Decrypter {
    // overloaded method to delete temporary copy file and copy new data to original file
    private static void decryptFile(File input, File output)throws FileNotFoundException,IOException{
        int index = 0;
        FileReader fr = new FileReader(input);
        FileWriter fw = new FileWriter(output);
        try{
            while((index = fr.read()) != -1){
                fw.write(index);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            input.delete();
            fr.close();
            fw.close();
        }
    }
    // real method where the decryption is working 
    public void decryptFile(File file, String filename, int pin) throws FileNotFoundException,IOException{
        //filereader and writer variable decalartion
        FileReader fr =  new FileReader(file); 
        File copy = new File("copy"+filename);
        FileWriter fw = new FileWriter(copy);

        int index = 0;
        try{ 
            
            while ((index=fr.read()) != -1){
                // copying character from input file and taking XOR and pasting it in output file
                fw.write((index ^ pin));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            fr.close();
            fw.close();
        }

        // code Snippet for calling overloaded function
        try{
           decryptFile(copy, file);
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
   
}
