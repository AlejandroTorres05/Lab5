import java.util.Scanner;
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Tree tree = new Tree();
    public static void main(String[] args) {
        System.out.println("Please type the ordered array");
        String names = sc.nextLine();
        String[] array = names.split(" ");
        organizeArray(array);
        tree.reverse();
    }

    public static void organizeArray(String [] names){

        int mid = (names.length-1)/2;
        int left = 0;
        int right = 0;
        tree.add(new Node(names[mid]));

        for (int i = 0; i<mid; i++){
            left++;
        }

        if ((left%2) == 0){
            tree.add(new Node(names[(left/2)-1]));
        }else {
            tree.add(new Node(names[left/2]));
        }

        for (int i = mid+1; i<names.length; i++){
            right++;
        }
        if ((right%2) == 0){
            tree.add(new Node(names[(right/2)+mid]));
        }else {
            tree.add(new Node(names[(right/2)+mid+1]));
        }

        for (int i  = 0; i<names.length;i++){
            tree.add(new Node(names[i]));
        }

    }


}