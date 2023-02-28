package Nazar.domain;

import java.util.Date;
import java.util.Objects;
public class Bucket {
    private Integer id;
    private Integer userid;
    private Integer productid;
    private Date purchasedate;
    public Bucket(Integer id, Integer userid, Integer productid, Date purchasedate) {
        this.id = id;
        this.userid = userid;
        this.productid = productid;
        this.purchasedate = purchasedate;
    }
    public Bucket(Integer userid, Integer productid, Date purchasedate) {
        this.userid = userid;
        this.productid = productid;
        this.purchasedate = purchasedate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public Integer getProductid() {
        return productid;
    }
    public void setProductid(Integer productid) {
        this.productid = productid;
    }
    public Date getPurchasedate() {
        return purchasedate;
    }
    public void setPurchasedate(Date purchasedate) {
        this.purchasedate = purchasedate;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return id.equals(bucket.id) && userid.equals(bucket.userid) && productid.equals(bucket.productid) && purchasedate.equals(bucket.purchasedate);
    }
    public int hashCode() {
        return Objects.hash(id, userid, productid, purchasedate);
    }
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", userid=" + userid +
                ", productid=" + productid +
                ", purchasedate=" + purchasedate +
                '}';
    }
}