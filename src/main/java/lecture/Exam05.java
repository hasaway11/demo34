package lecture;

// 예외(Exception) - 프로그래머가 대처할 수 있는 가벼운 오류  vs Error(개발자가 대처불가능한 오류)
// ※ 파일 출력 프로그램을 작성한다고 해보자
// 1. 파일 이름을 입력받는다
// 2. 파일을 연다 -> 파일이 없으면? 죽는다
// 3. 출력한다 -> 파일이 깨졌으면? 죽는다
// 4. 파일을 닫는다 -> 2번에서 파일을 못 열었으면? 죽는다

// 자바이전에는 2번 if else, 3번 if else, 4번 if else로 만들었다

// C++에서 생각한 방법 -> 내가 지금 작성하는 코드에서 예외가 발생해? 안해? ...모르겠는데
// try {
//      예외가 발생할 수 있는 코드.....
// } catch() {
//      예외에 대응하는 코드
// }

// 자바의 아이디어!!! 자바 코드에서 발생할 수 있는 예외를 미리 다 정해놓는다
// - 예외가 발생할 수 있는 코드는 빨간줄이 그어진다


import java.io.*;

public class Exam05 {
  // throws : 예외를 처리하지 않게 던져버린다 -> 그러면 main을 실행한 놈에게 던져진다
  public static void main(String[] args) {
    try {
      FileReader fr = new FileReader("c:/windows/win.aaa");
    } catch (FileNotFoundException e) {
      System.out.println("파일을 찾을 수 없습니다");
    }

  }
}
