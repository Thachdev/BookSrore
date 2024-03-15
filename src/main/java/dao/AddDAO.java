package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import context.DBContext;

public class AddDAO {
    public static void addBook(String name, String priceString, String img) {
        int price = 0;
        if (priceString != null && !priceString.isEmpty()) {
            try {
                price = Integer.parseInt(priceString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
        }
        
        try {
            Connection connection = DBContext.getConnection();
            String query = "INSERT INTO `bookstore`.`books` (`idbooks`, `bookname`, `bookprice`, `bookimage`) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,7);
            ps.setString(2, name);
            ps.setInt(3, price);
            ps.setString(4, img);
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }
}
