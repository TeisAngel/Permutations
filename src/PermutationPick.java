import java.util.ArrayList;

public class PermutationPick {

    public static void main(String[] args) {
        //args[0] is input
        ArrayList<String> permutation = makePermutation(args[0]);
        System.out.println("List of all permutations " + permutation.toString());
        System.out.println("Total amount of permutations is " + args[0].length() + "!");
    }

    private static ArrayList<String> makePermutation(String input) {
        ArrayList<String> collection1 = new ArrayList<>();
        ArrayList<String> collection2 = new ArrayList<>();

        collection1.add(input.charAt(0) + "");

        for (int i = 1; i < input.length(); i++) {
            collection2 = putCharInEveryString(input.charAt(i), collection1);
            collection1 = collection2;
        }

        return collection2;
    }

    private static ArrayList<String> putCharInEveryString(char ch, ArrayList<String> preCollection) {
        ArrayList<String> collection = new ArrayList<>();
        ArrayList<String> temp;

        for (int i = 0; i < preCollection.size(); i++) {

            temp = putChar(ch, preCollection.get(i));

            for (int j = 0; j < temp.size(); j++) {
                collection.add(temp.get(j));
            }
        }

        return collection;
    }

    private static ArrayList<String> putChar(char ch, String string) {
        ArrayList<String> collection = new ArrayList<>();

        for (int i = 0; i < string.length() + 1; i++) {
            collection.add(string.substring(0, i) + ch + string.substring(i));
        }

        return collection;
    }
}
