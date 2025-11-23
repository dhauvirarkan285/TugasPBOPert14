/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspert13;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RAISSA
 */
@Entity
@Table(name = "akun_orang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AkunOrang.findAll", query = "SELECT a FROM AkunOrang a")
    , @NamedQuery(name = "AkunOrang.findById", query = "SELECT a FROM AkunOrang a WHERE a.id = :id")
    , @NamedQuery(name = "AkunOrang.findByUsername", query = "SELECT a FROM AkunOrang a WHERE a.username = :username")
    , @NamedQuery(name = "AkunOrang.findByPassword", query = "SELECT a FROM AkunOrang a WHERE a.password = :password")
    , @NamedQuery(name = "AkunOrang.findByEmail", query = "SELECT a FROM AkunOrang a WHERE a.email = :email")
    , @NamedQuery(name = "AkunOrang.findByNamaLengkap", query = "SELECT a FROM AkunOrang a WHERE a.namaLengkap = :namaLengkap")})
public class AkunOrang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "nama_lengkap")
    private String namaLengkap;

    public AkunOrang() {
    }

    public AkunOrang(Integer id) {
        this.id = id;
    }

    public AkunOrang(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AkunOrang)) {
            return false;
        }
        AkunOrang other = (AkunOrang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugaspert13.AkunOrang[ id=" + id + " ]";
    }
    
}
