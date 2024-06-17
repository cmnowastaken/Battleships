import java.util.Scanner;

public class Instructions {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int decision;

        String multiLineStr = """
                                   ___  ___ ______________   __________ _________  ____
                                  / _ )/ _ /_  __/_  __/ /  / __/ __/ // /  _/ _ \\/ __/
                                 / _  / __ |/ /   / / / /__/ _/_\\ \\/ _  // // ___/\\ \\ \s
                                /____/_/ |_/_/   /_/ /____/___/___/_//_/___/_/  /___/ \s
                                                                      \s
                                
                                There will be 5 battleships set out on the board. Their shapes are as follows.
                              
                                𝖷 𝖷 𝖷 𝖷 𝖷
                                𝖷 𝖷 𝖷 𝖷
                                𝖷 𝖷 𝖷
                                𝖷 𝖷 𝖷
                                𝖷 𝖷
                              
                                Your job is to destroy these ships.
                                
                                To fire a missile, simply declare where you would like to shoot.
                                
                                For example, if you were to type B6 and press enter, a missile would be fired as follows:
                              
                                   1  2  3  4  5  6  7  8  9  10
                                A  •  •  •  •  •  •  •  •  •  •
                                B  •  •  •  •  •  •  •  •  •  •
                                C  •  •  •  •  •  •  •  •  •  •
                                D  •  •  •  •  •  •  •  •  •  •
                                E  •  •  •  •  •  •  •  •  •  •
                                F  •  •  •  •  •  •  •  •  •  •
                                G  •  0  •  •  •  •  •  •  •  •
                                H  •  •  •  •  •  •  •  •  •  •
                                I  •  •  •  •  •  •  •  •  •  •
                                J  •  •  •  •  •  •  •  •  •  •
                                
                                If there were to be a ship there, the board would display as follows:
                                
                                   1  2  3  4  5  6  7  8  9  10
                                A  •  •  •  •  •  •  •  •  •  •
                                B  •  •  •  •  •  •  •  •  •  •
                                C  •  •  •  •  •  •  •  •  •  •
                                D  •  •  •  •  •  •  •  •  •  •
                                E  •  •  •  •  •  •  •  •  •  •
                                F  •  •  •  •  •  •  •  •  •  •
                                G  •  𝖷  •  •  •  •  •  •  •  •
                                H  •  •  •  •  •  •  •  •  •  •
                                I  •  •  •  •  •  •  •  •  •  •
                                J  •  •  •  •  •  •  •  •  •  •
                                
                                Please note that the ships can be placed vertically as well, for example:
                                
                                𝖷
                                𝖷
                                𝖷
                                
                                As opposed to:
                                
                                𝖷 𝖷 𝖷
                                
                                Ships will never be placed on top of each other, but they can be placed next to each other.
                                
                                Does that make sense?
                                
                                1) Yes, let's play!
                                2) Yes, but that sounds boring and I don't want to play
                                3) No, please explain again
                                4) No, I don't want to play anyway
                              """;
            System.out.println(multiLineStr);
        decision = scanner.nextInt();

        if (decision == 1) {
            System.out.println('\u000c');
        } else if (decision == 2) {
            System.exit(0);
        } else if (decision == 3) {
            System.out.println('\u000c');
        } else if (decision == 4) {
            System.exit(0);
        } else {
            System.out.println("Invalid input, please enter an integer between 1 and 4.");
        }
    }
}
