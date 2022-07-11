public class RingAnnouncer {
    public static void main(String[] args) {
        String[] records = {"WIN", "WIN", "WIN", "LOSS", "WIN", "WIN", "LOSS"};

        /** Task 1 
         * 
         *   Using a for loop:
         *       count Java's wins and store the result in a variable: wins. 
         *       count Java's losses and store the result in a variable: losses.
         *
         * 
         * 
         */
        int wins = 0;
        int losses = 0;


        for (String record: records ) {
            if( record == "WIN")
                wins++;
            else
                losses++;
        }

        /** Task 2
         * Print:
         *     • \nWith a professional record of <wins> Wins and <losses> losses. 
         *     • He is the pride of oracle: Java Fury!
         *
         * 
         */

        System.out.println("\nWith a professional record of "+wins+" Wins and "+losses+" losses.");
        System.out.println("He is the pride of oracle: Java Fury!");
    }
}
