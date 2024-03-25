package ch07;

public class MathBean {
    public void printClassName(){
        // System.out.println("MathBean");
        // this.getClass()는 클래스의 정보를 다룰수 있게 된다.
        // 단, this.를 붙이지 않으면 MathBean이 아니라 인스턴스화한 클래스,
        // printClassName 등 과 같은 클래스를 말한다.
        System.out.println(this.getClass().getName());
    }

    public void printNumber(int x) {
        System.out.println(x);
    }

    public int getOne(){
        return 1;
    }

    public int plus(int x, int y){
        return x + y;
    }

}
