package newpackage;


public class Students {
    private String MSV;
    private String Hoten;
    private String Ngaysinh;
    private String lop;
 

    public Students(String MSV, String Hoten, String Ngaysinh, String lop) {
        this.MSV = MSV;
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.lop = lop;
    }

    public Students() {
    }

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    
}