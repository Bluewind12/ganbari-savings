package momonyan.ganbariSavings.Main

import android.graphics.Color

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import momonyan.ganbariSavings.DataModel.GoodLuckDataModel
import momonyan.ganbariSavings.R


class MainRecyclerAdapter(list: List<GoodLuckDataModel>) :
    RecyclerView.Adapter<MainRecyclerHolder>() {
    private val goodluckList: List<GoodLuckDataModel> = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerHolder {
        val inflate: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_recycler_column_layout, parent, false)
        return MainRecyclerHolder(inflate)
    }

    override fun onBindViewHolder(holder: MainRecyclerHolder, position: Int) {
        //Text
        holder.date!!.text = goodluckList[position].date
        holder.title!!.text = goodluckList[position].title

        //Number
        holder.score!!.text = goodluckList[position].score.toString()
        holder.sumScore!!.text = goodluckList[position].sumScore.toString()

        //Color
        if (goodluckList[position].score >= 0) {
            holder.color!!.setBackgroundColor(Color.RED)
        } else {
            holder.color!!.setBackgroundColor(Color.BLUE)
        }
    }

    override fun getItemCount(): Int {
        return goodluckList.size
    }

}