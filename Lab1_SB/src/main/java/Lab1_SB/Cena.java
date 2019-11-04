/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_SB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "CENA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cena.findAll", query = "SELECT c FROM Cena c"),
    @NamedQuery(name = "Cena.findByIdCeny", query = "SELECT c FROM Cena c WHERE c.idCeny = :idCeny"),
    @NamedQuery(name = "Cena.findByCena", query = "SELECT c FROM Cena c WHERE c.cena = :cena")})
public class Cena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CENY")
    private Integer idCeny;
    @Basic(optional = false)
    @Column(name = "CENA")
    private int cena;
    @JoinColumn(name = "ID_PRZEDMIOTU", referencedColumnName = "ID_PRZEDMIOTU")
    @ManyToOne(optional = false)
    private Przedmiot idPrzedmiotu;
    @JoinColumn(name = "ID_SKLEPU", referencedColumnName = "ID_SKLEPU")
    @ManyToOne(optional = false)
    private Sklep idSklepu;

    public Cena() {
    }

    public Cena(Integer idCeny) {
        this.idCeny = idCeny;
    }

    public Cena(Integer idCeny, int cena) {
        this.idCeny = idCeny;
        this.cena = cena;
    }

    public Integer getIdCeny() {
        return idCeny;
    }

    public void setIdCeny(Integer idCeny) {
        this.idCeny = idCeny;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Przedmiot getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public void setIdPrzedmiotu(Przedmiot idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public Sklep getIdSklepu() {
        return idSklepu;
    }

    public void setIdSklepu(Sklep idSklepu) {
        this.idSklepu = idSklepu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCeny != null ? idCeny.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cena)) {
            return false;
        }
        Cena other = (Cena) object;
        if ((this.idCeny == null && other.idCeny != null) || (this.idCeny != null && !this.idCeny.equals(other.idCeny))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lab1_SB.Cena[ idCeny=" + idCeny + " ]";
    }
    
}
