public class AlternateDigitSum {
    public static void main(String[] args) {
        System.out.println(alternateDigitSum(521));
    }

    public static int alternateDigitSum(int n) {
        int sum =0;
        int count =0;
        while(n!=0){
            if(count%2 == 0) sum += n%10;
            else {
                sum -= n % 10;
            }
            n = n/10;
            count ++;
        }
        return sum;
    }
}
