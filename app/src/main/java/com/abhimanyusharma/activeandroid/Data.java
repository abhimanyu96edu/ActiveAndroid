package com.abhimanyusharma.activeandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Abhimanyu Sharma on 23-06-2017.
 */

@Table(name = "Data")
public class Data extends Model{

    @Column(name = "UserEmail", unique = true, onUniqueConflict = Column.ConflictAction.ABORT)
    public String userEmail;

    @Column(name = "UserPassword")
    public String userPassword;

    @Column(name = "UserFirstName")
    public String userFirstName;

    @Column(name = "UserLastName")
    public String userLastName;

    public static List<Data>getAllocations(String userEmail){
        return new Select()
                .from(Data.class)
                .where("UserEmail = ?", userEmail)
                .orderBy("Name ASC")
                .execute();
    }

}
