
/**
 * BusStop demonstrates augmented operators to adjust the passenger count on a
 * bus route.
 * There is an error in the code.
 * 
 * @author First Last
 */
public class BusRoute {

    public static void main(String[] args) {

        int passengers = 8; // 8 people get on at stop 1
        int stop = 1;
        System.out.println("Departing stop #" + stop + " with " + passengers + " passengers");

        // 2nd stop (addition assignment operator)
        stop++;
        passengers = +6; // 6 passengers board
        System.out.println("Departing stop #" + stop + " with " + passengers + " passengers");

        // 3rd stop (subtraction assignment operator)
        stop++;
        passengers = -2; // 2 passengers board
        System.out.println("Departing stop #" + stop + " with " + passengers + " passengers");

        // TODO: 4th stop, half the passengers depart (division assignment operator)

        // TODO: 5th stop, the number of passengers triples (multiplication assignment
        // operator)

    }

}
