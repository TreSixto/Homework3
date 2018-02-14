/* Complex  Class
     * Trevon Alvarado
     * CSC-112  Intermediate Java
     * tsalvarado0001@student.stcc.edu
     * 02/12/18
     */

public class Complex {

	private double real;
	private double imag;

	public double getRealNum() {
		return real;
	}

	public double getImagNum() {
		return imag;
	}

	public void setRealNum(double real) {
		this.real = real;
	}

	public void setImagNum(double imag) {
		this.imag = imag;
	}

	public Complex(double real, double imag) {

		setImagNum(imag);
		setRealNum(real);
	}

	public Complex add(Complex secnum) {
		double realNum = this.getRealNum() + secnum.getRealNum();
		double imagNum = this.getImagNum() + secnum.getImagNum();

		return new Complex(realNum, imagNum);
	}

	public Complex subtract(Complex secnum) {

		return this.add(new Complex(-secnum.getRealNum(), -secnum.getImagNum()));

	}

	public Complex multiply(Complex secnum) {

		double realNumber = (this.getRealNum() * secnum.getRealNum()) - (this.getImagNum() * secnum.getImagNum());

		double imagNumber = (this.getRealNum() * secnum.getImagNum()) + (this.getImagNum() * secnum.getRealNum());

		return new Complex(realNumber, imagNumber);

	}

	public Complex divide(Complex secnum) {

		double realNumber = (this.getRealNum() * secnum.getRealNum() + this.getImagNum() * secnum.getImagNum())
				/ (secnum.getRealNum() * secnum.getRealNum() + secnum.getImagNum() * secnum.getImagNum());

		double imagNumber = (this.getImagNum() * secnum.getRealNum() - this.getRealNum() * secnum.getImagNum())
				/ (secnum.getRealNum() * secnum.getRealNum() + secnum.getImagNum() * secnum.getImagNum());

		return new Complex(realNumber, imagNumber);
	}

	public double abs() {

		return Math.sqrt(this.getRealNum() * this.getRealNum() + this.getImagNum() * this.getImagNum());

	}

	public Complex negate() {
		return new Complex(-this.real, -this.imag);
	}

	public Complex conjugate() {
		return new Complex(this.real, -this.imag);
	}

	public double distance(Complex secnum) {
		return Math.sqrt(Math.pow(this.getRealNum() - secnum.getRealNum(), 2) + Math.pow(this.imag - secnum.imag, 2));
	}

	public boolean equals(Complex c) {
		if (c == null)
			return false;
		if (this.getClass() != c.getClass())
			return false;
		Complex that = (Complex) c;
		return (this.real == that.real) && (this.imag == that.imag);

	}

	public boolean greaterThan(Complex secnum) {
		return this.distance(zero()) > secnum.distance(zero());

	}

	public boolean lessThan(Complex secnum) {
		return this.greaterThan(secnum) ? false : true;

	}

	public Complex zero() {
		return new Complex(0, 0);
	}

	public String toString() {
		return this.getRealNum() + " + " + this.getImagNum() + "i";

	}

}
