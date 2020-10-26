package com.example.android.mykotlinalarmclock.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "alarm_table")
data class Alarm(
    @PrimaryKey(autoGenerate = true)
    val alarmId: Int = 0,
    @ColumnInfo(name = "hour")
    val hour: Int,
    @ColumnInfo(name = "minute")
    val minute: Int,
    @ColumnInfo(name = "started")
    var started: Boolean = false,
    @ColumnInfo(name = "recurring")
    val recurring: Boolean,
    @ColumnInfo(name = "monday")
    val monday: Boolean,
    @ColumnInfo(name = "tuesday")
    val tuesday: Boolean,
    @ColumnInfo(name = "wednesday")
    val wednesday: Boolean,
    @ColumnInfo(name = "thursday")
    val thursday: Boolean,
    @ColumnInfo(name = "friday")
    val friday: Boolean,
    @ColumnInfo(name = "saturday")
    val saturday: Boolean,
    @ColumnInfo(name = "sunday")
    val sunday: Boolean,
    @ColumnInfo(name = "title")
    val title: String
) : Parcelable
