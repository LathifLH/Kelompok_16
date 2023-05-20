package com.Kelompok_16.myapplication.data

import com.Kelompok_16.myapplication.model.Food

object FoodDataSource {

    /**
     * Buat data dummy makanan
     * @return List dari makanan
     */
    fun createFoodData(): MutableList<Food> {
        val foodData = mutableListOf<Food>()
        val dummyFoodList = listOf(
            Food(
                name = "Nasi Goreng",
                locationName = "Warung Makan Sederhana",
                description = "Nasi goreng adalah makanan khas Indonesia yang terbuat dari nasi yang digoreng dengan bumbu-bumbu",
                imageUrl = "https://cdn-2.tstatic.net/kaltim/foto/bank/images/resep-nasi-goreng-jawa.jpg",
                rating = 4.5,
                category = "Nasi",
                isFavorite = true
            ),
            Food(
                name = "Sate Ayam",
                locationName = "Warung Sate Bambu",
                description = "Sate ayam adalah makanan yang terdiri dari potongan daging ayam yang ditusuk dengan tusukan bambu",
                imageUrl = "https://assets.pikiran-rakyat.com/crop/19x167:971x853/x/photo/2022/09/27/799023755.jpg",
                rating = 4.2,
                category = "Sate",
                isFavorite = false
            ),
            // Tambahkan data dummy lainnya di sini
            Food(
                name = "Gado-gado",
                locationName = "Warung Makan Gado-gado",
                description = "Gado-gado adalah makanan khas Indonesia yang terdiri dari sayuran segar yang dicampur dengan bumbu kacang",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/2/26/Gado_gado_jakarta.jpg",
                rating = 4.0,
                category = "Popular",
                isFavorite = true
            ),
            Food(
                name = "Mie Ayam",
                locationName = "Warung Mie Ayam Enak",
                description = "Mie ayam adalah makanan yang terdiri dari mi yang disajikan dengan daging ayam, sayuran, dan kuah kaldu",
                imageUrl = "https://images.tokopedia.net/img/JFrBQq/2022/8/15/06fce354-78b3-4aa2-b070-efaa73343a81.jpg",
                rating = 4.3,
                category = "Kuah",
                isFavorite = true
            ),
            Food(
                name = "Pisang Goreng",
                locationName = "Warung Pisang Goreng",
                description = "Pisang goreng adalah makanan yang terbuat dari pisang yang digoreng dengan adonan tepung",
                imageUrl = "https://img.okezone.com/content/2022/06/13/298/2610813/segini-kalori-pisang-goreng-teman-minum-kopi-paling-enak-di-pagi-hari-sbRugCbMvK.jpeg",
                rating = 4.1,
                category = "Gorengan",
                isFavorite = false
            )
            // Tambahkan data dummy lainnya di sini
        )

        foodData.addAll(dummyFoodList)
        return foodData

    }
}
