import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Main {
    final static Scanner scan = new Scanner(System.in);

    //validation of PIN so that it can be of 4 digit only;
    private static boolean checkPin(int pin){
        int digit = 0;
        while(pin > 0){
            pin = pin/10;
            digit++;
        }
        if(digit == 4) return true;
        return false;
    }

    // Funtion to print existing files in directory
    private static void printArray(String[] files){
        int count = 1;
        for(String str : files){
            System.out.println(count++ + ". "+str);
        }
        System.out.println();
    }
    public static void main(String[] args)throws FileNotFoundException,IOException {

        String filePath = ""; //input for the filePath location
        String filename = ""; // input for the file name
        int pin = 0;
        System.out.println("Enter the absolute file path"); 
        filePath = scan.nextLine();

        File f = new File(filePath);
        String[] files = f.list();
        
        // printing all files present in path calling above function
        printArray(files);

        System.out.println("Enter the file to Decrypt");
        filename = scan.nextLine();
    
        File file = new File(filePath+"/"+filename);

        // code snippet for the PIN validation
        boolean flag = true;
        while(flag){
            System.out.println("Enter your 4 digit PIN");
            pin = scan.nextInt();
            if(checkPin(pin)) flag = false;
        }

        // creating real object of Decrypter and calling method to decrypt file
        Decrypter obj = new Decrypter();
        obj.decryptFile(file,filename,pin);

    }
}
