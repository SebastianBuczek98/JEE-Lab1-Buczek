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
@Table(name = "PRZEDMIOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Przedmiot.findAll", query = "SELECT p FROM Przedmiot p"),
    @NamedQuery(name = "Przedmiot.findByIdPrzedmiotu", query = "SELECT p FROM Przedmiot p WHERE p.idPrzedmiotu = :idPrzedmiotu"),
    @NamedQuery(name = "Przedmiot.findByNazwa", query = "SELECT p FROM Przedmiot p WHERE p.nazwa = :nazwa")})
public class Przedmiot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRZEDMIOTU")
    private Integer idPrzedmiotu;
    @Basic(optional = false)
    @Column(name = "NAZWA")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrzedmiotu")
    private Collection<Cena> cenaCollection;

    public Przedmiot() {
    }

    public Przedmiot(Integer idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public Przedmiot(Integer idPrzedmiotu, String nazwa) {
        this.idPrzedmiotu = idPrzedmiotu;
        this.nazwa = nazwa;
    }

    public Integer getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public void setIdPrzedmiotu(Integer idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
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
        hash += (idPrzedmiotu != null ? idPrzedmiotu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Przedmiot)) {
            return false;
        }
        Przedmiot other = (Przedmiot) object;
        if ((this.idPrzedmiotu == null && other.idPrzedmiotu != null) || (this.idPrzedmiotu != null && !this.idPrzedmiotu.equals(other.idPrzedmiotu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lab1_SB.Przedmiot[ idPrzedmiotu=" + idPrzedmiotu + " ]";
    }

   // public int getID() {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }
    
}
