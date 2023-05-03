package ie.tudublin;

import Visuals.Start;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Start());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}