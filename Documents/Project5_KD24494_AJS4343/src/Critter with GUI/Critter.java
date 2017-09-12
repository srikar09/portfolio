/* CRITTERS Critter2.java
* * <Attila Szabo> 
* * <Krishna Dandamuraju>
* * <ajs4343> 
* * <kd244>
* * <76175.> 
* * Summer 2017 
* * Slip days used: 3
 */

package assignment5;
 
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

import javafx.stage.Stage;

import java.lang.reflect.*;

 
/* see the PDF for descriptions of the methods and fields in this class
 * you may add fields, methods or inner classes to Critter ONLY if you make your additions private
 * no new public, protected or default-package code or data can be added to Critter
 */
 
 
public abstract class Critter {
	
	private static String[][] worldView = new String [Params.world_width + 2][Params.world_height+2]; 

	public enum CritterShape {
		CIRCLE,
		SQUARE,
		TRIANGLE,
		DIAMOND,
		STAR
	}
	
	public javafx.scene.paint.Color viewColor() { 
		return javafx.scene.paint.Color.GREEN; 
	}
	
	public javafx.scene.paint.Color viewOutlineColor() { return viewColor(); }
	public javafx.scene.paint.Color viewFillColor() { return viewColor(); }
	public abstract CritterShape viewShape(); 
		
    private static final Object NULL = null;
	private static String myPackage;
    public static List<Critter> population = new java.util.ArrayList<Critter>();
    private static List<Critter> babies = new java.util.ArrayList<Critter>();
 
    // Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }
   
    public static java.util.Random rand = new java.util.Random();
    public static int getRandomInt(int max) {
        return rand.nextInt(max);
       
    }
   
    public static void setSeed(long new_seed) {
        rand = new java.util.Random(new_seed);
    }
   
   
    /* a one-character long string that visually depicts your critter in the ASCII interface */
    public String toString() { return ""; }
   
    private int energy = 0;
    protected int getEnergy() { return energy; }
   
    public int x_coord;
    public int y_coord;
    public int flag;
    public int fight;
    public int location;
    public int oldx;
    public int oldy;
    
    public int loc(int place){
    	if(place == 0){ // look called in doTimeStep
    		return location = 0;
    	}
    	else if (place == 1){ //look called in fight
    		return location = 1;
    	}else{
    		return location;
    	}
    }
    
