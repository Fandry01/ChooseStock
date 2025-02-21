package com.example.choosestock.Model;

public class Company {
    public String AssetType;
    public String Name;
    public String Description;
    public String Country;
    public String Sector;
    public String Industry;

    public String getAssetType() {
        return AssetType;
    }

    public void setAssetType(String assetType) {
        AssetType = assetType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }
    @Override
    public String toString() {
        return "Company{" +
                "AssetType='" + AssetType + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Country='" + Country + '\'' +
                ", Sector='" + Sector + '\'' +
                ", Industry='" + Industry + '\'' +
                '}';
    }
}
