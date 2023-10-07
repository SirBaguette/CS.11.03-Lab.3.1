
import java.util.Scanner;
import java.util.Timer;

public class TextBasedGame {
    static int experience;
    static int a;
    static boolean introFinished = false;
    static boolean crossedVolga = false;
    static boolean SASF = false;
    static boolean dead = false;
    static boolean volgaLanded = false;
    static boolean millFought = false;
    static boolean millEnd = false;
    static boolean NLBV = false;
    static boolean  MamaevKurgan = false;
    static boolean MamaevKurganFight = false;
    static boolean AYCN = false;
    static boolean mkfr = false;
    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    static int abc = 1*1+1-1/1%1;

    public static void main(String[] args) {

        while (!dead && !crossedVolga) {
            if (!introFinished && !dead) {introFinished = intro(0);}
            if (!crossedVolga && !dead) {
                crossedVolga = crossingVolga(0);
            }

        }
        if (dead) {
            deathProcess(0);
        }
        if (crossedVolga && !volgaLanded) {
            volgaLanded = volgaLanding(0);
        }
        if (dead) {
            deathProcess(0);
        }
        if (!millFought && volgaLanded) {
            millFought = theMill(0);
        }
        if (dead) {
            deathProcess(0);
        }
        if (millFought && !millEnd) {
            millEnd = mill(0);
        }
        if (dead) {
            deathProcess(0);
        }
        if(millEnd && !MamaevKurgan) {
            MamaevKurgan = MK(0);
        }
        if (dead) {
            deathProcess(0);
        }
        if (MamaevKurgan && !MamaevKurganFight) {
            MamaevKurganFight = MKfight(0);
        }
        if (dead) {
            deathProcess(0);
        }
        if (MamaevKurganFight && !mkfr) {
            mkfr = MkResults(0);
            pause(1000);
        }
        if (dead) {
            deathProcess(0);
        }
        if (mkfr) {
            System.out.println("This is the game, for now. You may have won, but there is a long way to go.");
            System.exit(0);
        }

    }



