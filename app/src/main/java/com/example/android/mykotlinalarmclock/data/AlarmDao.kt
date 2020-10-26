package com.example.android.mykotlinalarmclock.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AlarmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alarm:Alarm)

    @Update
    fun update(alarm: Alarm)

    @Delete
    fun delete(alarm: Alarm)

    @Query("DELETE from alarm_table")
    fun delete()

    @Query("SELECT * from alarm_table")
    fun getAllAlarms():List<Alarm>

    @Query("SELECT * from alarm_table")
    fun observeAllAlarms():LiveData<List<Alarm>>

}
