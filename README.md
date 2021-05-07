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
MyVisuals class


# What I am most proud of in the assignment



This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)


Controls

| Option    |  Control  |
|-----------|-----------|
|Play/Pause |  Spacebar |
|Menu 	    |     0     |
|Visual 1   |     1     |
|Visual 2   |     2     |
|Visual 3   |     3     |

