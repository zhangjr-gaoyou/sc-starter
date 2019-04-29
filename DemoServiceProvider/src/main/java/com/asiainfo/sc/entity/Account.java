package com.asiainfo.sc.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.asiainfo.sc.base.BaseEntity;

@Entity
public class Account extends BaseEntity {

    private Long id;
    private String userId;
    private String accountNumber;
    private Boolean defaultAccount;

    private Set<Address> addresses;

    public Account() {
    }

    public Account(String userId, String accountNumber) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.addresses = new HashSet<>();
        this.defaultAccount = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(Boolean defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", addresses=" + addresses +
                "} " + super.toString();
    }
}
