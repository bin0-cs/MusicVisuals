# Music Visualiser Project

Name: Bruno Oltean 

Student Number: C19383843


# Description of the assignment
For this assignment I was instructed to create "something beautiful while listening to music".

The song I chose was called ["The Spy From Cairo - Nafas"](https://www.youtube.com/watch?v=3-isjGJTiNs). 
Inspired by the sound of this track I wanted to create some audio visualisers which reflected the aesthetic 
and sound of the music. 

With the help of the [r/Processing](https://www.reddit.com/r/processing/) subreddit I created my first visual
which was yin & yang visual. For the latter visuals I had used all that I had learned during the semester
to create some more interesting spiralling visuals. All visuals reacted to the amplitude of the music.


# Instructions
- Fork and clone this repo to your computer
- Load the folder into an IDE of your choice
- Run Main.java
- Use Spacebar to play/pause the music 
- Cycle through the visuals with 0-3
- 0: Menu
- 1: YinY.java
- 2: Spiral.java
- 3: Fib.java


# How it works
I created classes for each visual and an instance of every class was created in the
BrunoVisuals Class and inheritance was utilised to extend to the Visual Class. 

```Java
public class BrunoVisuals extends Visual{

//Visuals 
Menu menu;
YinY yiny;
Fib fviz;
Visual viz;
Spiral sprl;
...

}
```

An instance of BrunoVisuals is found in every visual class and used as a parameter in every 
visual class constructor. An example of a visual class contructor and instantiation of the 
BrunoVisuals is given below.

```Java
public class YinY {
  BrunoVisuals x;

    //constructor
    public YinY(BrunoVisuals x){
      this.x = x;
    }
```

The setup method in the BrunoVisuals class loads the sound file using the minim sound library 
and creates new objects for every visual class being used. 

``` java
public void setup() {
    
    colorMode(RGB);
    frameRate(60);
    startMinim();
    loadAudio("nafas.mp3");
    ap = getAudioPlayer();
    fft = getFFT();
    font = createFont("OpenSans-Regular.ttf", 26);
    textFont(font);
    
    
    center = new PVector(width/2+radius/pow(2, levels), height/2);
    yiny = new YinY(this);
    fviz = new Fib(this);
    menu = new Menu(this);
    sprl = new Spiral(this);

    
  }
  ``` 


  Switch cases were implemented in the draw method of the BrunoVisuals class so that the 
program would allow the user to switch through each visual.


``` java
public void draw(){
	...

	switch(which){

			case 0 : {
				
				menu.setup();

				break;
			}

			case 1 : {
			
				yiny.render();
			
				break;
			}
			
			case 2 : {

				sprl.render();
			
				break;
			}

   			... 
   ```
The key pressed method checks the keys being pressed and plays/pauses or cycles through the 
relevant visuals.

``` java
public void keyPressed() {
    if (keyCode >= '0' && keyCode <= '6') {
        which = keyCode - '0';
    }
    if (keyCode == ' ') {
        if (ap.isPlaying()) {
            ap.pause();
        } else {
            ap.rewind();
            ap.play();
        }
    }
}
```

Controls

| Option    |  Control  |
|-----------|-----------|
|Play/Pause |  Spacebar |
|Menu 	    |     0     |
|Visual 1   |     1     |
|Visual 2   |     2     |
|Visual 3   |     3     |

# What I am most proud of in the assignment

What I am most proud of after doing this assignment is the journey and struggles
that I had overcome in the process of coding this project. It was a great learning experience 
and one that had turned out to be way more satisfying and enjoyable than initially expected. 
I also love the way the visuals had turned out in the end and how they fit the mood and psychedelic nature of 
the music used :)


# YouTube Video

This is a youtube video:

[![YouTube](images/YIN.png)](https://www.youtube.com/watch?v=vDLisFJei2I)




