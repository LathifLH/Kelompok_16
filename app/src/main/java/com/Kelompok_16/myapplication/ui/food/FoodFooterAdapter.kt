package com.Kelompok_16.myapplication.ui.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.avief_reja.myapplication.R
import com.avief_reja.myapplication.databinding.ItemFootnoteBinding
import com.avief_reja.myapplication.model.Food

class FoodFooterAdapter(
    private val list: List<Food>,
) : RecyclerView.Adapter<FoodFooterAdapter.HomeFooterViewHolder>() {

    /* Untuk menambahkan listener pada item di RecyclerView, kita bisa menggunakan lambda
        expression. Kita bisa menambahkan lambda expression dengan cara menambahkan properti
        onItemClick pada adapter. Properti ini akan menampung lambda expression yang akan
        dipanggil ketika item di RecyclerView diklik.
         */
    var onItemClick: ((Food) -> Unit)? = null


    /* Fungsi onCreateViewHolder() akan dipanggil ketika RecyclerView membutuhkan
    ViewHolder baru. Pada fungsi ini, kita akan membuat ViewHolder baru dan mengembalikannya.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFooterViewHolder {
        return HomeFooterViewHolder(
            ItemFootnoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    /* Fungsi getItemCount() akan mengembalikan jumlah data yang akan ditampilkan pada
    RecyclerView.
     */
    override fun getItemCount(): Int = list.size

    /* Fungsi onBindViewHolder() akan dipanggil ketika ViewHolder sudah siap ditampilkan.
    Pada fungsi ini, kita akan memanggil fungsi bindItem() yang ada pada ViewHolder untuk
    menampilkan data.
     */
    override fun onBindViewHolder(holder: HomeFooterViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list[position])
        }
        holder.bindItem(list[position])
    }


    /* Untuk menampilkan data pada RecyclerView, kita perlu membuat ViewHolder terlebih
    dahulu. ViewHolder berfungsi untuk menampung referensi dari view yang digunakan pada
    RecyclerView. Pada kelas HomeHeadlineAdapter, kita akan membuat ViewHolder dengan
    nama HomeFooterViewHolder.
     */
    class HomeFooterViewHolder(private val binding: ItemFootnoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(food: Food) {
            binding.apply {
                tvTitle.text = food.name
                tvSubtitle.text = food.locationName
                ivHeadline.load(food.imageUrl)
                tvRating.text = food.rating.toString()

                if (food.isFavorite) {
                    ivFavorite.load(R.drawable.ic_favorite)
                } else {
                    ivFavorite.load(R.drawable.ic_not_favorite)
                }
            }
        }
    }
}
