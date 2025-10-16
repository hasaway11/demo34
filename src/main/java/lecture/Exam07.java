package lecture;

import java.io.*;

// 체크하는 예외
// 체크하지 않는 예외 : RuntimeException의 자식들
public class Exam07 {
  public static void main(String[] args) {
    try {
      FileReader fr = new FileReader("c:/windows/system.ini");
      for(;;) {
        // system.ini에서 한글자를 읽어온다(글자가 -1이면 파일의 끝. 그래서 char이 아니라 int가 리턴된다)
        int ch = fr.read();
        if(ch<0)
          break;
        System.out.print((char)ch);
      }
    } catch (FileNotFoundException e) {
      System.out.println("파일을 찾을 수 없습니다");
    } catch (IOException e) {
      System.out.println("파일을 읽을 수 없습니다");
    }
  }
}
