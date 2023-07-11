//extends movement class with x position and y position should be a constant
//create a constructor for the ships that uses movement for the x and y position and the speeds
//constructor will import the image of your ship
//have update function for left and update right for movements

class Ships extends Movement{
  PImage ship;
  public Ships(double xS, double yS, int xPos, int yPos, PImage ship){
    super(xS, yS, xPos, yPos);
    this.ship = ship;
  }
  
  void move(){
    
    xPos += xSpeed;
  }
  
  public void safe(){
    if (xPos > width-390 || xPos < 0){
      xSpeed *= -1;
      yPos += ySpeed;
    }
  }
  
  
  void display(int x, int i){
    image(ship, xPos + x*40,yPos +i*60 + 50);
  }
  
  void clear(){
    tint(255, 128);
  }
  
  void setImg (PImage img){
    ship = img;
  }
  
  void stop(){
     ySpeed = 0;
     xSpeed = 0;
     xPos = 200;

  }
  
 
  
  
  
}
