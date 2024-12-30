package Project;

import java.util.ArrayList;
import java.util.Random;

public class NarrativeManager {
    private ArrayList<String> dragonLosingConversation;
    private ArrayList<String> dragonWinningConversation;
    private int indexDoor;
    private int indexDragon;

    private final Inventory inventory;
    private final Character player;

    public NarrativeManager(Inventory i, Character p) {
        inventory = i;
        player = p;
        indexDoor = 0;
        indexDragon = 0;
    }

    public void nextDoorNarration() {
        if (indexDoor == 0) door1();
        if (indexDoor == 1) door2();
        if (indexDoor == 2) door3();
        if (indexDoor == 3) door4();
        indexDoor++;
    }

    private void door1() {
        System.out.println("\n\n\nDoor 1: The Forgotten Chamber");
        System.out.println("""
                      __________
                     |  ______  |
                     | |      | |
                     | | Door | |
                     | |   1  | |
                     | |______| |
                     |__________|
                     /__________\\
                    |            |
                    |  Forgotten |
                    |   Chamber  |
                    |____________|
                
                The first door is a massive stone slab, weathered and cracked with age.
                Carvings of ancient warriors battling shadowy monsters cover its surface.
                
                As you approach, the air grows cold, and a ghostly figure materializes.
                
                'I am General Talen,' the figure declares. 'Many have tried and failed to open this door.
                Prove your worth through a game of Rock, Paper, Scissors, a battle of wits passed down
                from the ancients.'
                
                Before fading away, the figure hands you an amulet, its surface etched with runes
                that seem to hum with power.
                The carvings tell a story of a mighty king battling a dragon.
                           _______
                         .'\\     /'.
                        /   '-.-'   \\
                       |    (   )    |
                        \\    '-'    /
                         '.___|__.'
                             |||
                             |||
                           =======
                
                """);
        System.out.print("Do you want to take the Amulet with you?(y/n): ");
        if (GetInput.getWordInput().equalsIgnoreCase("y")) {
            inventory.addItem("Amulet");
            player.equipAmulet();
        }
        System.out.println("\nYou are approaching the door to prove you are worthy.");
        System.out.println("\nThe first challenge is gonna be Rock Paper Scissors with the door keeper shadows.\n");
    }

    private void door2() {
        System.out.println("\n\n\nDoor 2: The Abyssal Bridge");
        System.out.println("""
                       ___________
                      |  _______  |
                      | |       | |
                      | | Door  | |
                      | |   2   | |
                      | |_______| |
                      |___________|
                     /____________\\
                    /|            |\\
                   / |   Abyssal  | \\
                  /  |   Bridge   |  \\
                 /___|____________|___\\
                
                The second door stands at the end of a precarious stone bridge suspended
                over a seemingly endless abyss. The door glows faintly with blue light,
                its surface smooth as glass and etched with a cryptic riddle:
                
                'Only those with knowledge and patience may pass.'
                
                Beside the door, you find a stone tablet carved with symbols and words.
                   _________________________________________
                  /                                         \\
                 /                                           \\
                |  *****************************************  |
                |  *                                       *  |
                |  *      Tablet of Forgotten Lore         *  |
                |  *                                       *  |
                |  *   "Speak the truth, seek the light,   *  |
                |  *    and find the path to wisdom."      *  |
                |  *                                       *  |
                |  *****************************************  |
                 \\                                           /
                  \\_________________________________________/
                
                """);

        System.out.print("Do you want to take the tablet with you?(y/n): ");
        if (GetInput.getWordInput().equalsIgnoreCase("y")) {
            inventory.addItem("Tablet");
        }
        System.out.println("""
                
                
                The symbols shimmer as if alive, hinting at a connection to your next trial.
                
                The voice of General Talen echoes faintly: 'Solve the mystery of Hangman
                to proceed, or the bridge will crumble beneath you.'
                
                """);

        System.out.println("Whispers rise from the darkness below, warning you to turn back.");

        if (inventory.hasItem("Amulet")) {
            System.out.println("\nYour amulet glows faintly, shielding you from the damage of the whispers.\n");
        } else {
            System.out.println("\nThe whispers sow doubt in your heart. Your health decreases.");
            player.takeDamage(10);
        }
        System.out.println("\nBut You don't give up and go to the next door to face your challenge! Hangman!\n");

    }

