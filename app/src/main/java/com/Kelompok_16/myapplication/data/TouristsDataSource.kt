package com.Kelompok_16.myapplication.data

import com.Kelompok_16.myapplication.model.TouristAttraction

object TouristsDataSource {

    /**
     * Buat data dummy untuk tempat wisata
     * @return List<TouristAttraction>
     */
    fun createTouristAttractionData(): MutableList<TouristAttraction> {
        val touristData = mutableListOf<TouristAttraction>()
        val touristAttractions = listOf(
            TouristAttraction(
                name = "Bukit Tangkeban",
                locationName = "Pulosari, Pemalang",
                description = "Wisata alam Bukit Tangkeban merupakan salah satu destinasi wisata yang cukup populer di Pemalang. Dikutip dari laman resmi pemerintah Provinsi Jawa Tengah, Bukit Tangkeban terletak di Kecamatan Pulosari dan berada di lereng gunung Slamet.\n" +
                        "\n" +
                        "Destinasi wisata ini terletak kurang lebih 48 km dari pusat kota Pemalang dan dapat ditempuh menggunakan kendaraan darat dengan memakan waktu kurang lebih 1 jam 30 menit.\n",
                imageUrl = "https://1.bp.blogspot.com/-FhXA3U5YcE8/X74XP4AKc0I/AAAAAAAAAPY/BsCalOxMmhclQSwRhXQO6XLstQnLto3-wCLcBGAsYHQ/s2048/IMG_0055.JPG",
                rating = 4.5,
                category = "Bukit",
                latitude = -7.160187100087681,
                longitude = 109.23289981534231,
                isFavorite = true,
            ),
            TouristAttraction(
                name = "Curug Lawe",
                locationName = "Kedungwringin, Moga, Pemalang",
                description = "Curug Lawe adalah sebuah air terjun yang terletak di Desa Kedungwringin, Kecamatan Moga, Kabupaten Pemalang, Jawa Tengah. Dengan keindahan alamnya yang memukau, Curug Lawe menjadi salah satu destinasi wisata yang populer di Pemalang.\n" +
                        "\n" +
                        "Air terjun Curug Lawe memiliki ketinggian sekitar 50 meter dan terbentang melalui beberapa tingkatan. Suara gemuruh air yang jatuh dari ketinggian menciptakan suasana yang menenangkan dan memikat bagi pengunjung. Pemandangan alam sekitar yang hijau dan aliran sungai yang mengalir dengan jernih menambah keindahan dan keasrian tempat ini.",
                imageUrl = "https://asset.kompas.com/crops/ZkeIWvJJpdsxDIONHQHBRYcZ16Y=/0x0:1620x1080/750x500/data/photo/2021/04/08/606e4de4cafbc.jpg",
                rating = 4.8,
                category = "Popular",
                latitude = -7.127179288240368,
                longitude = 109.73015405753723,
                isFavorite = true,
            ),
            TouristAttraction(
                name = "Taman Bunga Pemalang",
                locationName = "Belik, Pemalang",
                description = "Taman Bunga Pemalang adalah destinasi wisata yang memukau di Kabupaten Pemalang, Jawa Tengah. Dikenal sebagai surga bunga, taman ini menawarkan pengalaman yang memikat bagi para pengunjung yang menyukai keindahan alam dan kebun bunga yang indah.\n" +
                        "\n" +
                        "Dengan luas yang luas, Taman Bunga Pemalang menampilkan berbagai jenis bunga yang menakjubkan. Begitu memasuki taman, pengunjung akan disambut dengan aroma harum bunga yang menguar di udara. Taman ini menawarkan panorama yang memukau dengan warna-warni bunga yang tumbuh subur di sepanjang area.",
                imageUrl = "https://assets.ayobandung.com/crop/0x0:0x0/750x500/webp/photo/2022/06/16/174292999.jpg",
                rating = 4.5,
                category = "Popular",
                latitude = -6.908683702228293,
                longitude = 109.38387827671151,
            ),
            TouristAttraction(
                name = "Pantai Widuri",
                locationName = "Pemalang, Jawa Tengah",
                description = "Pantai Widuri adalah salah satu destinasi wisata pantai yang terletak di Kabupaten Pemalang, Jawa Tengah. Pantai ini memiliki keindahan alam yang menakjubkan dengan pasir putih yang lembut dan air laut yang jernih. Pantai Widuri menawarkan pengalaman liburan yang menyenangkan dengan panorama alam yang menakjubkan dan udara segar dari samudra yang membentang luas.\n" +
                        "\n" +
                        "Pantai Widuri dikelilingi oleh pepohonan hijau yang memberikan nuansa alami dan menyejukkan. Pengunjung dapat menikmati suasana pantai yang tenang dan damai sambil menikmati deburan ombak yang menghantam pantai. Pantai ini juga memiliki pemandangan matahari terbenam yang memukau, di mana langit terikat dalam warna-warni indah yang menciptakan pemandangan yang memukau dan mengesankan.",
                imageUrl = "https://mytrip123.com/wp-content/uploads/2022/05/pantai-widuri.jpg",
                rating = 4.6,
                category = "Pantai",
                latitude = -6.861222844301551,
                longitude = 109.37810482490161,
            ),
            TouristAttraction(
                name = "Gunung Slamet",
                locationName = "Pemalang,Tegal, Banyumas Jawa Tengah",
                description = "Gunung tertinggi di Jawa Tengah yang menawarkan pemandangan alam yang memukau. Cocok untuk pendaki dan pecinta petualangan.",
                imageUrl = "https://img.inews.co.id/media/600/files/networks/2022/12/07/fc032_gunung-slamet.jpg",
                rating = 4.9,
                category = "Bukit",
                latitude = -7.240209,
                longitude = 109.208825,
                isFavorite = true,
            ),
            TouristAttraction(
                name = "Desa Wisata Kandri",
                locationName = "Pemalang, Jawa Tengah",
                description = "Desa Wisata Kandri adalah sebuah destinasi wisata yang terletak di Kabupaten Pemalang, Jawa Tengah. Desa ini menawarkan pengalaman liburan yang autentik dengan suasana pedesaan yang khas dan keindahan alam yang memukau. Desa Wisata Kandri memiliki beragam potensi wisata yang menarik, mulai dari keindahan alam, budaya lokal, hingga tradisi masyarakat yang masih terjaga.\n" +
                        "\n" +
                        "Salah satu daya tarik utama Desa Wisata Kandri adalah panorama alamnya yang memesona. Desa ini dikelilingi oleh perbukitan hijau yang menawan, hamparan sawah yang indah, dan sungai yang mengalir membelah desa. Pengunjung dapat menikmati keindahan alam dengan melakukan trekking atau berjalan-jalan santai di sekitar desa sambil menikmati udara segar dan pemandangan yang menenangkan.",
                imageUrl = "https://jadesta.kemenparekraf.go.id/imgpost/35438.jpg",
                rating = 4.4,
                category = "Danau",
                latitude = -7.0559356792173515,
                longitude = 110.35652192455646,
                isFavorite = true,
            ),
            TouristAttraction(
                name = "Air Terjun Curug Bajing",
                locationName = "Petungkriono, Pemalang",
                description = "Air Terjun Curug Bajing, yang terletak di Kabupaten Pemalang, Jawa Tengah, adalah salah satu destinasi alam yang menakjubkan dan memikat hati para pengunjung. Dengan keindahan alamnya yang luar biasa, air terjun ini menjadi tempat yang populer bagi pecinta alam dan penggemar petualangan.\n" +
                        "\n" +
                        "Curug Bajing menawarkan pemandangan yang menakjubkan dengan air yang mengalir deras dari ketinggian dan jatuh ke dalam kolam yang indah. Suara gemuruh air yang jatuh dan semburat air yang menyegarkan menciptakan suasana yang menenangkan dan menyejukkan. Pengunjung dapat menikmati keindahan alam ini sambil merasakan kekuatan alam yang mengalir melalui air terjun yang spektakuler.",
                imageUrl = "https://cdn.nativeindonesia.com/foto/2020/09/Jembatan-Curug-Bajing.jpg",
                rating = 4.7,
                category = "Popular",
                latitude = -7.171184098821957,
                longitude = 109.72870095339357,
                isFavorite = true,
            ),
            TouristAttraction(
                name = "Danau Asmara",
                locationName = "Pemalang, Jawa Tengah",
                description = "Danau Asmara adalah sebuah persembahan alam yang menakjubkan di Desa Wisata Kandri, Kabupaten Pemalang, Jawa Tengah. Dengan keindahannya yang memukau, danau ini menjadi destinasi wisata yang populer di daerah tersebut.\n" +
                        "\n" +
                        "Danau Asmara menawarkan pemandangan yang memesona dengan airnya yang jernih dan warna yang berkilauan. Dikelilingi oleh pegunungan hijau dan vegetasi yang lebat, danau ini menciptakan suasana yang tenang dan damai. Keindahan alam sekitar danau ini memberikan pengalaman yang menenangkan dan menyegarkan bagi para pengunjungnya.",
                imageUrl = "https://dolanyok.com/wp-content/uploads/Danau-Asmara-Pemalang.jpg",
                rating = 4.4,
                category = "Danau",
                latitude = -7.096844260156809,
                longitude = 109.34011738037913,
                isFavorite = true,
            ),
            TouristAttraction(
                name = "Pantai Joko Tingkir",
                locationName = "Petarukan, Pemalang",
                description = "Pantai Joko Tingkir adalah salah satu destinasi wisata pantai yang terletak di Kabupaten Pemalang, Jawa Tengah. Pantai ini menawarkan pesona keindahan alam yang memukau dengan pasir putihnya yang lembut dan air laut yang jernih. Nama pantai ini diambil dari tokoh legendaris Joko Tingkir, yang konon diyakini sebagai raja Pajang yang pernah memerintah di daerah ini.\n" +
                        "\n" +
                        "Pantai Joko Tingkir memiliki panorama yang menakjubkan dengan pemandangan laut yang luas dan ombak yang memukul di tepi pantai. Keindahan alam yang disajikan pantai ini membuatnya menjadi tempat yang populer bagi para wisatawan yang ingin menikmati suasana pantai yang indah dan menenangkan. Pohon kelapa yang tumbuh di sepanjang pantai menambah kesan tropis dan memberikan tempat teduh yang nyaman bagi pengunjung.",
                rating = 4.6,
                imageUrl = "https://nusantarapedia.net/wp-content/uploads/IMG-20220621-WA0009-1024x768.jpg",
                category = "Pantai",
                latitude = -6.8308049976425576,
                longitude = 109.45724572455356,
                isFavorite = true,
            ),
            TouristAttraction(
                name = "Bukit Mendelem",
                locationName = "Belik, Pemalang",
                description = "Bukit Mendelem adalah salah satu destinasi wisata alam yang terletak di Kabupaten Pemalang, Jawa Tengah. Bukit ini menawarkan pemandangan indah yang memikat dengan panorama alam yang menakjubkan. Nama \"Mendelem\" diambil dari bahasa Jawa yang berarti \"tersembunyi\", menggambarkan pesona alam yang masih alami dan belum terlalu banyak dikunjungi wisatawan.\n" +
                        "\n" +
                        "Bukit Mendelem terkenal karena keindahan bukit-bukit hijau yang terhampar luas dan pemandangan lembah yang indah. Dari puncak bukit, pengunjung dapat menikmati panorama yang menakjubkan, terutama saat matahari terbit atau terbenam. Suasana sejuk dan udara segar di bukit ini membuatnya menjadi tempat yang populer untuk bersantai, berfoto, atau sekadar menikmati keindahan alam.",
                rating = 4.2,
                imageUrl = "https://lh3.googleusercontent.com/p/AF1QipN93zV6-IOG8Grv7_HXIzIZpkbjKcQjCp_XTBqu=s1360-w1360-h1020",
                category = "Bukit",
                latitude = -7.175637996738764,
                longitude = 109.3329371399004,
            ),
        )

        touristData.addAll(touristAttractions)
        return touristData
    }
}
