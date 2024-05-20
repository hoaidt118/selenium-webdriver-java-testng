package JavaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Topic_01_Data_Type {

    // Kiểu dữ liệu trong Java - 2 nhóm
    //1. Kiểu dữ liệu nguyên thủy (Primitive Type)
    //8 loại :
   // - Số nguyên: byte - short - int - long
    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber= 15635658;
    long lNumber = 234343400;
  //  - Số thực: float - double
    float fNumber = 9.99f;
    double dNumber = 35.800789d;
   // - Ký tự: char
    char c = 'H';
   // - Logic: boolean
    boolean status = false;

    //2. Kiểu dữ liệu tham chiếu (Reference Type)
   // - Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Select select = new Select(firefoxDriver.findElement(By.className("")));

    //Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

   // - Object
    Object name= "Hoai";

  //  - Array (kiểu nguyên thủy/ tham chiếu)
    Integer[] studentAge = {15,20,8};
    String[] studentName= {"Automation", "Testing"};
  //  - Collection: list, set, queue
    List<String> studentAddress = new ArrayList<String>();


  //  - String
    String fullName= "Hoai Dang";

    /*
    Khai báo  1 biến để lưu trữ 1 loại dữ liệu nào đó, dựa theo:
    - Access Modifier: Phạm vi truy cập (public/ private/ protected/ default)
    - Kiểu dữ liệu
    - Tên biến
    - Giá trị cuủa biến - gán vào với phép =
    - Nêú như k gán: dữ liệu mặc định
     */
}
