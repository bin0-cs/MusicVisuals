package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
import example.YinY;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public void yinYang()

	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new YinY());

}
	public static void main(String[] args)
	{
		Main main = new Main();
		//main.startUI();	
		main.yinYang();		
	}
}