package com.plantix.data.database.dbpojo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(indices = @Index(value = {"id"}, unique = true))
public class Datum implements Serializable {
    private final static long serialVersionUID = -8861612118689010673L;
    @PrimaryKey(autoGenerate = true)
    private int Uid;
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private Integer id;
    @ColumnInfo(name = "email")
    @SerializedName("email")
    @Expose
    private String email;
    @ColumnInfo(name = "firstName")
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @ColumnInfo(name = "lastName")
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @ColumnInfo(name = "avatar")
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @ColumnInfo(name = "modifiedLowerCaseUserName")
    private String modifiedLowerCaseUserName = "";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getModifiedLowerCaseUserName() {
        return (firstName + " " + lastName).toLowerCase();
    }

    public void setModifiedLowerCaseUserName(String modifiedLowerCaseUserName) {
        this.modifiedLowerCaseUserName = modifiedLowerCaseUserName;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }
}
