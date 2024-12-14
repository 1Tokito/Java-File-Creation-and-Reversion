
package com.mycompany.semester2;

import java.io.*;  
import java.util.Scanner;  
  
public class FileOperations {  
  public static void main(String[] args) throws IOException {  
    // Ask the user for the file path and original content of file 1  
    Scanner scanner = new Scanner(System.in); 
    // Enter your file path below
    
    System.out.print("Enter the file path for file 1 (e.g. C:\\\\Users\\username\\\\Documents\\\\file1.txt): ");  
    System.out.println("Make sure that you input a double back quote and add the name of the file and the extension at the end, as shown in the example:");
    String filePath = scanner.nextLine();  
    //Enter the content for File One
    System.out.print("Enter the original content of file 1: ");  
    String originalContent = scanner.nextLine();  
  
    // Create a file and write data to it  
    File file1 = new File(filePath);  
      try (FileWriter writer = new FileWriter(file1)) {
          writer.write(originalContent);
      }  
  
    // Create a second file and write the reverse of the data in the first file  
    System.out.println("Make sure that you input a double back quote and add the name of the file and the extension at the end, as shown in the example:");
    System.out.print("Enter the file path for file 2 (e.g. C:\\\\Users\\username\\\\Documents\\\\file2.txt): ");  
    String file2 = scanner.nextLine();
    String data;
      try (FileWriter writer2 = new FileWriter(file2)) {
          Scanner scanner2 = new Scanner(file1);
          data = scanner2.nextLine();
          String reversedData = new StringBuilder(data).reverse().toString();
          writer2.write(reversedData);  
      }
  
    // Compare the data in both files  
    Scanner scanner3 = new Scanner(file2);  
    String data2 = scanner3.nextLine();  
    if (data.equals(data2)) {  
    System.out.println("The contents of both files are the same.");  
    } else {  
    System.out.println("The contents of both files are different.");  
    }  
  
    // Display the data of the first file on the console screen  
    System.out.println("Data in file1.txt:");  
    Scanner scanner4 = new Scanner(file1);  
    while (scanner4.hasNextLine()) {  
    System.out.println(scanner4.nextLine());  
    }  
  
    // Ask the user for the position and data to be altered  
    Scanner scanner5 = new Scanner(System.in);  
    System.out.print("Enter the position of the word to be altered(Must be an interger Value): ");  
    int position = scanner5.nextInt();  
    System.out.print("Enter the new word: ");  
    String newWord = scanner5.next();  
  
    // Replace the word at the specified position with the new word  
    Scanner scanner6 = new Scanner(file1);  
    String[] words = scanner6.nextLine().split(" ");  
    words[position - 1] = newWord;  
    String newData = String.join(" ", words);  
  
      try ( // Write the new data to the first file
              FileWriter writer3 = new FileWriter(file1)) {
          writer3.write(newData);
      }  
  
    // Convert the data of the first file to byte codes  
    Scanner scanner7 = new Scanner(file1);  
    String data3 = scanner7.nextLine();  
    byte[] byteData = data3.getBytes();
    
    
    System.out.println("Byte codes of the data in file1.txt:");  
    for (byte b : byteData) {
    System.out.print(b + " "); 
      
      
    }  
  }  
}




