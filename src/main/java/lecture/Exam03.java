package lecture;

// 싱글톤 패턴 : GoF(Gang of Four)가 제시한 디자인 패턴 중 하나
// - 디자인 패턴 - 개발 중 자주 벌어지는 상황들에 대한 표준 해결책
// 1. 자신의 private static 객체를 가진다
// 2. 생성자는 private
// 3. 객체를 빌리는 메소드 추가

// 스프링 빈을 싱글톤으로 제공된다
// (위 1,2,3으로 만든 싱글톤은 문제가 있다)
class Calc3 {
  private static Calc3 calc= new Calc3();
  private Calc3() {}
  public static Calc3 getInstance() {
    return calc;
  }
}

public class Exam03 {
}
