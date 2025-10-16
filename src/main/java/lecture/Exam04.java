package lecture;

// Builder 디자인 패턴 : 객체 생성의 난해함을 해결

import lombok.*;

@Data
@AllArgsConstructor
@Builder
class 학생 {
  private String 이름;
  private String 학교;
  private String 주소;
  private String 연락처;
}

public class Exam04 {
  public static void main(String[] args) {
    // 1. 생성자의 순서가 헷갈린다
    학생 s = new 학생("학익고","인천시 학익동","홍길동","010-1111-2222");

    // 2. 일부 필드만 값을 주고 싶다 -> 생성자를 대체 몇개나 만들어야 하나?
    // 학생 s2 = new 학생("전우치", "학익고", "인천시 학익동");

    학생 s2 = 학생.builder().이름("전우치").학교("학익고").build();
  }
}
