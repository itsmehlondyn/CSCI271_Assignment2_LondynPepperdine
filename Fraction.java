
/** ***********************************************************************
 * Project 2 for CSCI 271-001 Spring 2026
 *
 * Author: Londyn Pepperdine
 * OS: Windows
 * Compiler: javac 25.0.1
 * Date: Feb 6, 2025
 *
 * Purpose:
 * This program does exact arithmetic calculations of fraction. It can add,
 * subtract, multiply, divide, negate, and calculate exponents. This code
 * contains a list of test cases showing those calculations, outputting in
 * reduced form.
 ************************************************************************ */
/** ***********************************************************************
 * I declare and confirm the following:
 * - I have not discussed this program code with anyone other than my
 * instructor or the teaching assistants assigned to this course.
 * - I have not used programming code obtained from someone else,
 * or any unauthorised sources, including the Internet, either
 * modified or unmodified.
 * - If any source code or documentation used in my program was
 * obtained from other sources, like a text book or course notes,
 * I have clearly indicated that with a proper citation in the
 * comments of my program.
 * - I have not designed this program in such a way as to defeat or
 * interfere with the normal operation of the supplied grading code.
 *
 * Londyn Pepperdine
 *
 ************************************************************************ */
public class Fraction {

    private long numerator; //Stores the numerator
    private long denominator; //Stores the denominator

    /**
     * *************************** Fraction ******************************
     * Description: Constructs a Fraction given two inputs, numerator and
     * denominator. The fraction is also simplified.
     *
     * Parameters: num - input, numerator value denom - input, denominator value
     *
     * Pre: None
     *
     * Post: Fraction is initialized and reduced; handles special cases for 0.
     *
     * Returns: Nothing
     *
     * Called by: main for test cases Fraction methods that create new Fraction
     * objects
     *
     * Calls: gcd to reduce the fraction if needed
    ********************************************************************
     */
    public Fraction(long num, long denom) { //constructor
        this.numerator = num;
        this.denominator = denom;

        if (denom == 0) {
            numerator = Long.signum(num);
            denominator = 0;
        } else if (num == 0) {
            denominator = 1;
        } else {
            long sign = (Long.signum(num)) * (Long.signum(denom)); //TA :D
            numerator = Math.abs(num);
            denominator = Math.abs(denom);

            long g = gcd(numerator, denominator);
            numerator = (numerator / g) * sign;
            denominator = denominator / g;
        }
    }

    /**
     * *************************** Fraction ******************************
     * Description: Constructs a Fraction when only one input
     *
     * Parameters: num - input, numerator
     *
     * Pre: None
     *
     * Post: Fraction is set to num/1
     *
     * Returns: None
     *
     * Called by: main for test cases
     *
     * Calls: None
    ********************************************************************
     */
    public Fraction(long num) {
        numerator = num;
        denominator = 1;
    }

    /**
     * *************************** add ***********************************
     * Description: Adds this fraction to another fraction
     *
     * Parameters: inFraction - input, fraction to add
     *
     * Pre: inFraction must not be null
     *
     * Post: A new Fraction representing the sum is returned
     *
     * Returns: Fraction - sum of the two fractions
     *
     * Called by: main for test cases
     *
     * Calls: Fraction(long, long)
    ********************************************************************
     */
    public Fraction add(Fraction inFraction) {
        Fraction addFrac;

        long top = (this.numerator * inFraction.denominator) + (inFraction.numerator * this.denominator);
        long bottom = (this.denominator * inFraction.denominator);
        addFrac = new Fraction(top, bottom);

        return addFrac;
    }

    /**
     * *************************** subtract ******************************
     * Description: Subtracts another fraction from this fraction.
     *
     * Parameters: inFraction - input, fraction to subtract
     *
     * Pre: inFraction must not be null
     *
     * Post: A new Fraction representing the difference is returned
     *
     * Returns: Fraction - difference of the two fractions
     *
     * Called by: main for test cases
     *
     * Calls: Fraction(long, long)
    ********************************************************************
     */
    public Fraction subtract(Fraction inFraction) {
        Fraction subFrac;

        long top = (this.numerator * inFraction.denominator) - (inFraction.numerator * this.denominator);
        long bottom = (this.denominator * inFraction.denominator);
        subFrac = new Fraction(top, bottom);
        return subFrac;
    }

