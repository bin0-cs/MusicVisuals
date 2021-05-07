package ie.tudublin;

import c19383843.BrunoVisuals;



public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BrunoVisuals());		
	}
	

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}