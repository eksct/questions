public class STRING {
    private String  thise;
      private int Strn;
    private int maxLcs;
    String SmaxLcs;
    private char[] vals;
    STRING(){//null
        this.vals = new char[0];
    }
    STRING(String thise){
        this.thise = thise;
        this.Strn = thise.length();
        vals = new char[Strn];
        //vals = new char[Strn];
        for(int i=0;i<Strn;i++){
           vals[i]= thise.charAt(i);
        }
    }
    STRING(char[] vals){
        this.vals=vals;
    }
    STRING(STRING s){
        this(s.vals);
    }
    STRING(char[] v,int being,int end){
        if ((being >=0 && being <=v.length) && (end >=being && end<=v.length)){
            for (int i=0;i<v.length;i++){
                this.vals[i]=v[i];
            }
        }else {throw new ArrayIndexOutOfBoundsException();}
    }
    public STRING substring(int being,int end ){
        if (being==0 && end == this.vals.length) {
            return this;
        }
        return new STRING(this.vals,being,end);
    }
    public STRING substring(int being){
        return substring(being,this.vals.length);
    }

    public char CharAt(int i){
        if (i> vals.length-1)throw new ArrayIndexOutOfBoundsException();
        return this.vals[i];
    }
    public int length (){
        return this.vals.length;
    }
    public String toString(){
        return this.vals.toString();
    }

    public void LCSdop() {//最长对称子字符串
        if (this.thise.equals("")){
            System.out.println(0);
            System.out.println("null");
            return;
        }
        boolean[][] ans = new boolean[Strn][Strn];
//        for (int i=0;i<Strn;i++){ans[i][i]=true;}
        for (int i=1;i<this.Strn;i++){
            for (int j=0;j<this.Strn;j++){
                if (this.thise.charAt(i)==this.thise.charAt(j)){
                        if (i-j<3){//assa                                1. 0,1 f /  1,1 t / 2,1 t / 3.1 f    2. 2,0 f 2,1 t / 2.2 t/ 2.3 f   3. 3.0 t ,3.1f 3.2f 3.3 t
                            ans[j][i]=true;
                        }else {
                            ans[j][i]=ans[j+1][i-1];
                        }
                }
                if (ans[j][i] && i-j +1 >this.maxLcs){
                    this.maxLcs = i-j+1;
                    this.SmaxLcs = this.thise.substring(j,i+1);
                }
            }
        }
        System.out.println(this.maxLcs);
        System.out.println(this.SmaxLcs);
    }
    public void LCS(){//求最长子字符串

        for (int i=1;i<this.Strn;i++){
            for (int j=0;j<this.Strn;j++){
                if (this.thise.charAt(i)==this.thise.charAt(j) && i-j+1 > this.maxLcs){
                    this .maxLcs=i-j+1;
                    this.SmaxLcs = this.thise.substring(j,i+1);
                }
            }
        }
        System.out.println(this.maxLcs);
        System.out.println(this.SmaxLcs);
    }
}
