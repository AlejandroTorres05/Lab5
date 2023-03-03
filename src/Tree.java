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

    public void reverse(){
        reverse(root);
    }

    private void reverse(Node current){
        if(current == null){
            return;
        }
        reverse(current.getRight());
        System.out.print(current.getKey()+" ");
        reverse(current.getLeft());
    }

}
