package BaumKapitel;

import BaumKapitel.baum.BinaryTree;

public class Morsebaum {
    private final BinaryTree<String> root;

    public Morsebaum() {

        BinaryTree<String> h = new BinaryTree<>("H");
        BinaryTree<String> v = new BinaryTree<>("V");
        BinaryTree<String> f = new BinaryTree<>("F");
        BinaryTree<String> l = new BinaryTree<>("L");
        BinaryTree<String> p = new BinaryTree<>("P");
        BinaryTree<String> j = new BinaryTree<>("J");
        BinaryTree<String> b = new BinaryTree<>("B");
        BinaryTree<String> x = new BinaryTree<>("X");
        BinaryTree<String> c = new BinaryTree<>("C");
        BinaryTree<String> y = new BinaryTree<>("Y");
        BinaryTree<String> q = new BinaryTree<>("Q");
        BinaryTree<String> z = new BinaryTree<>("Z");

        // 3. Ebene
        BinaryTree<String> s = new BinaryTree<>("S", h, v);
        BinaryTree<String> u = new BinaryTree<>("U", f, new BinaryTree<>());
        BinaryTree<String> r = new BinaryTree<>("R", l, new BinaryTree<>());
        BinaryTree<String> w = new BinaryTree<>("W", p, j);
        BinaryTree<String> d = new BinaryTree<>("D", b, x);
        BinaryTree<String> k = new BinaryTree<>("K", c, y);
        BinaryTree<String> g = new BinaryTree<>("G", q, z);
        BinaryTree<String> o = new BinaryTree<>("O", new BinaryTree<>(), new BinaryTree<>());

        // 2. Ebene
        BinaryTree<String> i = new BinaryTree<>("I", s, u);
        BinaryTree<String> a = new BinaryTree<>("A", r, w);
        BinaryTree<String> n = new BinaryTree<>("N", d, k);
        BinaryTree<String> m = new BinaryTree<>("M", g, o);

        // 1. Ebene
        BinaryTree<String> e = new BinaryTree<>("E", i, a);
        BinaryTree<String> t = new BinaryTree<>("T", n, m);

        // Wurzel
        root = new BinaryTree<>("/", e, t);
    }
    public BinaryTree<String> getRoot(){
        return root;
    }

    private int countLayers(BinaryTree<String> pBaum) {
        if (pBaum == null) {
            return -1;
        } else {
            int depthLeft = countLayers(pBaum.getLeftTree());
            int depthRight = countLayers(pBaum.getRightTree());
            return (depthLeft > depthRight ? depthLeft : depthRight) + 1;
            //return Math.max(depthLeft, depthRight)) +1;
        }
    }

    public static void main(String[] args) {
        Morsebaum morsebaum = new Morsebaum();
        BinaryTree<String> root = morsebaum.getRoot();

        int layers = morsebaum.countLayers(root);
        System.out.println("Ebenen: " + layers);
    }


}