	protected final String look(int direction, boolean steps) {
		
		boolean found = false;
		this.energy =  this.energy - Params.look_energy_cost;
		
		if(this.location==0){
			int x = this.oldx;
			int y = this.oldy;
			if(steps==true){
				switch (direction){
				case 0: 		//right
					x+=2;
					break;
				case 1: 		// right and up
					x+=2;
					y-=2;
					break;
				case 2:         // up
					y-=2;
					break;
				case 3:         // left and up  
					x-=2;
					y-=2;
					break;
				case 4:         // left
					x-=2;
					break;
				case 5:         // left and down  
					x-=2;
					y+=2;
					break;
				case 6:         // down
					y+=2;
					break;
				case 7:         // down and right
					y+=2;
					x+=2;
					break;
				}
			}else{
				switch (direction){
				case 0:      //  right
					x+=1;
					break;
				case 1:     // right and up
					x+=1;
					y-=1;
					break;
				case 2:     // up
					y-=1;
					break;
				case 3:     // left and up  
					x-=1;
					y-=1;
					break; 
				case 4:    // left
					x-=1;
					break;			       
				case 5:     // left and down  
					x-=1;
					y+=1;
					break;
				case 6:    // down
					y+=1;
					break;
				case 7:  // down and right
					y+=1;
					x+=1;
					break;
				}

			}
			
			x %= Params.world_width;
		    y %= Params.world_height;
		    if(x < 0)
		        x+=Params.world_width;
		    if(y < 0)
		        y+=Params.world_height; 
		    
		    for (Critter critter : population){
		    	if(x== critter.x_coord && y == critter.y_coord){
		    		found = true;
		    		return critter.toString();
		    		
		    	}
		    }
		    
		}
		
		if(this.location==1){
			int x = this.x_coord;
			int y = this.y_coord;
			if(steps==true){
				switch (direction){
				case 0: 		//right
					x+=2;
					break;
				case 1: 		// right and up
					x+=2;
					y-=2;
					break;
				case 2:         // up
					y-=2;
					break;
				case 3:         // left and up  
					x-=2;
					y-=2;
					break;
				case 4:         // left
					x-=2;
					break;
				case 5:         // left and down  
					x-=2;
					y+=2;
					break;
				case 6:         // down
					y+=2;
					break;
				case 7:         // down and right
					y+=2;
					x+=2;
					break;
				}
			}else{
				switch (direction){
				case 0:      //  right
					x+=1;
					break;
				case 1:     // right and up
					x+=1;
					y-=1;
					break;
				case 2:     // up
					y-=1;
					break;
				case 3:     // left and up  
					x-=1;
					y-=1;
					break; 
				case 4:    // left
					x-=1;
					break;			       
				case 5:     // left and down  
					x-=1;
					y+=1;
					break;
				case 6:    // down
					y+=1;
					break;
				case 7:  // down and right
					y+=1;
					x+=1;
					break;
				}

			}
			
			x %= Params.world_width;
		    y %= Params.world_height;
		    if(x < 0)
		        x+=Params.world_width;
		    if(y < 0)
		        y+=Params.world_height; 
		    
		    for (Critter critter : population){
		    	if(x== critter.x_coord && y == critter.y_coord){
		    		found = true;
		    		return critter.toString();
		    		
		    	}
		    }
		    
		}
			
		
		
		

	    if (found == false) return null;
		return null;
	    
	}
   
    protected final void walk(int direction) {
    this.energy=  this.energy - Params.walk_energy_cost;
    oldx = this.x_coord;
    oldy = this.y_coord;
       
    if(flag==0){
       
    switch (direction){
   
    case 0:      //  right
        this.x_coord= this.x_coord+1;
        break;
    case 1:     // right and up
        this.x_coord= this.x_coord+1;
        this.y_coord= this.y_coord-1;
        break;
    case 2:     // up
        this.y_coord= this.y_coord-1;
        break;
    case 3:     // left and up  
        this.x_coord= this.x_coord-1;
        this.y_coord= this.y_coord-1;
        break;
       
    case 4:    // left
        this.x_coord= this.x_coord-1;
        break;
       
    case 5:     // left and down  
        this.x_coord= this.x_coord-1;
        this.y_coord= this.y_coord+1;
        break;
    case 6:    // down
        this.y_coord= this.y_coord+1;
        break;
   
    case 7:  // down and right
        this.y_coord= this.y_coord+1;
        this.x_coord= this.x_coord+1;
        break;
        }
    
    this.x_coord %= Params.world_width;
    this.y_coord %= Params.world_height;
    if(this.x_coord < 0)
        this.x_coord+=Params.world_width;
    if(this.y_coord < 0)
        this.y_coord+=Params.world_height; 
    
    this.flag=1;
     }
       

    else if(this.fight==1 && this.flag==0){
    	int temp =0;
    		int x=this.x_coord;
    		int y=this.y_coord;
    		
    		switch (direction){
            case 0:         //  right
                x= this.x_coord+1;
                break;
            case 1:         // right and up
                x= this.x_coord+1;
                y= this.y_coord-1;
                break;
            case 2:         // up
                x= this.y_coord-1;
                break;
            case 3:         // left and up  
                x= this.x_coord-1;
                y= this.y_coord-1;
                break;
               
            case 4:         // left
                x= this.x_coord-1;
                break;
               
            case 5:         // left and down  
                x= this.x_coord-1;
                y= this.y_coord+1;
                break;
            case 6:         // down
                y= this.y_coord+1;
                break;
           
            case 7:         // down and right
                x= this.y_coord+1;
                y= this.x_coord+1;
                break;
            }
            
            x %= Params.world_width;
            y %= Params.world_height;
            if(x < 0)
                x+=Params.world_width;
            if(y< 0)
               y+=Params.world_height; 
    	
    		for(Critter a:population){
    			if(x==a.x_coord && y== a.y_coord){	
    				temp =1;
    			}
    		}
    		
    		if (temp !=1){
    			this.x_coord=x;
    			this.y_coord=y;
    			this.flag=1;
    		}
    		
   
    }
    
 }
   
