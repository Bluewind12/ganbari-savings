package momonyan.ganbariSavings.Main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.main_layout.*
import momonyan.ganbariSavings.DataModel.GoodLuckDataModel
import momonyan.ganbariSavings.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)


        //AdMob Init
        MobileAds.initialize(this)

        val recyclerAdapter = MainRecyclerAdapter(this.createDataSet())
        val llm = LinearLayoutManager(this)

        mainRecyclerView.setHasFixedSize(true)

        mainRecyclerView.layoutManager = llm

        mainRecyclerView.adapter = recyclerAdapter
    }

    private fun createDataSet(): List<GoodLuckDataModel> {
        val dataList: MutableList<GoodLuckDataModel> = ArrayList()
        var sumScore = 0
        //TODO DataBaseからの取得
        for (i in 0..49) {
            val score = (-100..100).random()
            sumScore += score
            val glData = GoodLuckDataModel(
                date = getNowDate(i),
                title = "タイトル$i",
                score = score,
                sumScore = sumScore
            )
            dataList.add(glData)
        }
        return dataList
    }
}

@SuppressLint("SimpleDateFormat")
fun getNowDate(addNum: Int): String {
    val now = Date()
    val calender = Calendar.getInstance()
    calender.time = now
    calender.add(Calendar.DATE, addNum)
    Log.d("TESTTAG",calender.time.toString())
    val df: DateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    return df.format(calender.time)
}