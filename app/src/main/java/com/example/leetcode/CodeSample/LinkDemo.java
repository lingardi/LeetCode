package com.example.leetcode.CodeSample;

public class LinkDemo {
    interface ILink<E>{
        void add(E e);
        int size();
        boolean isEmpty();
        Object[] toArray();
        E get(int index);
        void set(int index, E data);
        boolean contains(E data);
        void remove(E data);
        void clean();
    }

    class LinkImp<E> implements ILink<E>{
        private int count;
        private int foot = 0;
        private Object[] returnData;
        class Node<E>{
            private E e;
            private Node next;

            public Node(E e) {
                this.e = e;
            }
            //第一次调用由root.addNode()
//            第二次调用由root.next.addNode()
            public void addNode(Node newNode){
                if (this.next == null){
                    this.next = newNode;
                }else {
                    this.next.addNode(newNode);
                }
            }

            private void toArrayNode() {
                LinkImp.this.returnData[foot++] = this.e;
                if (this.next != null){
                    this.next.toArrayNode();
                }
            }

            public E getNode(int index){
                if (LinkImp.this.foot ++ == index){
                    return this.e;
                }else {
                    return (E) this.next.getNode(index);
                }
            }

            public void setNode(int index, E data) {
                if (LinkImp.this.foot ++ == index){
                    this.e = data;
                }else {
                    this.next.setNode(index, data);
                }
            }

            public boolean containsNode(E data){
                if (this.e.equals(data)){
                    return true;
                }
                if (this.next == null){
                    return false;
                }else {
                    return this.next.containsNode(data);
                }
            }

            public void removeNode(Node previous, E data){
                if (data.equals(this.e)){
                    previous.next = this.next;
                }else{
                    if (this.next != null){
                        this.next.removeNode(this, data);
                    }
                }
            }
        }

        private Node root;
        @Override
        public void add(E e) {
            if (e == null){
                return;
            }
            Node newNode = new Node(e);
            if (this.root == null){
                this.root = newNode;
            }else {
                this.root.addNode(newNode);
            }
            this.count ++;
        }

        @Override
        public int size() {
            return this.count;
        }

        @Override
        public boolean isEmpty() {
            return this.root == null;
        }

        @Override
        public Object[] toArray() {
            if (this.root == null){
                return null;
            }
            this.foot = 0;
            this.returnData = new Object[this.count];
            //利用Node类进行递归数据获取
            this.root.toArrayNode();
            return this.returnData;
        }

        @Override
        public E get(int index) {
            if (index > this.count){
                return null;
            }
            this.foot = 0;
            return (E) this.root.getNode(index);
        }

        @Override
        public void set(int index, E data) {
            if (index > this.count){
                return;
            }
            this.foot = 0;
            this.root.setNode(index, data);
        }

        @Override
        public boolean contains(E data) {
            if (data == null){
                return false;
            }
            return this.root.containsNode(data);
        }

        @Override
        public void remove(E data) {
            if (this.contains(data)){
                if (this.root.e == data){
                    this.root = this.root.next;
                }else {//交由Node类负责删除
                    this.root.next.removeNode(this.root, data);
                }
                this.count --;
            }
        }

        @Override
        public void clean() {
            this.root = null;
            this.count = 0;
        }
    }

//    public class LinkDemo{
//        public static void main(String[] args){
//            LinkImp<String> s1 = new LinkImp<String>();
//            s1.add("1");
//            s1.add("2");
//        }
//    }
}
