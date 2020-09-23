package momonyan.ganbariSavings.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class GoodLuckEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val score:Int,
    val memo:String?,
    val created_at:String,
    val updated_at:String
)