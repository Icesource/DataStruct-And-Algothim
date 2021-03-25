package JianzhiOffer;

public class T12Power {
    //递归法
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double ans = 0, temp = 0;
        if (exponent % 2 == 0) {
            temp = Power(base, exponent / 2);
            ans = temp * temp;
        } else {
            temp = Power(base, exponent / 2);
            ans = temp * temp * base;
        }
        return ans;
    }

    // 迭代法
    public double Power2(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double x = base;
        double ans = 1;
        while (exponent != 0) {
            if ((exponent & 1) == 1) ans *= x;
            x = x * x;
            exponent >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        T12Power power = new T12Power();
        System.out.println(power.Power2(2,5));
    }
}