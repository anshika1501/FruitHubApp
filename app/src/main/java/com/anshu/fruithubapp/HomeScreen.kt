package com.anshu.fruithubapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp)
    ){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                tint = Color(0XFF272140)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painterResource(R.drawable.shopping_basket),
                    contentDescription = null,
                    modifier = modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text("My Basket", fontSize = 12.sp, color = Color(0XFF272140))

            }

        }
        //Greeting Text
        Text(
            "Hello, What fruit salad do you want Today?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0XFF272140),
            lineHeight = 28.sp,
            modifier = modifier.padding(bottom = 24.dp)
        )
        //SearchBar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF3F3F3), shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color(0XFF86869E),
                modifier = modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("Search for fruit salad",
                fontSize = 14.sp,
                color = Color(0XFF86869E),
                modifier = modifier.weight(1f)
            )
            Image(painter=painterResource(R.drawable.filter_list),
                contentDescription = null,
                modifier = modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            "Recommended Combo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(bottom = 32.dp)
            ){
            items(2){index ->
                RecommendedComboCard(
                    name = if (index == 0) "Honey limb Combo" else "Berry mango comb",
                    price = if (index == 0) "₹ 250" else "₹ 300",
                    imageRes = if (index == 0) R.drawable.food_1 else R.drawable.food_2
                )
            }

        }
        LazyRow(
            horizontalArrangement=Arrangement.spacedBy(24.dp),
            modifier=Modifier.padding(bottom=16.dp)
        )
        {
            items(listOf("Hottest", "Popular", "New combo", "Top")) { category ->
                Text(
                    text = category, fontSize = 16.sp, fontWeight = if
                                                                            (category == "Hottest") FontWeight.Bold else FontWeight.Normal
                )
            }
        }


    }//main column

}

@Composable
fun RecommendedComboCard(modifier: Modifier = Modifier,name:String,price:String,imageRes:Int) {
    Card(
        modifier = modifier.width(152.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation=CardDefaults.cardElevation(defaultElevation=4.dp)
    ) {
        Column(modifier = modifier.padding(start = 26.dp)) {
            Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Color(0xFFFF8C42),
                    modifier = modifier.size(20.dp)
                )



            }
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = modifier.size(80.dp)
            )
            Spacer(modifier = modifier.height(12.dp))

            Text(name, fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black)
            Spacer(modifier = modifier.height(8.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF8C42)
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color(0xFFFF8C42),
                    modifier = modifier
                        .size(24.dp)
                        .background(
                            color = Color(0xFFFFF2E7), shape = CircleShape
                        )
                        .padding(4.dp))

            }
        }

    }
}
@Composable
@Preview(showBackground = true)
fun HomeScreenPrev(modifier: Modifier = Modifier) {
    HomeScreen()
    //RecommendedComboCard(name="Burger ",price="200",imageRes=R.drawable.food_1)
}