    private void door3() {
        System.out.println("\n\n\nDoor 3: The Chamber of Shadows");
        System.out.println("""
                      _________
                     / _______ \\
                    / /       \\ \\
                   | | Door 3  | |
                   | | Shadows | |
                    \\ \\_______/ /
                     \\_________/
                     /         \\
                    |  Chamber  |
                    |   of      |
                    |  Shadows  |
                    |___________|
                
                The third door is unlike the others. It is surrounded by a ring of mirrors
                that reflect not your true image, but warped, twisted versions of yourself.
                The reflections whisper taunts and warnings, their voices filling your head
                with doubt.""");
        if (inventory.hasItem("Amulet")) {
            System.out.println("The amulet hums with energy, revealing your true self in the mirrors.");
        } else {
            System.out.println("The mirrors sow doubt in your mind. Your health decreases.");
            player.takeDamage(10);
        }
        System.out.println("""
                
                In the center of the door is a slot, perfectly shaped for a key, yet no key
                is present. Instead, a small glowing vial lies at the base of the door.
                
                       ~~~~~~~~~~~~~~~~~~~~~~~~~~~
                     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                  ~~~~~~~~~~~~~~ The Veil ~~~~~~~~~~~~~~
                  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   ~~~~~~~~~~~~~~~~ ||| ~~~~~~~~~~~~~~~
                    ~~~~~~~~~~~~~~ /   \\ ~~~~~~~~~~~~~~
                     ~~~~~~~~~~~~~ \\___/ ~~~~~~~~~~~~~
                      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        ~~~~~~~~~~~~~~~~~~~~~~~~~~~
                          ~~~~~~~~~~~~~~~~~~~~~~~
                            ~~~~~~~~~~~~~~~~~~~
                
                You pick it up, feeling its warmth seep into your hands.""");
        System.out.print("Do you want to take it?(y/n): ");
        if (GetInput.getWordInput().toLowerCase().charAt(0) =='y') {
            inventory.addItem("Vial");
            System.out.println("You take the Vial and move on.");
        }

        System.out.println("""
                
                A deep voice resonates through the chamber: 'The key lies within the game
                of Scrambled words. Only the strong and persistent will succeed.'
                As the whispers grow louder, you steel yourself for the challenge.
                
                """);

    }

    private void door4() {
        System.out.println("\n\n\nDoor 4: The Garden of Despair");

        System.out.println("""
                       __________
                      |  ______  |
                      | |      | |
                      | | Door | |
                      | |      | |
                      | |   4  | |
                      | |______| |
                      |__________|
                     //__________\\\\
                    //|          |\\\\
                   || |  Garden  | ||
                   || | of       | ||
                    \\\\| Despair  |//
                     \\\\__________//
                
                The fourth door opens to the "Garden of Despair", an otherworldly garden.
                The air is heavy with the scent of decayed flowers, and thorny vines writhe slowly, as if alive.
                At the center of the garden stands a pedestal, atop which rests a single black rose.
                
                As you approach, a vine lashes out, wrapping around your wrist. A voice echoes in your mind:
                
                “You do not belong here. The flower is not yours to take."
                
                You pull free of the vine and notice an inscription on the pedestal:
                
                "Life blooms only where hope is sown."
                
                You remember the tablet’s words and decide not to take the rose.
                Instead, you kneel and place the amulet upon the pedestal.
                
                The garden quakes, and the vines retreat. The black rose transforms into a radiant white flower.
                A new path opens before you.""");

        System.out.println("\n\nBefore You walk past the door you find a potion on the ground on the way to the dragon's nest.");
        System.out.print("Do you want to drink the potion?(y/n): ");

        if (GetInput.getWordInput().toLowerCase().charAt(0) == 'y') {
            Random r = new Random();
            boolean chance = r.nextBoolean();
            if (!chance) {
                System.out.println("The potion was a poison and you fall ill for minuets!");
                player.takeDamage(30);
            } else {
                System.out.println("The potion is a healing potion and it gives you energy!");
                player.takeHealing(30);
            }
        } else
            System.out.println("You continue without picking up the potion!");

        System.out.println("""
                
                Walking past the roses, you are greeted by an immense cavern, its walls glittering with embedded crystals.
                In the center lies the dragon, Zarathor, its scales shimmering like molten gold.
                
                The dragon opens one eye, its gaze piercing your very soul:
                """);
        System.out.println("Are you ready to go in and face your fear?");
        if (GetInput.getWordInput().toLowerCase().charAt(0) == 'n')
            System.out.println("Well Too late, The dragon already saw you.\n\n");

        System.out.println("""
                “You have come far, mortal. Few possess the courage to face me. But courage alone is not enough.”
                Zarathor rises, its massive wings unfurling, and roars:
                
                “To claim the Heart-flower, you must prove your worth. Not in battle, but in mind. Let us play a game.
                Should you fail, your journey ends here.”
                
                A massive stone board rises from the ground—it’s a game of Tic-Tac-Toe with a twist.
                But as you play, each move feels weighted, as though the dragon is testing not just
                your skill but your resolve.
                        -------The battle begins.----------
                
                
                """);
    }

    public void restartNarration(){
        indexDoor = 0;
        indexDragon = 0;
    }

