package com.abhimanyusharma.activeandroid.tablemodel;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;


@Table(name = "Data")
public class Data extends Model{

    @Column(name = "userEmail", unique = true, onUniqueConflict = Column.ConflictAction.ABORT)
    public String userEmail;

    @Column(name = "userPassword")
    public String userPassword;

    @Column(name = "userFirstName")
    public String userFirstName;

    @Column(name = "userLastName")
    public String userLastName;

    public Data() {
        super();
    }

    public Data( String userEmail, String userPassword, String userFirstName,String userLastName ) {
        super();
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public static String getValue (String userEmail){

        Data data =
         new Select("userPassword")
                .from(Data.class)
                .where("userEmail = ?", userEmail)
                .executeSingle();

        return  data.getUserPassword();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }


}
