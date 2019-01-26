/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.entity;

import java.util.Objects;

/**
 *
 * @author ACER
 */
public class Provider {
    private Integer id_provider;
    private String provider_name;

    public Integer getId_provider() {
        return id_provider;
    }

    public void setId_provider(Integer id_provider) {
        this.id_provider = id_provider;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id_provider);
        hash = 79 * hash + Objects.hashCode(this.provider_name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Provider other = (Provider) obj;
        if (!Objects.equals(this.provider_name, other.provider_name)) {
            return false;
        }
        if (!Objects.equals(this.id_provider, other.id_provider)) {
            return false;
        }
        return true;
    }
    
}
