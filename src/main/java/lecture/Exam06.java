package lecture;

import java.util.*;

// 자바는 모든 예외의 부모인 Exception 클래스를 제공
// Exception의 자식 예외들은 RuntimeException과 기타 예외들로 나뉜다
// - RuntimeException은 정말 정말 가벼운 예외(자바가 오류를 낼 가치도 없다. 이것도 미리 짐작안되면 개발자 하지마...)
// - RuntimeException의 자식들은 오류가 발생하지 않는다(개발자가 알아서 처리)

public class Exam06 {
  public static void main(String[] args) {
    // 나열한 값으로 List 생성
    try {
      List<Integer> list = Arrays.asList(10, 20, 30);
      for (int i = 0; i < 10; i++) {
        System.out.println(list.get(i));
      }
      System.out.println(10/0);
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("인덱스를 확인하세요");
    } catch(ArithmeticException e) {
      System.out.println("0으로 나눌 수 없습니다");
    }
  }
}
