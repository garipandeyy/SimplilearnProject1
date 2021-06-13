package com.companylockers.services;

import java.io.File;
import java.util.ArrayList;

import com.companylockers.directorypath.DirectoryPath;




public class CompanyLockersDirectory {

    private static DirectoryPath fileDirectory = new DirectoryPath();
    
    public static void PrintFiles() {
    	
    	ArrayList<File> existingFiles =fileDirectory.fillFiles();
    	if(existingFiles.size()>0) {
        for (File file : CompanyLockersDirectory.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }}
    
    public static DirectoryPath getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(DirectoryPath fileDirectory) {
    	CompanyLockersDirectory.fileDirectory = fileDirectory;
    }


}
