/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_SB;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
@Entity
@Table(name = "SKLEP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sklep.findAll", query = "SELECT s FROM Sklep s"),
    @NamedQuery(name = "Sklep.findByIdSklepu", query = "SELECT s FROM Sklep s WHERE s.idSklepu = :idSklepu"),
    @NamedQuery(name = "Sklep.findByNazwa", query = "SELECT s FROM Sklep s WHERE s.nazwa = :nazwa")})
public class Sklep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SKLEPU")
    private Integer idSklepu;
    @Basic(optional = false)
    @Column(name = "NAZWA")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSklepu")
    private Collection<Cena> cenaCollection;

    public Sklep() {
    }

    public Sklep(Integer idSklepu) {
        this.idSklepu = idSklepu;
    }

    public Sklep(Integer idSklepu, String nazwa) {
        this.idSklepu = idSklepu;
        this.nazwa = nazwa;
    }

    public Integer getIdSklepu() {
        return idSklepu;
    }

    public void setIdSklepu(Integer idSklepu) {
        this.idSklepu = idSklepu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<Cena> getCenaCollection() {
        return cenaCollection;
    }

    public void setCenaCollection(Collection<Cena> cenaCollection) {
        this.cenaCollection = cenaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSklepu != null ? idSklepu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sklep)) {
            return false;
        }
        Sklep other = (Sklep) object;
        if ((this.idSklepu == null && other.idSklepu != null) || (this.idSklepu != null && !this.idSklepu.equals(other.idSklepu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lab1_SB.Sklep[ idSklepu=" + idSklepu + " ]";
    }
    
}
