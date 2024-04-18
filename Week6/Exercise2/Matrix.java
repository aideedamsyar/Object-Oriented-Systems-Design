package Week6.Exercise2;

import java.util.Scanner;

public class Matrix {
    public int a, b, c, d;
    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();
    }

    public Matrix add(Matrix matrix2){
        Matrix res = new Matrix();
        res.a = this.a + matrix2.a;
        res.b = this.b + matrix2.b;
        res.c = this.c + matrix2.c;
        res.d = this.d + matrix2.d;

        return res;
    }

    public Matrix subtract(Matrix matrix2){
        Matrix res = new Matrix();
        res.a = this.a - matrix2.a;
        res.b = this.b - matrix2.b;
        res.c = this.c - matrix2.c;
        res.d = this.d - matrix2.d;

        return res;
    }

    public Matrix multiply(Matrix matrix2){
        Matrix res = new Matrix();
        res.a = (this.a * matrix2.a) + (this.b * matrix2.c);
        res.b = (this.a * matrix2.b) + (this.b * matrix2.d);
        res.c = (this.c * matrix2.a) + (this.d * matrix2.c);
        res.d = (this.c * matrix2.b) + (this.d * matrix2.d);

        return res;
    }

    public String toString(){
        return a + " " + b + "\n" + c + " " + d;}
}
