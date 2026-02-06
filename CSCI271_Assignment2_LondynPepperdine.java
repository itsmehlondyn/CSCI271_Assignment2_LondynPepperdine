
public class CSCI271_Assignment2_LondynPepperdine {

    public static void main(String[] args) {

        Fraction a = new Fraction(16);
        Fraction b = new Fraction(3, 5).add(new Fraction(7));
        Fraction c = new Fraction(6, 7);
        Fraction results = c.multiply(a.divide(b));
        System.out.println(results);

        Fraction d = new Fraction(9, -3).add(new Fraction(2, 0));
        System.out.println(d);

        Fraction e = new Fraction(5, 1).add(new Fraction(4, 1));
        System.out.println(e);

        Fraction f = new Fraction(9, -3).add(new Fraction(2, 9));
        System.out.println(f);

        Fraction g = new Fraction(0, 0).negate();
        System.out.println(g);

        Fraction h = new Fraction(1, 5).pow(-2);
        System.out.println(h);

        Fraction i = new Fraction(6, 8);
        System.out.println(i);

        Fraction j = new Fraction(6, -8);
        System.out.println(j);

        Fraction k = new Fraction(-6, 8);
        System.out.println(k);

        Fraction l = new Fraction(-6, -8);
        System.out.println(l);

        Fraction m = new Fraction(0, 7);
        System.out.println(m);

        Fraction n = new Fraction(0, -2);
        System.out.println(n);

        Fraction o = new Fraction(-1, 0);
        System.out.println(o);

        Fraction p = new Fraction(0, 0);
        System.out.println(p);

        Fraction q = new Fraction(5, 0);
        System.out.println(q);

        Fraction r = new Fraction(5, 7).multiply(new Fraction(0, 8));
        System.out.println(r);

        Fraction s = new Fraction(2, 3).divide(new Fraction(-4, 5));
        System.out.println(s);

        Fraction t = new Fraction(3, 5).negate();
        System.out.println(t);

        Fraction u = new Fraction(2, 3).pow(0);
        System.out.println(u);

        Fraction v = new Fraction(-2, 3).pow(3);
        System.out.println(v);

        Fraction w = new Fraction(1, 2).add(new Fraction(1, 3)).multiply(new Fraction(3, 4)).subtract(new Fraction(1, 8));
        System.out.println(w);

        Fraction x = new Fraction(0, 5);
        System.out.println(x);

        Fraction y = new Fraction(22, 22).divide(new Fraction(2));
        System.out.println(y);

        Fraction z = new Fraction(100, 100);
        System.out.println(z);

    }
    
}
