import java.util.LinkedList;
import java.util.ListIterator;

public class Itinerary {
    private LinkedList<Places> itinerary;
    private ListIterator<Places> itineraryIterator;
    private Places currentPlace;

    public Itinerary(Places startPoint) {
        itinerary = new LinkedList<>();
        itinerary.add(startPoint);
        currentPlace = startPoint;
        itineraryIterator = itinerary.listIterator(1);
    }

    public void addPlace(Places place) {
        if (!itinerary.contains(place)) {
            itinerary.add(place);
        } else {
            System.out.println("This place is already on the Itinerary");
        }
    }

    public void nextPlace() {
        if (itineraryIterator.hasNext()){
            Places nextPlace = itinerary.get(itineraryIterator.nextIndex());
            double travelledDistance = getDistance(nextPlace);
            System.out.printf("Your current place is %s and you are moving forward in your itinerary to %s%n", currentPlace.getName(), nextPlace.getName());
            System.out.printf("Distance to the next place: %.2f%n", travelledDistance);
            currentPlace = nextPlace;
        } else if (itinerary.size() == 1){
            System.out.println("You have nowhere to go yet!");
        } else {
            System.out.println("""
                    You have reached the end of the line
                    Now you can only move backwards
                    """);
        }
    }

    public void previousPlace() {
        if (itineraryIterator.hasPrevious()) {
            Places previousPlace = itinerary.get(itineraryIterator.previousIndex());
            double travelledDistance = getDistance(previousPlace);
            System.out.printf("Your current place is %s and you are moving backwards in your itinerary to %s%n", currentPlace.getName(), previousPlace.getName());
            System.out.printf("Distance to the next place: %.2f%n", travelledDistance);
            currentPlace = previousPlace;
        } else {
            System.out.println("""
                    You have reached the end of the line
                    Now you can only move forward
                    """);
        }
    }

    public double getDistance(Places nextPlace) {
        double currentPlaceDistance = currentPlace.getDistanceFromStart();
        double nextPlaceDistance = nextPlace.getDistanceFromStart();

        return nextPlaceDistance > currentPlaceDistance ? nextPlaceDistance - currentPlaceDistance : currentPlaceDistance - nextPlaceDistance;
    }

    public LinkedList<Places> getItinerary() {
        return itinerary;
    }
}
