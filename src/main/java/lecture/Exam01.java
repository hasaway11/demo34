package lecture;

// final : 변경 금지
// - final double PI = 3.14;        변경이 금지된 변수 -> 상수
// - 함수에 지정하면 override 금지
// - 클래스에 지정하면 상속 금지, 객체 생성 금지
// 대표적인 final 클래스는 Math 클래스(final 클래스이고 모든 메소드 final, 모든 변수 final)

// - 값을 저장하는 객체는 여러개 -> 객체가 여러개 있다면 반드시 내용이 달라야 한다 (Value Object, Entity)
// - 처리하는 객체는 여러개 필요가 없다

class Calc1 {
  public static int sum(int x, int y) {
    return x+y;
  }
}

public class Exam01 {
  public static void main(String[] args) {
    // static 함수는 객체 생성없이 사용 가능
    // 작업 객체는 static을 이용하면 객체를 생성하지 않아도 된다
    System.out.println(Calc1.sum(10, 20));
  }
}
