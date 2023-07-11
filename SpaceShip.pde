//this will extend movement class
//constructor will use x and y and xspeed and yspeed from movement class
//constructor will also get image for spaceship
//spaceship must have an update that is constantly being run 
//need to make sure SpaceShips don't go off screen 

class SpaceShip extends Movement{
  PImage ship;
  public SpaceShip(double xS, double yS, int xPos, int yPos, PImage ship){
    super(xS, yS, xPos, yPos);
    this.ship = ship;
  }
  
  void moveR(){
    if (xPos > width-60){
      xPos -=xSpeed;
    }
    super.xPos += super.xSpeed;
  }
  
  void moveL(){
    if (xPos < 10){
      xPos +=xSpeed;
    }
    super.xPos -= super.xSpeed;
  }
  
  
  
  
  void display(){
    image(ship, super.xPos, super.yPos);
  }
  
    void stop(){
     ySpeed = 0;
     xSpeed = 0;
     xPos = 400;

  }
  
  
}
