package com.ngabroger.newsngabs.presentation.component


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx. compose. material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

import com.ngabroger.newsngabs.data.model.ArticlesItem

@Composable
fun NewsCard(article : ArticlesItem, onClick: () -> Unit){
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(12.dp),
        modifier =  Modifier
            .padding(8.dp)
            .clickable{onClick()}

    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
            {
                Text(
                    text = article.title!!,
                    style = MaterialTheme.typography.displayMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = article.description!!,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = article.publishedAt!!,
                    style = MaterialTheme.typography.bodySmall
                )

            }


    }


}
@Preview
@Composable
fun NewsCardPreview(){
    NewsCard(
        article = ArticlesItem(
            title = "Ini adalah judul",
            description = "Ini adalah deskripsi",
            url = "https://www.google.com",
            urlToImage = "https://www.google.com",
            publishedAt = "2021-09-01T00:00:00Z",
            content = "Ini adalah konten",
            author = "Ngabroger",
            source = null
        )
    ){}
}

