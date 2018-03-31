package Model;

import View.Window;


import java.util.ArrayList;
import java.util.Random;

public class Game implements DeletableObserver{
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

    private Window window;
    private int size = 20;
    //private int bombTimer = 3000;
    private int numberOfBreakableBlocks = 40;

    public Game(Window window) {
        this.window = window;

        // Creating one Player at position (1,1)
        objects.add(new Player(10, 10, 3, 5));   // crée un jouer en (10,10), avec 3 bombe et 5hp

        
        // Creating one Ennemi
        objects.add(new Pnj(11,11,5));
       
        // Map building
        for (int i = 0; i < size; i++) {
            objects.add(new BlockUnbreakable(i, 0));
            objects.add(new BlockUnbreakable(0, i));
            objects.add(new BlockUnbreakable(i, size - 1));
            objects.add(new BlockUnbreakable(size - 1, i));
        }
        Random rand = new Random();
        for (int i = 0; i < numberOfBreakableBlocks; i++) {
            int x = rand.nextInt(16) + 2;
            int y = rand.nextInt(16) + 2;
            int lifepoints = rand.nextInt(5) + 1;
            BlockBreakable block = new BlockBreakable(x, y, lifepoints);
            block.attachDeletable(this);
            objects.add(block);
        }

        window.setGameObjects(this.getGameObjects());
        notifyView();
    }


    public void movePlayer(int x, int y, int playerNumber) {   // fait bouger le joueur choisit de x,y
        Player player = ((Player) objects.get(playerNumber));
        int nextX = player.getPosX() + x;
        int nextY = player.getPosY() + y;

        boolean obstacle = false;                                      // met l'était d'obstacle à false
        for (GameObject object : objects) {                            // vérifie les objets à nextPos
            if (object.isAtPosition(nextX, nextY)) {                   
                obstacle = object.isObstacle();            
            }
            if (obstacle == true) {
                break;
            }
        }
        player.rotate(x, y);                                            // change l'orientation
        if (obstacle == false) {                                        // bouge le joueur si il n'y a pas d'obstacle
            player.move(x, y); 
        }
        notifyView();
    }

    
    /////////////////////
    //Code test ajouté///
    /////////////////////
   
    public void moveEnnemi() throws InterruptedException {
    	Pnj ennemi = ((Pnj) objects.get(1));
    	Random rand = new Random();
    	Thread thread = new Thread();
    	thread.start();	
    	while(true) {
    	try {
    	Thread.sleep(500);	
    	int rand_x = rand.nextInt(3) -1;
    	int rand_y = rand.nextInt(3) -1;

    	int next_X = ennemi.getPosX() + rand_x;
    	int next_Y = ennemi.getPosY() + rand_y;
    	
    	boolean obstacle = false;
    	for(GameObject object : objects) {
    		if (object.isAtPosition(next_X, next_Y)) {
    			obstacle = object.isObstacle();
    		}
    		if (obstacle == true) {
    			break;
    		}
    	}
    	ennemi.rotate(rand_x,rand_y);
    	if (obstacle == false) {
    		ennemi.move(rand_x,rand_y);
    	}
    	notifyView();
    	
    	} catch(InterruptedException e) {
    	}
    }
    }
    
    
    
    public void action(int playerNumber) {
        Player player = ((Player) objects.get(playerNumber));
        Activable aimedObject = null;
		for(GameObject object : objects){
			if(object.isAtPosition(player.getFrontX(),player.getFrontY())){          // vérifie si l'objet est devant le joueur
			    if(object instanceof Activable){
			        aimedObject = (Activable) object;
			    }
			}
		}
		if(aimedObject != null){                                                    // diminue la vie de l'objet
		    aimedObject.activate();
            notifyView();
		}
        
    }

    private void notifyView() {                                      // recharge la fenêtre
        window.update();
    }

    public ArrayList<GameObject> getGameObjects() {
        return this.objects;
    }

    @Override
    synchronized public void delete(Deletable ps, ArrayList<GameObject> loot) {
        objects.remove(ps);
        if (loot != null) {
            objects.addAll(loot);
        }
        notifyView();
    }


    public void playerPos(int playerNumber) {
        Player player = ((Player) objects.get(playerNumber));
        System.out.println(player.getPosX() + ":" + player.getPosY());
        
    }

}