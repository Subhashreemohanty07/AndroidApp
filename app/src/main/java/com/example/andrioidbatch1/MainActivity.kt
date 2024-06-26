package com.example.andrioidbatch1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : ComponentActivity() {
    private val productVM: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val products by productVM.products.observeAsState(emptyList())
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                ProductGrid(products)
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun ProductImage(imageUrl: String) {
        Image(
            painter = rememberImagePainter(data = imageUrl),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(120.dp)
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
    }
    @Composable
    fun ProductGrid(products: List<Product>) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(products) { product ->
                ProductItem(product = product)
            }
        }
    }

    @Composable
    fun ProductItem(product: Product) {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProductImage(imageUrl = product.image)
                Spacer(modifier = Modifier.height(8.dp))

                // Title
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Red,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Category
                Text(
                    text = product.category,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Blue,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Price
                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Description
                Text(
                    text = product.descriptioN,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }


    // Model Classes and Retrofit Setup

    data class Product(
        val id: Int,
        val title: String,
        val price: Double,
        @SerializedName("description")
        val descriptioN: String,
        val category: String,
        val image: String,
        val rating: Rating
    )

    data class Rating(
        val rate: Float,
        val count: Int
    )

    interface ApiService {
        @GET("products")
        suspend fun getProducts(): List<Product>
    }

    object RetrofitClient {
        private const val BASE_URL = "https://fakestoreapi.com/"

        val apiService: ApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }

    class ProductRepository(private val apiService: ApiService) {
        suspend fun getProducts(): List<Product> {
            return apiService.getProducts()
        }
    }

    class ProductViewModel : ViewModel() {
        private val _products = MutableLiveData<List<Product>>()
        val products: LiveData<List<Product>> get() = _products

        private val repository = ProductRepository(RetrofitClient.apiService)

        init {
            fetchProducts()
        }

        fun fetchProducts() {
            viewModelScope.launch {
                try {
                    val productList = repository.getProducts()
                    _products.postValue(productList)
                } catch (e: Exception) {
                    // Handle the exception
                }
            }
        }
    }
}
