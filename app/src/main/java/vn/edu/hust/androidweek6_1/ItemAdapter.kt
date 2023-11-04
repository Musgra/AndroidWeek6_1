package vn.edu.hust.androidweek6_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val items: ArrayList<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.mail.text = items[position].mail
        viewHolder.title.text = items[position].title
        viewHolder.avatar.text = items[position].mail.first().uppercase()
        viewHolder.time.text = items[position].time
        viewHolder.content.text = items[position].content
        viewHolder.checkBox.isChecked = items[position].selected
        viewHolder.title.ellipsize = android.text.TextUtils.TruncateAt.END
        viewHolder.content.ellipsize = android.text.TextUtils.TruncateAt.END
        if (items[position].selected) {
            viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_on)
        } else viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_off)

        viewHolder.checkBox.setOnClickListener {
            items[position].selected = !items[position].selected
            if (items[position].selected) {
                viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_on)
            } else viewHolder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_off)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mail: TextView
        var title: TextView
        var content: TextView
        var avatar: TextView
        var time: TextView
        var checkBox: CheckBox

        init {
            mail = itemView.findViewById(R.id.mail)
            title = itemView.findViewById(R.id.title)
            avatar = itemView.findViewById(R.id.textView)
            time = itemView.findViewById(R.id.time)
            content = itemView.findViewById(R.id.content)
            checkBox = itemView.findViewById(R.id.checkBox)
        }
    }
}