package momonyan.ganbariSavings.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import momonyan.ganbariSavings.Dao.GoodLuckDao
import momonyan.ganbariSavings.Entity.GoodLuckEntity

/**
 * GoodLuckDatabase
 * Databaseのバージョン管理など
 */
@Database(entities = [GoodLuckEntity::class], version = 1)
abstract class GoodLuckDatabase : RoomDatabase() {

    abstract fun goodLuckDao(): GoodLuckDao

    companion object {

        private var INSTANCE: GoodLuckDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): GoodLuckDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        GoodLuckDatabase::class.java, "User.db")
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}