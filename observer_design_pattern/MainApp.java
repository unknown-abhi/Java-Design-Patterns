package observer_design_pattern;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Subject youtubeChannel = new YoutubeChannel();

        Observer user1 = new Subscriber("Vivek");
        Observer user2 = new Subscriber("Mohit");

        youtubeChannel.subscribe(user1);
        youtubeChannel.subscribe(user2);

        youtubeChannel.notifyChanges("New Hero Revamp");

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {

                System.out.println("Press 1 to Upload Video");
                System.out.println("Press 2 to Subscribe");
                System.out.println("Press 3 to Unsubscribe");
                System.out.println("Press 4 to Exit");

                int condition = sc.nextInt();
                sc.nextLine();

                switch (condition) {
                    case 1:
                        System.out.println("Enter Video Title : ");
                        String title = sc.nextLine();
                        youtubeChannel.notifyChanges(title);
                        break;

                    case 2:
                        System.out.println("Enter User Name : ");
                        String name = sc.nextLine();

                        youtubeChannel.subscribe(new Subscriber(name));
                        break;

                    case 3:
                        System.out.println("Enter User Name : ");
                        String name1 = sc.nextLine();

                        youtubeChannel.unSubscribe(new Subscriber(name1));
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
        }
    }
}
