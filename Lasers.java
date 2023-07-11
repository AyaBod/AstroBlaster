//lasers is shot from ships and extends the movement class
//lasers xPos will be defined as the Spaceship xPos and will be constant
//lasers yPos will be defined from the top of the ship and should decrease to go up the screen


class Lasers extends Movement{
  PImage ship;
  boolean released;
  public Lasers(double xS, double yS, int xPos, int yPos, PImage ship){
    super(xS, yS, xPos, yPos);
    this.ship = ship;
    this.released = false;
  }
  
  void moveU(){
    yPos -= ySpeed;
  }
  
  void moveR(){
    if (xPos > width-60){
      xPos -=xSpeed;
    }
    xPos += xSpeed;
  }
  
  void moveL(){
    if (xPos < 10){
      xPos +=xSpeed;
    }
    xPos -= xSpeed;
  }
  
  void display(){
    image(laser, xPos, yPos);
  }
  
 
  
  
  
}
 