    protected final void run(int direction) {
    	
    this.energy=  this.energy -Params.run_energy_cost;
    oldx = this.x_coord;
    oldy = this.y_coord;
   
    if(this.flag==0 && this.fight==0){
        switch (direction){
        case 0:         //  right
            this.x_coord= this.x_coord+2;
            break;
        case 1:         // right and up
            this.x_coord= this.x_coord+2;
            this.y_coord= this.y_coord-2;
            break;
        case 2:         // up
            this.y_coord= this.y_coord-2;
            break;
        case 3:         // left and up  
            this.x_coord= this.x_coord-2;
            this.y_coord= this.y_coord-2;
            break;
           
        case 4:         // left
            this.x_coord= this.x_coord-2;
            break;
           
        case 5:         // left and down  
            this.x_coord= this.x_coord-2;
            this.y_coord= this.y_coord+2;
            break;
        case 6:         // down
            this.y_coord= this.y_coord+2;
            break;
       
        case 7:         // down and right
            this.y_coord= this.y_coord+2;
            this.x_coord= this.x_coord+2;
            break;
        }
        
        this.x_coord %= Params.world_width;
        this.y_coord %= Params.world_height;
        if(this.x_coord < 0)
            this.x_coord+=Params.world_width;
        if(this.y_coord < 0)
            this.y_coord+=Params.world_height; 
        
        this.flag=1;
    }
   
    else if(this.fight==1 && this.flag==0){
    	int temp =0;
    		int x=this.x_coord;
    		int y=this.y_coord;
    		
    		switch (direction){
            case 0:         //  right
                x= this.x_coord+2;
                break;
            case 1:         // right and up
                x= this.x_coord+2;
                y= this.y_coord-2;
                break;
            case 2:         // up
                x= this.y_coord-2;
                break;
            case 3:         // left and up  
                x= this.x_coord-2;
                y= this.y_coord-2;
                break;
               
            case 4:         // left
                x= this.x_coord-2;
                break;
               
            case 5:         // left and down  
                x= this.x_coord-2;
                y= this.y_coord+2;
                break;
            case 6:         // down
                y= this.y_coord+2;
                break;
           
            case 7:         // down and right
                x= this.y_coord+2;
                y= this.x_coord+2;
                break;
            }
            
            x %= Params.world_width;
            y %= Params.world_height;
            if(x < 0)
                x+=Params.world_width;
            if(y< 0)
               y+=Params.world_height; 
    	
    		for(Critter a:population){
    			if(x==a.x_coord && y== a.y_coord){	
    				temp =1;
    			}
    		}
    		
    		if (temp !=1){
    			this.x_coord=x;
    			this.y_coord=y;
    			this.flag=1;
    		}
    		
    		
    	
    }
    
    
    
       
    }
   
    protected final void reproduce(Critter offspring, int direction) {
           
        if(this.energy>Params.min_reproduce_energy){  //  
            float offspringe = this.energy;
            offspring.energy=  (int) Math.floor((offspringe/(2.0)));  
            this.energy= (int) Math.ceil((offspringe/(2.0)));
            offspring.walk(direction);
            babies.add(offspring);
        }  
        return;
    }
 
    public abstract void doTimeStep();
    public abstract boolean fight(String oponent);
   
