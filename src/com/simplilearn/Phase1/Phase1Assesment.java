        /*              Developer Name : Ramya S
               Project name : Virtual Key for Your Repositories
        */

package com.simplilearn.Phase1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Phase1Assesment {

	static final String path = "E:\\LockedMe.com\\";
	static int n;

//Function to display the main menu options 
	void displayMenu() {
        
		System.out.println("\t Main Menu Options are");
		System.out.println("------------------------------------");
		System.out.println("1.Display all the files");
		System.out.println("2.Business level Operations ");
		System.out.println("3.Close the Application ");
		System.out.println("------------------------------------\n");
	}

//Function to Display all file in the directory 
	void DisplayAllFiles() {
		System.out.println("Displaying all files in path: " + path);
		File f = new File(path);
		File filenames[] = f.listFiles();
		for (File ff : filenames) {
			System.out.println(ff.getName());
		}

	}

//Function to Add for a file in the directory 
	void AddFile() {
		System.out.println("Enter the filename you  want to create :");
		Scanner sc2 = new Scanner(System.in);
		String Addfilename = sc2.next();
		File f1 = new File(path + Addfilename);

		boolean b = true;
		try {
			b = f1.createNewFile();
			System.out.println("File Created in path " + path);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not created ");
			e.printStackTrace();
		}

	}

//Function to Delete for a file in the directory 
	void DeleteFile() {
		System.out.println("Enter the filename that you want to delete ");
		Scanner sc3 = new Scanner(System.in);
		String dfilename = sc3.next();

		File f2 = new File(path + dfilename);
		// deleting the file
		boolean b1 = f2.delete();
		if (b1 != true) {
			System.out.println("File not found/cannot delete !!");
		} else {
			System.out.println("File Deleted ");
		}

	}

//Function to search for a file in the directory 
	void SearchFile() {
		System.out.println("Enter the file you want to search in the Directory :");
		Scanner sc4 = new Scanner(System.in);
		String sfilename = sc4.next();
		File f3 = new File(path);

		File Sfilenames[] = f3.listFiles();
		int flag = 0;
		for (File Sf : Sfilenames) {
			if (Sf.getName().equals(sfilename)) {
				flag = 1;
				break;

			} else {
				flag = 0;
			}
		}

		if (flag == 1) {
			System.out.println("File found ");
		} else {
			System.out.println("File Not found ");
		}

	}

//Function to display Business level operations(add,delete,search ,go to main menu) and perform user choice operation 
	void BusinessOpMenu() {
		System.out.println("\tThe Business level operations are");
		System.out.println("-----------------------------------------------------");
		System.out.println("1.Add File ");
		System.out.println("2.Delete File ");
		System.out.println("3.Search For a File ");
		System.out.println("4.Go back to the Main Menu ");
		System.out.println("------------------------------------------------------");
		System.out.println("Please enter the Business level operations you want to perform :");
		Scanner sc = new Scanner(System.in);
		int sub = sc.nextInt();
		switch (sub) {
		case 1:
			AddFile();
			BusinessOpMenu();
			break;

		case 2:
			DeleteFile();
			BusinessOpMenu();
			break;
		case 3:
			SearchFile();
			BusinessOpMenu();
			break;

		case 4:
			System.out.println("Going back to main menu ");
			MainMenu();
			break;
		}

	}

//Function to display main menu options and switch case to perform user choice operations (display,business operations,close application)
	void MainMenu() {
		displayMenu();
		System.out.println("Select the Operation you want to perform :");

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		switch (n) {
		case 1:
			DisplayAllFiles();
			MainMenu();
			break;

		case 2:
			BusinessOpMenu();
			MainMenu();
			break;
		case 3:
			System.out.println("Closing the Application");
			System.exit(0);
			break;
		default:
			System.out.println("Enter  Input (1,2,or 3), Invalid Input\n\n\n");
			MainMenu();
			break;
		}
		sc.close();

	}

//Main Method
	public static void main(String[] args) throws IOException {
		System.out.println("Developer Name : Ramya S");
		System.out.println("Project name : Virtual Key for Your Repositories\n\n");
		Phase1Assesment p1 = new Phase1Assesment();
		p1.MainMenu();

	}

}