    public void proposeChallenge() {
        System.out.println();
        System.out.println();
        System.out.println("Hello - " + player.getName());
        System.out.println("Welcome to Your Adventure!");
        System.out.println("""
                A grand, echoing voice, perhaps a wise old man or a divine entity, begins to narrate.
                
                "You are King Solomon, a ruler of great wisdom and power. Yet, even kings are not immune to sorrow.
                Your beloved daughter, Princess Shiba, lies gravely ill.
                
                A wise sage has revealed that a single bloom from the mystical Heart-flower, nestled within the lair
                of the ancient dragon, Zarathor, atop the perilous Mountain of Shadows, known as Mystical Dashen,
                holds the key to her recovery.
                
                But beware, for the mountain is not merely perilous; it is cursed, Multiple Doors sealed by generations
                past to contain a monstrous evil. A daunting quest awaits you, noble king. Will you be brave
                to dare go into the unknown, confront the DRAGON, and claim the flower to save your daughter?
                """);
    }

    public void dragonStart() {
        dragonWinningConversation = new ArrayList<>();
        dragonLosingConversation = new ArrayList<>();
        dragonWinningConversation.add("\"Ha! Did you really think you could defeat me? How amusing.\"");
        dragonWinningConversation.add("\"You are no match for my centuries of wisdom, mortal!\"");
        dragonWinningConversation.add("\"Bow before my might and accept your fate!\"");
        dragonWinningConversation.add("\"Pathetic. Even my claws could play better than you.\"");
        dragonWinningConversation.add("\"Is that all you’ve got, little king? How disappointing.\"");
        dragonWinningConversation.add("\"Feel the sting of defeat. Do you really want to continue this folly?\"");
        dragonWinningConversation.add("\"Every loss brings you closer to your doom. Surrender now!\"");
        dragonLosingConversation.add("\"You got lucky this time, mortal. Don't think it will happen again!\"");
        dragonLosingConversation.add("\"Hmph! A minor setback. The next round will be your undoing.\"");
        dragonLosingConversation.add("\"You've only scratched the surface of my power! Prepare yourself!\"");
        dragonLosingConversation.add("\"Enjoy your victory while it lasts—it will be your last.\"");
        dragonLosingConversation.add("\"Perhaps you are worthy of this challenge. Or perhaps not. Let us see.\"");
        dragonLosingConversation.add("\"A lucky strike! Even the weakest flame burns bright once.\"");
        dragonLosingConversation.add("\"Do not mistake a single victory for strength, mortal.\"");
        dragonLosingConversation.add("\"Bah! Beginner’s luck. It won't happen again.\"");
        dragonLosingConversation.add("\"Victory is an illusion, mortal. The dragon always prevails.\"");
        dragonLosingConversation.add("\"Do you truly believe you can defeat me in the end? Foolish.\"");
        dragonLosingConversation.add("\"You’ve scratched the surface, but the mountain still stands.\"");
        dragonLosingConversation.add("\"A small crack in my defense—hardly worth celebrating.\"");
    }

    public void getDragonConversation(int i){
        if(indexDragon == 0) {
            dragonStart();
            return;
        }
        switch (i){
            case 0 -> System.out.println(dragonWinningConversation.get(indexDragon++));
            case 1 -> System.out.println(dragonLosingConversation.get(indexDragon++));
        }
    }

    public void gameLostMessage() {
        System.out.println("""
        The dragon lets out a thunderous laugh as you collapse, your strength drained,
        your will broken. "You dared to challenge me, mortal, but your efforts were
        in vain," it sneers.

        The mystical Heart-flower remains out of reach, its glow fading as the cavern
        grows darker. You have failed to save your daughter, and your tale becomes
        one of caution for those who dare to venture into the unknown.

        "Perhaps another might succeed where you have fallen," the dragon muses,
        retreating into the shadows.

        Game over. Better luck next time, brave soul.
        """);
    }

    public void gameWonMessage() {
        System.out.println("""
        
        
        The dragon roars one final time, a sound that echoes through the cavern,
        shaking the very walls. Defeated, it collapses, its fiery breath extinguished.
        As the dust settles, the mystical Heart-flower blooms before you, its petals
        shimmering with an ethereal light.

        "You have conquered your fears, your doubts, and even the ancient dragon.
        Your courage and determination have prevailed."

        You carefully pluck the Heart-flower and begin your journey back to your
        daughter, carrying the hope of her recovery with you. You are a true hero,
        King Solomon.

        Congratulations, you have won the game!
        """);
    }

    public void lastGameRules() {
        System.out.println("""
                This is the final challenge against the mighty dragon, Zarathor.
                Victory here will decide the fate of your journey and your daughter’s life.
                
                The Tik-Tak-Toe Duel:
                
                You will engage in a battle of wits by playing a round of Tik-Tak-Toe against the dragon.
                Victory here will give you the upper hand in this final test.
                
                The Dice of Fate:
                
                After each round of Tik-Tak-Toe, both you and the dragon will roll a six-sided die.
                The outcome of the dice roll will determine:
                If the winner rolls a higher number than the loser the loser will take the roll * 5 damage. else none.
                
                You must deplete the dragon’s health to 0 to claim ultimate victory and retrieve the Heart-flower.
                However, beware—if your own health falls to 0, your journey will come to a tragic end.

                """);
    }
}
