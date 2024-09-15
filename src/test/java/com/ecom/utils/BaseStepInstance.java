package com.ecom.utils;
import com.ecom.pages.*;
import com.ecom.utils.CommonActions;
import com.ecom.objectrepo.*;

public class BaseStepInstance {

	// ---------------------Object Repository-------------------------

		protected MainRepo getMainRepoInstance() {
			return MainRepo.getInstance();
		}
	
	
	
	// ---------------------PageFunctions-------------------------

		protected MainPage getMainPageInstance() {
			return MainPage.getInstance();
		}		
		
		
		// ----------------------CommonClasses-----------------------

		protected CommonActions getCommonActionsInstance() {
			return CommonActions.getInstance();

		}
		
	}