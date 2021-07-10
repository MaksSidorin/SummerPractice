package com.example.summerpractice.all_news_list
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice.R

class TagsAdapter(private val tags: ArrayList<MyNews>, private val onClickListener: MyOnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val tag = tags[position]

        return tag.SizeNews
    }

    class BigViewHolder : RecyclerView.ViewHolder {

        val BigImageView: ImageView
        val BigTextView: TextView
        val BigDateView: TextView

        constructor(view: View) : super(view) {

            BigImageView = view.findViewById<View>(R.id.BigImage) as ImageView
            BigTextView = view.findViewById<View>(R.id.BigText) as TextView
            BigDateView = view.findViewById<View>(R.id.BigDate) as TextView
        }
    }

    class MyViewHolder : RecyclerView.ViewHolder {
        val newsImageView: ImageView
        val textView: TextView
        val dateView: TextView

        constructor(view: View) : super(view) {
            newsImageView = view.findViewById<View>(R.id.newsImage) as ImageView
            textView = view.findViewById<View>(R.id.text) as TextView
            dateView = view.findViewById<View>(R.id.date) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 1) {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.main_news, parent, false)
            return BigViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.tags_item, parent, false)
            return MyViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is BigViewHolder) {
            val tag = tags[position]
            holder.run {
                BigImageView.setImageResource(tag.getMyImage())
                BigTextView.setText(tag.getMyText())
                BigDateView.setText(tag.getMyDate())
            }
            holder.BigTextView.setOnClickListener {
                onClickListener.onClicked(tag.getMyText())
            }
        } else if (holder is MyViewHolder) {
            val tag = tags[position]
            holder.newsImageView.setImageResource(tag.getMyImage())
            holder.textView.setText(tag.getMyText())
            holder.dateView.setText(tag.getMyDate())
            holder.textView.setOnClickListener {
                onClickListener.onClicked(tag.getMyText())
            }
        }
    }

        override fun getItemCount(): Int {
            return tags.size
        }

}