public class Q1 {
    public static boolean Sarah(int N, int k, int a){
        if(a == 0) {
            return (N == k);
        }
        return Sarah(N-2,k,a-1) || Sarah(N-3,k,a-1);
    }
    public static void main(String[] args){
        System.out.println(Sarah(12,4,3));
        System.out.println(Sarah(29,5,10));
        System.out.println(Sarah(75,25,7));
        System.out.println(Sarah(74,30,16));
        System.out.println(Sarah(75,25,0));
        System.out.println(Sarah(75,75,0));

    }
}
