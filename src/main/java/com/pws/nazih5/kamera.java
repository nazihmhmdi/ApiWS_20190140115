/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.nazih5;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author nazih
 */
@Entity
@Table(name = "kamera")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class kamera implements Serializable {

    @Size(max = 20)
    @Column(name = "merek")
    private String merek;
    @Size(max = 20)
    @Column(name = "tipe")
    private String tipe;
    @Size(max = 10)
    @Column(name = "jenis")
    private String jenis;
    @Size(max = 10)
    @Column(name = "harga")
    private String harga;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "noseri")
    private String noseri;

    public kamera(String noseri) {
        this.noseri = noseri;
    }

    public String getNoseri() {
        return noseri;
    }

    public void setNoseri(String noseri) {
        this.noseri = noseri;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noseri != null ? noseri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof kamera)) {
            return false;
        }
        kamera other = (kamera) object;
        if ((this.noseri == null && other.noseri != null) || (this.noseri != null && !this.noseri.equals(other.noseri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pws.nazih5.kamera[ noseri=" + noseri + " ]";
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
    
}