    /**
     * create and initialize a Critter subclass.
     * critter_class_name must be the unqualified name of a concrete subclass of Critter, if not,
     * an InvalidCritterException must be thrown.
     * (Java weirdness: Exception throwing does not work properly if the parameter has lower-case instead of
     * upper. For example, if craig is supplied instead of Craig, an error is thrown instead of
     * an Exception.)
     * @param critter_class_name
     * @throws InvalidCritterException
     */
    public static void makeCritter(String critter_class_name) throws InvalidCritterException {    
        // How to throw critter not found exception . How do you create a critter not found exception
        // Need to throw critter not found exception
        // Also can I assume all constructors have no parameters. Is this the right way  
   
          Class aclass = null;
          try {
              aclass = Class.forName(myPackage + "."+critter_class_name);
          } catch (Exception e1) {
              // TODO Auto-generated catch block
              throw new InvalidCritterException(critter_class_name);
             
          }
     
         
          Critter critter= null;
          try {
              critter=(Critter)aclass.newInstance();
          } catch (InstantiationException e) {
              e.printStackTrace();
          } catch (IllegalAccessException e) {
              e.printStackTrace();
          }
          critter.energy=Params.start_energy;  
          critter.x_coord=(int) Critter.getRandomInt(Params.world_width);  
          critter.y_coord= (int)Critter.getRandomInt(Params.world_height);  // use the given random number generator
          critter.flag= 0;
          critter.fight=0;
          population.add(critter);              // does it need to be typecasted? will this work
         
     
         
      }
   
