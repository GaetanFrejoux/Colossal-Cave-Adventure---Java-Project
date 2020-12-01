import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hero {

	public final static int DEFAULT_HP = 100;
	public final static int DEFAULT_BESCHERELLE_LEVEL = 0;
	public final static int DEFAULT_KEY_LEVEL = 0;
	public final static boolean DEFAULT_IMMUNISED_VALUE = false;

	public final static String NAME = "Houga Bouga";


	// ***** ATTRIBUTES *****

	private final String PLAYERNAME;
	private int hp;
	private int keyLevel;
	private int lvlBescherelle;
	private boolean immunised;
	private final Map<String, Obj> objs;
	private Place place;

	// ***** CONSTRUCTORS *****
	public Hero(String name, Place place) {

		this.PLAYERNAME = name;
		this.hp = DEFAULT_HP;
		this.keyLevel = DEFAULT_KEY_LEVEL;
		this.lvlBescherelle = DEFAULT_BESCHERELLE_LEVEL;
		this.immunised = DEFAULT_IMMUNISED_VALUE;
		this.objs = new HashMap<>();
		this.place = place;

	}


	// ***** METHODS *****


	// Getter

	public int getHP() {
		return this.hp;
	}

	public int getBLevel() {
		return this.lvlBescherelle;
	}

	public int getKeyLevel() {
		return this.keyLevel;
	}

	public boolean isImmun() {
		return this.immunised;
	}

	public String getPLAYERNAME() {
		return this.PLAYERNAME;
	}

	public Place getPlace() {
		return this.place;
	}
	
	public Map<String, Obj> getObjs(){
		return this.objs;
	}

	public boolean isAlive(){
		return this.hp>0;
	}
	// Setter

	public void increaseBescherelle() {
		this.lvlBescherelle++;
	}

	public void increaseKey() {
		this.keyLevel++;
	}
	public void setImmunised(){
		this.immunised=true;
	}
	public void setPlace(Place newPlace){
		this.place = newPlace;
	}

	// Display


	// Others

	public void take(String s) {
		if (this.place.getItems().containsKey(s)) {
			this.place.getItems().get(s).take(this);
		}
		else{
			System.out.print("\nNo kind of" + s + " in this place STOOOPID CAVEMAN !\n");
		}
	}


	public void talk(String s) throws InterruptedException {
		//TODO
		if (this.place.getAnimals().containsKey(s)) {
			this.place.getAnimals().get(s).talk(this);
		}
		else{
			System.out.print("\nWhere did you see a " + s + " in this place !? STOOOPID CAVEMAN !\n");
		}
	}

	public void go(String s) {
		if(this.getPlace().getDoors() != null && this.getPlace().getDoors().containsKey(s)) {
			this.getPlace().getDoors().get(s).go(this, s);
		}
		else {
			System.out.print("\nYou live in a cave ? There's nothing like \"" + s + "\" around you stupid caveman !\n"); //On se fait insulter
		}
	}

	public void use(String s) {
		//TODO
	}
	
	public void look(String s) {
		//TODO
	}
	
	public void quit() {
		this.hp = 0;
	}
}
