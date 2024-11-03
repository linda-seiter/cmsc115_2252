
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
        System.out.println("Departing stop #" + stop + " with " + passengers + " passengers\n");

        // TODO: Fix Error
        // 2nd stop (addition assignment operator)
        stop++;
        passengers = +6; // 6 passengers board the bus
        System.out.println("6 get on at stop #" + stop);
        System.out.println(passengers + " passengers on the bus\n");

        // TODO: Fix Error
        // 3rd stop (subtraction assignment operator)
        stop++;
        passengers = -2; // 2 passengers get off the bus
        System.out.println("2 get off at stop #" + stop);
        System.out.println(passengers + " passengers on the bus\n");

        // TODO: 4th stop, half the passengers get off the bus (division assignment
        // operator)

        // TODO: 5th stop, the number of passengers on the bus triples (multiplication
        // assignment operator)

    }

}
