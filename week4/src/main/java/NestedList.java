import java.util.Scanner;

public class NestedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String startUL = "<ul>";
        String endUL = "</ul>;"
        System.out.print("Enter tag: ");
        String tag = input.next().toLowerCase();
        if (tag.startsWith("<ul>") && tag.endsWith("</ul>") && tag.substring(startUL.length()+1, tag.indexOf(endUL)).contains("<ul>")) {
            System.out.println("Nested list");
        } else {
            System.out.println("Not nested list");
        }
    }
}
