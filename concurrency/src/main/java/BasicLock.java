class Solution {
    public String addBinary(String a, String b) {
        int length;
        int aLength = a.length();
        int bLength = b.length();

        if(aLength > bLength) {
            length = aLength;
            for(int j = 0; j < aLength - bLength ;j++) {
                b = "0" + b;
            }
        } else {
            length = bLength;
            for(int j = 0; j < bLength -aLength;j++ ) {
                a = "0" + a;
            }

        }

        int flag = 0;
        String result = "";

        for(int i = length-1; i >=0 ; i--){

            int atA = Integer.parseInt(a.charAt(i)+"");
            int atB = Integer.parseInt(b.charAt(i)+"");

            int sum = atA + atB + flag;

            if(sum == 2) {
                sum = 0;
                flag = 1 ;
            } else if ( sum == 3 ) {
                sum = 1;
                flag = 1;
            } else {
                flag = 0;
            }
            result = sum + result;
        }
        if(flag == 1) {
            result = 1 + result;
        }

        return result;
    }


}