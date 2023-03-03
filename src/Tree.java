public class Tree {

    private Node root;

    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            add(root, node);
        }
    }
    private void add(Node current, Node node){
        if(node.getKey().compareTo(current.getKey()) < 0){
            if(current.getLeft() == null){
                current.setLeft(node);
            }else{
                add(current.getLeft(), node);
            }
        }else if(node.getKey().compareTo(current.getKey()) > 0){
            if(current.getRight() == null){
                current.setRight(node);
            }else{
                add(current.getRight(), node);
            }
        }else{

        }
    }

    public Node getMin(){
        return getMin(root);
    }

    private Node getMin(Node current){
        if(current.getLeft() == null){
            return current;
        }
        return getMin(current.getLeft());
    }

    public Node getMax(){
        return getMax(root);
    }

    private Node getMax(Node current){
        if(current.getRight() == null){
            return current;
        }
        return getMax(current.getRight());
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node current){
        if(current == null){
            return;
        }
        inOrder(current.getLeft());
        System.out.println(current.getKey());
        inOrder(current.getRight());
    }

    public Node search(String goal){
        return search(root, goal);
    }

    private Node search(Node current, String goal){
        if(current == null){
            System.out.println("Not found");
            return null;
        }
        if(current.getKey().equals(goal)){
            return current;
        }

        if(goal.compareTo(current.getKey()) < 0){
            return search(current.getLeft(), goal);
        }else{
            return search(current.getRight(), goal);
        }

    }

    public void delete (String goal){
        delete(root, goal,null);
    }

    private void delete (Node current, String goal, Node parent){

        if (current == null) return;

        if (current.getKey().equals(goal)) {

            if (current.getLeft() == null && current.getRight() == null){

                if (parent.getLeft().equals(current)){
                    parent.setLeft(null);
                }else {
                    parent.setRight(null);
                }
            }else if (current.getRight() == null && current.getLeft() != null) {

                if (parent.getLeft().equals(current)){
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }else if (current.getRight() != null && current.getLeft() == null) {

                if (parent.getLeft().equals(current)){
                    parent.setLeft(current.getRight());
                } else {
                    parent.setRight((current.getRight()));
                }
            } else {
                Node successor = getMin(current.getRight());
                current.setKey(successor.getKey());
                delete(current.getRight(), successor.getKey(), current);
            }

        }

        else {

            if (goal.compareTo(current.getKey()) < 0) {
                delete(current.getLeft(), goal, current);
            } else {
                delete(current.getRight(), goal, current);
            }
        }
    }
}
