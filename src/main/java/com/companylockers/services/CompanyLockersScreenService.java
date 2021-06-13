package com.companylockers.services;

import simplilearn.companylockers.screen.CompanyLockersScreen;
import simplilearn.companylockers.screen.FileOptionsScreen;
import simplilearn.companylockers.screen.WelcomeScreen;
public class CompanyLockersScreenService {
	
	
	
	
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
    public static FileOptionsScreen FileOptionsScreen = new FileOptionsScreen();
    
    

    public static CompanyLockersScreen CurrentScreen = WelcomeScreen;

    
    public static CompanyLockersScreen getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen( CompanyLockersScreen currentScreen) {
        CurrentScreen = currentScreen;
    }


}
