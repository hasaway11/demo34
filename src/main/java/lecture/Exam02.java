package lecture;

class Calc2 {
  private double 소득세율 = 0.03;
  public static int 소득세(int 급여) {
    // static는 new이전부터 사용가능
    // 일반 멤버는 new(객체생성)이후부터 사용가능
    // 따라서 static 멤버는 일반 멤버에 접근할 수 없다 -> static은 자바의 객체 지향 문법 중 상당부분이 적용이 안된다

    // 그래서 객체를 안만드는 것이 아니라 1개만 만들자(싱글톤 출현)
    //return 급여 * 소득세율;
    return 1;
  }
}

public class Exam02 {
}
