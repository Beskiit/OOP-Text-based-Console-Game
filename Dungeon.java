package OOPGame;

import java.util.Random;
import java.util.Scanner;

interface StoryMode {
	void conversation() throws InterruptedException;
}

interface SurvivalMode{
	void enemy();
	void enemyATK();
	void user();
	void userATK();
	void skill();
}

interface Characters{
	static String storyChar = "Thor";
	static String enemySurvival = "Wild troll";
}

public class Dungeon implements StoryMode, SurvivalMode, Characters{
	String skillCast, name;
	int enemyDamage, yourDamage, yourHP = 100, enemyHP = 100;
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[]args) throws InterruptedException {
		
		Dungeon dungeon = new Dungeon();
		boolean cont = true;
		
		System.out.println("\t\t-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("\t\t⢰⣶⡀⠀⠀⠀⢠⣶⣆⠀⠀⠀⠀⣴⣶⠀⢰⣶⣶⣶⣶⣶⣶⠀⠀⣶⣦⠀⠀⠀⠀⠀⠀⢀⣤⣶⣶⣶⣦⣄⠀⠀⢀⣤⣶⣶⣶⣶⣤⡀⠀⠀⣴⣶⣦⠀⠀⠀⠀⠀⠀⢠⣶⣶⡄⠀⠀⣶⣶⣶⣶⣶⣶⠀");
		System.out.println("\t\t⠘⣿⣧⠀⠀⠀⣼⣿⣿⡀⠀⠀⢠⣿⡏⠀⢸⣿⡇⠀⠀⠀⠉⠀⠀⣿⣿⠀⠀⠀⠀⠀⣰⣿⠟⠉⠀⠈⠉⠛⠃⢰⣿⡟⠉⠀⠀⠉⢻⣿⣆⠀⣿⣯⣿⣧⠀⠀⠀⠀⢠⣿⣿⣿⡇⠀⠀⣿⣧⠀⠀⠀⠈⠀");
		System.out.println("\t\t⢹⣿⡄⠀⢰⣿⠋⣿⣧⠀⠀⣾⡿⠀⠀⢸⣿⣧⣤⣤⣤⡀⠀⠀⣿⣿⠀⠀⠀⠀⢠⣿⡏⠀⠀⠀⠀⠀⠀⠀ ⣿⡿⠀⠀⠀⠀⠀⠀⢿⣿⠀⠀⣿⣿⠸⣿⣇⠀⠀⢀⣿⡟⢸⣿⡇⠀⠀⣿⣿⣤⣤⣤⡄⠀");
		System.out.println("\t\t⠈⣿⣧⠀⣾⡿⠀⢹⣿⡄⢰⣿⠇⠀⠀⢸⣿⡟⠛⠛⠛⠃⠀⠀⣿⣿⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀ ⣿⣧⠀⠀⠀⠀⠀⠀⣼⣿⠀⠀⣿⣿⠀⢹⣿⡆⢀⣼⣿⠁⢸⣿⡇⠀⠀⣿⣿⠛⠛⠛⠋⠀");
		System.out.println("\t\t⠀⠀⢸⣿⣶⣿⠃⠀⠀⣿⣷⣼⡟⠀⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⢿⣿⡄⠀⠀⠀⠀ ⣀⠀⢻⣿⣄⠀⠀⠀⠀⣰⣿⡏⠀⠀⣿⣿⠀⠀⢿⣿⣼⣿⠁⠀⢸⣿⡇⠀⠀⣿⡿⠀⠀⠀⠀⠀");
		System.out.println("\t\t⠀⠀⠀⢿⣿⡟⠀⠀⠀⠸⣿⣿⠃⠀⠀⠀⢸⣿⣷⣶⣶⣶⣶⠀⠀⣿⣿⣶⣶⣶⣶⠀⠈⠻⣿⣷⣶⣶⣿⠟⠀⠀⠻⢿⣷⣶⣶⣾⡿⠛⠀⠀⠀⣿⣿⠀⠀⠈⢿⣿⠇⠀⠀⢸⣿⡇⠀⠀⣿⣿⣶⣶⣶⣶⡆");
		System.out.println("\t\t-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		
		System.out.print("Enter your name: ");
		dungeon.name = sc.next();
		
		System.out.println("Press 1 or 2 to select your game mode.");
		System.out.println("1 - Story");
		System.out.println("2 - Survival");
		int gameMode = sc.nextInt();
		while(cont) {
			System.out.println("Press P to start playing, " + dungeon.name);
			String play = sc.next();
			
			if(play.equalsIgnoreCase("P")) {
				if(gameMode == 1) {
					dungeon.conversation();
					cont = false;
				}else if(gameMode == 2) {
					System.out.println("\nA wild troll has appear! Fight it using your skill.");
					while(cont) {
						
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
						dungeon.enemy();
						System.out.println("\n\n\n");
						dungeon.user();
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
						dungeon.skill();
						dungeon.skillCast = sc.next();
						dungeon.userATK();
						if(dungeon.enemyHP <= 0) {
							dungeon.enemyHP = 0;
							System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
							dungeon.enemy();
							System.out.println("\n\n\n");
							dungeon.user();
							System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
							System.out.println("\n\n-------------Game Over, you win!-------------");
							cont = false;
							break;
						}
						
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
						dungeon.enemy();
						System.out.println("\n\n\n");
						dungeon.user();
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
						
						System.out.println("It is " + enemySurvival + "'s turn\n");
						dungeon.enemyATK();
						Thread.sleep(3000);
						
						if(dungeon.yourHP <= 0) {
							dungeon.yourHP = 0;
							System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
							dungeon.enemy();
							System.out.println("\n\n\n");
							dungeon.user();
							System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
							System.out.println("\n\n-------------Game Over, you lost!-------------");
							cont = false;
							break;
						}
					}
				}
			}else {
				System.err.println("Input error! please try again.");
			}
		}
	}
	
	@Override
	public void enemyATK() {
		int randDMG = rnd.nextInt(0,4);
		if(randDMG == 0) {
			System.out.println("The " + enemySurvival + " throws his hatchet and deal 15 damage!\n");
			yourHP = yourHP - 15;
		}else if(randDMG == 1) {
			System.out.println("The " + enemySurvival + " cast an dark spell to you and deal 19 damage!\n");
			yourHP = yourHP - 19;
		}else if(randDMG == 2) {
			System.out.println("The " + enemySurvival + " uses flame breath and deal 24 damage!\n");
			yourHP = yourHP - 24;
		}else if(randDMG == 3) {
			System.out.println("The " + enemySurvival + " uses electric shock and deal 18 damage!\n");
			yourHP = yourHP - 18;
		}
	}

	@Override
	public void enemy() {
		System.out.println("\t\t\tEnemy HP: " + enemyHP);
	}
	
	@Override
	public void user() {
		System.out.println("Your HP: " + yourHP);
	}
	
	@Override
	public void userATK() {
		if(skillCast.equalsIgnoreCase("A")) {
			System.out.println(name + " uses tackle!\n" + name + " deals 10 damage!\n");
			enemyHP = enemyHP - 10;
		}else if(skillCast.equalsIgnoreCase("M")) {
			System.out.println(name + " uses cursed magic!\n" + name + " deals 20 damage!\n");
			enemyHP = enemyHP - 20;
		}else if(skillCast.equalsIgnoreCase("E")) {
			System.out.println(name + " uses electric charge!\n" + name + " deals 23 damage!\n");
			enemyHP = enemyHP - 23;
		}else if(skillCast.equalsIgnoreCase("L")) {
			System.out.println(name + " uses Lightning Arrow!\n" + name + " deals 26 damage!\n");
			enemyHP = enemyHP - 26;
		}
	}

	@Override
	public void skill() {
		System.out.println("[A] Tackle\t\t [M] Cursed magic\n[E] Electric Charge\t [L] Lightning Arrow");
	}

	@Override
	public void conversation() throws InterruptedException {
		System.out.println("\n" + storyChar + ": Welcome, Warrior " + name + ", to the Abyssal Crypt, a realm shrouded in mystery and dark whispers.\n You, the valiant adventurer, step into the shoes of Roland, a fearless knight, and Elara, a skilled sorceress.\n");
		Thread.sleep(4000);
		System.out.println("As you guide them through the ominous Blackwood Forest, the air thickens with arcane energy.\nThe entrance to the crypt looms before you, adorned with ancient symbols.\n");
		Thread.sleep(4000);
		System.out.println("Upon crossing the threshold, sinister whispers envelop you. Roland draws his sword, and Elara raises her staff.\nYour choices guide them through twisting corridors, facing spectral guardians and arcane illusions.\n");
		Thread.sleep(4000);
		System.out.println("The Heartstone of Eldoria awaits at the dungeon's core, pulsating with untold power.\nWill you have the courage to prove your worth? The voice of the abyss challenges you, testing your unity and resolve.\n");
		Thread.sleep(4000);
		System.out.println("With each step, your decisions shape the destiny of Roland and Elara. Forge a bond that resonates with the Heartstone, unlocking the crypt's secrets.\nAs you emerge, changed by the abyss, the journey continues, with new challenges awaiting your command in the ever-unfolding tale of Eldoria.\n");
	}
}