//declare all variables
//create arrayLists in the astroBlaster class for Lasers and Ships
ArrayList <Lasers> ammo = new ArrayList <Lasers>();
//ArrayList <Ships> shipsAliens = new ArrayList <Ships>();
Ships[][] shipsAliens = new Ships[3][10];
PImage back, alien, fight, laser, trans;
SpaceShip fighter;
Lasers pew;
int xPos = 390;
int yPos = 720;
//boolean released = false;
int i = 0;
int index = 0;
int row = 0;
boolean okay =true;
int shot = 0;

//setup - initialize variables and screen
void setup(){
  //create screen
  size(800, 800);
  //initialize background image
  back = loadImage("backgroundImage.png");
  back.resize(1000,1000);
  //create the spaceship as an object
  alien = loadImage("alien1.png");
  alien.resize(30, 30);
  //fighter img
  fight = loadImage("SpaceShip.png");
  fight.resize(50, 50);
  //laser img
  laser = loadImage("LaserW.png");
  laser.resize(20, 50);
  //trans
  trans = loadImage("trans.png");
  trans.resize(20, 50);
  fighter = new SpaceShip((double)7, (double)10, xPos, yPos ,fight);
  
  //ammo.add(pew);  //just to start the laser amo
  //use arraylist to make spaceShip objects about 10 per row and 3 rows on top
  for (int i = 0; i<3; i++){
    for (int x = 0; x<10; x++){
      //shipsAliens.add(new Ships((double)1, (double)10, 10, 10 ,alien));
      shipsAliens[i][x] = new Ships((double)10, (double)10, 10, 10 ,alien);
    }
  }
  
  /*while (i <30){
    shipsAliens.add(new Ships((double)1, (double)10, 10, 10 ,alien));
    i++;
  }*/
}

  

//draw - call all methods 
void draw(){
   
  //set background image each time
  image(back,-60,-70);
  //display the spaceShip/aliens
  
  for (int i = 0; i<3; i++){
    for (int x = 0; x<10; x++){
      shipsAliens[i][x].display(x, i);
      shipsAliens[i][x].move();
      
    Ships a = shipsAliens[i][index];  
    for (int k = 0; k < ammo.size(); k++) {
      //(l.getXPos() - a.getXPos() < 30 && l.getXPos() - a.getXPos() > 0 && l.getYPos() - a.getYPos() < 30 && l.getYPos() - a.getYPos() > 0)
      //(l.getYPos() <= a.getYPos()+30 && a.getYPos() <= l.getYPos()+30 ) && (l.getXPos() <= a.getXPos()+30 && a.getXPos() <= l.getXPos()+30 )
      Lasers l = ammo.get(k);
      if ((l.getYPos() <= a.getYPos()+30 && a.getYPos() <= l.getYPos()+30 )  ){
        shipsAliens[i][index].setImg(trans);
        shot++;
        ammo.remove(k);
        index++;
        //break;
      }
      
      if(index>9){
        index = 0;
      }

    }
    if (shipsAliens[i][x].getYPos()> 200){
        shipsAliens[i][x].stop();
        fighter.stop();
        okay = false;
      }
    System.out.println(shipsAliens[i][x].getYPos());
    
    }
  }
  //System.out.println("im out ");
  //tint(, 0, 0);
  //l.getYPos() <= a.getYPos()+30 && a.getYPos() <= l.getYPos()+30 
  /*
  for (int i = 0; i < shipsAliens.size(); i++) {
    shipsAliens.get(i).move();
      
    for (int k = 0; k < ammo.size(); k++) {
      //(l.getXPos() - a.getXPos() < 30 && l.getXPos() - a.getXPos() > 0 && l.getYPos() - a.getYPos() < 30 && l.getYPos() - a.getYPos() > 0)
      Ships a = shipsAliens.get(index);
      Lasers l = ammo.get(k);
      if (l.getYPos() < 200){
        a.setImg(laser);
        ammo.remove(k);
        index++;
        //break;
      }
    }
  }*/
  
  for (int i = 0; i<3; i++){
    for (int x = 0; x<10; x++){
    shipsAliens[i][x].safe();
  }
  }
  //display the ships - look at ball class for example
  //ammo.get(index).display();
  fighter.display();
  
  for (Lasers bull : ammo){
    bull.display();
    bull.moveU(); 
  }
  
 

  /*
  okay so basically, boolean released is an instance of the lasers class, and when space released, that instance is set to true. When it is, it displays THAT INDEX OF THE AMMO/LASERS 
  ARRAY and moves it. Then it also adds another object to the array while upping the index. Then, it's supposed to do the same thing but with the next object but it's not :(
  */
  
  //update the ships to move from left to right make sure they don't leave the edges
  //shoot laser based off of spacebar
  //update laser position
  textSize(38);
  color(255,255,255);
  text("ALIENS SHOT: " + shot, 20, 30);
}

//update spaceShip by a and d buttons - use keyPressed function https://processing.org/reference/keyPressed_.html?scrlybrkr=56711ebf 
//void keyPressed(){} - uncomment does not need to be called
void keyPressed() {
    if (key == 'd') {
      fighter.moveR();
      //pew.moveR();
    }
    if (key == 'a') {
      fighter.moveL();
      //pew.moveL();
    }
  }
  
void keyReleased() {
  if (key == ' ' && okay) {
    ammo.add(new Lasers((double)10, (double)10, fighter.getXPos()+15, fighter.getYPos() ,laser));
  }
}
      

//create laser when spaceBar is released - https://processing.org/reference/keyReleased_.html 
//void keyReleased(){} - uncomment does not need to be called
//create a collision method in astroblaster that checks to see if the laser x,y position come into the same area as one of the ships - collision needs to be called
//if it comes into contact delete the ship and the laser
//if laser reaches y = 0 delete from the arrayList

 
