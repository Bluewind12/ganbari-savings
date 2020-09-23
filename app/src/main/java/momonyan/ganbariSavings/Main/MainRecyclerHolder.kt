package momonyan.ganbariSavings.Main

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.main_recycler_column_layout.view.*


class MainRecyclerHolder(columnView: View) : ViewHolder(columnView) {

    var date: TextView? = null
    var title: TextView? = null
    var score: TextView? = null
    var sumScore: TextView? = null
    var color: View? = null

    init {
        date = columnView.mainRecyclerDateTextView
        title = columnView.mainRecyclerTitleTextView
        score = columnView.mainRecyclerScoreTextView
        sumScore = columnView.mainRecyclerSumScoreTextView
        color = columnView.mainRecyclerColorBar
    }
}