/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspert12;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RAISSA
 */
@Entity
@Table(name = "perawatan_kereta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerawatanKereta.findAll", query = "SELECT p FROM PerawatanKereta p")
    , @NamedQuery(name = "PerawatanKereta.findByIdPerawatan", query = "SELECT p FROM PerawatanKereta p WHERE p.idPerawatan = :idPerawatan")
    , @NamedQuery(name = "PerawatanKereta.findByTanggalPerawatan", query = "SELECT p FROM PerawatanKereta p WHERE p.tanggalPerawatan = :tanggalPerawatan")
    , @NamedQuery(name = "PerawatanKereta.findByJenisPerawatan", query = "SELECT p FROM PerawatanKereta p WHERE p.jenisPerawatan = :jenisPerawatan")
    , @NamedQuery(name = "PerawatanKereta.findByKeterangan", query = "SELECT p FROM PerawatanKereta p WHERE p.keterangan = :keterangan")})
public class PerawatanKereta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perawatan")
    private Integer idPerawatan;
    @Basic(optional = false)
    @Column(name = "tanggal_perawatan")
    @Temporal(TemporalType.DATE)
    private Date tanggalPerawatan;
    @Column(name = "jenis_perawatan")
    private String jenisPerawatan;
    @Column(name = "keterangan")
    private String keterangan;
    @JoinColumn(name = "id_armada", referencedColumnName = "id_armada")
    @ManyToOne(optional = false)
    private Depokeretasbi idArmada;

    public PerawatanKereta() {
    }

    public PerawatanKereta(Integer idPerawatan) {
        this.idPerawatan = idPerawatan;
    }

    public PerawatanKereta(Integer idPerawatan, Date tanggalPerawatan) {
        this.idPerawatan = idPerawatan;
        this.tanggalPerawatan = tanggalPerawatan;
    }

    public Integer getIdPerawatan() {
        return idPerawatan;
    }

    public void setIdPerawatan(Integer idPerawatan) {
        this.idPerawatan = idPerawatan;
    }

    public Date getTanggalPerawatan() {
        return tanggalPerawatan;
    }

    public void setTanggalPerawatan(Date tanggalPerawatan) {
        this.tanggalPerawatan = tanggalPerawatan;
    }

    public String getJenisPerawatan() {
        return jenisPerawatan;
    }

    public void setJenisPerawatan(String jenisPerawatan) {
        this.jenisPerawatan = jenisPerawatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Depokeretasbi getIdArmada() {
        return idArmada;
    }

    public void setIdArmada(Depokeretasbi idArmada) {
        this.idArmada = idArmada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerawatan != null ? idPerawatan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerawatanKereta)) {
            return false;
        }
        PerawatanKereta other = (PerawatanKereta) object;
        if ((this.idPerawatan == null && other.idPerawatan != null) || (this.idPerawatan != null && !this.idPerawatan.equals(other.idPerawatan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugaspert12.PerawatanKereta[ idPerawatan=" + idPerawatan + " ]";
    }
    
}
