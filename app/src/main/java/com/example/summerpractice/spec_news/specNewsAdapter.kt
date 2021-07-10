package com.example.summerpractice.spec_news
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice.R

class specNewsAdapter(private val specNews: ArrayList<SpecNewsType>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

      override fun getItemViewType(position: Int): Int {
        return if (specNews.get(position) is ImageType) {
            SpecNewsType.IMAGE_TYPE
        } else if (specNews.get(position) is HeaderType) {
            SpecNewsType.HEADER_TYPE
        } else if (specNews.get(position) is GreyTextType) {
            SpecNewsType.GREY_TEXT_TYPE
        }
        else if (specNews.get(position) is BlackTextType) {
            SpecNewsType.BLACK_TEXT_TYPE
        } else if (specNews.get(position) is BulletedTextType) {
            SpecNewsType.BULL_TEXT_TYPE
        } else if (specNews.get(position) is ItalicTextType) {
            SpecNewsType.ITALIC_TEXT_TYPE
        } else if (specNews.get(position) is TwoButtonsType) {
            SpecNewsType.TWO_BUTTON_TYPE
        } else {
            -1
        }
    }

    class ImageViewHolder : RecyclerView.ViewHolder {

        val SpecImageView: ImageView

        constructor(view: View) : super(view) {
            SpecImageView = view.findViewById<View>(R.id.SpecImage) as ImageView
        }
    }

    class BoldHeaderViewHolder : RecyclerView.ViewHolder {
        val headerView: TextView

        constructor(view: View) : super(view) {
            headerView = view.findViewById<View>(R.id.boldHeader) as TextView
        }
    }

    class GreyTextViewHolder : RecyclerView.ViewHolder {
        val greyTextView: TextView

        constructor(view: View) : super(view) {
            greyTextView = view.findViewById<View>(R.id.greyText) as TextView
        }
    }

    class BlackTextViewHolder : RecyclerView.ViewHolder {
        val blackTextView: TextView

        constructor(view: View) : super(view) {
            blackTextView = view.findViewById<View>(R.id.blackText) as TextView
        }
    }

    class BullTextViewHolder : RecyclerView.ViewHolder {
        val bullTextView: TextView

        constructor(view: View) : super(view) {
            bullTextView = view.findViewById<View>(R.id.bulletedList) as TextView
        }
    }

    class ItalicTextViewHolder : RecyclerView.ViewHolder {
        val italicTextView: TextView

        constructor(view: View) : super(view) {
            italicTextView = view.findViewById<View>(R.id.italic_text) as TextView
        }
    }

    class TwoButtonsViewHolder : RecyclerView.ViewHolder {
        val likeButtonView: ImageButton
        val dislikeButtonView: ImageButton
        val likeTextView: TextView
        val dislikeTextView: TextView


        constructor(view: View) : super(view) {
            likeButtonView = view.findViewById<View>(R.id.likeButton) as ImageButton
            dislikeButtonView = view.findViewById<View>(R.id.dislikeButton) as ImageButton
            likeTextView = view.findViewById<View>(R.id.likeText) as TextView
            dislikeTextView = view.findViewById<View>(R.id.dislikeText) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {

            SpecNewsType.IMAGE_TYPE -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.image_specific_news, parent, false)
                return ImageViewHolder(itemView)
            }
            SpecNewsType.HEADER_TYPE -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.big_bold_header, parent, false)
                return BoldHeaderViewHolder(itemView)
            }
            SpecNewsType.GREY_TEXT_TYPE -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.grey_text, parent, false)
                return GreyTextViewHolder(itemView)
            }
            SpecNewsType.BLACK_TEXT_TYPE -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.black_text, parent, false)
                return BlackTextViewHolder(itemView)
            }
            SpecNewsType.BULL_TEXT_TYPE -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.bulleted_list, parent, false)
                return BullTextViewHolder(itemView)
            }
            SpecNewsType.ITALIC_TEXT_TYPE -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.italic_text, parent, false)
                return ItalicTextViewHolder(itemView)
            }
            SpecNewsType.TWO_BUTTON_TYPE -> {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.two_buttons, parent, false)
                return TwoButtonsViewHolder(itemView)
            }
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }

    fun getOnClickListener(): View.OnClickListener? {
        return View.OnClickListener {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is ImageViewHolder -> {
                (holder).SpecImageView
                        .setImageResource((specNews.get(position) as ImageType).getSpecNewsImage())
            }
            is BoldHeaderViewHolder -> {
                (holder).headerView
                        .setText((specNews.get(position) as HeaderType).getMyHead())
            }
            is GreyTextViewHolder -> {
                (holder).greyTextView
                        .setText((specNews.get(position) as GreyTextType).getMyGreyText())
            }
            is BlackTextViewHolder -> {
                (holder).blackTextView
                        .setText((specNews.get(position) as BlackTextType).getMyBlackText())
            }
            is BullTextViewHolder -> {
                (holder).bullTextView
                        .setText((specNews.get(position) as BulletedTextType).getMyBullText())
            }
            is ItalicTextViewHolder -> {
                (holder).italicTextView
                        .setText((specNews.get(position) as ItalicTextType).getMyItalicText())
            }
            is TwoButtonsViewHolder -> {
                (holder).likeButtonView
                        .setOnClickListener(getOnClickListener())
                (holder).dislikeButtonView
                        .setOnClickListener(getOnClickListener())
                (holder).likeTextView
                        .setText((specNews.get(position) as TwoButtonsType).getMyLikeText())
                (holder).dislikeTextView
                        .setText((specNews.get(position) as TwoButtonsType).getMyDislikeText())
            }
        }
    }

    override fun getItemCount(): Int {
        return specNews.size
    }

}