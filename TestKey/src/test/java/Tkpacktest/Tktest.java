package Tkpacktest;

import java.io.IOException;

import org.testng.annotations.Test;

import tkpackelements.Tkelements;

public class Tktest {
	
	
	@Test
	public void execution() throws IOException
	{
		Tkelements obj = new Tkelements();
		obj.initiate("MAS_Details");
	}

}
