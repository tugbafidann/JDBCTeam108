import java.sql.*;

public class JDBC01_Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1- ilgili Driver'i yüklemeliyiz. MySQL kullandigimizi bildiriyoruz
        // Driver'ı bulamama ihtimaline karşi forname methodu icin "ClassNotFoundException"
        // method signature 'ımıza exception olarak firlatmamizi istiyor.(main methodun devamında
        // throws ClassNotFoundException olarak yazdi)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2 - Baglantiyi olusturmak icin username ve password girmeliyiz.
         // Burada da bu username ve password'un yanlis olma ihtimaline karsi
         // SQLException firlatmamizi istiyor.

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        // 3 - SQL query'leri icin bir Statement objesi olusturup , javada SQL sorgularimiz
        // icin bir alan acacagiz.

        Statement st=con.createStatement();

        // 4- SQL query'lerimizi yazip caliştirabiliriz

        ResultSet veri=st.executeQuery("SELECT * FROM personel");

        // 5 - Sonuclari görmek icin İteration ile Set icerisindeki elemanlari  WHİLE
        // döngüsü ile yazdiriyoruz

        while (veri.next() ){
            System.out.println(veri.getInt(1)+" "+veri.getString(2)+" "+
                     veri.getString(3)+" "+veri.getInt(4)+" "+ veri.getString(5));
        }

        // 6- olusturulan baglantilari kapatiyoruz
        con.close();
        st.close();
        veri.close();
    }
}