    public static boolean intro(int a) {
        Scanner intro = new Scanner(System.in);
        System.out.println("You are Ivan, a soldier in the glorious Red Army. " +
                "\nYou belong to the 13th Guards Rifle Division, commanded by Rodimtsev." +
                "\nThe Division is to cross the Volga on the 13th of September.");
        pause(1000);
        System.out.println("Press 1 to Continue:");
        while (a != 1) {
            try {
                a = Integer.parseInt(intro.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        if (a == 1) {
            return true;
        }
        return false;
    }
    static double volgaChances;
    static int ammo;
    static double health;
    static int weapon = 0; //weapon 1 = Tokarev, 2 = Mosin-Nagant M1891 3 = PPSh-41
    static int vo;

    public static boolean crossingVolga(int v) {
        Scanner intro = new Scanner(System.in);
        System.out.println("It is the 13th of September, and darkness has not yet completely fallen." +
                "\nYou have finally been issued with a Tokarev TT-33, 20 rounds of 7.62 ammunition, some bread and sausages. Unfortunately no vodka.");
        pause(1000);
        System.out.println("Obtained New Weapon: Tokarev TT-33)\n" +
                "(Obtained Ammunition: 20 rounds)");
        pause(1000);
        System.out.println("After several round trips, it is finally your turn to rush from the river bank to one of the boats.\n" +
                "Amongst the chaos, you lost your detachment.\n" +
                "Will you board a gunboat from the Volga Floatilla, or a commandeered fishing barque?");
        pause(1000);
        System.out.println("(Option 1: Board the gunboat. [Press 1])\n" +
                "(Option 2: Board the fishing barque. [Press 2])");
        weapon = 1;
        ammo = 20;
        while (v <= 0 || v > 2) {
            try {
                v = Integer.parseInt(intro.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        if (v == 1) {
            System.out.println("You managed to get on one of the gunboats. Its riveted armour gives some sense of protection.");
            volgaChances = Math.random()-0.1;
            vo = 1;
            return true;
        }
        else if (v == 2) {
            System.out.println("You get onto one of the inconspicuous barques. Its modest mast and deck reeks of fish.");
            volgaChances = Math.random();
            vo = 2;
            return true;
        }

        return false;
    }
    public static boolean volgaLanding(int l) {
        Scanner mainscan = new Scanner(System.in);

        if (crossedVolga && volgaChances < 0.10 && vo == 1) {
            pause(1000);
            System.out.println("The Germans suddenly opened fire. Before you knew it, the gunboat went up in flames.");
            dead = true;
            return false;
        }
        else if (crossedVolga && volgaChances < 0.10 && vo == 2) {
            pause(1000);
            System.out.println("The Germans suddenly opened fire. Before you knew it, the barque went up in flames.");
            dead = true;
            return false;
        }
        else if (crossedVolga && volgaChances >= 0.1 && vo == 1) {
            pause(1000);
            System.out.println("German machine guns and artillery opened fire from the opposite bank. \n" +
                    "Columns of water was thrown up, and the silver bellies of the fish appeared on the surface. \n" +
                    "The gunboat fired back occasionally. The scene of Stalingrad was more like an image of hell.\n" +
                    "Huge flames waved at you from charred buildings, black smoke ascending even higher. \n" +
                    "The gunboat landed. Without much thought, you quickly disembarked onto the shore, dodging bullets from all sides.");
            pause(2500);
            System.out.println("(Achievement Unlocked: The Stalingrad Academy of Street Fighting)");
            SASF = true;
            System.out.println("Press 1 to Continue:");
            while (a != 1) {
                try {
                    a = Integer.parseInt(mainscan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            return true;
        }
        else if (crossedVolga && volgaChances >= 0.1 && vo == 2) {
            pause(1000);
            System.out.println("German machine guns and artillery opened fire from the opposite bank. \n" +
                    "Columns of water was thrown up, and the silver bellies of the fish appeared on the surface. \n" +
                    "The mast of the barque is riddled with bullets. The scene of Stalingrad was more like an image of hell.\n" +
                    "Huge flames waved at you from charred buildings, black smoke ascending even higher. \n" +
                    "The barque landed. Without much thought, you quickly disembarked onto the shore, dodging bullets from all sides.");
            pause(2500);
            System.out.println("(Achievement Unlocked: The Stalingrad Academy of Street Fighting)");
            experience++;
            SASF = true;
            System.out.println("Press 1 to Continue:");
            while (a != 1) {
                try {
                    a = Integer.parseInt(mainscan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            return true;
        }
        return false;
    }
    static int millCharge;
    static double millChances;

    public static boolean theMill(int m){
        Scanner mill = new Scanner(System.in);
        System.out.println("Quickly after gaining a foothold on the riverbank, order came down.\n" +
                "You are to retake the red mill and to secure the river crossing for your fellow comrades.\n" +
                "A few tanks joined the small force. It looked like one of the T-60 tanks, but there was no paint on its armour, just a hastily drawn red star." +
                "\nSome of the tank crews smiled at you. You recognised their uniform: they were from the manufacturing plants that made these tanks.");
        pause(2000);
        System.out.println("You could see the mill from distance. It seemed much like a skeleton, bullet-riddled.\n" +
                "It is time to die, for the motherland. Will you be brave and lead the charge?" +
                "\n(Press 1 to charge)\n(Press 2 to follow)");
        while (millCharge <= 0 || millCharge > 2) {
            try {
                millCharge = Integer.parseInt(mill.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        if (millCharge == 1) {
            System.out.println("No land for us beyond the Volga!");
            millChances = Math.random()-0.3;
            return true;
        }
        else if (millCharge == 2) {
            System.out.println("For the Motherland, for Stalin!");
            millChances = Math.random();
            return true;
        }
        return false;
    }
    static int millEnter;
    public static boolean mill(int mill) {
        Scanner mil = new Scanner(System.in);
        if (millChances < 0.30 && millCharge == 1) {
            pause(1000);
            System.out.println("You charged towards the big red mill, pistol in hand. German machine guns fired." +
                    "\nYou died for the motherland, like thousands of others.");
            dead = true;
            return false;
        } else if (millChances < 0.30 && millCharge == 2) {
            pause(1000);
            System.out.println("You followed your comrades, and charged towards the big red mill.\n" +
                    "Before you could reach the building, a mortar threw your body into the air.");
            dead = true;
            return false;
        } else if (millChances >= 0.30 && millCharge == 1) {
            pause(1000);
            System.out.println("You charged fearlessly towards the big red mill. Bullets wizzed right past you.\n" +
                    "Comrades fell one by one next to you, but miraculously you have made it close to the Germans.\n" +
                    "Followed by some grenades thrown by your comrades, the close quarter combat began.\n" +
                    "You picked up a rifle with a bayonet fixed from a dead comrade, and continued to charge towards the Nazis.");
            pause(1000);
            System.out.println("(Obtained New Weapon: Mosin-Nagant M1891)");
            pause(1000);
            System.out.println("Shouting and chaos ensued. You somehow survived the fight and stabbed a Fritz yourself.");
            pause(2500);
            System.out.println("(Achievement Unlocked: No land for us beyond the Volga!)");
            experience = experience + 2;
            NLBV = true;
            System.out.println("Press 1 to Continue:");
            while (millEnter != 1) {
                try {
                    millEnter = Integer.parseInt(mil.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            return true;
        } else if (millChances >= 0.1 && millCharge == 2) {
            pause(1000);
            System.out.println("You followed the charge towards the big red mill. Bullets wizzed right past you.\n" +
                    "Comrades fell one by one next to you, but miraculously you have made it close to the Germans.\n" +
                    "Followed by some grenades thrown by your comrades, the close quarter combat began.\n" +
                    "You picked up a rifle with a bayonet fixed from a dead comrade, and continued to charge towards the Nazis.");
            pause(1000);
            System.out.println("(Obtained New Weapon: Mosin-Nagant M1891)");
            pause(1000);
            System.out.println("Shouting and chaos ensued. You somehow survived the fight and stabbed a Fritz yourself.");
            System.out.println("Press 1 to Continue:");
            experience++;
            while (millEnter != 1) {
                try {
                    millEnter = Integer.parseInt(mil.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            return true;
        }
        return false;
    }
    public static int MKenter;
    public static boolean MK(int mk) {
        Scanner mkScan = new Scanner(System.in);
        System.out.println("No break for the Red Army. The situation in Stalingrad is dire. We need to counterattack.\n" +
                "Mamaev Kurgan was taken by the Germans at the start of the fight. Now we take it back.");
        pause(1000);
        System.out.println("Press 1 to continue:");
        while (MKenter != 1) {
            try {
                MKenter = Integer.parseInt(mkScan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        return true;
    }
    public static int MKFenter;
    public static double MKChances;
    public static boolean MKfight(int f) {
        Scanner mkScan = new Scanner(System.in);
        System.out.println("One of your platoon commanders lived in Stalingrad. He told you that the mountain used to boast a park.\n" +
                "The park overlooked the city, and was a romantic destination for couples. Many of them died when the air raids started." +
                "\nNow the height simply boasts dirt, which looked like it had been ploughed so many times by the bombs and bullets." +
                "\nOnce again, we will fight off the enemy.");
        pause(1000);
        System.out.println("(Press 1 to attack the height directly)" +
                "\n(Press 2 to help your comrades by striking German artillery support)");
        while (MKFenter != 1 && MKFenter != 2) {
            try {
                MKFenter = Integer.parseInt(mkScan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        if (MKFenter == 1) {
            MKChances = Math.random()-0.2;
        }
        if (MKFenter == 2) {
            MKChances = Math.random();
        }
        return true;
    }
    public static boolean MkResults(int r) {
        Scanner scanmk = new Scanner(System.in);

        if (MKChances < 0.5 && MKFenter == 1) {
            pause(1000);
            System.out.println("Despite the waves of comrades cut down mercilessly by German fire, you charged fearlessly." +
                    "\nOf course, your fate is no different.");
            dead = true;
            return false;
        }
        else if (MKChances < 0.50 && MKFenter == 2) {
            pause(1000);
            System.out.println("You followed your platoon in an attempt to take out enemy mortar positions." +
                    "\nUnfortunately, SS soldiers were close by and quickly encircled your small force.");
            dead = true;
            return false;
        }
        else if (MKChances >= 0.5 && MKFenter == 1) {
            pause(1000);
            System.out.println("Despite the waves of comrades cut down mercilessly by German fire, you charged fearlessly. \n" +
                    "Mortar fire rained down on the small hilltop. The land turned into mush over and over again.\n" +
                    "The superiors seemed to have been calling up reinforcements for a renewed push.\n" +
                    "You were called up to the suicidal effort. \n" +
                    "You charged up. The fire seemed to be a lot more dispersed, owing to the efforts of your predecessors.\n" +
                    "You reached the top, unplugged the ugly German swastika flag, and proceeded to trample on it.");
            pause(2500);
            System.out.println("(Achievement Unlocked: \"Adolf, you can not.\")");
            AYCN = true;
            System.out.println("Press 1 to Continue:");
            while (a != 1) {
                try {
                    a = Integer.parseInt(scanmk.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            return true;
        }
        else if (MKChances >= 0.5 && MKFenter == 2) {
            pause(1000);
            System.out.println("German machine guns and artillery opened fire from the opposite bank. \n" +
                    "Columns of water was thrown up, and the silver bellies of the fish appeared on the surface. \n" +
                    "The mast of the barque is riddled with bullets. The scene of Stalingrad was more like an image of hell.\n" +
                    "Huge flames waved at you from charred buildings, black smoke ascending even higher. \n" +
                    "The barque landed. Without much thought, you quickly disembarked onto the shore, dodging bullets from all sides.");
            pause(2500);
            System.out.println("(Achievement Unlocked: The Stalingrad Academy of Street Fighting)");
            experience++;
            SASF = true;
            System.out.println("Press 1 to Continue:");
            while (a != 1) {
                try {
                    a = Integer.parseInt(scanmk.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            return true;
        }
        return false;
    }


    public static int deathChoice;
    public static void deathProcess(int g){
        Scanner deathScan = new Scanner(System.in);
        pause(2000);
        System.out.println("\nUnfortunately you have perished, and your bones will forever stay with the city.");
        pause(1000);
        System.out.println("Would you like to restart the game?\n" +
                "(Press 1 to Replay)\n(Press 2 to view Achievements)\n(Press 3 to go to hell)");
        while (deathChoice != 1 && deathChoice != 2 && deathChoice != 3) {
            try {
                deathChoice = Integer.parseInt(deathScan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        if (deathChoice == 1) {
            System.out.println("Your game will be restarted in a moment. Achievements will be kept.");
            pause(1000);
            experience = 0;
            a = 0;
            ammo = 0;
            introFinished = false;
            crossedVolga = false;
            dead = false;
            volgaLanded = false;
            millFought = false;
            millEnd = false;
            NLBV = false;
            MamaevKurgan = false;
            MKenter = 0;
            millEnter = 0;
            vo = 0;
        }
        else if (deathChoice == 3) {
            System.out.println("Your game has been terminated.");
            System.exit(0);
        }
        else if (deathChoice == 2) {
            if (SASF) {
                System.out.println("(Achievement: Stalingrad Academy of Street Fighting)");
                pause(500);
            }
            if (NLBV) {
                System.out.println("(Achievement: No Land for us Beyond the Volga)");
                pause(500);
            }
            System.out.println("These are all your achievements. Please continue.");
            pause(500);
            System.out.println("Would you like to restart the game?\n" +
                    "(Press 1 to Replay)\n(Press 3 to go to hell)");
            while (deathChoice != 1 && deathChoice != 3) {
                try {
                    deathChoice = Integer.parseInt(deathScan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }
            if (deathChoice == 1) {
                System.out.println("Your game will be restarted in a moment. Achievements will be kept.");
                pause(1000);
                experience = 0;
                a = 0;
                ammo = 0;
                introFinished = false;
                crossedVolga = false;
                dead = false;
                volgaLanded = false;
                millFought = false;
                millEnd = false;
                NLBV = false;
                MamaevKurgan = false;
                MKenter = 0;
                millEnter = 0;
                vo = 0;
            }
            else if (deathChoice == 3) {
                System.out.println("Your game has been terminated.");
                System.exit(0);
            }
        }
    }

}