package lam.fpoly.shopthoitrang.Dao;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import lam.fpoly.shopthoitrang.DbSqlServer;
import lam.fpoly.shopthoitrang.Model.TbHoaDonChiTiet;

public class TbHoaDonChiTietDao {
    Connection objConn;
    public TbHoaDonChiTietDao(){
        DbSqlServer db = new DbSqlServer();
        objConn = db.openConnect();
    }
    public TbHoaDonChiTiet getAll(int id){
        List<TbHoaDonChiTiet> listCat = new ArrayList<TbHoaDonChiTiet>();
        try {
            if (this.objConn != null) {
                String sqlQuery = "SELECT * FROM chiTietHoaDon WHERE id_donHang = '"+id+"'";
                Statement statement = this.objConn.createStatement(); // khởi tạo cấu trúc truy vấn
                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn
                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list
                    TbHoaDonChiTiet obj = new TbHoaDonChiTiet();
                    obj.setId_DonHang(resultSet.getInt("id_donHang"));
                    obj.setId_SanPham(resultSet.getInt("id_sanPham"));
                    obj.setSoLuong(resultSet.getInt("soLuong"));
                    listCat.add(obj);
                }
            }
        } catch (Exception e) {
            Log.i("TAG", "getAll: lỗi");
        }

        return  listCat.get(0);
    }
}
