/**
 * Simple class representation of complex numbers.
 */
class Complex {
    double real;
    double imag;

    Complex() {
        real = 0.0;
        imag = 0.0;
    }

    Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    static Complex add(Complex num1, Complex num2) {
        Complex newNum = new Complex();
        newNum.real = num1.real + num2.real;
        newNum.imag = num1.imag + num2.imag;
        return newNum;
    }
} 