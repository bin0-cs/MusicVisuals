package ie.tudublin;

import c19383843.MyVisuals;
import c19383843.YinY;


public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisuals());		
	}

	public void yinYang()

	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new YinY());

}
	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();	
		//main.yinYang();		
	}
}