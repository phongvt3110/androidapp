package vn.eas.app1;

/**
 * Created by phongvt on 5/26/17.
 */

public class Monhoc {
    private String monhoc;
    private int hocphi;
    public Monhoc(){}
    public Monhoc(String mh,int hp){
        this.monhoc = mh;
        this.hocphi = hp;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public int getHocphi() {
        return hocphi;
    }

    public void setHocphi(int hocphi) {
        this.hocphi = hocphi;
    }
}
