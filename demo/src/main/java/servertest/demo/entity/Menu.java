package servertest.demo.entity;


import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "menu")
public class Menu {

    @Column(name="parent")
    private String parent;

    @Column(name="child")
    private String child;

    @Id
    @Column(name="url")
    private String url;

    @Column(name="createtime")
    private Timestamp timestamp;

    public String getParent() {
        return parent;
    }

    public String getChild() {
        return child;
    }

    public String getUrl() {
        return url;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
