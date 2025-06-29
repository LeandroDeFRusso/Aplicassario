package com.lrv.aplicassario2

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BirthdayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(birthday: Birthday)

    @Query("SELECT * FROM birthdays ORDER BY substr(date, 4, 2), substr(date, 1, 2)")
    fun getAll(): Flow<List<Birthday>>

    @Query("SELECT * FROM birthdays WHERE `group` = :group ORDER BY substr(date, 4, 2), substr(date, 1, 2)")
    fun getByGroup(group: String): Flow<List<Birthday>>

    @Delete
    suspend fun delete(birthday: Birthday)
}
