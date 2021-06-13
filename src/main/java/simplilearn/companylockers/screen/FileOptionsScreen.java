package simplilearn.companylockers.screen;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.companylockers.directorypath.DirectoryPath;
import com.companylockers.services.CompanyLockersScreenService;

public class FileOptionsScreen implements CompanyLockersScreen {
	
	private DirectoryPath dir = new DirectoryPath();
	
	private ArrayList<String> options = new ArrayList<>();

    public FileOptionsScreen() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
        
    }
    
    @Override
    public void Display() {
    	System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        
    	switch(option) {

            case 1: // Add File
                this.AddFile();
                
                this.Display();
                break;
            case 2: // Delete File
                this.DeleteFile();
                
                this.Display();
                break;
            case 3: // Search File
                this.SearchFile();
                this.Display();
                break;
            
                
            case 4: // Return to Menu
            	
            	CompanyLockersScreenService.setCurrentScreen(CompanyLockersScreenService.WelcomeScreen);
            	CompanyLockersScreenService.getCurrentScreen().Display();
            	CompanyLockersScreenService.getCurrentScreen().GetUserInput();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
                
                
        }

    }
    


    public void AddFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("Adding a file named: " + fileName);
        
		try {
			Path path = FileSystems.getDefault().getPath(DirectoryPath.name + fileName).toAbsolutePath();
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("This File Already Exits,Please enter a new file");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    public void DeleteFile() {
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);
        
       
        
		Path path = FileSystems.getDefault().getPath(DirectoryPath.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("Delete operation failed:" + fileName + ", as there is no such file found.");
	      }
    }
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("Searching for a file named: " + fileName);
        
      
        
        ArrayList<File> files = dir.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("File present " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File not found/exist");
        }
    }
    
    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    
    private int getOption() {
        Scanner input = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = input.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid Option");
        }
        return returnOption;

    }

	

}

