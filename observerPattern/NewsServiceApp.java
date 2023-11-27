package observerPattern;
import java.util.*;
public class NewsServiceApp {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    NewsAgency newsAgency = new NewsAgency();
    Random random = new Random();

        while (true) {
        // Created Subscribers
        Subscriber Pedro = new SubscriberUpdates("Mr Pedro");
        Subscriber Juan = new SubscriberUpdates("Mr Juan");
        Subscriber Clara = new SubscriberUpdates("Ms Clara");
        List<Subscriber> subscribersList = new ArrayList<>(Arrays.asList(Pedro,Juan,Clara));

        // Automatically subscribe client to news
        for (Subscriber subscriber : subscribersList) {
            subscriber.subscribeNews(newsAgency);
        }

        // News Service Printing
        System.out.println("-- Real-Time News Subscription Service --");

        // Client's preference container
        List<String> preferenceList = new ArrayList<>(List.of(""));

        // Breaking News for default category
        System.out.println();
        newsAgency.printNews("Unemployment hits record low in the Philippines. [Economy]");
        System.out.println();

        // Input strings
        String categoryInput;
        String subscriberInput;

        // For RNG
        int min = 1;
        int max = 3;
        int randomNum = random.nextInt(max - min + 1) + min;

        for (Subscriber subscriber : subscribersList) {
            while (true) {
                System.out.print(subscriber.clientName() + ", do you want to change your category? [Yes] or [No]: ");
                categoryInput = sc.nextLine().toLowerCase();

                if (categoryInput.equals("yes")) {
                    System.out.println("Category List: ");
                    System.out.println("Economy");
                    System.out.println("Politics");
                    System.out.println("Weather");
                    System.out.print("Choose a Category: ");
                    preferenceList = Arrays.asList(sc.nextLine());
                    subscriber.clientPreference(preferenceList);
                    System.out.println();
                    break;
                } else if (categoryInput.equals("no")) {
                    System.out.println(subscriber.clientName() + "'s category is at default.");
                    System.out.println();
                    break;
                } else {
                    System.out.println("Please input Yes or No only!");
                }
                System.out.println();
            }

            // It will randomly choose news below
            if (randomNum == 1) {
                newsAgency.printNews("Unemployment hits record low in the Philippines. [Economy]");
                System.out.println();
            } else if (randomNum == 2) {
                newsAgency.printNews("US warship shoots down attack drones over the Red Sea [Politics]");
                System.out.println();
            } else if (randomNum == 3) {
                newsAgency.printNews("Deadly landslide strikes Alaskan island community after rain and windstorm [Weather]");
                System.out.println();
            }
        }

        System.out.println("====================================JUST IN!====================================");
        newsAgency.printNews("US warship shoots down attack drones over the Red Sea [Politics]");
        System.out.println();

        for (Subscriber subscriber : subscribersList) {
            while (true) {
                System.out.println(subscriber.clientName() + ", do you want to subscribe for news update? [Yes] or [No]: ");
                subscriberInput = sc.nextLine().toLowerCase();

                if (subscriberInput.equals("yes")) {
                    break;
                } else if (subscriberInput.equals("no")) {
                    subscriber.unsubscribeNews();
                    break;
                } else {
                    System.out.println("Please input Yes or No only!");
                }
                System.out.println();
            }
        }

        System.out.println("====================================JUST IN!====================================");
        newsAgency.printNews("Deadly landslide strikes Alaskan island community after rain and windstorm [Weather]");
        System.out.println();

        System.out.print("Do you want to exit application? [Yes] or [No]: ");
        String choice = sc.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            System.out.println("Exiting program...");
            System.exit(0);
        }
        }
    }
}