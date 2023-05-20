package com.Kelompok_16.myapplication.ui.food

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import coil.load
import com.avief_reja.myapplication.R
import com.avief_reja.myapplication.data.FoodDataSource
import com.avief_reja.myapplication.databinding.FragmentFoodBinding
import com.avief_reja.myapplication.databinding.ItemCategoryBinding
import com.avief_reja.myapplication.databinding.ItemHeadlineBinding
import com.avief_reja.myapplication.model.Food
import com.avief_reja.myapplication.ui.SharedViewModel
import com.avief_reja.myapplication.ui.detail.DetailActivity
import com.avief_reja.myapplication.utils.resolveAttributeColor
import com.google.android.gms.maps.model.LatLng
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class FoodFragment : Fragment() {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    private val headlineData = FoodDataSource.createFoodData().take(5)
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        initializeCategory()
        setupCarouselHeadline()
        observeLivedata()
        return binding.root
    }

    private fun observeLivedata() {
        viewModel.location.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.tvLocation.text = viewModel.getStringLocation(requireContext(), it)
            }
        }

        viewModel.foodData.observe(viewLifecycleOwner) {
            setupFootNote(it)
        }
    }

    /* fungsi steupCarouselHeadline() untuk mengatur adapter dari carouselHeadline
    * Buat object carouselListener dengan tipe CarouselListener dan inisialisasi dengan object anonymous
    * Buat object listCarousel dengan tipe List<CarouselItem> dan inisialisasi dengan memanggil headlineData.map
    * Buat object binding dengan tipe ItemHeadlineBinding dan inisialisasi dengan memanggil ItemHeadlineBinding.inflate
    * Buat object food dengan tipe Food dan inisialisasi dengan memanggil headlineData[position]
    * Panggil fungsi with(binding) untuk mengatur data yang akan ditampilkan pada layout item_headline.xml
    * Panggil fungsi root.setOnClickListener untuk menambahkan aksi ketika item_headline.xml diklik
    * Panggil fungsi navigateToDetail untuk berpindah ke halaman detail
    * Panggil fungsi setData untuk mengatur data yang akan ditampilkan pada carouselHeadline
    *
    * Sumber : https://github.com/ImaginativeShohag/Why-Not-Image-Carousel
     */
    private fun setupCarouselHeadline() {
        with(binding.carouselHeadline) {
            registerLifecycle(lifecycle)
            carouselListener = object : CarouselListener {
                override fun onCreateViewHolder(
                    layoutInflater: LayoutInflater,
                    parent: ViewGroup
                ): ViewBinding {
                    return ItemHeadlineBinding.inflate(layoutInflater, parent, false)
                }

                override fun onBindViewHolder(
                    binding: ViewBinding,
                    item: CarouselItem,
                    position: Int
                ) {
                    val currentBinding = binding as ItemHeadlineBinding
                    val food = headlineData[position]

                    with(currentBinding) {
                        tvTitle.text = food.name
                        tvSubtitle.text = food.locationName
                        ivHeadline.load(food.imageUrl)
                        root.setOnClickListener {
                            navigateToDetail(food)
                        }
                    }
                }
            }

            val listCarousel = headlineData.map { touristAttraction ->
                CarouselItem(imageUrl = touristAttraction.imageUrl)
            }

            setData(listCarousel)
            setIndicator(binding.customIndicator)
        }

    }

    /* Buat function setupFootNote() untuk mengatur adapter dari rvFootnote
    * Buat object footNoteAdapter dengan tipe HomeFooterAdapter dan inisialisasi dengan memanggil HomeFooterAdapter(headlineData)
    * Setelah itu, kita akan mengatur rvFootnote dengan memanggil footNoteAdapter
     */
    private fun setupFootNote(data: List<Food>) {
        val footNoteAdapter = FoodFooterAdapter(data)
        with(binding.rvFootnote) {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = footNoteAdapter.apply {
                onItemClick = { data ->
                    navigateToDetail(data)
                }
            }
            setHasFixedSize(true)
        }
    }

    /* fungsi untuk menginisialisasi category
    * Buat function initializeCategory() untuk mengatur category
    * Panggil fungsi setupCategory untuk mengatur category
    * Panggil fungsi activatedCategory untuk mengatur category yang aktif
    * Panggil fungsi root.setOnClickListener untuk menambahkan aksi ketika category diklik
    * Panggil fungsi activatedCategory untuk mengatur category yang aktif
     */
    private fun initializeCategory() {
        with(binding) {
            setupCategory(ivCategoryRice, "Nasi", 0)
            setupCategory(ivCategorySoup, "Kuah", 0)
            setupCategory(ivCategoryFried, "Gorengan", 0)
            setupCategory(ivCategoryPopular, "Popular", R.drawable.ic_category_popular)
            setupCategory(ivCategorySatay, "Sate", 0)

            activatedCategory(ivCategoryPopular)


            ivCategoryPopular.root.setOnClickListener { activatedCategory(ivCategoryPopular) }
            ivCategoryRice.root.setOnClickListener { activatedCategory(ivCategoryRice) }
            ivCategorySoup.root.setOnClickListener { activatedCategory(ivCategorySoup) }
            ivCategoryFried.root.setOnClickListener { activatedCategory(ivCategoryFried) }
            ivCategorySatay.root.setOnClickListener { activatedCategory(ivCategorySatay) }
        }
    }

    private fun setupCategory(
        binding: ItemCategoryBinding,
        categoryName: String,
        categoryImage: Int,
    ) {
        with(binding) {
            if (categoryImage == 0) {
                ivCategory.visibility = View.GONE
            } else {
                ivCategory.setImageResource(categoryImage)
            }
            tvCategory.text = categoryName
        }
    }

    private fun clearAllCategory() {
        with(binding) {
            clearCategory(ivCategoryRice)
            clearCategory(ivCategoryFried)
            clearCategory(ivCategorySoup)
            clearCategory(ivCategorySatay)
            clearCategory(ivCategoryPopular)
        }
    }

    private fun clearCategory(
        binding: ItemCategoryBinding,
    ) {
        with(binding) {
            val colorSurface =
                requireContext().resolveAttributeColor(android.R.attr.colorBackground)

            root.strokeColor = ContextCompat.getColor(requireContext(), R.color.alto)
            root.setCardBackgroundColor(colorSurface)
            tvCategory.setTextColor(ContextCompat.getColor(requireContext(), R.color.slate_gray))
            ivCategory.setColorFilter(ContextCompat.getColor(requireContext(), R.color.slate_gray))
        }
    }

    private fun activatedCategory(
        binding: ItemCategoryBinding,
    ) {
        clearAllCategory()
        with(binding) {
            root.strokeColor = ContextCompat.getColor(requireContext(), R.color.primary)
            root.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.primary))
            tvCategory.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            ivCategory.setColorFilter(ContextCompat.getColor(requireContext(), R.color.white))

            viewModel.filterFood(tvCategory.text.toString())
        }
    }

    private fun navigateToDetail(item: Food) {
        val intent = Intent(
            requireContext(),
            DetailActivity::class.java
        ).putExtra(DetailActivity.EXTRA_FOOD, item)
            .putExtra(DetailActivity.EXTRA_LATITUDE, viewModel.location.value?.latitude)
            .putExtra(DetailActivity.EXTRA_LONGITUDE, viewModel.location.value?.longitude)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