    /**
     * *************************** multiply ******************************
     * Description: Multiplies this fraction by another fraction.
     *
     * Parameters: inFraction - input, fraction to multiply by
     *
     * Pre: inFraction must not be null
     *
     * Post: A new Fraction representing the product is returned
     *
     * Returns: Fraction - product of the two fractions
     *
     * Called by: main for test cases pow
     *
     * Calls: Fraction(long, long)
    ********************************************************************
     */
    public Fraction multiply(Fraction inFraction) {

        long top = (this.numerator * inFraction.numerator);
        long bottom = (this.denominator * inFraction.denominator);

        return new Fraction(top, bottom);
    }

    /**
     * *************************** divide ********************************
     * Description: Divides this fraction by another fraction.
     *
     * Parameters: inFraction - input, divisor fraction
     *
     * Pre: inFraction must not be null
     *
     * Post: A new Fraction representing the quotient is returned
     *
     * Returns: Fraction - quotient of the two fractions
     *
     * Called by: main for test cases
     *
     * Calls: Fraction(long, long)
    ********************************************************************
     */
    public Fraction divide(Fraction inFraction) {
        long top = this.numerator * inFraction.denominator;
        long bottom = this.denominator * inFraction.numerator;
        return new Fraction(top, bottom);

    }

    /**
     * *************************** toString ******************************
     * Description: Converts the fraction to a string.
     *
     * Parameters: None
     *
     * Pre: None
     *
     * Post: A string is returned
     *
     * Returns: String
     *
     * Called by: main for test cases
     *
     * Calls: None
    ********************************************************************
     */
    @Override
    public String toString() {
        if (denominator == 1) {
            //return Long.toString(numerator);
            return ("" + numerator);
        } else if (numerator == 0 && denominator == 0) {
            return "NaN";
            //NaN
        } else if (numerator < 0 && denominator == 0) {
            return "Negative infinity";
            //neg infinity
        } else if (numerator > 0 && denominator == 0) {
            return "Positive infinity";
            //pos infinity
        } else {
            return (numerator + "/" + denominator);
        }
    }

    /**
     * *************************** gcd ***********************************
     * Description: Computes the greatest common divisor using the Euclidean
     * algorithm. Pseudo code given in assignment
     *
     * Parameters: a - input, first value b - input, second value
     *
     * Pre: None
     *
     * Post: GCD of a and b is returned
     *
     * Returns: long - greatest common divisor
     *
     * Called by: Fraction(long num, long denom)
     *
     * Calls: None
    ********************************************************************
     */
    public static long gcd(long a, long b) {
        if (a < 0) {
            a = -a;
        }
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        if (a == 0) {
            a = 1;
        }
        return a;
    }

    /**
     * *************************** negate ********************************
     * Description: Negates the value of this fraction.
     *
     * Parameters: None
     *
     * Pre: None
     *
     * Post: A new Fraction with opposite sign is returned
     *
     * Returns: Fraction - negated fraction
     *
     * Called by: main for test cases
     *
     * Calls: Fraction(long, long)
    ********************************************************************
     */
    public Fraction negate() {
        return new Fraction(numerator * -1, denominator);
    }

    /**
     * *************************** pow ***********************************
     * Description: Raises this fraction to an integer power.
     *
     * Parameters: n - input, exponent value
     *
     * Pre: None
     *
     * Post: A new Fraction representing this fraction raised to n is returned
     *
     * Returns: Fraction - result of exponentiation
     *
     * Called by: main for test cases
     *
     * Calls: multiply Fraction(long, long)
    ********************************************************************
     */
    public Fraction pow(int n) {

        Fraction base = new Fraction(numerator, denominator);

        if (n == 0) {
            return new Fraction(1, 1);
        } else if (n < 0) {
            base = new Fraction(this.denominator, this.numerator);
            n = -n;
        }

        Fraction result = new Fraction(1, 1);

        //Multiply base n times
        for (int i = 0; i < n; i++) {
            result = result.multiply(base);

        }
        return result;

    }

}
