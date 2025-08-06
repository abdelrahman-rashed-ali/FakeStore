package com.example.fakestore.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.fakestore.domain.model.Product

@Composable
fun DetailScreen(product: Product) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(product.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(8.dp))
        Text(product.title)
        Text("Price: $${product.price}")
        Text(product.description)
    }
}
