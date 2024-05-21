public class Instructions {
    public static void main(String[] args) {
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
                              
                                   A  B  C  D  E  F  G  H  I  J
                                0  •  •  •  •  •  •  •  •  •  •
                                1  •  •  •  •  •  •  •  •  •  •
                                2  •  •  •  •  •  •  •  •  •  •
                                3  •  •  •  •  •  •  •  •  •  •
                                4  •  •  •  •  •  •  •  •  •  •
                                5  •  •  •  •  •  •  •  •  •  •
                                6  •  𝖮  •  •  •  •  •  •  •  •
                                7  •  •  •  •  •  •  •  •  •  •
                                8  •  •  •  •  •  •  •  •  •  •
                                9  •  •  •  •  •  •  •  •  •  •
                                
                                If there were to be a ship there, the board would display as follows:
                                
                                   A  B  C  D  E  F  G  H  I  J
                                0  •  •  •  •  •  •  •  •  •  •
                                1  •  •  •  •  •  •  •  •  •  •
                                2  •  •  •  •  •  •  •  •  •  •
                                3  •  •  •  •  •  •  •  •  •  •
                                4  •  •  •  •  •  •  •  •  •  •
                                5  •  •  •  •  •  •  •  •  •  •
                                6  •  𝖷  •  •  •  •  •  •  •  •
                                7  •  •  •  •  •  •  •  •  •  •
                                8  •  •  •  •  •  •  •  •  •  •
                                9  •  •  •  •  •  •  •  •  •  •
                                
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
    }
}
