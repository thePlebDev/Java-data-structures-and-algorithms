package JavaDsa.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    //CREATE THE BREADTH FIRST TRAVERSAL


    private class Node{
        private int element;
        private Node leftChild;
        private Node rightChild;

        public Node(int element, Node leftChild,Node rightChild){
            this.element = element;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
        //SETTERS
        public void setElement(int element){
            this.element = element;
        }
        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
        //GETTERS

        public int getElement() {
            return element;
        }
        public Node getLeftChild() {
            return leftChild;
        }
        public Node getRightChild() {
            return rightChild;
        }
    }

    /**************************END OF NODE CLASS******************************************/
    private Node root = null;
    int size = 0;


    public void insert(int element){
        Node newNode = new Node(element,null,null);
        if(this.root == null){
            this.root = newNode;
        }else{
            insertNode(this.root,newNode);
        }
        size ++;
    }

    private void insertNode(Node node, Node newNode){
        if(node.getElement() > newNode.getElement()){
            if(node.getLeftChild() == null){
                node.setLeftChild(newNode);
            }else{
                insertNode(node.getLeftChild(),newNode);
            }
        }else{
            if(node.getRightChild() == null){
                node.setRightChild(newNode);
            }else{
                insertNode(node.getRightChild(),newNode);
            }
        }
    }

    public void inOrderTraverse(){
        if(this.root != null){
            inOrderTraverseNode(this.root);
        }
    }

    private void inOrderTraverseNode(Node node){
        if(node != null){
            inOrderTraverseNode(node.getLeftChild());
            System.out.println(node.getElement());
            inOrderTraverseNode(node.getRightChild());
        }
    }

    public Boolean breadthFirstSearch(int target){

        if(this.root != null){
            Queue<Node> queue = new LinkedList<>();
            queue.add(this.root);
            while(!queue.isEmpty()){
                Node node = queue.remove();

                if(node.getElement() == target){
                    return true;
                }
                
                for(Node n:children(node)){

                    queue.add(n);
                }
            }
        }


        return false;
    }



    private List<Node> children(Node node){
        List<Node> list = new ArrayList<>(2);
        if(node.getLeftChild() != null){
            list.add(node.getLeftChild());
        }
        if(node.getRightChild() != null){
            list.add(node.getRightChild());
        }

        return list;
    }




















}
