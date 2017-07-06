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

    @Column(name = "userName")
    public String userName;

    @Column(name = "userNumber")
    public String userNumber;

    public Data() {
        super();
    }

    public Data( String userEmail, String userPassword, String userName, String userNumber ) {
        super();
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNumber = userNumber;
    }

    public static String getValue (String userEmail){

        Select select = new Select();
         Data data = select.from(Data.class)
                .where("userEmail = ?", userEmail)
                .executeSingle();

        //com.activeandroid.util.Log.d("log email :"+ data.getUserEmail());
        //com.activeandroid.util.Log.d("log password"+ data.getUserPassword());
        //com.activeandroid.util.Log.d("log name"+ data.getUserName());
        //com.activeandroid.util.Log.d("log number"+ data.getUserNumber());

        return  data.getUserPassword();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserNumber() {
        return userNumber;
    }
}
