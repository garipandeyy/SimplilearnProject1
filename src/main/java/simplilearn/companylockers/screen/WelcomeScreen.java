package simplilearn.companylockers.screen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.companylockers.services.CompanyLockersDirectory;
import com.companylockers.services.CompanyLockersScreenService;


public class WelcomeScreen implements CompanyLockersScreen {

    private String welcomeMessage = "Welcome to CompanyLockers Appliation!";
    private String developerName = "Developer Name: Garima Pandey";

    private ArrayList<String> options = new ArrayList<>();


    public WelcomeScreen() {
        options.add("1. Files present in directory");
        options.add("2. File Operations Menu");
        options.add("3. Exit");

    }
    
	public void WelcomePage() {
    	System.out.println(welcomeMessage);
        System.out.println(developerName);
        System.out.println("\n");
        Display();
    }
    
    @Override
    public void Display() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        System.out.println("Please enter your choice");
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
        System.out.println("Thank you!! Have a great time");
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files present in Directory
                this.ShowFiles();
                
                this.Display();
                
                break;
                
            case 2: // Show File Operation  menu
            	CompanyLockersScreenService.setCurrentScreen(CompanyLockersScreenService.FileOptionsScreen);
            	CompanyLockersScreenService.getCurrentScreen().Display();
            	CompanyLockersScreenService.getCurrentScreen().GetUserInput();
                
                this.Display();
                
                break;
                        
            default:
                System.out.println("Invalid Choice");
                break;
        }
        
    }

    public void ShowFiles() {


        System.out.println("Checking The file Directory");
    	CompanyLockersDirectory.PrintFiles();

    }
    
    private int getOption() {
        Scanner input = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = input.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}

