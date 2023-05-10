import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                You are starting a new Itinerary.
                Add you place of origin information:
                """);
        System.out.println("Place name: ");
        Places origin = new Places(scanner.nextLine());
        Itinerary itinerary = new Itinerary(origin);
        String userSelection = "";
        do {
            System.out.println("""
                    
                    Available actions (Select word or letter):
                    (A)dd Place
                    (F)orward
                    (B)ackawrd
                    (L)ist Places
                    (M)enu
                    (Q)uit
                    
                    """);
            userSelection = scanner.nextLine();

            switch (userSelection) {
                case "A" -> {
                    System.out.println("Adding cities to itinerary.");
                    System.out.println("City name: ");
                    String name = scanner.nextLine();
                    System.out.println("City distance from the origin: ");
                    double distance = Double.parseDouble(scanner.nextLine());
                    itinerary.addPlace(new Places(name, distance));
                }
                case "F" -> itinerary.nextPlace();
                case "B" -> itinerary.previousPlace();
                case "L" -> {
                    for (Places place : itinerary.getItinerary()) {
                        System.out.println(place.getName() + " ----> " + place.getDistanceFromStart());
                    }
                }
                case "M" -> System.out.println("Loading Menu of Options");
                default -> System.out.println("Select a valid option");
            }

        } while (!userSelection.contains("Q"));
    }
}
