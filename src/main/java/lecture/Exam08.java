package lecture;

// finally : 예외 발생여부에 상관없이 실행할 코드를 작성

import java.io.*;

// try ~ catch ~ finally
public class Exam08 {
  public static void main(String[] args) {
    FileReader fr = null;
    try {
      fr = new FileReader("c:/windows/system.ini");
      for(;;) {
        int ch = fr.read();
        if(ch<0)
          break;
        System.out.print((char)ch);
      }
    } catch (FileNotFoundException e) {
      System.out.println("파일을 찾을 수 없습니다");
    } catch (IOException e) {
      System.out.println("파일을 읽을 수 없습니다");
    } finally {
      try {
        fr.close();
      } catch (IOException e) {
        System.out.println("파일을 열지 못해서 닫을 수 있습니다");
      }
    }
  }
}