    /**
     * Gets a list of critters of a specific type.
     * @param critter_class_name What kind of Critter is to be listed.  Unqualified class name.
     * @return List of Critters.
     * @throws InvalidCritterException
     */
    public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException {
       
       
        List<Critter> result = new java.util.ArrayList<Critter>();
        
        try {
            Class<?> A = Class.forName(myPackage + "."+critter_class_name);
            for(Critter critter: population){
                if(A.equals(critter.getClass())){
                    result.add(critter);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new InvalidCritterException(critter_class_name);
           
        }
       
       
   
        
        return result;
    }
   
    /**
     * Prints out how many Critters of each type there are on the board.
     * @param critters List of Critters.
     */
    public static String runStats(List<Critter> critters) {
        System.out.print("" + critters.size() + " critters as follows -- ");
        java.util.Map<String, Integer> critter_count = new java.util.HashMap<String, Integer>();
        for (Critter crit : critters) {
            String crit_string = crit.toString();
            Integer old_count = critter_count.get(crit_string);
            if (old_count == null) {
                critter_count.put(crit_string,  1);
            } else {
                critter_count.put(crit_string, old_count.intValue() + 1);
            }
        }
        String prefix = "";
        String x="";
        for (String s : critter_count.keySet()) {
            x= x+prefix + s + ":" + critter_count.get(s);
            prefix = ", ";
        }
        System.out.println();
		return x;      
    
    
    }
   
    /* the TestCritter class allows some critters to "cheat". If you want to
     * create tests of your Critter model, you can create subclasses of this class
     * and then use the setter functions contained here.
     *
     * NOTE: you must make sure that the setter functions work with your implementation
     * of Critter. That means, if you're recording the positions of your critters
     * using some sort of external grid or some other data structure in addition
     * to the x_coord and y_coord functions, then you MUST update these setter functions
     * so that they correctly update your grid/data structure.
     */
    public static abstract class TestCritter extends Critter {
        protected void setEnergy(int new_energy_value) {
            super.energy = new_energy_value;
        }
       
        protected void setX_coord(int new_x_coord) {
            super.x_coord = new_x_coord;  
        }
       
        protected void setY_coord(int new_y_coord) {
            super.y_coord = new_y_coord; 
        }
       
        protected int getX_coord() {
            return super.x_coord;
        }
       
        protected int getY_coord() {
            return super.y_coord;
        }
       
 
        /*
         * This method getPopulation has to be modified by you if you are not using the population
         * ArrayList that has been provided in the starter code.  In any case, it has to be
         * implemented for grading tests to work.
         */
        protected static List<Critter> getPopulation() {
            return population;
        }
       
        /*
         * This method getBabies has to be modified by you if you are not using the babies
         * ArrayList that has been provided in the starter code.  In any case, it has to be
         * implemented for grading tests to work.  Babies should be added to the general population
         * at either the beginning OR the end of every timestep.
         */
        protected static List<Critter> getBabies() {
            return babies;
        }
    }
 
    /**
     * Clear the world of all critters, dead and alive
     */
    public static void clearWorld() {
       population.clear();     
    }
   
    public static void worldTimeStep() {
    
        
        for(Critter x : population){
            x.doTimeStep();
        }
        // Do I have to decrement energy or is it done automatically
       
       
        // resolve conflicts
        for(Critter x : population){
        	x.fight=1;
            for(Critter y : population){
                if(!x.equals(y)){
                	y.fight=1;
                	if(  (x.x_coord== y.x_coord)  && (x.y_coord == y.y_coord)  ){
                		boolean fightx= x.fight(y.toString());
                		boolean fighty= y.fight(x.toString());
                		// checking to make sure it cannot go to a new location if there is something already
                				


                		if(  ( (x.energy>0)  && (y.energy>0)) && ( (x.x_coord == y.x_coord)  && (x.y_coord == y.y_coord)   )  ){  // same position and energy
                			
                			
                			int numx=0;
                			int numy=0;
                			if(fightx){
                				numx =  Critter.getRandomInt(x.energy);
                			}
                			if(fighty){
                				numy= Critter.getRandomInt(y.energy);      
                			}
                			if(numy>numx){ 
                				float tempener= x.energy;
                				y.energy =(int)y.energy+(int) Math.floor((tempener)*(0.5));
                				x.energy = 0;
                			}

                			else {
                				float tempener= y.energy;
                				x.energy =(int)x.energy+(int) Math.floor((tempener)*(0.5));
                				y.energy =0;
                				//                    		population.remove(y);
                			}


                		}
                		
                	}
                	
                }
             y.fight=0; }
    x.fight=0;  }
        
        for(Critter x : population){
            x.energy=x.energy-Params.rest_energy_cost;
        }

        //remove dead critters
        ArrayList <Critter> x =new ArrayList<Critter>();
        
        for(Critter a : population){    
            if(a.energy>0){    
                x.add(a);
            }
        }
   
       population.clear();
       for(Critter a : x){
    	   population.add(a);
    	   
       }
        for(Critter b : population){    
            b.flag =0;
            b.fight=0;
        }
       
        for(int i = Params.refresh_algae_count; i > 0; i--){
            Algae a = new Algae();
            a.setY_coord(getRandomInt(Params.world_height));
            a.setEnergy(Params.start_energy);
            a.setX_coord(getRandomInt(Params.world_width));
            population.add(a);
        }
        
        
    	
        for(Critter z:babies ){    
            population.add(z);
        }        
        babies.clear();
        
      
        
       
   
    }
   
	public static void displayWorld(Object pane) {
		for (int x = 0; x < Params.world_width + 2; x ++) //set up the boundary
		{
			for (int y = 0; y < Params.world_height + 2; y++)
			{
				if((x==0&&y==0)||(x==0&&y==Params.world_height + 1)
						||(x==Params.world_width + 1&&y==0)||(x==Params.world_width + 1&&y==Params.world_height + 1))//four corners
					worldView[x][y] = "+";
					//System.out.print("+");
				else if( x==0 || x== Params.world_width +1)//vertical bound
					worldView[x][y] = "|";
					//System.out.print("|");
				else if( y==0 || y==Params.world_height + 1)
					worldView[x][y] = "-";
					//System.out.print("-");
				else
					worldView[x][y] = " ";
					//System.out.print(" ");
			}
			
		}
		
		for(int i = 0; i<population.size(); i++) //get the critter to the world
		{
			int x = population.get(i).x_coord;
			int y = population.get(i).y_coord;
			String z = population.get(i).toString();
			worldView[x+1][y+1]= z;
		}
		for (int y = 0; y < Params.world_height + 2; y ++) //print out the world
		{
			for (int x = 0; x < Params.world_width + 2; x++)
			{
				System.out.print(worldView[x][y]);
			}
			System.out.println();
		}
		
	}
	}
	