public class Q3 {
    public static int Carl(String a,String b,int num,int i,int x ){
        if(a.equals(b)){
            return num;
        }
        if(a.length() < b.length()){
            return Carl(b,a,num,i,x);
        }

            if (a.charAt(i) == b.charAt(x)) {
                if (a.charAt(i + 2) == b.charAt(x + 2) && a.charAt(i + 1) != b.charAt(x + 1)) {
                    num++;
                    b = b.substring(0, x + 1) + a.charAt(i + 1) + b.substring(x + 2);
                }
                if (a.charAt(i + 1) == b.charAt(x + 2)) {
                    num++;
                    b = b.substring(0, x + 1) + b.substring(x + 2);
                }
                if (a.charAt(i + 2) != b.charAt(x + 2) && a.charAt(i + 1) != b.charAt(x + 1)) {
                    num++;
                    b = b.substring(0, x + 1) + a.charAt(i + 1) + b.substring(x+1);
                }
                if (a.charAt(i + 2) == b.charAt(x + 1)) {
                    num++;
                    b = b.substring(0, x) + a.charAt(i + 1) + b.substring(x + 1);
                    System.out.println(b);
                }


            }
            if (a.charAt(i) != b.charAt(x)) {
                num++;
                b = b.substring(0, x) + a.charAt(i) + b.substring(x + 1);
            }

            i++;
            x++;


        return Carl(a,b,num,i,x);
    }


    public static void main(String[] args){
        String a = "plane";
        String b = "plane";
        int num = 0;
        int i = 0;
        int x = 0;
        System.out.println(Carl(a,b,num,i,x));

        a = "man";
        b = "men";
        num = 0;
        i = 0;
        x = 0;
        System.out.println(Carl(a,b,num,i,x));

        a = "exclamation";
        b = "excavation";
        num = 0;
        i = 0;
        x = 0;
        System.out.println(Carl(a,b,num,i,x));

        a = "inquire";
        b = "ensure";
        num = 0;
        i = 0;
        x = 0;
        System.out.println(Carl(a,b,num,i,x));

        a = "sunday";
        b = "saturday";
        num = 0;
        i = 0;
        x = 0;
        System.out.println(Carl(a,b,num,i,x));


    }
}
