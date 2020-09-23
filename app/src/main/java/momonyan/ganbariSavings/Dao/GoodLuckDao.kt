package momonyan.ganbariSavings.Dao

import androidx.room.*
import momonyan.ganbariSavings.Entity.GoodLuckEntity

/**
 * GoodLuckDao
 * Query管理
 */
@Dao
interface GoodLuckDao {

    @Query("select * from GoodLuckEntity")
    fun getAll(): List<GoodLuckEntity>

    @Query("select * from GoodLuckEntity where id = :id")
    fun findId(id: Int): GoodLuckEntity

    @Query("select * from GoodLuckEntity where created_at between :startDate and :endDate ")
    fun findCreatedBetween(startDate: String, endDate: String): List<GoodLuckEntity>

    @Query("select * from GoodLuckEntity where updated_at between :startDate and :endDate ")
    fun findUpdatedBetween(startDate: String, endDate: String): List<GoodLuckEntity>

    @Insert
    fun insert(goodLuckEntity: GoodLuckEntity)

    @Update
    fun update(goodLuckEntity: GoodLuckEntity)

    @Delete
    fun delete(goodLuckEntity: GoodLuckEntity)

    @Query("delete from GoodLuckEntity")
    fun allDelete()
}